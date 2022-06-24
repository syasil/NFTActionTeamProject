package ImageProcesser;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ProductImageSaver {

	private static BufferedImage image;
	
	public void setImage(BufferedImage image) {
		
		this.image = image;
		
	}
	public static Image getImage() {
		return image;
	}
	public static void saveImage(String filename) {
		
		try {
			ImageIO.write(image, "png", new File("image/product/" + filename + ".png"));
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}

}
