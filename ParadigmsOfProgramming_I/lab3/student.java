import java.util.*;
import java.util.Scanner;


	class Student{  
	 int rollno;  
	 String name;
	 int semester;
	 double sgpa; 
	 void insertRecord(int r, String n,int s,double t){  
	  rollno=r;  
	  name=n;  
	  semester=s;
	  sgpa=t;
	 }  
	 void displayInformation(){System.out.println("roll no:- "+rollno);
	 System.out.println("Name:- "+name);
	 System.out.println("Semester:- "+semester);
	 System.out.println("sgpa:- "+sgpa);
	 }  
	}  
	class TestStudent4{  
	 public static void main(String args[]){  
	 Scanner s=new Scanner(System.in);
	 System.out.println("Enter the number of total students in collage");
	 int q=s.nextInt();
	 
	 for(int i=0;i<q;i++){
		 
		 Student si=new Student();
		 System.out.println("Enter the student name:");
	   si.name=s.nextLine();
	   System.out.println("Enter the STudent roll no:");
	   si.rollno=s.nextInt();
	   System.out.println("Enter the marks of the student");
	   si.sgpa=s.nextDouble();
	   System.out.println("Enter the semster no of the student:");
	   si.semester=s.nextInt();
	   si.displayInformation();
	 }  
	}
	}
  