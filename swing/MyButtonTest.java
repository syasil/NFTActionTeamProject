package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyButtonTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyButtonTest frame = new MyButtonTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyButtonTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MyButton btnNewButton = new MyButton();
		btnNewButton.setText("이게 버튼이다.");
		btnNewButton.setColorClick(Color.cyan);
		btnNewButton.setRadius(40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton, "안녕");
				
			}
		});
		btnNewButton.setBounds(205, 33, 195, 41);
		contentPane.add(btnNewButton);
		
		MyButton btnNewButton_1 = new MyButton();
		btnNewButton_1.setBounds(205, 84, 195, 41);
		contentPane.add(btnNewButton_1);
		
		MyButton btnNewButton_1_1 = new MyButton();
		btnNewButton_1_1.setBounds(205, 135, 195, 41);
		contentPane.add(btnNewButton_1_1);
	}

}
