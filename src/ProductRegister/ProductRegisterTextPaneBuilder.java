package ProductRegister;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JTextPane;

public class ProductRegisterTextPaneBuilder {

	private JFrame frame;
	
	private ProductRegisterNameTextPane productRegisterNameTextPane;
	private ProductRegisterContentTextPane productRegisterContentTextPane;

	public ProductRegisterTextPaneBuilder(JFrame frame) {
		
		this.frame = frame;
		
	}
	
	public void BuildProductRegisterNameTextPane(int x, int y,int width, int height, SystemColor color, String text) {
		
		productRegisterNameTextPane = new ProductRegisterNameTextPane(x, y, width, height, frame, color, text);
	}

	public void BuildProductRegisterContentTextPane(int x, int y,int width, int height,  SystemColor color, String text) {
		
		productRegisterContentTextPane = new ProductRegisterContentTextPane(x, y, width, height, frame, color, text);
		
	}

}
