package NftAuction;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import AdminPage.AdminMainPage;
//import 오류로 [FacadeJoinPage] 와 같이 임시 주석처리함
//import ProductRegister.FacadeProductRegisterPage;
import UserJoin.FacadeJoinPage;
import swing.AButton;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Main {


	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Main() {
		initialize();
	}

	
	private void initialize() {
		
		
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 900, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		
		//FacadeProductRegisterPage facadeprodictRegisterPage = new FacadeProductRegisterPage(mainFrame);
		
//		FacadeJoinPage GeneralUserJoinPage = new FacadeJoinPage(1, mainFrame);
		//1 == 일반회원 ,2 == 관리자회원
		
		///////////////////////////////////////////////////////
		// 관리자 연결 - 버튼
		AButton btn_adminPage = new AButton("관리자페이지띄우기");
		btn_adminPage.setBounds(400, 35, 120, 25);
		mainFrame.add(btn_adminPage);
		// 버튼이벤트
		btn_adminPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminMainPage();
			}
		});
		///////////////////////////////////////////////////////
		
		
		
	}
}
