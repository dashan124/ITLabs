import java.lang.*;

class A implements Runnable{
	public void msg(){
		try{
			System.out.println("Hello!#$@$%#");
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("Error  "+e);
		}
	}
}
class B implements Runnable{
	public void run(){
		try{
			System.out.println("world!@#");
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
}
public class Prog{
public static void main(String args[]){
	A a=new A();
	Thread t1=new Thread(a);
	t1.start();
	B b=new B();
	Thread t2=new Thread(b);
	t2.start();

}
}