import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;
class Employee
{
	String name;
	int id;
	double salary;
	double bhr;    //base hourly rate
	double bonus;
	double tax;
	double total;
	void getdata() 
	{
		Scanner br=new Scanner(System.in);
		System.out.println ("Enter Name of Employee");
		name = br.nextLine();
		System.out.println ("Enter id of Employee");
		id = br.nextInt();
		System.out.println("Enter the basicsalary of the employee:");
		salary=br.nextDouble();
		System.out.println ("Enter bonus % of the Employee:");
		bonus = br.nextDouble();
		System.out.println ("Enter tax% on salary:");
		tax = br.nextDouble();
	}
	void show()
	{
		total=salary+((salary*bonus/(double)100)-salary*(tax/(double)100));
		System.out.println ("Id = "+id);
		System.out.println ("Name = "+name);
		System.out.println ("salary = "+salary);
		System.out.println ("bonus = "+bonus);
		System.out.println ("Tax = "+tax);
		System.out.println ("total = "+total);
	}
}
class q2Employee
{
	public static void main(String args[]) 
	{  Scanner br=new Scanner(System.in);
	System.out.println("Enter the number of Employee:");
		int n=br.nextInt();
		Employee[] s=new Employee[n];
		for(int i=0;i<n;i++) {
			s[i]=new Employee();
			s[i].getdata();
			s[i].show();
		}
		
	}
}