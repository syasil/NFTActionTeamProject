import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import swing.CButton;
import swing.CLabel;
import swing.CPanel;
import swing.CTextField;
import java.awt.Font;

public class MissingID {

	private JFrame frame;
	private JTextField txtfBirth;
	private JTextField txtfID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MissingID window = new MissingID();
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
	public MissingID() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame();
		CPanel pnlMissing = new CPanel();
		CLabel lbBirth = new CLabel("Birth : ");
		txtfBirth = new JTextField(10);
		CButton btnBirth = new CButton("ID찾기");
		CLabel lbID = new CLabel("ID : ");
		txtfID = new CTextField(10);
		CButton btnID = new CButton("PW찾기");
		CButton btnOk = new CButton("확인");
		CLabel lblMent = new CLabel("*birth와 id입력 후 pw찾기 요망");
		CLabel lblMent2 = new CLabel("*yyyy-mm-dd");

		pnlMissing.setLayout(null);
		frame.setVisible(true);

		// ***********좌표 설정***************

		frame.setBounds(100, 100, 382, 340);
		lbBirth.setBounds(56, 52, 60, 36);
		lbID.setBounds(56, 126, 60, 36);
		txtfBirth.setBounds(99, 57, 123, 28);
		btnBirth.setBounds(244, 56, 101, 28);
		txtfID.setBounds(99, 131, 123, 28);
		btnID.setBounds(244, 130, 101, 28);
		btnOk.setBounds(145, 201, 101, 50);
		lblMent.setBounds(66, 172, 232, 15);
		lblMent2.setBounds(66, 96, 105, 20);

		// ***********폰트*******************

		// ***********add*******************

		frame.getContentPane().add(pnlMissing, BorderLayout.CENTER);

		pnlMissing.add(lbBirth);
		pnlMissing.add(txtfBirth);
		pnlMissing.add(btnBirth);
		pnlMissing.add(lbID);
		pnlMissing.add(txtfID);
		pnlMissing.add(btnID);
		pnlMissing.add(btnOk);
		pnlMissing.add(lblMent);
		pnlMissing.add(lblMent2);

		// **********기능******************

		btnBirth.addActionListener(new ActionListener() { // 아이디 찾는 기능
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;

				try {
					String que = "select * from t_user";

					conn = connectDb.getInstance().get();

					psmt = conn.prepareStatement(que);
					rs = psmt.executeQuery();

					while (rs.next()) {

						String id = rs.getString(2);
						String pw = rs.getString(3);
						String birth = rs.getString(4);
						String date = birth.substring(0, 10);
						if (txtfBirth.getText().equals(date)) {
							JOptionPane.showMessageDialog(null, "가입한 아이디는 " + id + "입니다");
							break;
						} else {
							JOptionPane.showMessageDialog(null, "등록된" + txtfBirth.getText() + "가 없습니다.");

							break;
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
		// --------------------------------------------------------------------

		btnID.addActionListener(new ActionListener() { // 비밀번호 찾는 기능
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;

				try {
					String que = "select * from t_user";

					conn = connectDb.getInstance().get();

					psmt = conn.prepareStatement(que);
					rs = psmt.executeQuery();

					while (rs.next()) {

						String id = rs.getString(2);
						String pw = rs.getString(3);
						String birth = rs.getString(4);
						String date = birth.substring(0, 10);
						if (txtfBirth.getText().equals(date)) {
							if (txtfID.getText().equals(id)) {
								JOptionPane.showMessageDialog(null, "pw는 " + pw + "입니다");
								break;
							} else {
								JOptionPane.showMessageDialog(null, "아이디가 잘못되엇습니다.");

								break;
							}
						} else if (txtfBirth.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Birth를 입력해주세요.");
							System.out.println(id + pw + birth);
							break;
						} else {
							JOptionPane.showMessageDialog(null, "등록된" + txtfBirth.getText() + "가 없습니다.");
							break;
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

		// --------------------------------------------------------------------

		btnOk.addActionListener(new ActionListener() { // 확인버튼
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

	}
}
