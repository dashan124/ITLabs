package labpop;
import java.util.*;
import java.util.Scanner;
/*6.With a java program to create a class for
square,cube,rectangle,sphere,cylinder having different variables use default
constructors,constructors with parameters and over loaded constructor to
assign values and use methods to calculate its area.*/
class Area{
	double radius;
	int side;
	int a;
	int b;
	double height;
	Area(double x){
		radius=x;
	}
	Area(int y){
		side=y;
	}
	Area(int c,int d){
		a=c;
		b=d;
	}
	Area(double r,double h){
		radius=r;
		height=h;
	}
	void cal(double radius) {
		double ar=4*3.14*radius*radius;
		System.out.println("area of the sphere is "+ar);
	}
	void cal(int a,int b) {
		int arr=a*b;
		System.out.println("the area of the rectangle is "+arr);
	}
	void cal(int side) {
		int aree=6*side*side;
		System.out.println("The area of the cube is"+aree);
	}
	void cal(double radius,double height) {
		double art=2*3.14*radius*(radius+height);
		System.out.println("The area of the cylinder is "+art);
	}
	void cal1(int side) {
		int ary=side*side;
		System.out.println("The ares of the square is "+ary);
	}
}
public class Prog6 {
public static void main(String args[]) {
	Area hj=new Area();
	hj.cal(3,4);
}
}
