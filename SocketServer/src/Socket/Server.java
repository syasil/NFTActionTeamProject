package Socket;


import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Server implements Runnable, Serializable{
	
	private Socket socket;
	List<ServerSocketThread> list;
	
	

	
	public Server() {
		
		list = new ArrayList<ServerSocketThread>();
		System.out.println(">> Server is up and running...");
		
	}
	public void giveAndTake() {
		
		try (ServerSocket serverSocket= new ServerSocket(8080)){
			
			serverSocket.setReuseAddress(true);
			
			while(true) {
				
				socket = serverSocket.accept();
				ServerSocketThread thread = new ServerSocketThread(this, socket);
				addClient(thread);
				thread.start();
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	private synchronized void addClient(ServerSocketThread thread) {
		
		list.add(thread);
		System.out.println(">> Server: One client has connected... \nConnecting a total of " + list.size() +" clients");
		
		
	}
	
	protected synchronized void removeClient(ServerSocketThread thread) {
		
		list.remove(thread);
		System.out.println(">> Server: One client terminated the connection... \nConnecting a total of " + list.size() +" clients");
		
		
	}
	
	protected synchronized void broadCasting(String str) {
		
		for (int i = 0; i < list.size(); i++) {
			
			ServerSocketThread thread = list.get(i);
			thread.sendMessage(str);
		}

	}
		
	protected synchronized void broadCasting(byte[] bytes, FileInputStream fis) {
		
		for (int i = 0; i < list.size(); i++) {
			
			ServerSocketThread thread = list.get(i);
			thread.sendMessage(bytes, fis);
			
		}
		
	}
	protected synchronized void broadCasting(Image img) {
		
		for (int i = 0; i < list.size(); i++) {
					
			ServerSocketThread thread = list.get(i);
			thread.sendMessage(img);
			
		}
	}
	
	

	
	/*
	public static void main(String[] args) throws IOException{
		
		ExecutorService eService = Executors.newFixedThreadPool(5);
		//쓰레드 생성, 6번 째 접속부터는 제한

		
		
	
		
		try (ServerSocket serverSocket= new ServerSocket(8080)){

			
			while(true) {
				
				System.out.println("기다리는 중");
				clientSocket = serverSocket.accept(); //클라이언트의 연결 수락
				System.out.println(">>User is Connected : "+ clientSocket.getInetAddress());
				
				Server server = new Server(clientSocket);
				
				eService.submit(server);
			
		
				
			
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(">> server is disconnected...");
		eService.shutdown();
		
	
		
	}
*/
	@Override
	public void run() {
		
		try {
			while(true) {
				
				
				
				
				
				
			
			}
			
			
		
			
		}
		catch(Exception e){
			
		}
		
		
		/*
		SendThread sendThread = new SendThread();
		sendThread.setSocket(clientSocket);
		sendThread.start();
		
		ReceiveThread receiveThread = new ReceiveThread();
		receiveThread.setSocket(clientSocket);
		receiveThread.start();
		
		 */
		
	}
	
	

	
}

