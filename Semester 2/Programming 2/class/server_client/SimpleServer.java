package client_server;

import java.util.Scanner;  
import java.io.*;
import java.net.*;
public class SimpleServer  {
	public static void main(String[] args) throws IOException{
		int portID=2214;
		try{
			ServerSocket ss=new ServerSocket(portID);
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			int j=0;
			while(j++<3){
				Socket s=ss.accept();
				DataOutputStream out=new DataOutputStream(s.getOutputStream());
				DataInputStream in=new DataInputStream(s.getInputStream());

				System.out.print("Server: ");
				out.writeUTF(myObj.nextLine()+"\n");
				System.out.println("Waiting for a message from the client....");
				System.out.println(in.readUTF());
				
				out.close();
				s.close();
			}
			ss.close();
			myObj.close();
		}
		catch(IOException e){
			System.err.println("Could not listen at port "+portID);
		}

	}
}

