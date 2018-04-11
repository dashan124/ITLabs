import java.util.*;
import java.util.Scanner;
class Interest{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("Input the investment amount:");
		int a=s.nextInt();
		System.out.println("Enter the rate of the interest:");
		int r=s.nextInt();
		System.out.println("Enter the number of years:");
		int y=s.nextInt();
		int n=12;
		System.out.println("year 		Futurevalue");
		for(int i=1;i<=y;i++){
			double p=a*(Math.pow((1+(r/(double)(100*n))),(n*i)));
			//12 is the compund frequency
			System.out.println(i+"		 "+p);
		}
	}
}