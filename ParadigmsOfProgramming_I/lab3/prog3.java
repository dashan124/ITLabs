import java.util.*;
import java.util.Scanner;
class yahoo{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the no of array elemets:");
		int n=s.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter the array elements:");
		for(int i=0;i<n;i++){
			arr[i]=s.nextInt();
		}
		System.out.println("Enter the element to search its index:");
		int k=s.nextInt();
		for(int j=0;j<n;j++){
			if(arr[j]==k){
				System.out.println("The required index is :"+j);
			}
		}
	}
}