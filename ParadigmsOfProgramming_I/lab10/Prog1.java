import java.lang.*;

class A implements Runnable{
	public void run(){
		try{
			for(int i=0;i<5;i++){
				System.out.println("Hello!#$@$%#");
			Thread.sleep(1000);
			}
		}catch(Exception e){
			System.out.println("Error  "+e);
		}
	}
}
class B implements Runnable{
	public void run(){
		try{
			for(int i=0;i<5;i++){
				System.out.println("world!@#");
			Thread.sleep(1000);
			}
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
}
public class Prog1{
public static void main(String args[]){
	A a=new A();
	Thread t1=new Thread(a);
	t1.start();
	B b=new B();
	Thread t2=new Thread(b);
	t2.start();
	try{
		t1.yield();
	t2.yield();
	
	}catch(Exception e){
		System.out.println(e);
	}
	System.out.println("hello java");

}
}