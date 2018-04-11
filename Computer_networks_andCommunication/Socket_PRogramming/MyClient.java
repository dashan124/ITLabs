import java.net.*;
import java.io.*;
import java.util.*;
class MyClient{
  private DataInputStream din=null;
  private DataOutputStream dout=null;
  private Socket s=null;
  private BufferedReader br=null;
public MyClient(String address,int port){
  try{
 s=new Socket("localhost",3333);
 System.out.println("Connected to Server");
din=new DataInputStream(s.getInputStream());
 dout=new DataOutputStream(s.getOutputStream());
 br=new BufferedReader(new InputStreamReader(System.in));
}
catch(Exception e){
  System.out.println("Error while Connecting to client \n"+e);
  System.exit(0);
}
String str="",str2="";
while(!str.equals("stop")){
  try{
str=br.readLine();
dout.writeUTF(str);
dout.flush();
str2=din.readUTF();
System.out.println("Server says: "+str2);

}
catch(Exception e){
  System.out.println("Error reading data client Side\n"+e);
  System.exit(0);
}
}
try{
dout.close();
s.close();
System.out.println("Closing Clinet");
}catch(Exception e){
  System.out.println("Error While Closing Client\n"+e);
  System.exit(0);
}
}
public static void main(String args[]){
  MyClient cli=new MyClient("host",3333);
}
}
