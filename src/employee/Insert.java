package employee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import swing.CButton;
import swing.CLabel;
import swing.CTextField;

public class Insert extends JFrame {

	private JPanel contentPane;
	private CTextField txtUserID;
	private CTextField txtUserPW;
	private CTextField txtUserPWRe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
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
	public Insert() {
		// 경고창을 조금 바꿈
		UIManager.put("OptionPane.background", Color.WHITE);
		UIManager.put("Panel.background", Color.WHITE);
		UIManager.put("OptionPane.messageFont", new Font("맑은 고딕", Font.PLAIN, 16)); 
		UIManager.put("OptionPane.buttonFont", new Font("맑은 고딕", Font.PLAIN, 16));

		
		setResizable(false);
		setBounds(100, 100, 360, 410);
		setLocationRelativeTo(getRootPane());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.decode("#1A1A25"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CLabel lblNewLabel = new CLabel("신규 등록하기");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(12, 10, 320, 15);
		contentPane.add(lblNewLabel);
		
		txtUserID = new CTextField();
		txtUserID.setBounds(39, 94, 264, 30);
		contentPane.add(txtUserID);
		
		txtUserPW = new CTextField();
		txtUserPW.setBounds(39, 174, 264, 30);
		contentPane.add(txtUserPW);
		
		txtUserPWRe = new CTextField();
		txtUserPWRe.setBounds(39, 251, 264, 30);
		contentPane.add(txtUserPWRe);
		txtUserPWRe.setColumns(10);
		
		CLabel lblUserID = new CLabel("회원 아이디");
		lblUserID.setBounds(39, 62, 107, 30);
		contentPane.add(lblUserID);
		
		CLabel lblUserPW = new CLabel("회원 비밀번호");
		lblUserPW.setBounds(39, 144, 107, 30);
		contentPane.add(lblUserPW);
		
		CLabel lblUserPWRe = new CLabel("비밀번호 확인");
		lblUserPWRe.setBounds(39, 221, 107, 30);
		contentPane.add(lblUserPWRe);
		
		
		CButton btnInsert = new CButton("입력하기");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtUserID.getText().equals("")) {

					JOptionPane.showMessageDialog(getRootPane(), "아이디를 입력하시오.", "확인", JOptionPane.INFORMATION_MESSAGE);
					txtUserID.requestFocus();
					return;
				}
				
				if (txtUserPW.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하시오.");
					txtUserPW.requestFocus();
					return;
				}
			}
		});
		btnInsert.setBounds(39, 309, 264, 30);
		contentPane.add(btnInsert);
	}
}
