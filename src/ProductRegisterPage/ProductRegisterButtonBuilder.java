package ProductRegisterPage;

import java.awt.Font;

import javax.swing.JFrame;

public class ProductRegisterButtonBuilder {

private JFrame frame;
	
	private ProductRegisterImageButton productRegisterImageButton;
	private ProductRegisterEnterButton productRegisterEnterButton;
	

	public ProductRegisterButtonBuilder(JFrame frame) {
		
		this.frame = frame;
	}

	public void BuildProductRegisterImageButton(int x, int y, int width, int height, String text, Font font) {
		
		productRegisterImageButton = new ProductRegisterImageButton(x, y, width, height, frame, text);
		
	}

	public void BuildProductRegisterEnterButton(int x, int y, int width, int height, String text, Font font) {
		
		productRegisterEnterButton = new ProductRegisterEnterButton(x, y, width, height, frame, text,font);
		
	}



}
