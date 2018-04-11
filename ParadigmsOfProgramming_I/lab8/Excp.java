import java.util.*;
public class Excp {
public static void main(String args[]) {
	int a,b,c;
	System.out.println("Enter a integer");
	Scanner s=new Scanner(System.in);
	a=s.nextInt();
	System.out.println("Enter another integer");
	b=s.nextInt();
	try {
		c=b/a;
		System.out.println("The division is "+c);
	}catch(ArithmeticException e) {
		System.out.println("You are trying to divide by zero" +e);
	}
	System.out.println("After the division part");
}
}
