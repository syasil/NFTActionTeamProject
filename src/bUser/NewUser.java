package bUser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import swing.*;
import DBConnection.*;

public class NewUser {

	static JdbcUtil dbConn = new JdbcUtil();
	private JFrame frame;
	private JTextField txtfWallet;
	private JTextField txtfBirth;
	private JPasswordField txtfRePw;
	private JTextField txtf_img;
	public static FileInputStream fis = null;
	public static File file = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser window = new NewUser();
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
	public NewUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame();

		frame.setSize(329, 575);

		CPanel pnlNewuser = new CPanel();
		CLabel lblTitle = new CLabel("회원가입");
		CLabel lblID = new CLabel("ID: ");
		CLabel lblPw = new CLabel("PW:");
		CLabel lblBirth = new CLabel("Birth: ");
		CLabel lblNick = new CLabel("NickName: ");
		lblNick.setText("Nick:");
		CTextField txtfID = new CTextField(10);
		CPasswordField txtfPw = new CPasswordField(10);
		CTextField txtfNick = new CTextField(10);
		CButton bntCancle = new CButton("취소");
		CButton bntSignup = new CButton("회원가입");
		CLabel lblMent = new CLabel("*yyyymmdd");
		CLabel lblWallet = new CLabel("Wallet: ");
		CButton btnWallet = new CButton("확인");
		CLabel lblRePw = new CLabel("PW 확인: ");
		lblRePw.setText("Re PW: ");
		CButton btnPw = new CButton("확인");
		CButton btnImg = new CButton("사진");
		CLabel lblImg = new CLabel();
		CButton btnId = new CButton("확인");
		CButton btnNick = new CButton("확인");
		CButton btnBirth = new CButton("확인");

		txtfWallet = new CTextField(10);
		txtfBirth = new CTextField(10);
		txtfRePw = new CPasswordField(10);
		txtf_img = new CTextField(10);

		frame.setVisible(true);

		// ***********좌표 설정***************
		pnlNewuser.setLayout(null);
		lblTitle.setBounds(88, 10, 150, 100);
		lblID.setBounds(20, 100, 30, 30);
		txtfID.setBounds(100, 100, 100, 30);
		lblPw.setBounds(20, 142, 30, 30);
		txtfPw.setBounds(100, 145, 100, 30);
		lblBirth.setBounds(20, 320, 54, 30);
		lblNick.setBounds(20, 235, 68, 30);
		txtfNick.setBounds(100, 235, 100, 30);
		lblMent.setBounds(1, 355, 92, 20);
		bntSignup.setBounds(20, 487, 120, 20);
		bntCancle.setBounds(174, 487, 120, 20);
		lblWallet.setBounds(20, 280, 68, 30);
		txtfWallet.setBounds(100, 280, 100, 30);
		btnPw.setBounds(212, 192, 73, 23);
		txtfBirth.setBounds(100, 325, 100, 30);
		txtfRePw.setBounds(100, 190, 100, 30);
		btnWallet.setBounds(212, 293, 73, 23);
		btnImg.setBounds(20, 415, 73, 23);
		lblRePw.setBounds(20, 200, 68, 15);
		lblImg.setBounds(111, 383, 150, 100);
		txtf_img.setBounds(20, 456, 68, 21);
		btnId.setBounds(212, 103, 73, 23);
		btnBirth.setBounds(212, 333, 73, 23);
		btnNick.setBounds(212, 253, 73, 23);

		txtf_img.setVisible(false);
		// ************색상********************
		bntCancle.setBackground(Color.LIGHT_GRAY);
		bntSignup.setBackground(Color.LIGHT_GRAY);
		bntCancle.setBackground(Color.LIGHT_GRAY);

		// *************폰트*********************
		Font font = new Font("맑은 고딕", Font.BOLD, 30);

		lblTitle.setFont(font);

		// ***********add*******************
		frame.getContentPane().add(pnlNewuser);

