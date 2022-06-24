import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Basic {

	private JFrame frame;
	
	/**
	 * Launch the application.11
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Basic window = new Basic();
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
	public Basic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame = new JFrame();

		frame.setSize(600, 500);

		JPanel panel = new JPanel();
		JLabel idLabel = new JLabel("ID: ");
		JLabel passLabel = new JLabel("PW:");
		JTextField idText = new JTextField(10);
		JPasswordField passText = new JPasswordField(10);
		JButton loginButton = new JButton("로그인");
		JButton signupButton = new JButton("회원가입");
		JButton missingButton = new JButton("ID / PW찾기");
		
		
		JLabel titleLabel = new JLabel("NFT 경매 시스템");
		// ***********좌표 설정***************
		panel.setLayout(null);
		idLabel.setBounds(360, 25, 30, 30);
		idText.setBounds(390, 25, 100, 30);
		passLabel.setBounds(360, 60, 30, 30);
		loginButton.setBounds(500, 15, 80, 80);
		passText.setBounds(390, 60, 100, 30);
		signupButton.setBounds(370, 100, 100, 20);
		missingButton.setBounds(480, 100, 100, 20);
		titleLabel.setBounds(20, -50, 400, 200); // y좌표 -> 가능????

		// ************색상********************
		loginButton.setBackground(Color.LIGHT_GRAY);
		signupButton.setBackground(Color.LIGHT_GRAY);
		missingButton.setBackground(Color.LIGHT_GRAY);

		// *************폰트*********************
		Font font = new Font("궁서", Font.ITALIC, 40);

		titleLabel.setFont(font);

		// ***********add*******************
		frame.getContentPane().add(panel);
		panel.add(titleLabel);
		panel.add(idLabel);
		panel.add(idText);
		panel.add(passLabel);
		panel.add(passText);
		panel.add(loginButton);
		panel.add(signupButton);
		panel.add(missingButton);
		frame.setVisible(true);

		// ***********기능*********
		signupButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewUser();
			}
		});
		
		missingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new MissingID();	
				
			}
		});
		
		
		
		
	}

}

