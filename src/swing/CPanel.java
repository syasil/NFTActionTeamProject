package swing;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CPanel extends JPanel {

	private Image img;
	private int roundSize;
	
	public CPanel() {
		this(0);
	}
	
	public CPanel(int roundSize) {
		this.roundSize = roundSize;
		setLayout(null);
	}
	
	public CPanel(String img) {
		this(new ImageIcon(img).getImage(), 0);
	}
	
	public CPanel(String img, int roundSize) {
		this(new ImageIcon(img).getImage(), roundSize);
	}
	
	public CPanel(Image img) {
		this(img, 0);
	}
	
	public CPanel(Image img, int roundSize) {
		this.img = img;
		this.roundSize = roundSize;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (roundSize > 0) { 
			RoundRectangle2D r = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), roundSize, roundSize);
			g.setClip(r);
		}
		
		if (img != null) {
			g.drawImage(img, 0, 0, null);
		} else {
			g.setColor(new Color(26, 26, 37));
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
}