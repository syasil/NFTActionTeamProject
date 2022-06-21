package NftAuction;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JoinTextFieldBuilder {
	private JFrame frame;
	
	private JoinTextField joinIdTextField;
	private JoinTextField joinPasswordTextField;
	private JoinTextField joinCheckPasswordTextField;
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	
	
	public JoinTextFieldBuilder(int x, int y, int width, int height, JFrame frame) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
		
		
		
	}

	public void buildJoinIdTextField() {
		joinIdTextField = new JoinIdJTextField(x, y, width, height, frame);
		System.out.println(x);
		joinIdTextField.setTextField();
		
	}

	public void buildJoinPassWordTextField() {
		//joinPasswordTextField.setTextField();
	}

	public void buildJoinCheckPassWordTextField() {
		//joinCheckPasswordTextField.setTextField();
		
	}
	
	public JTextField getJoinIdTextField() {
		return joinIdTextField.getTextField();
	}
}
