package GuiBuilder;

import javax.swing.JFrame;

import Auction.ProductSearchTextField;
import ProductRegisterPage.ProductRegisterContentTextField;
import ProductRegisterPage.ProductRegisterNameTextField;

public class TextFieldBuilder {

	private JFrame frame;

	public TextFieldBuilder(JFrame frame) {
		
		this.frame = frame;
	}

	public void BuildProductRegisterNameTextField(int x, int y, int width, int height) {
		
		ProductRegisterNameTextField productRegisterNameTextField = new ProductRegisterNameTextField(x, y, width, height, frame);
		
	}

	public void BuildProductRegisterContentTextField(int x, int y, int width, int height) {
		
		ProductRegisterContentTextField productRegisterContentTextField = new ProductRegisterContentTextField(x, y, width, height, frame);
		
	}
	public void BuildProductSearchTextField(int x, int y, int width, int height) {
		
		ProductSearchTextField productSearchTextField = new ProductSearchTextField(x, y, width, height, frame);
		
	}

}
