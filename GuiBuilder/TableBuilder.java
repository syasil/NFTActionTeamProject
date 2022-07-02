package GuiBuilder;

import javax.swing.JFrame;

import Auction.ProductListTable;



public class TableBuilder {
private JFrame frame;
	
	public TableBuilder(JFrame frame) {
		
		this.frame = frame;
	}

	public void BuildProductListTable(int x, int y, int width, int height) {
		
		ProductListTable productListTable = new ProductListTable(x, y, width, height, frame);
		
	}



}
