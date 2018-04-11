import java.util.*;
import java.util.Scanner;
/*
 * 4.Using the concept of passing object as parameter implement a java program
to calculate total score of each students in class(consider 5 to 10 students and
5 subjects).
 */
class Student1{
	String name;
	int rollno;
	int m1;
	int m2;
	int m3;
	int m4;
	int m5;
	void total(int m1,int m2,int m3,int m4,int m5) {
		int t=m1+m2+m3+m4+m5;
		System.out.println("the total marks of the student"+t);
	}
}
class Student {
public static void main(String args[]) {
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	Student1[] c=new Student1[n];
	for(int i=0;i<n;i++) {
		c[i]=new Student1();
		System.out.println("Enter the name of the student:");
		c[i].name=s.nextLine();
		System.out.println("enter the roll no");
		c[i].rollno=s.nextInt();
		System.out.println("Enter the marks in first subject");
		c[i].m1=s.nextInt();
		System.out.println("marks in second subject");
		c[i].m2=s.nextInt();
		System.out.println("marks in third subject");
		c[i].m3=s.nextInt();
		System.out.println("marks in fourth subject");
		c[i].m4=s.nextInt();
		System.out.println("marks in fifth subject");
		c[i].m5=s.nextInt();
	}
}
}
