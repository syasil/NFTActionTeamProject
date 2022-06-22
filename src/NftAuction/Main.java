package NftAuction;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;

public class Main {

	private JFrame mainFrame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextPane txtpnId;
	private JTextPane txtpnId_1;
	private JTextPane txtpnId_2;
	private JTextPane txtpnId_3;
	private JTextPane txtpnId_4;
	private JTextPane txtpnId_5;

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
		
		FacadeJoinPage GeneralUserJoinPage = new FacadeJoinPage(1, mainFrame);
		//1 == 일반유저 ,2 == 기업유저 
		
		
		
		
		
		
		
		
	}
}
