package ImageProcesser;

import java.awt.Image;



public class ImageSizeModifider {
	
	
	private static ImageSizeModifider instance = new ImageSizeModifider();
	public static ImageSizeModifider getInstance() {
		return instance;
	}
	
	public Image resizeImageFile(Image image, int width, int height) {
		

		int oldWidth = image.getWidth(null);
		int oldHeight = image.getHeight(null);
		
		
		if(oldWidth > width) {
			
			height = (oldHeight * width)/oldWidth;
			
			Image resizeImage = image.getScaledInstance(width, height, Image.SCALE_FAST);
			
			return resizeImage;
		}
		else if(oldHeight > height) {
			
			width = (oldWidth * height)/oldHeight;
			
			Image resizeImage = image.getScaledInstance(width, height, Image.SCALE_FAST);
			
			return resizeImage;
			
		}
		return image;
		
	}
}
