package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread{
	
	private Socket socket;
	
	@Override
	public void run(){
		super.run();
		
		try {
			while(true) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String receiveData;
				
			}
		
	
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
	
	public void setSocket(Socket _socket) {
		
		socket= _socket;
		
	}
	

}
