import java.util.*;
import java.util.Scanner;
class Array{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of the elements in array:");
		int n=s.nextInt();
		int[] ar=new int[n];
		System.out.println("enter  the array elements:");
		for(int i=0;i<n;i++){
			ar[i]=s.nextInt();
		}
		int sum=0;
		for(int j=0;j<n;j++){
			if(ar[j]==10){
				sum=sum+ar[j];
			}
		}
		if(sum==30){
			System.out.println("true");
		}
		else{
			System.out.println("False");
		}
	}
}