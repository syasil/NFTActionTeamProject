package ProductRegisterPage;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import FileFinder.FileFinder;
import ImageProcesser.ImageFileSaver;
import ImageProcesser.ImageSizeModifider;

public class ProductRegisterImageLabel {
	private JFrame frame;
	private static JLabel label;
	private static BufferedImage image;
	private static ImageIcon imageIcon;
	private FileFinder fileFinder; 
	
	
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
			
				fileFinder = new FileFinder();
				try {
					
					image = ImageIO.read(ImageFileSaver.getFile());
					setImage(ImageSizeModifider.getInstance().resizeImageFile(image, 100, 100));
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			
		});
		
	}

	//  textfield 의 위치와 크기를 x, y, width, height 값으로 set
	
	public void setBoundLabel(int x,int y, int width, int height) {
		
		System.out.println("ProductRegisterImageLabel::setLabel");
		
		label.setBounds(x, y, width, height);
	}

	
	private void setImage(Image resizeImageFile) {
		
		label.setIcon(new ImageIcon(resizeImageFile));
		
	}
	
}
