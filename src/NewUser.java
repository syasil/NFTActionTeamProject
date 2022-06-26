import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewUser {

	private JFrame frame;

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

		frame.setSize(300, 500);

		JPanel pnlNewuser = new JPanel();
		JLabel lblTitle = new JLabel("회원가입");
		JLabel lblID = new JLabel("ID: ");
		JLabel lblPw = new JLabel("PW:");
		JLabel lblBirth = new JLabel("Birth: ");
		JLabel lblNick = new JLabel("NickName: ");
		JTextField txtfID = new JTextField(10);
		JPasswordField txtfPw = new JPasswordField(10);
		JTextField txtfBirth = new JTextField(10);
		JTextField txtfNick = new JTextField(10);
		JButton bntCancle = new JButton("취소");
		JButton bntSignup = new JButton("회원가입");

		frame.setVisible(true);

		// ***********좌표 설정***************
		pnlNewuser.setLayout(null);
		lblTitle.setBounds(60, 10, 150, 100);
		lblID.setBounds(34, 99, 30, 30);
		txtfID.setBounds(100, 100, 100, 30);
		lblPw.setBounds(34, 149, 30, 30);
		txtfPw.setBounds(100, 150, 100, 30);
		lblBirth.setBounds(34, 199, 40, 30);
		txtfBirth.setBounds(100, 200, 100, 30);
		lblNick.setBounds(34, 249, 68, 30);
		txtfNick.setBounds(100, 250, 100, 30);

		bntSignup.setBounds(20, 300, 100, 20);
		bntCancle.setBounds(140, 300, 100, 20);

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
		pnlNewuser.add(txtfBirth);
		pnlNewuser.add(lblNick);
		pnlNewuser.add(txtfNick);
		pnlNewuser.add(bntCancle);
		pnlNewuser.add(bntSignup);

		// **********기능******************

		bntCancle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

			}
		});

		// ------------------------------------------------------------------
		bntSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
				String que = "insert into test1(id,pw,birth,nick)" + "values(?,?,?,?)";

				Connection con = null;
				PreparedStatement pstmt = null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection(url, "JYY", "@Tt38003800");

					pstmt = con.prepareStatement(que);

					pstmt.setString(1, txtfID.getText());
					pstmt.setString(2, txtfPw.getText());
					pstmt.setString(3, txtfBirth.getText()); // date 타입 변경해야함
					pstmt.setString(4, txtfNick.getText());

					int n = pstmt.executeUpdate();
				} catch (Exception e1) {
					e1.printStackTrace();

				}

				String resultStr = null;
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				frame.dispose();
			}
		});

	}

}
