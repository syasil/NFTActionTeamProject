import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MissingID {

	private JFrame frame;
	private JTextField txtfBirth;
	private JTextField textField;

	String id="abc";      //***예시 - 지워야함
	
	
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
		btnBirth.setBounds(244, 56, 74, 28);
		panel.add(btnBirth);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(99, 131, 123, 28);
		panel.add(textField);

		JButton btnID = new JButton("PW찾기");
		btnID.setBounds(244, 130, 74, 28);
		panel.add(btnID);

		JButton btnOk = new JButton("확인");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnOk.setBounds(145, 201, 101, 50);
		panel.add(btnOk);
		frame.setVisible(true);

		// ******** 기능 ****************

		
		btnBirth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(txtfBirth.getText().equals(id)) {		//추후 데이터 베이스 넣기
				String resultStr = null;resultStr = JOptionPane.showInputDialog("기본 입력창입니다.");
			}
			}
		});
	}
}
