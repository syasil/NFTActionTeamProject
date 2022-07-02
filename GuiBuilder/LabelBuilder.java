package GuiBuilder;

import javax.swing.JFrame;

import ProductRegisterPage.ProductRegisterImageLabel;

public class LabelBuilder {
private JFrame frame;
	
	private ProductRegisterImageLabel productRegisterImageLabel;
	

	public LabelBuilder(JFrame frame) {
		
		this.frame = frame;
	}

	public void BuildProductRegisterImageLabel(int x, int y, int width, int height) {
		
		productRegisterImageLabel = new ProductRegisterImageLabel(x, y, width, height, frame);
		
	}

	

	
}
