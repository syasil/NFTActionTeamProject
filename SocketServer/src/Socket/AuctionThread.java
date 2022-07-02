package Socket;

import java.net.Socket;

import Database.AuctionEndProductInsert;

public class AuctionThread extends Thread implements Runnable{

	
	
	private String[] strArray;
	private Server server;
	private Socket socket;
	private int second;
	private static String price;

	public AuctionThread(String[] strArray, Server server, Socket socket) {
		
		this.strArray = strArray;
		this.server = server;
		this.socket = socket;
		this.second = Integer.parseInt(strArray[2]);
		this.price = strArray[3];
		
		AuctionEndProductInsert productInsert = new AuctionEndProductInsert(); 
		
		
	}

	@Override
	public void run() {

		while(true) {
			try {
				
				Thread.sleep(1000);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			if(second > 0) {
				
				
				server.broadCasting(",timer" + "," + strArray[1] + "," + --second + "," + price);
				System.out.println("남은 시간 : " + second);
				System.out.println("현재가격 : " + price);
				
				
			}
			else{
				
				
				System.out.println(">> SERVER: Auction has ended.");
				server.broadCasting(",auctionEnd");
				
				productInsert.
				
				
				
				break;
				
			}
		
		}

	}

	public static void setPrice(String str) {
		
		price = str;
		
	}
}