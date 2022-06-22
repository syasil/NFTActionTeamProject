package ProductRegister;

import javax.swing.JFrame;

public class ProductRegisterButtonbuilder {

private JFrame frame;
	
	private ProductRegisterImageButton productRegisterImageButton;
	

	public ProductRegisterButtonbuilder(JFrame frame) {
		
		this.frame = frame;
	}

	public void BuildProductRegisterNameTextField(int x, int y, int width, int height, String text) {
		
		productRegisterImageButton = new ProductRegisterImageButton(x, y, width, height, frame, text);
		
	}



}
