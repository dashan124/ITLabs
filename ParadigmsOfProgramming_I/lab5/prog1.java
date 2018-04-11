import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;
class Product
{   static String owner="dastechproducts";
	String name;
	double price;
	/*int sub1;
	int sub2;
	double total;
	float per;*/
	void getdata() 
	{
		Scanner br=new Scanner(System.in);
		System.out.println ("Enter Name of Product");
		name = br.nextLine();
		System.out.println ("Enter price of  product");
		price = br.nextDouble();
	}
	void show()
	{  
	    System.out.println ("Name = "+name);
		System.out.println("price of the object:"+price+"   owner     "+owner);
	}
}
class Product1
{
	public static void main(String args[]) 
	{  Scanner br=new Scanner(System.in);
	System.out.println("Enter the number of products:");
		int n=br.nextInt();
		Product[] s=new Product[n];
		double total=0;
		for(int i=0;i<n;i++) {
			s[i]=new Product();
			s[i].getdata();
			total+=s[i].price;
			s[i].show();
		}
		System.out.println("the total price is"+total);
		
	}
}