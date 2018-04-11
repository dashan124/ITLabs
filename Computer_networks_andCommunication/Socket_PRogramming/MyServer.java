import java.net.*;
import java.io.*;
import java.util.*;
class MyServer{
  private ServerSocket ss=null;
  private Socket s=null;
  private DataOutputStream dout=null;
  private DataInputStream din=null;
  private BufferedReader br=null;
public MyServer(int port){
  try{
 ss=new ServerSocket(port);
 System.out.println("Server Ready");

 s=ss.accept();
 System.out.println("Clinet Connected");
din=new DataInputStream(s.getInputStream());
 dout=new DataOutputStream(s.getOutputStream());
 br=new BufferedReader(new InputStreamReader(System.in));
}
catch(Exception e){
  System.out.println("Error Server $\n"+e);
  System.exit(0);
}
String str="",str2="";
while(!str.equals("stop")){
  try{
str=din.readUTF();
System.out.println("client says: "+str);
str2=br.readLine();
dout.writeUTF(str2);
dout.flush();
}
catch(Exception e){
  System.out.println("Exception while reading data\n"+e);
  System.exit(0);
}
}
try{
din.close();
s.close();
ss.close();
System.out.println("Closing Connection");
}
catch(Exception e){
  System.out.println("Error while Closing Server\n"+e);
  System.exit(0);
}
}
public static void main(String args[]){
  MyServer server=new MyServer(3333);
}}
