import java.util.*;
class main{
	static int a;
	static int b;
	main(int x,int y){
		a=x;
		b=y;
	}
	public static void swap(main n){
		int temp=n.a;
		n.a=n.b;
		n.b=temp;
	}
	public static void swap1(int a,int b) {
		int t=a;
		a=b;
		b=t;
		//System.out.println("Now the value of x  "+x);
		//System.out.println("Now the value of y  "+y);
	}
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the first number:");
		int x=s.nextInt();
		System.out.println("Enter the second number:");
		int y=s.nextInt();
		main n2=new main(x,y);
		n2.swap(n2);
		System.out.println("Swappin using the by refrence:");
		System.out.println("after swaping x     "+n2.a);
		System.out.println("after swapping y     "+ n2.b);
	    swap1(x, y);
		System.out.println("Using pass by value");
		System.out.println("Now the value of x "+x);
		System.out.println("Now the value of Y   "+y);
	}
}

