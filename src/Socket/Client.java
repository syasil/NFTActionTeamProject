package Socket;


import java.io.IOException;

import java.net.Socket;

public class Client {
	
	static Socket clientSocket;
	
	public void ConnectSocketServer() throws IOException{
		
		clientSocket = new Socket("127.0.0.1",8080);
		
		ReceiveThread receiveThread = new ReceiveThread();
		receiveThread.setSocket(clientSocket);
		receiveThread.start();
		
		
		
	}

	public static Socket getSocket() {
		// TODO Auto-generated method stub
		return clientSocket;
	}
	
	
	
}
