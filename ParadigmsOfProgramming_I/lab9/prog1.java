import java.util.*;
class Try{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		try{
			System.out.println("Enter two integers");
			int a=s.nextInt();
			int b =s.nextInt();
			int arr[]=new int[5];
			System.out.println("Division by zero"+a/b);
		    arr[6]=24;
		    System.out.println("arr eleemnt"+arr[6]);
		}
		catch(ArithmeticException e){
			System.out.println("You can  not divide by zero");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Warning : array bounds out of exception");
		}
	}

}
