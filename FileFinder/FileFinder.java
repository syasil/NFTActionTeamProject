package FileFinder;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import ImageProcesser.ImageSizeModifider;
import ImageProcesser.ProductImageSaver;
import ProductRegisterPage.ProductRegisterImageContentTextPane;
import ProductRegisterPage.ProductRegisterImageLabel;


public class FileFinder {

	
	private JFrame frame;
	private JFileChooser fileChooser;
	private BufferedImage image;
	private String url;
	
	private ImageSizeModifider imageSizeModifider = new ImageSizeModifider();
	

	public FileFinder(JFrame frame) {
		
		this.frame = frame;
		
		fileChooser = new JFileChooser();
		
		
		fileChooser.setFileFilter(new FileNameExtensionFilter("png", "png")); //파일 유형 필터 
		fileChooser.setMultiSelectionEnabled(false); //다중 선택 불가
		
		if(fileChooser.showOpenDialog(frame) == fileChooser.APPROVE_OPTION) {
			url=fileChooser.getSelectedFile().toString();
			System.out.println(url);
			ProductRegisterImageContentTextPane.setContentTextPane(url);
			try {
				
				File sourceimage = new File(url);
				image = ImageIO.read(sourceimage);
			
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			ProductImageSaver productImageSaver = new ProductImageSaver();
			productImageSaver.setImage(image);
			
		
			ProductRegisterImageLabel.setImage(new ImageIcon(imageSizeModifider.resizeImageFile(image, 100, 100)));
			
		}
		
		
	}

}
	
