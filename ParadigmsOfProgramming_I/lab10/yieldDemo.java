import java.lang.*;

// MyThread extending Thread
class MyThread extends Thread
{
	public void run()
	{
		try{
			for (int i=0; i<5 ; i++){
System.out.println(Thread.currentThread().getName()
								+ " in control");
Thread.sleep(1000);
	}
		}catch(Exception e){
			System.out.println("Error"+e);
		}
		}
}

// Driver Class
public class yieldDemo
{
	public static void main(String[]args)
	{
		MyThread t = new MyThread();
		t.start();

		for (int i=0; i<5; i++)
		{
			// Control passes to child thread
			Thread.yield();

			// After execution of child Thread
			// main thread takes over
			System.out.println(Thread.currentThread().getName()
								+ " in control");
		}
	}
}
