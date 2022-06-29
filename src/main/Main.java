package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import image.ResizeImage;
import sample.Sample;
import swing.CButton;
import swing.CLabel;
import swing.CPanel;
import user.UserJoin;
import user.UserLogin;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//////////////////////////////////////////
	// 프로그램 전체에서 쓰이는 변수 선언
	//////////////////////////////////////////
	public static String USER_ID = "MOMO";
	public static String USER_NICKNAME = "";
	public static String USER_NO = "";
	

	//////////////////////////////////////////
	// 각 패널들 변수 선언
	//////////////////////////////////////////
	public static Sample pnlSample;
	public static UserLogin pnlLogin;
	public static UserJoin pnlJoin;
	
	
	private JPanel pnlTop; 
	
	private CPanel pnlMain;
	
	
	private CButton btnLogin;
	private CButton btnJoin;
	
	private CLabel lblRemainText;
	private CLabel lblRemainTime;
	
	
	// 카운트 다운 시계
	private Countdown cd;

	public Main() {
		initComponents();
	}

	private void initComponents() {

		JLayeredPane pane = getLayeredPane();
		
		// 각 판넬 초기화..
		pnlSample = new Sample();
		pnlSample.setVisible(false);
		
		pnlLogin = new UserLogin();
		pnlLogin.setVisible(false);
		
		pnlJoin = new UserJoin();
		pnlJoin.setVisible(false);

		
		pnlTop = new JPanel();
		pnlTop.setLayout(null);
		pnlTop.setBackground(new Color(26, 26, 37));
		pnlTop.setBounds(0, 0, 600, 70);
		
		pnlMain = new CPanel(new ImageIcon("images/bg.jpg"));
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
		
		pnlTop.add(btnLogin);
		pnlTop.add(btnJoin);

		/////////////////////////////////////////
		// 상품
		/////////////////////////////////////////
		
		CLabel lblTitle = new CLabel("라이브 아트");
		lblTitle.setBounds(10, 10, 500, 50);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 36));

		CLabel lblAuthor = new CLabel("Team#3");
		lblAuthor.setBounds(15, 60, 500, 20);
		lblAuthor.setForeground(Color.LIGHT_GRAY);
		
		//CPanel pnlAuction = new CPanel(new ImageIcon("images/sample3.png").getImage(), 20);
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
		pane.add(pnlSample, new Integer(50));
		pane.add(pnlLogin, new Integer(40));
		pane.add(pnlJoin, new Integer(30));
		pane.add(pnlTop, new Integer(20));
		pane.add(pnlMain, new Integer(10));
		

		// 프레임을 원하는 사이즈로 하려면 아래와 같이 해야 한다.
		// setSize 로 하면 사이즈가 안 맞음
		getRootPane().setPreferredSize(new Dimension(600, 900));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}