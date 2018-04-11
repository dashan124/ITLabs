import java.io.Serializable;
interface A
{
    int a = 10;
    public void Msg1();
    public void Msg2();

}
interface B extends A{
    public void Complex1();
    public void Complex2();
}
//here we are doing simple inheritence
class C implements B
    {
    public void Msg1()
    {
        System.out.println("M1 from inheritance in interfaces: " + a);

    }
    public void Msg2()
    {
        System.out.println("M2 from inheritance in interfaces");
    }
   
    public void Complex1() {
        System.out.println("Complex1 from inheritance in interfaces");
    }

    public void Complex2() {
        System.out.println("Complex2 from inheritance in interfaces");
    }
   
    public static void main(String[] args)
    {
        C c = new C();
        c.Msg1();
        c.Msg2();
    }
}
//implementing Markerinterface
class MI implements Cloneable
{
    int i;
    String s;
 
    // MI class constructor
    public MI(int i,String s)
    {
        this.i = i;
        this.s = s;

    }
 
    // Overriding clone() method
    // by simply calling Object class
    // clone() method.
    protected Object clone()
    throws CloneNotSupportedException
    {
        return super.clone();
    }
    public static void main(String[] args) throws CloneNotSupportedException
    {
        MI m = new MI(20, "Marker Interface implementations");
 
        // cloning 'a' and holding
        // new cloned object reference in b
 
        // down-casting as clone() return type is Object
        MI b = (MI)m.clone();
 
        System.out.println(b.i);
        System.out.println(b.s);
    }

}
//implementing adapter class
class ADP implements A{
    public void Msg1()
    {

    }
    public void Msg2()
    {
        System.out.println("Inherited from Adapter class, where other method is not implemented");
    }
    public static void main(String[] args){
        ADP o = new ADP();
        o.Msg2();
    }
}
//implementing interface inside class
class IC
{
    public void m1(){
        System.out.println("Normal Method in class containing interface");

    }
    interface ICi{
        public void m2Ic();
    }  
    public static void main(String[] args){
        IC b= new IC();
        b.m1();
    }
}
class ICE implements IC.ICi{
    public void m2Ic(){
        System.out.println("Method overriden for implementing interface defined inside class");
    }
    public static void main(String[] args){
        ICE f = new ICE();
        f.m2Ic();
    }

}
//implementing abstract class using interfaces
abstract class AC implements A{
    public void Msg1()
    {
        System.out.println("Overriding only one method in abstract class");
    }
  
}
class Call extends AC{
    public void Msg2()
    {
        System.out.println("Overriding M2 by inheriting from abstract class");
    }
    public static void main(String[] args){
        Call o = new Call();
        o.Msg1();
        o.Msg2();
    }
}
//here lets create a nested interface
interface n1{
    public void m1();
    interface n2{
        public void m2();
    }
}
class C1 implements n1
{
    public void m1(){
        System.out.println("Nested Interfaces M1");
    }
}
class C2 implements n1.n2
{
    public void m2(){
        System.out.println("Nested Interfaces M2");
    }
}
class Interfaces
{
    public static void main(String args[]){
        String[] arg = {};
        C.main(arg);
        try{
            MI.main(arg);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        ADP.main(arg);
        IC.main(arg);
        ICE.main(arg);
        Call.main(arg);
        C2 obj = new C2();
        obj.m2();
        C1 obj1 = new C1();
        obj1.m1();
    }
}