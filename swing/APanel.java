package swing;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class APanel extends JPanel {

	private Image img;
	private int roundSize;
	
	public APanel() {
		this(0);
	}
	
	public APanel(int roundSize) {
		this.roundSize = roundSize;
		setLayout(null);
	}
	
	public APanel(String img) {
		this(new ImageIcon(img).getImage(), 0);
	}
	
	public APanel(String img, int roundSize) {
		this(new ImageIcon(img).getImage(), roundSize);
	}
	
	public APanel(Image img) {
		this(img, 0);
	}
	
	public APanel(Image img, int roundSize) {
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
			g.setColor(new Color(252, 250, 255));
//			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	
	//선 그리기
    public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin1 = new Line2D.Float(20, 55, 600, 55);
        g2.draw(lin1);
    }
	
}