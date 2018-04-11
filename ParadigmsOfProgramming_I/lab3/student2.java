import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;
class Student
{
	String name;
	int roll_no;
	int sem;
	int sub1,sub2;
	int total;
	float per;
	void getdata() 
	{
		Scanner br=new Scanner(System.in);
		System.out.println ("Enter Name of Student");
		name = br.nextLine();
		System.out.println ("Enter Roll No. of Student");
		roll_no = br.nextInt();
		System.out.println("Enter the semester of the student:");
		sem=br.nextInt();
		System.out.println ("Enter marks out of 100 of 1st subject");
		sub1 = br.nextInt();
		System.out.println ("Enter marks out of 100 of 2nd subject");
		sub2 = br.nextInt();
	}
	void show()
	{
		total=sub1+sub2;
		per=(total*100)/200;
		System.out.println ("Roll No. = "+roll_no);
		System.out.println ("Name = "+name);
		System.out.println ("Marks of 1st Subject = "+sub1);
		System.out.println ("Marks of 2nd Subject = "+sub2);
		System.out.println ("Total Marks = "+total);
		System.out.println ("Percentage = "+per+"%");
	}
}
class q2Student
{
	public static void main(String args[]) 
	{  Scanner br=new Scanner(System.in);
	System.out.println("Enter the number of students:");
		int n=br.nextInt();
		Student[] s=new Student[n];
		for(int i=0;i<n;i++) {
			s[i]=new Student();
			s[i].getdata();
			s[i].show();
		}
		
	}
}