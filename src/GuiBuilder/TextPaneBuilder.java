package GuiBuilder;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import ProductRegisterPage.ProductRegisterContentTextPane;
import ProductRegisterPage.ProductRegisterImageContentTextPane;
import ProductRegisterPage.ProductRegisterNameTextPane;
import ProductRegisterPage.ProductRegisterTitleTextPane;

public class TextPaneBuilder {

	private JFrame frame;
	
	private ProductRegisterNameTextPane productRegisterNameTextPane;
	private ProductRegisterContentTextPane productRegisterContentTextPane;

	private ProductRegisterImageContentTextPane productRegisterImageContentTextPane;

	private ProductRegisterTitleTextPane productRegisterTitleTextPane;

	public TextPaneBuilder(JFrame frame) {
		
		this.frame = frame;
		
	}

	public void BuildProductRegisterNameTextPane(int x, int y,int width, int height, SystemColor color, String text) {
		
		productRegisterNameTextPane = new ProductRegisterNameTextPane(x, y, width, height, frame, color, text);
	}

	public void BuildProductRegisterContentTextPane(int x, int y,int width, int height,  SystemColor color, String text) {
		
		productRegisterContentTextPane = new ProductRegisterContentTextPane(x, y, width, height, frame, color, text);
		
	}

	public void BuildProductRegisterImageContentTextPane(int x, int y,int width, int height,  SystemColor color, String text) {

		productRegisterImageContentTextPane = new ProductRegisterImageContentTextPane(x, y, width, height, frame, color, text);
		
	}

	public void BuildProductRegisterTitleTextPane(int x, int y,int width, int height,  SystemColor color, String text) {
		
		productRegisterTitleTextPane = new ProductRegisterTitleTextPane(x, y, width, height, frame, color, text);
		
	}

}
