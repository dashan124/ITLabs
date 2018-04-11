import java.net.*;
import java.io.*;
import java.util.*;

class Client{
  private Socket socket=null;//create a variable for socket for client side to connect with the server
  private DataInputStream input=null;
  private DataOutputStream out=null;

  public Client(String address,int port){
    try{
      socket=new Socket(address,port);
      System.out.println("Connection Established@nitk");
      input=new DataInputStream(System.in);//input from the terminal
      out=new DataOutputStream(socket.getOutputStream());//send data to the socket
    }catch(Exception e){
      System.out.println("Error Occured Exception  "+e);
    }
    String line="";
    while(!line.equals("Over")){
      try{
        line=input.readLine();
        out.writeUTF(line);
      }catch(Exception e){
        System.out.println("Error Code "+e);
      }
    }
    try{
      input.close();//closing the input stream
      out.close();
      socket.close();
    }catch(Exception e){
      System.out.println("Error while Closing "+e);
    }
  }
  public static void main(String args[]){
    Client client=new Client("local",5000);//creates a clinet object with this creadential
  }
}
