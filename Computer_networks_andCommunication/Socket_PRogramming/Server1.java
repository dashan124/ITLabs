import java.net.*;
import java.io.*;
import java.util.*;


class Server{
  private Socket socket=null;
  private ServerSocket serversocket=null;
  private DataInputStream din=null;
  //server only need port number to connect with the client
  public Server(int port){
    try{
      serversocket=new ServerSocket(port);
      System.out.println("Connected to Server!!!");
      //waits for cient
      socket=serversocket.accept();//accept the client request
      System.out.println("Clinet Connected");
      din=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
      String line="";
      while(!line.equals("Over")){
        try{
          line=din.readUTF();//read the encoded data
        //  out.writeUTF(line);
        System.out.println(line);
        }catch(Exception e){
          System.out.println("Error Code "+e);
        }
      }
      System.out.println("Closing the Connection");
      socket.close();
      din.close();
    }catch(Exception e){
      System.out.println("Error while Connecting with the server \n"+e);
    }
  }
  public static void main(String args[]){
     Server server = new Server(5000);
  }
}