		pnlNewuser.add(lblTitle);
		pnlNewuser.add(lblID);
		pnlNewuser.add(txtfID);
		pnlNewuser.add(lblPw);
		pnlNewuser.add(txtfPw);
		pnlNewuser.add(lblBirth);
		pnlNewuser.add(lblNick);
		pnlNewuser.add(txtfNick);
		pnlNewuser.add(bntCancle);
		pnlNewuser.add(bntSignup);
		pnlNewuser.add(lblMent);
		pnlNewuser.add(lblWallet);
		pnlNewuser.add(txtfWallet);
		pnlNewuser.add(txtfBirth);
		pnlNewuser.add(txtfRePw);
		pnlNewuser.add(btnPw);
		pnlNewuser.add(btnWallet);
		pnlNewuser.add(btnImg);
		pnlNewuser.add(lblRePw);
		pnlNewuser.add(lblImg);
		pnlNewuser.add(txtf_img);
		pnlNewuser.add(btnId);
		pnlNewuser.add(btnBirth);
		pnlNewuser.add(btnNick);

		// **********기능******************

		bntCancle.addActionListener(new ActionListener() { // 취소버튼

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

			}
		});
//------------------------------------------------------------------------------

		btnImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 이미지 파일 넣기

				try {
					JFileChooser jfc = new JFileChooser();
					jfc.setFileFilter(new FileNameExtensionFilter("이미지 파일", ImageIO.getReaderFileSuffixes())); // 파일 필터
					jfc.setMultiSelectionEnabled(false);// 다중 선택 불가
					jfc.showOpenDialog(null); // 선택옵션

					File f = jfc.getSelectedFile(); // 선택한파일 f에 삽입

					String filename = f.getAbsolutePath(); // 파일 위치(디렉토리) 가져온다

					txtf_img.setText(filename); // 텍스트에 저장경로 삽입

					Image getAbsolutePath = null; // 디렉토리 비우기

					ImageIcon icon = new ImageIcon(filename); // ImageIcon에 이미지 파일넣기(크기조절위해)

					Image image = icon.getImage().getScaledInstance(80, 130, Image.SCALE_SMOOTH); // 크기조절 후 이미지에 넣기
					ImageIcon icon2 = new ImageIcon(image); // ImageIcon에 조절된 이지 넣기

					lblImg.setIcon(icon2); // 레이블에 이미지 넣기

					file = new File(txtf_img.getText());
					fis = new FileInputStream(file);

					// Basic.userIcon = icon2;
				} catch (Exception e1) {
					e1.getStackTrace();
				}

			}
		});

		// ------------------------------------------------------------------------------

		btnPw.addActionListener(new ActionListener() { // 비밀번호 재확인
			public void actionPerformed(ActionEvent e) {
				if (!txtfPw.getText().equals("")) {
					if (txtfPw.getText().equals(txtfRePw.getText())) {
						txtfPw.setEnabled(false);
						txtfRePw.setEnabled(false);
						JOptionPane.showMessageDialog(null, "확인 되었습니다.");
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
					}
				}
			}
		});

		// ------------------------------------------------------------------
		bntSignup.addActionListener(new ActionListener() { // 확인버튼 ->db데이터 넣기
			public void actionPerformed(ActionEvent e) {

				if ((txtfID.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
					txtfID.requestFocus();
					return;
				}

				if ((txtfPw.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
					txtfPw.requestFocus();
					return;
				}
				if ((txtfNick.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "닉네임을 입력해주세요");
					txtfNick.requestFocus();
					return;
				}
				if ((txtfBirth.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "생일을 입력해주세요");
					txtfBirth.requestFocus();
					return;
				}
				if ((txtfWallet.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "지갑을 입력해주세요");
					txtfWallet.requestFocus();
					return;
				}

				else {

					String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
//					String que = "insert into t_user(USER_NO,USER_ID,USER_PASS,USER_BIR,USER_NICK,USER_CREDAY,WAl_NO,USER_ICON)"
//							+ "values(SEQ_INCREASE_USER_NO.NEXTVAL,?,?,?,?,to_date(sysdate,'yyyy/mm/dd'),?,?)";
					String que = "insert into t_user(USER_NO,USER_ID,USER_PASS,USER_BIR,USER_NICK,USER_CREDAY,WAl_NO,USER_ICON)"
							+ "values(SEQ_T_USER_NO.NEXTVAL,?,?,?,?,to_date(sysdate,'yyyy/mm/dd'),?,?)";

//					Connection con = null;
					Connection conn = null;
					PreparedStatement pstmt = null;
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
//						con = DriverManager.getConnection(url, "JYY", "@Tt38003800");
						conn = dbConn.getConnection();
						
//						pstmt = con.prepareStatement(que);
						pstmt = conn.prepareStatement(que);

						pstmt.setString(1, txtfID.getText());
						pstmt.setString(2, txtfPw.getText());
						pstmt.setString(3, txtfBirth.getText());
						pstmt.setString(4, txtfNick.getText());
						pstmt.setString(5, txtfWallet.getText());

						pstmt.setBinaryStream(6, fis, (int) file.length()); // 이미지 db에 저장

						int n = pstmt.executeUpdate();

					} catch (Exception e1) {
						e1.printStackTrace();

					}
					String resultStr = null;
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
					frame.dispose();
				}
			}
		});
//------------------------------------------------------------------------------------------
		btnWallet.addActionListener(new ActionListener() { // 가상지갑 확인
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;

				try {
					String que = "select * from t_wallet where wal_no='" + txtfWallet.getText() + "'";
					// 1,정의영 2,모승범
//					conn = connecDb.get();
					conn = dbConn.getConnection();

					psmt = conn.prepareStatement(que);
					rs = psmt.executeQuery();

					if (rs.next()) {
						String wal_no = rs.getString(1);
						if (txtfWallet.getText().equals(wal_no)) {
							txtfWallet.setEnabled(false);
							JOptionPane.showMessageDialog(null, "확인 되었습니다.");
						}
					} else {
						if (!txtfWallet.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "없는 지갑입니다.");
							txtfWallet.setText(null);
						}
					}

					rs.close();
					psmt.close();
					conn.close();
				} catch (Exception e1) {
					e1.getStackTrace();
				}
			}
		});
		// ------------------------------------------------------------------------------------------
		btnId.addActionListener(new ActionListener() { // 아이디 중복
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;

				try {
					String que = "select * from t_user where user_id='" + txtfID.getText() + "'";
					//
//					conn = connecDb.get();
					conn = dbConn.getConnection();
					

					psmt = conn.prepareStatement(que);
					rs = psmt.executeQuery();

					if (rs.next()) {
						String id = rs.getString(2);
						if (txtfID.getText().equals(id)) {
							JOptionPane.showMessageDialog(null, "중복된 아이디 입니다..");
							txtfID.setText(null);

						}
					} else {
						if (!txtfID.getText().equals("")) {
							txtfID.setEnabled(false);
							JOptionPane.showMessageDialog(null, "확인 되었습니다.");
						}
					}

					rs.close();
					psmt.close();
					conn.close();
				} catch (Exception e1) {
					e1.getStackTrace();
				}
			}
		});
		// ------------------------------------------------------------------------------------------
		btnNick.addActionListener(new ActionListener() { // NICK 중복확인
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;

				try {
					String que = "select * from t_user where user_Nick='" + txtfNick.getText() + "'";

//					conn = connecDb.get();
					conn = dbConn.getConnection();

					psmt = conn.prepareStatement(que);
					rs = psmt.executeQuery();

					if (rs.next()) {
						String Nick = rs.getString(5);
						if (txtfNick.getText().equals(Nick)) {
							JOptionPane.showMessageDialog(null, "중복된 닉네임 입니다..");
							txtfNick.setText(null);

						}
					} else {
						if (!txtfNick.getText().equals("")) {
							txtfNick.setEnabled(false);
							JOptionPane.showMessageDialog(null, "확인 되었습니다.");
						}
					}

					rs.close();
					psmt.close();
					conn.close();
				} catch (Exception e1) {
					e1.getStackTrace();
				}

			}
		});
		// ------------------------------------------------------------------------------------------
		btnBirth.addActionListener(new ActionListener() { // 확인
			public void actionPerformed(ActionEvent e) {
				if (!txtfID.getText().equals("")) {
					txtfBirth.setEnabled(false);
					JOptionPane.showMessageDialog(null, "확인 되었습니다.");
				}
			}
		});
	}
}