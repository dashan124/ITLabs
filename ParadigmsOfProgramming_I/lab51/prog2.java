import java.util.*;
import java.util.Scanner;
class prog2{
	public static void main(String args[]){
		Scanner s =new Scanner(System.in);
		System.out.println("Enter the decimal no to convert it in to binary:");
		int n=s.nextInt();
		String str="";
		char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		int rem;
		while(n>0){
			rem=n%16;
		//	System.out.println("rem"+rem+"  hex[rem] is "+hex[rem]);
			str=hex[rem]+str;
			n=n/16;
		//	System.out.println("n is "+n);
		}
		System.out.println("the hexadecimal representation is :"+str);
	}
}