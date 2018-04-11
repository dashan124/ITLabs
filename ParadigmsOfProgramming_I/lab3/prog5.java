import java.util.*;
import java.util.Scanner;
class SurfaceArea{
	double Area(double radius,double length){
		return(3.14*(radius*(radius+length)));
	}
	double Area(int radius,int height){
		return(2*3.14*(radius*(radius+height)));
	}
	int Area(int a,int b,int c){
		return(2*((a*b)+(b*c)+(c*a)));
	}
	double Area(double l,double w,double h){
		return((l*w)+(l*(Math.sqrt(((w*w)/4)+(h*h))))+(w*Math.sqrt(((l*l)/4)+(h*h))));
	}
	double Area(int radius){
		return(3.14*3*radius*radius);
	}
}
class prog5{
	public static void main(String args[]){
		System.out.println("enter your choice:");
		System.out.println("1.cone");
		System.out.println("2.cylinder");
		System.out.println("3.rectangular prism");
		System.out.println("4.pyramid");
		System.out.println("5.hemisphere");
		Scanner s=new Scanner(System.in);
		SurfaceArea area=new SurfaceArea();
		int n=s.nextInt();
		if(n==1){
			double radius=s.nextDouble();
			double length=s.nextDouble();
			System.out.println("the area of cone is"+area.Area(radius,length));
		}
		else if(n==2){
			double radius=s.nextDouble();
			double height=s.nextDouble();
			System.out.println("the area of the cylinder"+area.Area(radius,height));
		}
		else if(n==3){
			int a=s.nextInt();
			int b=s.nextInt();
			int c=s.nextInt();
			System.out.println("the area of the rectangular prism is"+area.Area(a,b,c));
		}
		else if(n==4){
			double x=s.nextDouble();
			double y=s.nextDouble();
			double z=s.nextDouble();
			System.out.println("the area of the pyramid is "+area.Area(x,y,z));
		}
		else if(n==5){
			int r=s.nextInt();
			System.out.println("the area of hemisphre is "+area.Area(r));
		}
	}
}