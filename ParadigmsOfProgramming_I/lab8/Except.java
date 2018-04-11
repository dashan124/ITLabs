import java.util.*;
public class Except {
	public static void main(String args[]) {
		try {
			try {
				System.out.println("going to divide");
				int b=45/0;
			}catch(ArithmeticException e) {
				System.out.println("Trying to divide by zero "+e);
			}
			try {
				int a[]=new int[5];
				a[5]=4;
				
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("array index out of bound "+e);
			}
			System.out.println("middle of the program");
		}catch(Exception e) {
			System.out.println("Handeled");
		}
		System.out.println("Execution of the normal program starts now");
	}
}
