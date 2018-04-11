import java.util.*;
import java.util.Scanner;
class prog2{
public static void main(String args[]){
int binary[]=new int[40];
int index=0;
while(num>0){
binary[index++]=num%2;
num=num/2;
}
for(int i=index-1;i>=0;i--){
System.out.println(binary[i]);
}
}