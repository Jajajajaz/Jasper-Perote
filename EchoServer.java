package ServerEcho;

import java.io.*;
import java.net.*;


public class EchoServer {
	public static void main(String args[]){
		System.out.println("Echo Server");
		try(ServerSocket echoServer = new ServerSocket(8000)){	
			Socket clientSocket = echoServer.accept();			
			System.out.println("Connected to Client");	
			BufferedReader bufferReader = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));	
			PrintWriter outPut = new PrintWriter(clientSocket.getOutputStream(),true);	
			String line;
			while((line = bufferReader.readLine()) != null){	
				System.out.println("\nMessage from Client: "+line);		
				outPut.println(line);							
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}