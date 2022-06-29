import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JTextField;

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

		JPanel pnlMissing = new JPanel();

		JLabel lbBirth = new JLabel("Birth : "); // birth 형식 설정 필요 *현재 varchar2형식
		txtfBirth = new JTextField(10);
		JButton btnBirth = new JButton("ID찾기");
		JLabel lbID = new JLabel("ID : ");
		txtfID = new JTextField(10);
		JButton btnID = new JButton("PW찾기");
		JButton btnOk = new JButton("확인");
		JLabel lblMent = new JLabel("*birth와 id입력 후 pw찾기 요망");
		JLabel lblMent2 = new JLabel("*yyyymmdd");
		
		pnlMissing.setLayout(null);
		frame.setVisible(true);

		// ***********좌표 설정***************

		frame.setBounds(100, 100, 382, 340);
		lbBirth.setBounds(56, 52, 60, 36);
		lbID.setBounds(56, 126, 60, 36);
		txtfBirth.setBounds(99, 57, 123, 28);
		btnBirth.setBounds(244, 56, 82, 28);
		txtfID.setBounds(99, 131, 123, 28);
		btnID.setBounds(244, 130, 82, 28);
		btnOk.setBounds(145, 201, 101, 50);
		lblMent.setBounds(66, 172, 178, 15);
		lblMent2.setBounds(66, 96, 82, 20);
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

		btnBirth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;

				try {
					String que = "select * from user_t";

					conn = connecDb.get();

					psmt = conn.prepareStatement(que);
					rs = psmt.executeQuery();

					while (rs.next()) {

						String id = rs.getString(2);
						String pw = rs.getString(3);
						String birth = rs.getString(4);
						if (txtfBirth.getText().equals(birth)) {
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

		btnID.addActionListener(new ActionListener() { // 기능
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement psmt = null;
				ResultSet rs = null;

				try {
					String que = "select * from user_t";

					conn = connecDb.get();

					psmt = conn.prepareStatement(que);
					rs = psmt.executeQuery();

					while (rs.next()) {

						String id = rs.getString(2);
						String pw = rs.getString(3);
						String birth = rs.getString(4);
						
						if (txtfBirth.getText().equals(birth)) {
							if (txtfID.getText().equals(id)) {
								JOptionPane.showMessageDialog(null, "pw는 " + pw + "입니다");
								break;
							} else {
								JOptionPane.showMessageDialog(null, "아이디가 잘못되엇습니다.");
								
								break;
							}
						} else if (txtfBirth.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Birth를 입력해주세요.");
							System.out.println(id+pw+birth);
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

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

	}
}
