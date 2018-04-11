import java.util.*;
import java.util.Scanner;
class prog1{
public static void main(String[] args){
Scanner s=new Scanner(System.in);
System.out.println("Enter the first number:");
int a=s.nextInt();
System.out.println("Enter the second number");
int b=s.nextInt();
System.out.println("Enter the third number:");
int c=s.nextInt();
if((a>b)&&(a>c)&&(b>c)){
	System.out.println("decreasing ");
}
else if((a<b)&&(a<c)&&(b<c)){
System.out.println("Increasing");
}
else{
	System.out.println("neither increasing or decreasing");
}
}
}
