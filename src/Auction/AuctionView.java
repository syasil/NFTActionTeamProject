package Auction;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import socket.Client;

public class AuctionView extends JFrame implements Runnable{

	
	private JLabel imageLabel = new JLabel();
	private JTextPane timerTextPane = new JTextPane(); 
	private JTextPane currentPriceTextPane = new JTextPane(); 
	private JTextPane minBidPricePriceTextPane = new JTextPane();
	
	private Socket socket;
	private Image img;
	private BufferedReader in;
	private String in_str;
	private String[] data;
	private int timer;
	private JTextField priceTextField;
	private int price;
	private JButton bidButton = new JButton();
	private double bidPrice;
	private PrintWriter out;
	
	
	
	
	public AuctionView() {
		
		init();
		initNet();
		start();
		
	}
	
	
	private void initNet() {
		
		try {
			
			socket = Client.getSocket();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			
			
			
			
		} catch (UnknownHostException e) {
			
			System.out.println("IP 주소가 다릅니다.");
			
		} catch (IOException e) {
			
			System.out.println("접속 실패");
			
		}
		
		Thread thread = new Thread(this);
		thread.start();
		
	}


	private void start() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}


	private void init() {
		
		setSize(400,500);
		setLocation(400,400);
		getContentPane().setLayout(null);
		setVisible(true);
		
		imageLabel.setBounds(120,20,100,100);
		imageLabel.setOpaque(true);
		imageLabel.setBackground(Color.DARK_GRAY);
		getContentPane().add(imageLabel);
		
		timerTextPane.setBounds(130,140,100,30);
		timerTextPane.setFont(new Font("맑은 고딕",Font.BOLD,15));
		timerTextPane.setBackground(SystemColor.menu);
		timerTextPane.setText("남은시간");
		getContentPane().add(timerTextPane);
		
		
		currentPriceTextPane.setBounds(80,180,200,30);
		currentPriceTextPane.setFont(new Font("맑은 고딕",Font.BOLD,15));
		currentPriceTextPane.setBackground(SystemColor.menu);
		currentPriceTextPane.setText("현재 가격 : ");
		getContentPane().add(currentPriceTextPane);
		
		minBidPricePriceTextPane.setBounds(80,220,200,30);
		minBidPricePriceTextPane.setFont(new Font("맑은 고딕",Font.BOLD,15));
		minBidPricePriceTextPane.setBackground(SystemColor.menu);
		minBidPricePriceTextPane.setText("최소 입찰가 : ");
		getContentPane().add(minBidPricePriceTextPane);
		
		priceTextField = new JTextField();
		priceTextField.setBounds(80, 260, 100, 30);
		getContentPane().add(priceTextField);
		
		
		bidButton = new JButton();
		bidButton.setBounds(190, 260, 60, 30);
		bidButton .setText("입찰");
		bidButton.setBackground(Color.lightGray);
		bidButton.addActionListener(e ->{
			
			Bidding();
			
		});
		getContentPane().add(bidButton);
		
		
	}


	private void Bidding() {
		
		if(priceTextField.getText().equals("")) {
			bidPrice = (int) price * 1.1;
			
		}else {
			try {
				
				bidPrice = Integer.parseInt(priceTextField.getText());
				if(bidPrice < price * 1.1) {
					System.out.println("최소입찰가보다 큰 값을 입력해주십시오.");
					return;
				}
			}
			catch(Exception e){
				
				System.out.println("숫자를 입력해주십시오.");
				
			}
			
			
		}
		
		System.out.println(bidPrice);
		out.println("bid,"+bidPrice+",0"); //0 관리자; 입찰자 없음 noBidder
		
			
		
		
		
	}


	@Override
	public void run() {
		
		while(true) {
			try {

				in_str= in.readLine();
				data = in_str.split(",");
				System.out.println(in_str);
				for (int i = 0; i < data.length; i++) {
					System.out.println(i +" : "+ data[i]);
				}
				
				
				switch (data[1]) {
				
					case "timer":
						
						
						timer = Integer.parseInt(data[3]);
						price = (int) Math.floor(Float.parseFloat(data[4]));
						System.out.println(price);
						timerTextPane.setText(timer/60 + " 분 " + timer%60 + " 초" );
						for (int i = 0; i < data.length; i++) {
							System.out.println(data[i]);
						}
						
						currentPriceTextPane.setText("현재 가격 : " + price);
						minBidPricePriceTextPane.setText("최소 입찰가 : " + (int)(price * 1.1));
						
						break;
						
					case "priceChange":
						System.out.println("priceChane"+data[2]);
						price = (int) Math.floor(Float.parseFloat(data[2]));
						
						currentPriceTextPane.setText("현재 가격 : " + price);
						minBidPricePriceTextPane.setText("최소 입찰가 : " + (int)(price * 1.1));
						
						break;
	
					default:
						break;
					}
				
				
				
				
			} catch (Exception e) {


				
			}
		}
		
		
	}




}
