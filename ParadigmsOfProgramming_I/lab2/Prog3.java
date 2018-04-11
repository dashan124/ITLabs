import java.util.*;
import java.util.Scanner;
class Prog3{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		System.out.println("enter a number:");
		int n=s.nextInt();
		System.out.println("Right shift unsigned:");
	 int x=n>>1;
		System.out.println(x);
		System.out.println("after left shift:");
		int y=n<<1;
		System.out.println(y);
		System.out.println("after unsigned right shift:");
		System.out.println(n>>>1);
	}
}