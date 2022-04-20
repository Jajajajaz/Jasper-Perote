package ServerEcho;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class EchoClient {
	public static void main(String[] args) {
		System.out.println("Echo Client");	
		try{
			InetAddress localHost = InetAddress.getLocalHost();		
			Socket socket = new Socket(localHost,8000);				
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);		
			BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));		
			
			System.out.println("Connected to Server!\nStatus: Operation");		
			Scanner scanner = new Scanner(System.in);				
			while(true){
				System.out.println("\nEnter text: ");		
				String input = scanner.nextLine();
				if("exit".equalsIgnoreCase(input)){				
					break;
				}
				
				out.println(input);			
				String response = buffer.readLine();		
				System.out.println("\nSend to Server: "+response);		
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}