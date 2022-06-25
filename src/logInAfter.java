import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class logInAfter extends JFrame{

	private  JFrame frameAfter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logInAfter window = new logInAfter();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logInAfter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAfter = new JFrame();

		frameAfter.setSize(600, 900);

		JPanel panel = new JPanel();
		JButton bntLogOut = new JButton("로그아웃");
		bntLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						frameAfter.setVisible(false);
						new logInBefore().setVisible(true);
			}
		});
		
		
		JLabel titleLabel = new JLabel("NFT 경매 시스템");
		// ***********좌표 설정***************
		panel.setLayout(null);
		bntLogOut.setBounds(474, 96, 100, 20);
		titleLabel.setBounds(12, -10, 336, 155);
		bntLogOut.setBackground(Color.LIGHT_GRAY);

		// *************폰트*********************
		Font font = new Font("궁서", Font.ITALIC, 40);

		titleLabel.setFont(font);

		// ***********add*******************
		frameAfter.getContentPane().add(panel);
		panel.add(titleLabel);
		panel.add(bntLogOut);
		
		JLabel lblWelcome = new JLabel("환영합니다");
		lblWelcome.setBounds(474, 23, 100, 28);
		panel.add(lblWelcome);
		
		JLabel lblUserID = new JLabel(logInBefore.str+"님");	//id? 닉네임?
		lblUserID.setBounds(474, 61, 100, 28);
		panel.add(lblUserID);
		
		JLabel lblImg = new JLabel("이미지 넣을곳");
		lblImg.setBounds(360, 27, 102, 96);
		panel.add(lblImg);
		
		
		
		frameAfter.setVisible(false);
		
	
		
	}
	public void setVisible(boolean b) {
		frameAfter.setVisible(b);
	}
}
