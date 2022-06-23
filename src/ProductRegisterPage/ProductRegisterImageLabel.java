package ProductRegisterPage;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class ProductRegisterImageLabel {
	private JFrame frame;
	private static JLabel label;
	private static ImageIcon image;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public ProductRegisterImageLabel(int x, int y, int width, int height ,JFrame frame) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
		
		System.out.println("ProductRegisterImageLabel::buildLabel");
		
		label = new JLabel();
		setBoundLabel(x, y, width, height);
		frame.getContentPane().add(label);
		
	}

	//  textfield 의 위치와 크기를 x, y, width, height 값으로 set
	
	public void setBoundLabel(int x,int y, int width, int height) {
		
		System.out.println("ProductRegisterImageLabel::setLabel");
		
		label.setBounds(x, y, width, height);
	}

	public static void setImage(ImageIcon imageIcon) {
		
		System.out.println("ProductRegisterImageLabel::setImage");
		image = imageIcon;
		label.setIcon(image);
		
	}
	public static ImageIcon getImage() {
		return image;
	}
	
}
