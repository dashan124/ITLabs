import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalClinet{
  public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    try{
      Registry myReg=LocateRegistry.getRegistry("127.0.0.1",1099);
      CalCulaterInterface c=(CalCulaterInterface)myReg.lookup("mycalc");

      System.out.println("Enter two numbers for calc opeartions:");
      int a=s.nextInt();
      int b=s.nextInt();
      System.out.println("a+b  = "+c.add(a,b));
      System.out.println("a+b  = "+c.substarct(a,b));
      System.out.println("a+b  = "+c.multiply(a,b));
      System.out.println("a+b  = "+c.divide(a,b));


    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
