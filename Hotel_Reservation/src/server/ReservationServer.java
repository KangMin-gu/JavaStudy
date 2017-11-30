package server;
import java.io.*;
import java.net.*;
import java.util.*;


public class ReservationServer {
	
	public static void main(String[] args) {
		try{
			ServerSocket ssocket = new ServerSocket(7878);
			System.out.println("Server Standby!!!");
			
			while(true) {
				Socket socket = ssocket.accept();
				ObjectInputStream nois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream noos = new ObjectOutputStream(socket.getOutputStream());
				
				ReservationThread thread = new ReservationThread(nois, noos);
				Thread t = new Thread(thread);
				t.start();
			}//while
		}catch(Exception e){
			e.printStackTrace();
		}//catch
	}//main

}
