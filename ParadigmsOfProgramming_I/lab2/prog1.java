import java.util.*;
import java.util.Scanner;
class prog1{
	public static void main(String[] args){
		System.out.println("enter two operands");
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		System.out.println("enter a mathmatical operation");
		char x=s.next().charAt(0);
		if(x=='+'){
			System.out.println("addition of elements is:");
			int c=a+b;
			System.out.println(c);
		}
		else if(x=='-'){
			System.out.println("substraction of elements is:");
			int c=a-b;
			System.out.println(c);
		}
		else if(x=='*'){
			System.out.println("multipication of elements is:");
			int c=a*b;
			System.out.println(c);
		}
		else if(x=='/'){
			if(b!=0){
			System.out.println(" a/b is:");
			double c=a/b;
			System.out.println(c);
		}
		else{
			System.out.println("error cannot divide by zero!");
		}
		}
		else if(x=='%'){
			System.out.println("a%b is:");
			int c=a%b;
			System.out.println(c);
		}
		else{
			System.out.println("try another choice");
		}

		
	}
}