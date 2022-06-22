package ProductRegister;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ProductRegisterNameTextField implements ProductRegisterTextField{

	private JFrame frame;
	private JTextField textField;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public ProductRegisterNameTextField(int x, int y, int width, int height ,JFrame frame) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
		
		System.out.println("ProductRegisterNameTextField::buildTextField");
		
		textField = new JTextField();
		setBoundTextField(x, y, width, height);
		
		frame.getContentPane().add(textField);
	}

	//  textfield 의 위치와 크기를 x, y, width, height 값으로 set
	@Override
	public void setBoundTextField(int x,int y, int width, int height) {
		
		System.out.println("joinIdTextField::setTextField");
		
		textField.setBounds(x, y, width, height);
	}
	
	


}
