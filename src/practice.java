import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class practice extends JFrame{

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
					practice window = new practice();
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
	public practice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 382, 340);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lbBirth = new JLabel("Birth : ");
		lbBirth.setBounds(56, 52, 60, 36);
		panel.add(lbBirth);

		JLabel lbID = new JLabel("ID : ");
		lbID.setBounds(56, 126, 60, 36);
		panel.add(lbID);

		txtfBirth = new JTextField();
		txtfBirth.setBounds(99, 57, 123, 28);	
		panel.add(txtfBirth);
		txtfBirth.setColumns(10);

		JButton btnBirth = new JButton("ID찾기");
		
		
		
		btnBirth.addActionListener(new ActionListener() {							//기능
			public void actionPerformed(ActionEvent e) {
				Connection conn=null; //DB�� �����ϴ� �������̽�
				PreparedStatement psmt=null;//sql�� ��ü
				ResultSet rs=null; //sql�� ���� ��ȯ(���� ���࿡ ���� ����� ����)
				
				
				try {
					String que="select * from enrol";
					
					conn=connecDb.get(); //DB����
					
					psmt=conn.prepareStatement(que);
					rs=psmt.executeQuery();
					//select => exectueQuery()
					//DML(insert,update,delete) => executeUpdate();
					
					while(rs.next()) {
						
						String sub_no=rs.getString(1);
						String stu_no=rs.getString(2);
						int enr_grade=rs.getInt(3);
						if(txtfBirth.getText().equals(stu_no)) {
							JOptionPane.showMessageDialog(null, enr_grade+"입니다");
							
						}else {
							JOptionPane.showMessageDialog(null, "등록된"+txtfBirth.getText()+"가 없습니다.");
							break;
						}
					}
				
				rs.close();
				psmt.close();
				conn.close();
			}catch(Exception e1) {
				e1.getStackTrace();
			}}
		});
		btnBirth.setBounds(244, 56, 82, 28);
		panel.add(btnBirth);

		txtfID = new JTextField();
		txtfID.setColumns(10);
		txtfID.setBounds(99, 131, 123, 28);
		panel.add(txtfID);

		JButton btnID = new JButton("PW찾기");
		btnID.addActionListener(new ActionListener() {		//기능
			public void actionPerformed(ActionEvent e) {
				Connection conn=null; //DB�� �����ϴ� �������̽�
				PreparedStatement psmt=null;//sql�� ��ü
				ResultSet rs=null; //sql�� ���� ��ȯ(���� ���࿡ ���� ����� ����)
				
				
				try {
					String que="select * from enrol1";
					
					conn=connecDb.get(); //DB����
					
					psmt=conn.prepareStatement(que);
					rs=psmt.executeQuery();
					//select => exectueQuery()
					//DML(insert,update,delete) => executeUpdate();
					
					while(rs.next()) {
						
						String sub_no=rs.getString(1);
						String stu_no=rs.getString(2);
						int enr_grade=rs.getInt(3);
						if(txtfID.getText().equals(stu_no)) {
							JOptionPane.showMessageDialog(null, enr_grade+"입니다");
						}else {
							JOptionPane.showMessageDialog(null, "등록된"+txtfID.getText()+"가 없습니다.");
							break;
						}
					}
				
				rs.close();
				psmt.close();
				conn.close();
			}catch(Exception e1) {
				e1.getStackTrace();
			}}
		});
		btnID.setBounds(244, 130, 82, 28);
		panel.add(btnID);

		JButton btnOk = new JButton("확인");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnOk.setBounds(145, 201, 101, 50);
		panel.add(btnOk);
		
		JLabel lblMent = new JLabel("*birth와 id입력 후 pw찾기 요망");
		lblMent.setBounds(66, 172, 178, 15);
		panel.add(lblMent);
		frame.setVisible(true);



		
	}
}
