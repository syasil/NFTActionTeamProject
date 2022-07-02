package NftAuction;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Auction.AuctionRegisterPage;
import Auction.AuctionView;
import ProductRegisterPage.FacadeProductRegisterPage;
import socket.Client;

public class TestMain {
	

	private JFrame mainFrame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestMain window = new TestMain();
					
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TestMain() {
		initialize();
		
		
	}

	
	private void initialize() {
		
		
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 600, 900);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		
		Client clientSocket = new Client();
		try {
			
			clientSocket.ConnectSocketServer();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JButton productRegisterPageButton= new JButton();
		productRegisterPageButton.setBounds(20, 20, 20, 20);
		productRegisterPageButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FacadeProductRegisterPage facadeproductRegisterPage = new FacadeProductRegisterPage();
				
			}
		});
		mainFrame.add(productRegisterPageButton);
		
		
		
		JButton productListButton= new JButton();
		productListButton.setBounds(20, 60, 20, 20);
		productListButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//ProductList productList = new ProductList();
				//productList.selectList();
				AuctionRegisterPage auctionRegisterPage = new AuctionRegisterPage();
			
				
				
			}
		});
		mainFrame.add(productListButton);
		
		JButton auctionViewButton= new JButton();
		auctionViewButton.setBounds(20, 100, 20, 20);
		auctionViewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new AuctionView();
	
			}
		});
		mainFrame.add(auctionViewButton);
		
	}
}
