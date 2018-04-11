import java.util.*;
import java.util.Scanner;
     class Length {
  public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     int x=scan.nextInt();
     int[] array= new int[x];
     for(int i=0;i<array.length;i++)
         array[i]=scan.nextInt();
     System.out.println(a(array));
      }
public static int a(int[] array){
    int count=0,temp=0;
    for(int i=0;i<array.length;i++){
        count=0;
        for(int j=i,k=i+1;j<array.length-1;j++,k++)
            if(array[j]-array[k]==1)
                count++;
            else{if(temp<count)
                temp=count;
            break;}
        }
    return temp+1;
 }

  }