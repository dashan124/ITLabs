package app1;
import java.lang.*;
import java.lang.Runnable;
class Multithread implements Runnable{
public void run() {
	try{
		System.out.println("Thread"+Thread.currentThread().getId()+"is running");
	}catch(Exception e) {
		System.out.println("Error while making a thread"+e);
	}
}
}
public class MultithreadingInterFace {
public static void main(String args[]) {
	Multithread o =new Multithread();
	Thread a=new Thread(o);
	a.start();
}
}
