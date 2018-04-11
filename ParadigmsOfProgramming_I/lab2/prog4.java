import java.util.*;
import java.util.Scanner;
class prog4{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		System.out.println("enter the value of a1,b1 and c1 for eqn a1x+b1y=c1:");
		int a1=s.nextInt();
		int b1=s.nextInt();
		int c1=s.nextInt();
		System.out.println("enter the value of a2 ,b2 and c2 for second linear equation a2x +b2y=c2:");
		int a2=s.nextInt();
		int b2=s.nextInt();
		int c2=s.nextInt();
		double y=(((c1*a2)-(a1*c2))/((b1*a2)-(a1*b2)));
		System.out.println("value of y is:");
		System.out.println(y);
		double x=(((c1*b2)-(b1*c2))/((a1*b2)-(a2*b1)));
		System.out.println("value of x is:");
		System.out.println(x);

	}
}