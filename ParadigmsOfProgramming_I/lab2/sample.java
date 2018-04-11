import java.util.*;
import java.util.Scanner;
class sample{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		char[] ar=new char[10];
		//char a='a';
		for(int i=0;i<10;i++){
			ar[i]=s.next().charAt(0);
		}
		for(int j=0;j<10;j++){
			System.out.println(ar[j]);
		}
	}
}