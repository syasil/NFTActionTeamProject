package GuiBuilder;

import javax.swing.JFrame;

import Auction.AuctionStartButton;
import Auction.ProductSearchButton;
import ProductRegisterPage.ProductRegisterEnterButton;
import ProductRegisterPage.ProductRegisterImageButton;

public class ButtonBuilder {

private JFrame frame;
	
	

	public ButtonBuilder(JFrame frame) {
		
		this.frame = frame;
	}

	public void BuildProductRegisterImageButton(int x, int y, int width, int height, String text) {
		
		ProductRegisterImageButton productRegisterImageButton = new ProductRegisterImageButton(x, y, width, height, frame, text);
		
	}

	public void BuildProductRegisterEnterButton(int x, int y, int width, int height, String text) {
		
		ProductRegisterEnterButton productRegisterEnterButton = new ProductRegisterEnterButton(x, y, width, height, frame, text);
		
	}

	public void BuildProductSearchButton(int x, int y, int width, int height, String text) {
		
		ProductSearchButton productSearchButton = new ProductSearchButton(x, y, width, height, frame, text);
		
	}

	
	



}
