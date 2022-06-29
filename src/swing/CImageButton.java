package swing;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

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
			RoundRectangle2D r = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), roundSize, roundSize);
			g.setClip(r);
		}
		
		g.drawImage(img, 0, 0, null);
	}
}