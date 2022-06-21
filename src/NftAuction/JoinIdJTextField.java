package NftAuction;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JoinIdJTextField implements JoinTextField{
	private JFrame frame;
	private JTextField textField;
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public JoinIdJTextField(int x, int y, int width, int height ,JFrame frame) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
	}

	
	public void setTextField() {
		System.out.println("joinIdTextField::setTextField");
		
		textField = new JTextField();
		textField.setBounds(x, y, width, height);
		frame.getContentPane().add(textField);
		
	}
	
	public JTextField getTextField() {
		return textField;
	}

	
}
