package swing;

import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

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
			
			//BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.fillRoundRect(0, 0, width, height, roundSize, roundSize);
			g2.drawImage(img, 0, 0, null);
			g2.dispose();
			
			//super.paintComponent(g2);
		} else {

			g.drawImage(img, 0, 0, null);
		}
	}
}