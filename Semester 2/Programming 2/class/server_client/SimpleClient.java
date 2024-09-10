package client_server;

import java.util.Scanner; 
import java.io.*;
import java.net.*;
public class SimpleClient {
	public static void main(String[] args) throws IOException{
		Socket s=new Socket("localhost",2214); //"127.0.0.1" OR "????"
		DataOutputStream out=new DataOutputStream(s.getOutputStream());
		DataInputStream in=new DataInputStream(s.getInputStream());	    
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		String msg="";

		System.out.println("Waiting for a message from the server....");
		msg=in.readUTF();
		System.out.println("Server:"+msg);
		System.out.print("Client: ");
		out.writeUTF(myObj.nextLine()+"\n");

		in.close();
		s.close();

	}
}