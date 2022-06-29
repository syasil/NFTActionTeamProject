package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CImageButton extends JButton {
	
	private Image img;
	private int roundSize;

	public CImageButton(ImageIcon img) {
		this(img, 0);
	}
	
	public CImageButton(ImageIcon img, int roundSize) {
		this.img = img.getImage();
		this.roundSize = roundSize;
		setContentAreaFilled(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setFocusable(false);
		setBorderPainted(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (roundSize > 0) {
			int width = getWidth();
			int height = getHeight();
			
			BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null), BufferedImage.TYPE_INT_RGB);
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			g2d.clip(new RoundRectangle2D.Double(0, 0, getWidth(),getHeight(), roundSize, roundSize));
			g2d.drawImage(img, 0,0, null);
			g2d.dispose();
		} else {
			g.drawImage(img, 0, 0, null);
		}
	}
}