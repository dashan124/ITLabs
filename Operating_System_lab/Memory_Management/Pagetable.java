import java.util.HashMap;
import java.lang.Math.*;

class Page {
   String pageId;
public Page(String pageId) { this.pageId = pageId; }
}

class Frame {
   Page page = null;
   int num;

   public Frame(int num) { this.num = num; }

   boolean isAllocated() { return page != null; }
   void assign(Page page) { this.page = page; }
}

class Process {
   Page[] pages;
   int size;
   String name;
   boolean alloc;

   HashMap<Page, Frame> pageTable = new HashMap<>(); // Table for pages in memory frames

   public int PAGE_SIZE = 100;
  
   public Process(int size, String name) {
       this.size = size;
       this.name = name;
       int numFrames = (int) Math.ceil((float)size / PAGE_SIZE);
       pages = new Page[numFrames];
       for (int i=0; i<numFrames; i++) {
           pages[i] = new Page(name+ "" +i);
       }
   }

   void execute() {
       if (alloc)
           for(Page page: pages) {
               System.out.println(page.pageId + " executing from frame " + pageTable.get(page).num);
           }
       else
           System.out.println("Process not in memory");
   }

   Page[] getPages() {
       return this.pages;
   }
}

class Memory {
   Frame[] frames;
  
   public Memory(int numFrames) {
       frames = new Frame[numFrames];
       for (int i=0; i<numFrames; i++) {
           frames[i] = new Frame(i);
       }
   }

   void allocateMemory(Process process) {
       Page[] pages = process.getPages();
       int alloc = 0;
       for (Page page: pages) {
           for (Frame frame: frames) {
               if(!frame.isAllocated()) {
                   frame.assign(page);
                   process.pageTable.put(page, frame);
                   alloc++;
                   break;
               }
   }
       }
       if (alloc != pages.length) {
           System.out.println("Only " + alloc + " Pages allocated.");
       }
       process.alloc = true;
   }

   void killProcess(Process process) {
       for(Page page: process.getPages()) {
           process.pageTable.get(page).page = null;
       }
       System.out.println("Process " + process.name + " killed.");
       process.alloc = false;
   }

   void displayFrames() {
       for (Frame frame: frames) {
           if (frame.isAllocated())
               System.out.println("Frame " + frame.num + ": Page " + frame.page.pageId);
           else
               System.out.println("Frame " + frame.num + ": empty");                   
       }
   }
}

class PagingTable {

   public static void main(String[] args) {
       Memory mem = new Memory(10);
       Process p1 = new Process(300, "Process 1");
       mem.allocateMemory(p1);
       Process p2 = new Process(300, "Process 2");
       mem.allocateMemory(p2);
       Process p3 = new Process(300, "Process 3");
       mem.allocateMemory(p3);
       mem.displayFrames();
       mem.killProcess(p2);
       mem.displayFrames();
       p2.execute();
       p1.execute();
       Process p4 = new Process(400, "Process 4");
       mem.allocateMemory(p4);
       mem.displayFrames();
   }
}
