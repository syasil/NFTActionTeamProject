import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Basic {
	public static String userNo = "";
	public static String userID = "";
	public static String userNick = "";
	public static int userPoint = 0;
	public static String userIcon = "";

	private JFrame frameBefore;

	/**
	 * Launch the application.11
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Basic window = new Basic();
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
	public Basic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameBefore = new JFrame();
		frameBefore.setSize(600, 900);

		JPanel pnlBefore = new JPanel();
		JLabel lblID = new JLabel("ID: ");
		JLabel lblPw = new JLabel("PW:");
		JTextField txtfID = new JTextField(10);
		JPasswordField txtfPw = new JPasswordField(10);
		JButton bntlogIn = new JButton("로그인");
		JButton bntSign = new JButton("회원가입");
		JButton bntMissing = new JButton("ID / PW찾기");
		JLabel lblTitle = new JLabel("NFT 경매 시스템");
		// ***********좌표 설정***************
		pnlBefore.setLayout(null);
		lblID.setBounds(360, 25, 30, 30);
		txtfID.setBounds(390, 25, 100, 30);
		lblPw.setBounds(360, 60, 30, 30);
		bntlogIn.setBounds(500, 15, 80, 80);
		txtfPw.setBounds(390, 60, 100, 30);
		bntSign.setBounds(370, 100, 100, 20);
		bntMissing.setBounds(480, 100, 100, 20);
		lblTitle.setBounds(12, -10, 336, 155);

		// ************색상********************
		bntlogIn.setBackground(Color.LIGHT_GRAY);
		bntSign.setBackground(Color.LIGHT_GRAY);
		bntMissing.setBackground(Color.LIGHT_GRAY);

		// *************폰트*********************
		Font font = new Font("궁서", Font.ITALIC, 40);
		lblTitle.setFont(new Font("궁서", Font.ITALIC, 40));

		// ***********add*******************
		frameBefore.getContentPane().add(pnlBefore);
		pnlBefore.add(lblID);
		pnlBefore.add(txtfID);
		pnlBefore.add(lblPw);
		pnlBefore.add(txtfPw);
		pnlBefore.add(bntlogIn);
		pnlBefore.add(bntSign);
		pnlBefore.add(bntMissing);
		pnlBefore.add(lblTitle);

		frameBefore.setVisible(true);

		// ***********기능*********
		bntSign.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewUser();
			}
		});
		// ---------------------------------------------------
		bntMissing.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MissingID();

			}
		});
		// ---------------------------------------------------
		bntlogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;
		
				try {
					
					String que = "select * from user_t where user_id='" + txtfID.getText() + "'";
				//	String que = "select * from user_t,point where user_id='" + txtfID.getText() + "'";
				//	String que = "select user_t.user_no,user_t.user_id,user_t.user_pass,user_t.user_bir,user_t.user_nick,user_t.user_icon,point.pnt_total from user_t left outer join point on user_id='" + txtfID.getText() + "'";
					
					
					conn = connecDb.get();

					psmt = conn.prepareStatement(que);
					rs = psmt.executeQuery();
					
					
					if (rs.next()) {
						
						String no = rs.getString(1);
						String id = rs.getString(2);
						String pw = rs.getString(3);
						String birth = rs.getString(4);
						String nick = rs.getString(5);
						String icon = rs.getString(6);
					//	int point = rs.getInt(7);
			
						
						if (txtfPw.getText().equals(pw)) {
							frameBefore.setVisible(false);
							userNo = no;
							userID = id;
							userNick = nick;
							userIcon = icon;
					//		userPoint=point;
							new logIn().setVisible(true);
			
						} else {
							JOptionPane.showMessageDialog(null, "비밀번호가 잘못되었습니다.");
//							
						}
					} else {
						JOptionPane.showMessageDialog(null, "등록된" + txtfID.getText() + "가 없습니다.");
					
					}
//					

					rs.close();
					psmt.close();
					conn.close();
				} catch (Exception e1) {
					e1.getStackTrace();
				}
				
			}
		});

	}

	public void setVisible(boolean b) {
		frameBefore.setVisible(b);
	}
}
