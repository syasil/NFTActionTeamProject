package ProductRegisterPage;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JTextPane;

public class ProductRegisterTextPaneBuilder {

	private JFrame frame;
	
	private ProductRegisterNameTextPane productRegisterNameTextPane;
	private ProductRegisterContentTextPane productRegisterContentTextPane;

	private ProductRegisterImageContentTextPane productRegisterImageContentTextPane;

	public ProductRegisterTextPaneBuilder(JFrame frame) {
		
		this.frame = frame;
		
	}

	public void BuildProductRegisterNameTextPane(int x, int y,int width, int height, SystemColor color, String text, Font font) {
		
		productRegisterNameTextPane = new ProductRegisterNameTextPane(x, y, width, height, frame, color, text);
	}

	public void BuildProductRegisterContentTextPane(int x, int y,int width, int height,  SystemColor color, String text, Font font) {
		
		productRegisterContentTextPane = new ProductRegisterContentTextPane(x, y, width, height, frame, color, text);
		
	}

	public void BuildProductRegisterImageContentTextPane(int x, int y,int width, int height,  SystemColor color, String text, Font font) {

		productRegisterImageContentTextPane = new ProductRegisterImageContentTextPane(x, y, width, height, frame, color, text);
		
	}

}
