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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NewUser {

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

		JPanel pnlNewuser = new JPanel();
		JLabel lblTitle = new JLabel("회원가입");
		JLabel lblID = new JLabel("ID: ");
		JLabel lblPw = new JLabel("PW:");
		JLabel lblBirth = new JLabel("Birth: ");
		JLabel lblNick = new JLabel("NickName: ");
		JTextField txtfID = new JTextField(10);
		JPasswordField txtfPw = new JPasswordField(10);
		JTextField txtfNick = new JTextField(10);
		JButton bntCancle = new JButton("취소");
		JButton bntSignup = new JButton("회원가입");
		JLabel lblMent = new JLabel("*yyyymmdd");
		JLabel lblWallet = new JLabel("Wallet: ");
		txtfWallet = new JTextField(10);
		txtfBirth = new JTextField(10);
		txtfRePw = new JPasswordField(10);
		JButton btnWallet = new JButton("확인");
		JLabel lblRePw = new JLabel("PW 확인: ");
		JButton btnPw = new JButton("확인");
		JButton btnImg = new JButton("사진");
		JLabel lblImg = new JLabel("");
		txtf_img = new JTextField(10);
		JButton btnId = new JButton("확인");
		JButton btnNick = new JButton("확인");
		JButton btnBirth = new JButton("확인");

		frame.setVisible(true);

		// ***********좌표 설정***************
		pnlNewuser.setLayout(null);
		lblTitle.setBounds(60, 10, 150, 100);
		lblID.setBounds(34, 99, 30, 30);
		txtfID.setBounds(100, 100, 100, 30);
		lblPw.setBounds(34, 149, 30, 30);
		txtfPw.setBounds(100, 150, 100, 30);
		lblBirth.setBounds(34, 329, 40, 30);
		lblNick.setBounds(34, 249, 68, 30);
		txtfNick.setBounds(100, 250, 100, 30);
		lblMent.setBounds(20, 355, 82, 20);
		bntSignup.setBounds(20, 487, 100, 20);
		bntCancle.setBounds(174, 487, 100, 20);
		lblWallet.setBounds(34, 289, 68, 30);
		txtfWallet.setBounds(100, 289, 100, 30);
		btnPw.setBounds(212, 203, 62, 23);
		txtfBirth.setBounds(100, 329, 100, 30);
		txtfRePw.setBounds(100, 200, 100, 30);
		btnWallet.setBounds(212, 293, 62, 23);
		btnImg.setBounds(20, 415, 68, 23);
		lblRePw.setBounds(34, 207, 54, 15);
		lblImg.setBounds(100, 383, 174, 94);
		txtf_img.setBounds(20, 456, 68, 21);
		btnId.setBounds(212, 103, 62, 23);
		btnBirth.setBounds(212, 333, 62, 23);
		btnNick.setBounds(212, 253, 62, 23);

		txtf_img.setVisible(false);
		// ************색상********************
		bntCancle.setBackground(Color.LIGHT_GRAY);
		bntSignup.setBackground(Color.LIGHT_GRAY);
		bntCancle.setBackground(Color.LIGHT_GRAY);

		// *************폰트*********************
		Font font = new Font("궁서", Font.BOLD, 30);

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
					jfc.setFileFilter(new FileNameExtensionFilter("jpg", "png")); // 파일 필터
					jfc.setMultiSelectionEnabled(false);// 다중 선택 불가
					jfc.showOpenDialog(null); // 선택옵션

					File f = jfc.getSelectedFile(); // 선택한파일 f에 삽입
					String filename = f.getAbsolutePath(); // 파일 위치(디렉토리) 가져온다
					txtf_img.setText(filename); // 텍스트에 저장경로 삽입
					Image getAbsolutePath = null; // 디렉토리 비우기
					ImageIcon icon = new ImageIcon(filename); // ImageIcon에 이미지 파일넣기(크기조절위해)
					Image image = icon.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH); // 크기조절 후 이미지에 넣기
					ImageIcon icon2 = new ImageIcon(image); // ImageIcon에 조절된 이지 넣기
					lblImg.setIcon(icon2); // 레이블에 이미지 넣기

					file = new File(txtf_img.getText());
					fis = new FileInputStream(file);

				//	Basic.userIcon = icon2; 
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
					String que = "insert into user_t(USER_NO,USER_ID,USER_PASS,USER_BIR,USER_NICK,USER_CREDAY,USER_ICON)"
							+ "values(SEQ_INCREASE_USER_NO.NEXTVAL,?,?,?,?,to_date(sysdate,'yyyy/mm/dd'),?)";

					Connection con = null;
					PreparedStatement pstmt = null;
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con = DriverManager.getConnection(url, "JYY", "@Tt38003800");

						pstmt = con.prepareStatement(que);

						pstmt.setString(1, txtfID.getText());
						pstmt.setString(2, txtfPw.getText());
						pstmt.setString(3, txtfBirth.getText());
						pstmt.setString(4, txtfNick.getText());

						pstmt.setBinaryStream(5, fis, (int) file.length()); // 이미지 db에 저장

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
					String que = "select * from wallet where wal_no='" + txtfWallet.getText() + "'";
					// 1,정의영 2,모승범
					conn = connecDb.get();

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
					String que = "select * from user_t where user_id='" + txtfID.getText() + "'";
					//
					conn = connecDb.get();

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
					String que = "select * from user_t where user_Nick='" + txtfNick.getText() + "'";

					conn = connecDb.get();

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
