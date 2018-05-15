import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import java.rmi.RemoteException;



public class ImplementCal extends UnicastRemoteObject implements CalCulaterInterface{
/*Used for exporting a remote object with JRMP
and obtaining a stub that communicates to the remote object.
*/
  public ImplementCal() throws RemoteException{

  }
  public int add(int a,int b){
    return a+b;
  }
  public int substarct(int a,int b){
    return a-b;
  }
  public int multiply(int a,int b){
    return a*b;
  }
  public double divide(int a,int b){
    return a/b;
  }
}
