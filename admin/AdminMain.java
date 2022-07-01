package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain frame = new AdminMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMain() {
		
		setTitle("관리자");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("회원목록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				UserList frmUserList = new UserList();
				frmUserList.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(30, 10, 140, 83);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("전자지갑 목록");
		btnNewButton_1.setBounds(30, 116, 140, 83);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("상품목록");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductList frmProductList = new ProductList();
				frmProductList.setVisible(true);
				
			}
		});
		btnNewButton_1_1.setBounds(182, 10, 140, 83);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("전자지갑 로그");
		btnNewButton_1_1_1.setBounds(182, 116, 140, 83);
		contentPane.add(btnNewButton_1_1_1);
	}
}
