package student;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertStudent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public InsertStudent() {
		setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(56, 10, 116, 21);
		textField_2.setColumns(10);
		add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(56, 36, 116, 21);
		textField_1.setColumns(10);
		add(textField_1);
		
		textField = new JTextField();
		textField.setBounds(56, 77, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(167, 160, 97, 23);
		add(btnNewButton);
		
		
	}

}
