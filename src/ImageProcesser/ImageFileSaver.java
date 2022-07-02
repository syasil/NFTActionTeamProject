package ImageProcesser;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageFileSaver {

	private static ImageFileSaver instance = new ImageFileSaver();
	private static File file;
	
	public static ImageFileSaver getInstance() {
		
		return instance;
		
	}
	/*
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
	}*/
	public static File getFile() {
		
		return file;
	}
	public void setFile(File file) {
		
		this.file = file;
		
	}

}
