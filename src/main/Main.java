package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.LabelPeer;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;

import ProductRegisterPage.FacadeProductRegisterPage;
import ProductRegisterPage.ProductRegister;
import blockchain.BlockChain;
import functions.SlidingAnimate;
import product.ProductAdd;
import socket.Client;
import swing.CButton;
import user.FindPassword;
import user.UserJoin;
import user.UserLogin;

public class Main extends JFrame {

	//////////////////////////////////////////
	// 프로그램 전체에서 쓰이는 변수 선언
	//////////////////////////////////////////
	public static String USER_ID = "";
	public static String USER_NICKNAME = "";
	public static String USER_NO = "";

	//////////////////////////////////////////
	// 각 패널들 변수 선언
	//////////////////////////////////////////

	public static JLayeredPane pane; // 패널들을 넣을 레이어드 팬

	public static UserLogin pnlLogin;
	public static UserJoin pnlJoin;
	public static FindPassword pnlPassword;
	public static ProductAdd pnlProduct;

	public static PanelTop pnlTop;
	public static PanelMain pnlMain;
	public static PanelOpaque pnlOpaque;

	public static CButton btnAddProduct;
	private ProductRegister pannelProductRegister;

	public Main() {
		initComponents();
	}

	private void initComponents() {

		initNet();
		setTitle("NFT 클라이언트");

		/////////////////////////////////////////////
		// 경고창 배경색, 글씨 크기 변경
		/////////////////////////////////////////////
		UIManager.put("OptionPane.background", Color.WHITE);
		UIManager.put("Panel.background", Color.WHITE);
		UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.PLAIN, 16));
		UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.PLAIN, 16));

		/////////////////////////////////////////////
		// 레이어드 패인 설정
		/////////////////////////////////////////////
		pane = getLayeredPane();

		/////////////////////////////////////////////
		// 각 판넬 초기화..
		/////////////////////////////////////////////

		// 회원 가입 관련
		pnlLogin = new UserLogin();
		pnlJoin = new UserJoin();
		pnlPassword = new FindPassword();

		// 상품 등록
		//pnlProduct = new ProductAdd();
		pannelProductRegister = ProductRegister.getInstance();

		// 메인 페이지 관련
		pnlTop = new PanelTop();
		pnlMain = new PanelMain();
		pnlOpaque = new PanelOpaque();

		// 각 페널 프레임에 추가
		pane.add(pnlLogin, new Integer(40));
		pane.add(pnlJoin, new Integer(40));
		pane.add(pnlPassword, new Integer(40));

		pane.add(pnlOpaque, new Integer(30));
		pane.add(pnlTop, new Integer(20));
		pane.add(pnlMain, new Integer(10));

		/////////////////////////////////////////////
		// 상품 추가 버튼
		/////////////////////////////////////////////
		btnAddProduct = new CButton("+", "DARK");
		btnAddProduct.setFont(new Font("Arial", Font.BOLD, 36));
		btnAddProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("test");
				Main.pnlOpaque.setVisible(false);
				//Main.pnlMain.setVisible(false);
				/*
				if (Main.pnlProduct.isVisible() != true) {
					new SlidingAnimate(Main.pnlProduct, "DOWN").start();
				}*/
				if(!Main.USER_ID.equals("")) {
					FacadeProductRegisterPage facadeProductRegisterPage = new FacadeProductRegisterPage();
				}
				
				//pannelProductRegister.Hello();
				//pannelProductRegister.setVisible(true);
			}
		});
		btnAddProduct.setBounds(520, 820, 65, 65);
		btnAddProduct.setVisible(true);
		pane.add(btnAddProduct, new Integer(30));

		// 프레임을 원하는 사이즈로 하려면 아래와 같이 해야 한다.
		// setSize 로 하면 사이즈가 안 맞음
		getRootPane().setPreferredSize(new Dimension(600, 900));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}

	private void initNet() {
		
		Client clientSocket = new Client();
		try {
			
			clientSocket.ConnectSocketServer();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		BlockChain blockChain = new BlockChain();
		Thread blockChainThread = new Thread(blockChain);
		blockChainThread.start();
		
		
		
		
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}