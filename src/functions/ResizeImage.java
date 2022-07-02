package functions;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ResizeImage {

	public static ImageIcon resize(String str, int width, int height) {
		ImageIcon image = new ImageIcon(str);
		return resize(image, width, height);
	}
	
	public static ImageIcon resize(ImageIcon img, int width, int height) {
		Image image = img.getImage();
		return resize(image, width, height);
	}

	public static ImageIcon resize(Image img, int width, int height) {
		Image image = img;
		Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}
}
