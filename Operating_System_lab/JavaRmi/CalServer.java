import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalServer{
  public static void main(String args[]){
    /*
    Registry is a remote interface to a simple remote
     object registry that provides methods for storing
     and retrieving remote object references bound with arbitrary string names.
      The bind, unbind, and rebind methods are used to alter the name bindings
      in the registry, and the lookup and list methods are used to query
      the current name bindings.
    */
    try{
      Registry reg=LocateRegistry.createRegistry(1099);
      ImplementCal c=new ImplementCal();
      reg.rebind("mycalc",c);
      System.out.println("Server is Ready ...........");
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
