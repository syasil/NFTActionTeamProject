package swing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class AButton extends JButton {
	private Color color1 = new Color(0, 198, 251);
	private Color color2 = new Color(0, 91, 234);
	private final Timer timer;
	private float alpha = 0.3f;
	private boolean mouseOver;

	public AButton() {
		this("", "");
	}
	
	public AButton(String text) {
		this(text, "");
	}

	public AButton(String text, String color) {
		if (color.equals("DARK")) {
			color1 = Color.GRAY;
			color2 = Color.GRAY;
		}
		
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBorder(new EmptyBorder(10, 20, 10, 20));
		setFocusable(false);
		setFont(new Font("맑은 고딕", Font.BOLD, 14));
		setText(text);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				mouseOver = true;
				timer.start();
			}

			@Override
			public void mouseExited(MouseEvent me) {
				mouseOver = false;
				timer.start();
			}

		});
		timer = new Timer(40, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (mouseOver) {
					if (alpha < 0.6f) {
						alpha += 0.05f;
						repaint();
					} else {
						alpha = 0.6f;
						timer.stop();
						repaint();
					}
				} else {
					if (alpha > 0.3f) {
						alpha -= 0.05f;
						repaint();
					} else {
						alpha = 0.3f;
						timer.stop();
						repaint();
					}
				}
			}
		});

	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		int width = getWidth();
		int height = getHeight();
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = img.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Create Gradients Color
		GradientPaint gra = new GradientPaint(0, 0, color1, width, 0, color2);
		g2.setPaint(gra);
		g2.fillRoundRect(0, 0, width, height, height, height);
		createStyle(g2);
		g2.dispose();
		grphcs.drawImage(img, 0, 0, null);
		super.paintComponent(grphcs);
	}

	private void createStyle(Graphics2D g2) {
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
		int width = getWidth();
		int height = getHeight();
		GradientPaint gra = new GradientPaint(0, 0, Color.WHITE, 0, height, new Color(255, 255, 255, 60));
		g2.setPaint(gra);
		Path2D.Float f = new Path2D.Float();
		f.moveTo(0, 0);
		int controll = height + height / 2;
		f.curveTo(0, 0, width / 2, controll, width, 0);
		g2.fill(f);
	}
}