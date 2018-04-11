import java.util.*;
import java.util.Scanner;
public class finalize{  
 public void finalize(){System.out.println("object is garbage collected");}  
 public static void main(String args[]){  
  finalize s1=new finalize();  
  finalize s2=new finalize();  
  s1=null;  
  s2=null;  
  System.gc();  
 }  
} 