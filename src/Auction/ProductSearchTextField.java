package Auction;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ProductSearchTextField{
	private JFrame frame;
	private static JTextField textField;
	
	
	public ProductSearchTextField(int x, int y, int width, int height ,JFrame frame) {
		
		
		this.frame = frame;
		
		System.out.println("ProductRegisterNameTextField::buildTextField");
		
		textField = new JTextField();
		setBoundTextField(x, y, width, height);
		
		frame.getContentPane().add(textField);
	}
	
	public void setBoundTextField(int x,int y, int width, int height) {
		
		textField.setBounds(x, y, width, height);
	}
	
	public static String getTextFieldValue() {
		
		return textField.getText();
		
	}

	
	
}
