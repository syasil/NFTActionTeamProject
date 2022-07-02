package Socket;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;

import Database.DatabaseLinker;

public class ServerSocketThread extends Thread implements Serializable{

	private Socket socket;
	private Server server;
	private BufferedReader in;
	private PrintWriter out;
	private ObjectOutputStream oos;
	private String name;
	private String threadName;
	private boolean isManager = true;
/*	
	
	private Connection connection = null;
	private PreparedStatement psmt = null;
	private String sql;
	private ResultSet rs = null;
	
	private BufferedImage image;
	private File imageFile;
	private byte buffer[] = new byte[2048];
*/	
	private AuctionThread auctionThread;
	
	
	
	
	public ServerSocketThread(Server server, Socket socket) {
		 
		this.server = server;
		this.socket = socket;
		threadName = super.getName();
		System.out.println(">>Server: Client " + socket.getInetAddress() + " has Connected...");
		System.out.println("Thread Name : " + threadName);
		
	}
	
	public void sendMessage(String str) {
		
		out.println(str);
		
	}
	public void sendMessage(byte[] bytes, FileInputStream fis) {
		
		
		
	}
	public void sendMessage(Image img) {
		try {
			
			oos.defaultWriteObject();
			oos.writeObject(img);
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void run() {
		
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);//true : auto flush
			oos = new ObjectOutputStream(socket.getOutputStream());
			
			while(true) {
				
				String str_in = in.readLine();
				
				
				String[] strArray = str_in.split(",");
				
				switch (strArray[0]) {
				case "auctionStart":
					
					try {
						
						auctionThread = new AuctionThread(strArray,server,socket);
						auctionThread.start();
			
						
						/*
						DatabaseLinker dbLinker = new DatabaseLinker();
						connection = dbLinker.connectDB();
						
						sql = "select product_image_metadata from product where product_number=?";
						psmt = connection.prepareStatement(sql);
						psmt.setString(1, strArray[1]);
						rs = psmt.executeQuery();
						 
						 
						rs.next();
						System.out.println(rs.getString(1));
						System.out.println("image/product/" + rs.getString(1) + ".png");
						Image img = ImageIO.read(new File("D:/development/NFTActionTeamProject/SocketServer/image/product/" + rs.getString(1) + ".png"));
						
						File imgPath = new File("D:/development/NFTActionTeamProject/SocketServer/image/product/" + rs.getString(1) + ".png");
						FileInputStream fis = new FileInputStream(imgPath);
						ByteArrayInputStream baos = new ByteArrayInputStream();
						//server.broadCasting(img);
						
						*/
	
					} catch (Exception e) {
						
						e.printStackTrace();
						
					}
					
					break;
					
				case "bid":
					System.out.println(str_in);
					AuctionThread.setPrice(strArray[1]);
					server.broadCasting(",priceChange," + strArray[1]);
					
					break;

				default:
					break;
				}
				
				
					
					
				
					
			}
				
			
				
			
			
		} catch (IOException e) {
			
			System.out.println(">>Server : Client " + socket.getInetAddress() + " is terminated the connection...");
			server.removeClient(this);
			
		} finally {
			
				try {
					
					socket.close();
					
				} catch (IOException e2) {
					
					e2.printStackTrace();
					
				}
			
			
		}
		
	}



	

	

}
