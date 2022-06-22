package UserJoin;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JoinPasswordTextField implements JoinTextField{
	
	private JTextField textField;
	
	private int x;
	private int y;
	private int width;
	private int heigth;
	private JFrame frame;
	
	public JoinPasswordTextField(int x, int y, int width, int heigth, JFrame frame){
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = heigth;
		this.frame = frame;
		
		System.out.println("joinPasswordTextField::buildTextField");
		
		textField = new JTextField();
		setBoundTextField(x, y, width, heigth);
		frame.getContentPane().add(textField);
	}
	
	// textfield 의 위치와 크기를 x, y, width, height 값으로 set
	public void setBoundTextField(int x, int y, int width, int heigth) {
		
		System.out.println("joinPasswordTextField::setTextField");
		textField.setBounds(x, y, width, heigth);
		
	}
}

