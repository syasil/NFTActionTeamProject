package UserJoin;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JoinIdTextField implements JoinTextField{
	
	private JFrame frame;
	private JTextField textField;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public JoinIdTextField(int x, int y, int width, int height ,JFrame frame) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
		
		System.out.println("joinIdTextField::buildTextField");
		
		textField = new JTextField();
		setBoundTextField(x, y, width, height);
		
		frame.getContentPane().add(textField);
	}

	//  textfield 의 위치와 크기를 x, y, width, height 값으로 set
	public void setBoundTextField(int x,int y, int width, int height) {
		
		System.out.println("joinIdTextField::setTextField");
		
		textField.setBounds(x, y, width, height);
	}
	
	

	
}
