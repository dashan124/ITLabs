import java.io.*;
import java.util.*;

class Process{ //create a class process with an attribute size (process size)
  int size;
  Process(int size){
    this.size=size;
  }
}
class Paging{
  public static void main(String args[]){
  int n;
  System.out.println("no os frames");
  Scanner s = new Scanner(System.in);
  n=s.nextInt();
  int[] a = new int[n]; //memory partions 
  System.out.println("");
  int Memory; //memory of the each partition
  Memory=s.nextInt();
  for(int i=0;i<n;i++){
    a[i]=Memory;
  }

  System.out.println("Enter the pagesize that you want to set");
  int page;
  page=s.nextInt();
//page size which is related to the process partitioning 
  System.out.println("Enter the number of processes that you wanna allocate");
  int Process_no; //total no of processes
  Process_no=s.nextInt();
  LinkedList[] process_ar=new LinkedList[Process_no];
  int[] Pro2 = new int[Process_no];
  System.out.println("Enter the size of each process");
  for(int i=0;i<Process_no;i++){
    int temp=s.nextInt();
    int partition =(int)(temp/page);
    LinkedList l = new LinkedList(); //create a linked list 
    for(int j=0;j<partition;j++){
      Process o = new Process(page); //add process to linked list
      l.add(o);
      }

    int memfinal=0;
    memfinal = temp-(page*partition);
    if(memfinal!=0){
    Process o = new Process(memfinal);
    l.add(o);
    }
    Pro2[i]=temp;
    process_ar[i]=l;
  }


    LinkedList[] allocated = new LinkedList[Process_no];
    for(int j=0;j<Process_no;j++){
      for(int k=0;k<n;k++){
        if(a[k]>=Pro2[j]){
          a[k]-=Pro2[j];
          Pro2[j]=0;
          break;
        }
        else{
          int count=0;
          int srt=0;
          count=(int)(Pro2[j]/page);
          srt=Pro2[j]-(count*page);
          if(process_ar[j].size()>count){
            while(process_ar[j].size()!=1){
              if(k<n){
                if(a[k]>=page){
                  a[k]-=page;
                  process_ar[j].pop();
                }
                else{
                  k+=1;
                }
              }
              else{
                break;
              }
            }
            if(k<n){
              if(a[k]>=srt){
                a[k]-=srt;
                process_ar[j].pop();
                break;
              }
              else{
                k=k+1;
                if(k<n){
                  a[k]-=srt;
                  process_ar[j].pop();
                  break;
                }
                else{
                  break;
                }
              }  }
          }
          else if(process_ar[j].size()==count){
            while(process_ar[j].size()!=0){
              if(k<n){
                if(a[k]>=page){
                  a[k]-=page;
                  process_ar[j].pop();
                }
                else{
                  k+=1;
                }
              }
              else{
                break;
              }
            }
          }

        }
      }
    }

    for(int w=0;w<Process_no;w++){
      if(Pro2[w]==0 || process_ar[w].size()==0){
        System.out.println("Process "+ (w+1) + " is allocated");
      }
      else if(process_ar[w].size()!=0){
        System.out.println("Process "+ (w+1)+ "  number of pages whose allocation still left are " + process_ar[w].size());
      }
    }
  }
}
