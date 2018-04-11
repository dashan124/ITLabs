import java.util.Scanner;
class Square
{
	int s;
    //Default Constructor
    Square()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the side of the sqaure");
        this.s = scan.nextInt();
    }

    public void area() {
        System.out.println("Area of square is " + s * s);
    }
}
class Cube
{
    //Constructor with a parameter
    int a;
    Cube(int a)
    {
        this.a = a;
    }

    public void area() {
        System.out.println("Area of cube is " + (6 * a * a));
    }
}
class Rectangle{
    int l,b;
    //Constructor with parameters
    Rectangle(int l,int b){
        this.l = l;
        this.b = b;
    }

    public void area() {
        System.out.println("Area of Rectangle is " + (l * b));
    }

}
class Sphere
{
    //Constructor Overlaoding
    int r;
    double rad;
    final double PI = 3.14;
    Sphere(int r)
    {
    	this.r = r;
    }
    Sphere(double r)
    {
    	this.rad = r;
    }

    public void area() {
    	if (r != null)
        	System.out.println("Area of sphere with integer radius is " + (4 * PI * r * r));
        else 
        	System.out.println("Area of sphere with integer radius is " + (4 * PI * rad * rad));      
    }

}
class AreaCon
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Square s2 = new Square();
        s2.area();
        int s1,l,b,r1;
        double r2;
        System.out.println("Enter side of cube : ");
        s1 = s.nextInt();
        Cube c = new Cube(s1);
        c.area();
        System.out.println("Enter sides of Rectangle : ");
        l = s.nextInt();
        b = s.nextInt();
        Rectangle r = new Rectangle(l,b);
        r.area();
        System.out.println("Enter radius of sphere : ");
        r1 = s.nextInt();
        Sphere sp = new Sphere(r1);
        sp.area();
        System.out.println("Enter radius of Sphere : ");
        r2 = s.nextDouble();
        Sphere sph = new Sphere(r2);
        sph.area();
    }
}