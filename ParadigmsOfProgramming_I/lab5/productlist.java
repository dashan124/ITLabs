/*Write a java program to enter list of products,display list of products ,select
products   based   on   user   choice   and   finally   display   total   cost   for   selected
products and quantity of each product selected.Use static variable and static
method in it.*/
import java.util.*;
import java.util.Scanner;
class Product{
	static String wires="Tas";
	static String motors="motors";
	static String gen="Engine parts";
	static String oil="Engine oil";
	static double pricew=200;
	static double pricemotor=400.00;
	static double pricegen=1000.00;
	static double priceoil=800;
	String name;
	int totalprice;
	int nw;
	int nm;
	int genp;
	int oilq;
	void getdata() 
	{
		Scanner br=new Scanner(System.in);
		System.out.println ("Enter Name of product");
		name = br.nextLine();
		System.out.println ("Enter no of this product you want:");
		n = br.nextInt();
		int nw1=0;
		if(name.eauals(wires))
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
Product(int x,int y,int z,int w){
   nw=x;
   nm=y;
   genp=z;
   oilq=w;
	}
double caltotal(){
		totalprice=nw*pricew+nm*pricemotor+genp*pricegen+oilq*priceoil;
		return totalprice;
	}
public static void main(String args[]){
Scanner s=new Scanner(System.in);
System.out.println("Enter the no of products:");
int n=s.nextInt();
double total=0;
for(int i=0;i<n;i++){
String name=s.nextLine();
Product p=new Product();
int x1=0;
int x2=0;
int x3=0;
int x4=0;
if((p.wires).equals(s)){
x1+=1;
}
else if ((p.motors).equals(s)){
	x2+=1;
}
else if((p.gen).equals(s)){
	x3+=1;
}
else if((p.oil).equals(s)){
	x4+=1;
}
else{
	System.out.println("Try on another shop!!");
}
Product p2=new Product(x1,x2,x3,x4);
total+=p2.caltotal();
}
System.out.println("The total amount is :"+total);
}
}