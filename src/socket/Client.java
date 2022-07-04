package socket;


import java.io.IOException;

import java.net.Socket;

public class Client {
	
	static Socket clientSocket;
	
	public void ConnectSocketServer() throws IOException{
		
		clientSocket = new Socket("127.0.0.1",8080);
	
		
	}

	public static Socket getSocket() {
		
		return clientSocket;
	}
	
	
	
}
