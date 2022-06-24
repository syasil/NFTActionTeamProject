package NftAuction;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ProductRegisterPage.FacadeProductRegisterPage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
		mainFrame.setBounds(100, 100, 600, 900);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		
		
		
		//FacadeProductRegisterPage facadeprodictRegisterPage = new FacadeProductRegisterPage(mainFrame);
		//상품 등록 페이지 생성 객체 나중에 버튼 연결해야함
		
		//FacadeJoinPage GeneralUserJoinPage = new FacadeJoinPage(1, mainFrame);
		//1 == 일반회원 ,2 == 관리자회원
		
	}
}
