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

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 900, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		FacadeJoinPage GeneralUserJoinPage = new FacadeJoinPage(120, 15, 150, 20, 1, mainFrame);
		//mainFrame.getContentPane().add(GeneralUserJoinPage.getGeneralUserJoinPage());
		
		
		
		
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 101, 116, 21);
		mainFrame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(121, 157, 116, 21);
		mainFrame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(121, 210, 116, 21);
		mainFrame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(121, 266, 116, 21);
		mainFrame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(121, 320, 116, 21);
		mainFrame.getContentPane().add(textField_5);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(71, 402, 97, 23);
		mainFrame.getContentPane().add(btnNewButton);
		
		txtpnId = new JTextPane();
		txtpnId.setBackground(SystemColor.control);
		txtpnId.setText("\uC544\uC774\uB514");
		txtpnId.setBounds(12, 47, 60, 21);
		mainFrame.getContentPane().add(txtpnId);
		
		txtpnId_1 = new JTextPane();
		txtpnId_1.setText("\uBE44\uBC00\uBC88\uD638");
		txtpnId_1.setBackground(SystemColor.menu);
		txtpnId_1.setBounds(12, 101, 60, 21);
		mainFrame.getContentPane().add(txtpnId_1);
		
		txtpnId_2 = new JTextPane();
		txtpnId_2.setText("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		txtpnId_2.setBackground(SystemColor.menu);
		txtpnId_2.setBounds(12, 157, 91, 21);
		mainFrame.getContentPane().add(txtpnId_2);
		
		txtpnId_3 = new JTextPane();
		txtpnId_3.setText("\uC774\uB984");
		txtpnId_3.setBackground(SystemColor.menu);
		txtpnId_3.setBounds(12, 210, 91, 21);
		mainFrame.getContentPane().add(txtpnId_3);
		
		txtpnId_4 = new JTextPane();
		txtpnId_4.setText("\uC774\uBA54\uC77C");
		txtpnId_4.setBackground(SystemColor.menu);
		txtpnId_4.setBounds(12, 266, 91, 21);
		mainFrame.getContentPane().add(txtpnId_4);
		
		txtpnId_5 = new JTextPane();
		txtpnId_5.setText("\uC8FC\uC18C");
		txtpnId_5.setBackground(SystemColor.menu);
		txtpnId_5.setBounds(12, 320, 91, 21);
		mainFrame.getContentPane().add(txtpnId_5);
		
		
		
	}
}
