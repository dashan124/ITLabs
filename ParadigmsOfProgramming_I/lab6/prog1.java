import java.util.*;
import java.util.Scanner;
class personaldetails{
	String name;
	int Id;
	int salry;
	double arp;
}
class appraisal extends personaldetails{
	public double salarynew(){
		return arp*salry/100;
	}
}
class payroll extends appraisal{
	public double payevalu(){
		return salry+this.salarynew();
	}
}
class prog1 extends payroll{
	public static void main(String args[]){
    payroll c=new payroll();
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the name of the employee:");
    c.name=s.nextLine();
    System.out.println("Enter the id of emp:");
    c.Id=s.nextInt();
    System.out.println("Enter the salry of emp:");
    c.salry=s.nextInt();
    System.out.println("Enter the increment in the salry :");
	c.arp=s.nextDouble();
    System.out.println("the total new salry is "+c.payevalu());
    System.out.println("appraisal is "+c.salarynew());
	}
}