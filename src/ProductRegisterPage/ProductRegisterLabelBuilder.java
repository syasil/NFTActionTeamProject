package ProductRegisterPage;

import javax.swing.JFrame;

public class ProductRegisterLabelBuilder {
private JFrame frame;
	
	private ProductRegisterImageLabel productRegisterImageLabel;
	

	public ProductRegisterLabelBuilder(JFrame frame) {
		
		this.frame = frame;
	}

	public void BuildProductRegisterImageLabel(int x, int y, int width, int height) {
		
		productRegisterImageLabel = new ProductRegisterImageLabel(x, y, width, height, frame);
		
	}

	

	
}
