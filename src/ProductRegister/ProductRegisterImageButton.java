package ProductRegister;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ProductRegisterImageButton implements ProductRegisterButton{

	private JFrame frame;
	private JButton button;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public ProductRegisterImageButton(int x, int y, int width, int height ,JFrame frame, String text) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
		
		System.out.println("ProductRegisterImageButton::buildJButton");
		
		button = new JButton();
		setBoundButton(x, y, width, height);
		setContentButton(text);
		frame.getContentPane().add(button);
	}

	//  button 의 위치와 크기를 x, y, width, height 값으로 set
	@Override
	public void setBoundButton(int x,int y, int width, int height) {
		
		System.out.println("ProductRegisterImageButton::setJButton");
		
		button.setBounds(x, y, width, height);
	}

	@Override
	public void setContentButton(String text) {
	
		button.setText(text);
		
	}

}
