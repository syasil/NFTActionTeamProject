package swing;

import java.awt.AlphaComposite;
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
	
	private BufferedImage imgBackground;
	private BufferedImage imageRender;
	private int roundSize;

	public CImageButton(ImageIcon img) {
		this(img, 0);
	}
	
	public CImageButton(ImageIcon img, int roundSize) {
		this.imgBackground = imageIconToBufferedImage(img);
		this.roundSize = roundSize;
		setContentAreaFilled(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setFocusable(false);
		setBorderPainted(false);
	}

	
	public void setImage(ImageIcon icon) {
		BufferedImage value = imageIconToBufferedImage(icon);
		
		if (value != imgBackground) {
			BufferedImage old = imgBackground;
			imgBackground = value;
			imageRender = null;
			firePropertyChange("image", old, imgBackground);
			repaint();
		}
	}	
	
	
	protected BufferedImage imageIconToBufferedImage(ImageIcon icon) {
		BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = bufferedImage.createGraphics();
		icon.paintIcon(null, graphics, 0, 0);
		graphics.dispose();
		return bufferedImage;
	}
	
	protected void applyQualityRenderHints(Graphics2D g2d) {
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
	}
	
	protected BufferedImage getImageToRender() {
		BufferedImage source = imgBackground;
		BufferedImage mask = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = mask.createGraphics();
		applyQualityRenderHints(g2d);
		g2d.setBackground(new Color(255, 255, 255, 0));
		g2d.clearRect(0, 0, mask.getWidth(), mask.getHeight());
		g2d.setBackground(new Color(255, 255, 255, 255));
		g2d.fillRoundRect(0, 0, mask.getWidth(), mask.getHeight(), roundSize, roundSize);
		g2d.dispose();

		BufferedImage comp = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
		g2d = comp.createGraphics();
		applyQualityRenderHints(g2d);
		g2d.setBackground(new Color(255, 255, 255, 0));
		g2d.clearRect(0, 0, source.getWidth(), source.getHeight());
		g2d.drawImage(source, 0, 0, this);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
		g2d.drawImage(mask, 0, 0, this);
		g2d.dispose();

		imageRender = comp;

		return imageRender;
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (roundSize > 0) {
			super.paintComponent(g);
			BufferedImage img = getImageToRender();
			Graphics2D g2d = (Graphics2D) g.create();
			int width = getWidth();
			int height = getHeight();
			int x = ((width - img.getWidth()) / 2);
			int y = ((height - img.getHeight()) / 2);
			g2d.drawImage(img, x, y, this);
			g2d.dispose();
		} else {
			g.drawImage(imgBackground, 0, 0, null);
		}
	}
}