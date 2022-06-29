package functions;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ResizeImage {

	public static ImageIcon resize(String str, int width, int height) {
		ImageIcon img = new ImageIcon(str);
		return resize(img, width, height);
	}
	
	public static ImageIcon resize(ImageIcon img, int width, int height) {
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}
}
