import java.util.*;
import java.util.Scanner;
class prog4{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
	System.out.println("Enter the no of elements in first array:");
	int n1=s.nextInt();
	int[] arr=new int[n1];
	System.out.println("Enter the elements in first array:");
	for(int i=0;i<n1;i++){
		arr[i]=s.nextInt();
	}
	System.out.println("Enter the no of elements in Second array:");
	int n2=s.nextInt();
	int[] arr2=new int[n2];
	System.out.println("Enter the elements in Second array:");
	for(int j=0;j<n2;j++){
		arr2[j]=s.nextInt();
	}
	for(int k=0;k<n1;k++){
		for(int v=0;v<n2;v++){
			if(arr[k]==arr2[v]){
				System.out.println("common element = "+arr[k]);
				break;
			}
		}
	}
	}
}