package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import functions.ResizeImage;
import functions.SlidingAnimate;
import socket.Client;
import swing.CButton;
import swing.CLabel;
import swing.CPanel;

public class PanelMain  extends CPanel implements Runnable {
	
	private CLabel lblRemainText;
	private CLabel lblRemainTime;
	private CLabel lblMinBidPrice;
	private CLabel lblcurrentPrice;
	private CButton btnBidding;
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	private String in_str;
	private String[] data;
	private int timer;
	private int price;
	private Object bidPrice;
	
	
	
	// 카운트 다운 시계
	//private Countdown cd;
	
	public PanelMain() {
		super("images/bg.jpg");
		initComponents();
	}
	
	private void initComponents() {
		setLayout(null);
		setBounds(0, 0, 600, 900);
	
		CLabel lblTitle = new CLabel("라이브 아트");
		lblTitle.setBounds(10, 10, 500, 50);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 36));

		CLabel lblAuthor = new CLabel("Team#3");
		lblAuthor.setBounds(15, 60, 500, 20);
		lblAuthor.setForeground(Color.LIGHT_GRAY);
		
		ImageIcon img = ResizeImage.resize("images/sample2.jpg", 500, 500);
		CPanel pnlAuction = new CPanel(img, 20);
		pnlAuction.setLayout(null);
		pnlAuction.setBounds(50, 120, 500, 500);
		
		pnlAuction.add(lblTitle);
		pnlAuction.add(lblAuthor);
		
		lblRemainText = new CLabel("Auction end in");
		lblRemainText.setBounds(50, 630, 500, 30);
		lblRemainText.setHorizontalAlignment(JLabel.RIGHT);
		
		lblRemainTime = new CLabel("0h 0m 0s");
		lblRemainTime.setBounds(50, 660, 500, 30);
		lblRemainTime.setFont(new Font("Helvetica", Font.BOLD, 32));
		lblRemainTime.setForeground(new Color(197, 38, 157));
		lblRemainTime.setHorizontalAlignment(JLabel.RIGHT);
		
		lblcurrentPrice = new CLabel("0");
		lblcurrentPrice.setBounds(50, 710, 500, 30);
		lblcurrentPrice.setFont(new Font("Helvetica", Font.BOLD, 32));
		lblcurrentPrice.setForeground(new Color(255, 255, 255));
		lblcurrentPrice.setHorizontalAlignment(JLabel.RIGHT);
		
		lblMinBidPrice = new CLabel("0");
		lblMinBidPrice.setBounds(50-(25*lblcurrentPrice.getText().length()), 714, 500, 30);
		lblMinBidPrice.setFont(new Font("Helvetica", Font.BOLD, 20));
		lblMinBidPrice.setForeground(new Color(255, 255, 255));
		lblMinBidPrice.setHorizontalAlignment(JLabel.RIGHT);
		
		btnBidding = new CButton("입찰", "DARK");
		btnBidding.setBounds(430, 750, 120, 30);
		btnBidding.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!Main.USER_ID.equals("")) {
					System.out.println("bid,"+lblMinBidPrice.getText()+","+Main.USER_NO);
					out.println("bid,"+lblMinBidPrice.getText()+","+Main.USER_NO);
					
				}
			}
		});
		
		
		add(pnlAuction);
		add(lblRemainText);
		add(lblRemainTime);
		add(lblcurrentPrice);
		add(lblMinBidPrice);
		add(btnBidding);
		initNet();
		/*
		if(cd != null) cd.stopCountdown();
		cd = new Countdown(lblRemainTime, 500); // 쓰레드객체생성
		cd.start(); // 쓰레드실행
		*/
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

	
	
	@Override
	public void run() {
		while(true) {
			try {
	
				data = in.readLine().split(",");

				switch (data[1]) {
				
					case "timer":
						
						
						timer = Integer.parseInt(data[3]);
						price = (int) Math.floor(Float.parseFloat(data[4]));
						
						
						lblRemainTime.setText(timer/3600 + " h " + timer/60 + " m " + timer%60 + " s" );	
						lblcurrentPrice.setText("" + price);
						lblMinBidPrice.setText("" + (int)Math.floor(price * 1.1));
						lblMinBidPrice.setLocation(50-(25*lblcurrentPrice.getText().length()),714);
						
						
						break;
						
					case "priceChange":
						System.out.println("priceChange"+data[2]);
						price = (int) Math.floor(Float.parseFloat(data[2]));
						
						lblcurrentPrice.setText("" + price);
						lblMinBidPrice.setText("" + (int)Math.floor(price * 1.1));
						
						break;
	
					default:
						break;
					}
				
				
				
				
			} catch (Exception e) {
	
	
				
			}
		}
	}
}
