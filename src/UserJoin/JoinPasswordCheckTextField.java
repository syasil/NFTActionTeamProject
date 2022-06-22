package UserJoin;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JoinPasswordCheckTextField implements JoinTextField{
	
	private JTextField textField;
	
	private int x;
	private int y;
	private int width;
	private int height;
	private JFrame frame;
	
	public JoinPasswordCheckTextField(int x, int y, int width, int height, JFrame frame){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
		
		System.out.println("joinPasswordCheckTextField::buildTextField");
		
		textField = new JTextField();
		setBoundTextField(x, y, width, height);
		frame.getContentPane().add(textField);
	}
	
	// �ش� textfield�� x, y, width, height�� set
	public void setBoundTextField(int x,int y, int width, int height) {
		
		System.out.println("joinIdTextField::setTextField");
		
		textField.setBounds(x, y, width, height);
		
	}
}
