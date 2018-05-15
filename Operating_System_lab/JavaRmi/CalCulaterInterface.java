import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalCulaterInterface extends Remote{
  public int add(int a,int b) throws RemoteException;
  public int substarct(int a,int b) throws RemoteException;
  public int multiply(int a,int b) throws RemoteException;
  public double divide(int a,int b) throws RemoteException;
}
