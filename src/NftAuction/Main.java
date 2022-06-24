package NftAuction;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

//import ProductRegister.FacadeProductRegisterPage;
import UserJoin.FacadeJoinPage;

import java.awt.Color;
import java.awt.SystemColor;
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
		
		FacadeJoinPage GeneralUserJoinPage = new FacadeJoinPage(1, mainFrame);
		//1 == 일반회원 ,2 == 관리자회원
		
		
		
		
	}
}
