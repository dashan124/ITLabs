import java.util.*;
class Prog2{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a integer");
		//main try block
		try{
			int a=s.nextInt();
			int b=a/0;
			try{
				System.out.println("a string");
				String x="";
				String y=x.substring(1);
				try{
					int arr[]={1,2,3,4,5,6};
					int u=arr[10];
					System.out.println("arr"+u);
				}
				catch(ArrayIndexOutOfBoundsException e1){
					System.out.println("Array bounds out of bounds");
				}
			}
			catch(NullPointerException e2){
				System.out.println("String is null");
			}
		}
		catch(ArithmeticException e3){
			System.out.println("Trying to divide by zero");
		}
	}
}