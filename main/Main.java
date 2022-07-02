package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import db.DB;
import functions.ResizeImage;
import functions.SlidingAnimate;
import swing.*;
import user.*;

public class Main extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int mainID;

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
	
	
	private JPanel pnlTop; 
	
	private CPanel pnlMain;
	
	
	private CButton btnLogin;
	private CButton btnJoin;
	private CImageButton btnProfile;
	
	private CLabel lblRemainText;
	private CLabel lblRemainTime;
	
	
	// 카운트 다운 시계
	private Countdown cd;

	public Main() {
		initComponents();
	}
	
	private void initComponents() {
		
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
		pnlLogin = new UserLogin();
		pnlLogin.setVisible(false);
		
		pnlJoin = new UserJoin();
		pnlJoin.setVisible(false);

		pnlPassword = new FindPassword();
		pnlPassword.setVisible(false);
		
		pnlTop = new JPanel();
		pnlTop.setLayout(null);
		pnlTop.setBackground(new Color(26, 26, 37));
		pnlTop.setBounds(0, 0, 600, 70);
		
		pnlMain = new CPanel("images/bg.jpg");
		pnlMain.setLayout(null);
		pnlMain.setBounds(0, 0, 600, 900);

		
		btnLogin = new CButton("로그인");
		btnLogin.setBounds(340, 20, 120, 30);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				pnlJoin.setVisible(false);

				if (pnlLogin.isVisible() != true) { 
					new SlidingAnimate(pnlLogin, "DOWN").start();
				}
			}
		});
		pnlTop.add(btnLogin);
		
		btnJoin = new CButton("회원가입", "DARK");
		btnJoin.setBounds(470, 20, 120, 30);
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pnlLogin.setVisible(false);
				
				if (pnlJoin.isVisible() != true) { 
					new SlidingAnimate(pnlJoin, "DOWN").start();
				}
				
				if(cd != null) cd.stopCountdown();
				cd = new Countdown(lblRemainTime, 500); // 쓰레드객체생성
				cd.start(); // 쓰레드실행
			}
		});
		pnlTop.add(btnJoin);

		btnProfile = new CImageButton(ResizeImage.resize("images/profile.jpg", 50, 50), 50);
		btnProfile.setBounds(20, 10, 50, 50);
		btnProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!USER_ID.equals("")) {
					Connection conn = null;
					PreparedStatement psmt = null;
					ResultSet rs = null; 

					try {
						conn = DB.get();
						psmt = conn.prepareStatement("select * from users where user_id = ? ");
						psmt.setString(1, USER_ID);
						rs = psmt.executeQuery();
						
						if (rs.next()) {
							Blob blob = rs.getBlob("user_icon");
							BufferedImage imgByte = ImageIO.read(blob.getBinaryStream(1, blob.length()));
							btnProfile.setImage(ResizeImage.resize(imgByte, 50, 50));
						}
						
						rs.close(); 
						psmt.close();
						conn.close();
					} catch (Exception err) {
						err.printStackTrace();
					}
				}
				
			}
		});
		pnlTop.add(btnProfile);


		/////////////////////////////////////////
		// 상품
		/////////////////////////////////////////
		
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
		
		pnlMain.add(pnlAuction);
		pnlMain.add(lblRemainText);
		pnlMain.add(lblRemainTime);


		// 각 페널 프레임에 추가
		pane.add(pnlLogin, new Integer(30));
		pane.add(pnlJoin, new Integer(30));
		pane.add(pnlPassword, new Integer(30));
		
		pane.add(pnlTop, new Integer(20));
		pane.add(pnlMain, new Integer(10));


		// 프레임을 원하는 사이즈로 하려면 아래와 같이 해야 한다.
		// setSize 로 하면 사이즈가 안 맞음
		getRootPane().setPreferredSize(new Dimension(600, 900));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}