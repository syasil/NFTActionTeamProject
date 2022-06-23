package ProductRegisterPage;

import javax.swing.JFrame;

public class ProductRegisterTextFieldBuilder {

	private JFrame frame;
	
	private ProductRegisterNameTextField productRegisterNameTextField;
	private ProductRegisterContentTextField productRegisterContentTextField;

	public ProductRegisterTextFieldBuilder(JFrame frame) {
		
		this.frame = frame;
	}

	public void BuildProductRegisterNameTextField(int x, int y, int width, int height) {
		
		productRegisterNameTextField = new ProductRegisterNameTextField(x, y, width, height, frame);
		
	}

	public void BuildProductRegisterContentTextField(int x, int y, int width, int height) {
		
		productRegisterContentTextField = new ProductRegisterContentTextField(x, y, width, height, frame);
		
	}

}
