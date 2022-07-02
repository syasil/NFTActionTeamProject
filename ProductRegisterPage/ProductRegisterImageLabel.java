package ProductRegisterPage;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import FileFinder.FileFinder;

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
		label.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
		label.setText("이미지 추가");
		label.setHorizontalAlignment(JLabel.CENTER);
		setBoundLabel(x, y, width, height);
		frame.getContentPane().add(label);
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FileFinder filefinder = new FileFinder(frame);
			}
		});
		
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
