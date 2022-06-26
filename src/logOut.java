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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class logOut extends JFrame {

	private JFrame frameAfter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logOut window = new logOut();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public logOut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frameAfter = new JFrame();

		frameAfter.setSize(600, 900);

		JPanel pnlAfter = new JPanel();

		JButton bntLogOut = new JButton("로그아웃");
		JLabel lblTitle = new JLabel("NFT 경매 시스템");
		JLabel lblWelcome = new JLabel("환영합니다");
		JLabel lblUserID = new JLabel("닉네임 님"); // 닉네임 연동
		JLabel lblPoint = new JLabel("포인트 : ****"); // 포인트 연동
		JLabel lblImg = new JLabel("이미지 넣을곳"); // 팀 마크??? or 사이트 마크??

		frameAfter.setVisible(false);

		pnlAfter.setLayout(null);

		// ***********좌표 설정***************

		lblWelcome.setBounds(474, 10, 100, 28);
		lblUserID.setBounds(474, 34, 100, 28);
		lblImg.setBounds(360, 27, 102, 96);
		bntLogOut.setBounds(474, 96, 100, 20);
		lblTitle.setBounds(12, -10, 336, 155);
		lblPoint.setBounds(474, 61, 100, 28);
		// *************폰트*********************
		Font font = new Font("궁서", Font.ITALIC, 40);
		bntLogOut.setBackground(Color.LIGHT_GRAY);
		lblTitle.setFont(font);

		// ***********add*******************
		frameAfter.getContentPane().add(pnlAfter);
		pnlAfter.add(lblTitle);
		pnlAfter.add(bntLogOut);
		pnlAfter.add(lblWelcome);
		pnlAfter.add(lblUserID);
		pnlAfter.add(lblImg);
		pnlAfter.add(lblPoint);

		// ************기능********************
		bntLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frameAfter.setVisible(false);
				new logIn().setVisible(true);
			}
		});

	}

	public void setVisible(boolean b) {
		frameAfter.setVisible(b);
	}
}
