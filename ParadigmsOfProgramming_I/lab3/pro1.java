import java.util.*;
import java.util.Scanner;
class student{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a number:");
		int n=s.nextInt();
		n=n%7;
		if(n==1){
			System.out.println("Monday");
		}
		if(n==2){
			System.out.println("tuesday");
		}
		 if(n==3){
			System.out.println("Wednesday");
		}
		if(n==4){
			System.out.println("Thursday");
		}
		if(n==5){
			System.out.println("Friday");
		}
		 if(n==6){
			System.out.println("Saturday");
		}
		if(n==7){
			System.out.println("Sunday");
		}
		
	}
}