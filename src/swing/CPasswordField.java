package swing;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class CPasswordField extends JPasswordField {
	private Shape shape;
	
	public CPasswordField() {
		this(50);
	}
	
	public CPasswordField(int size) {
		super(size);
		setOpaque(false);
		setForeground(Color.DARK_GRAY);
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
		super.paintComponent(g);
	}
	protected void paintBorder(Graphics g) {
		g.setColor(new Color(0, 0, 0, 150));
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
	}
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 10, 10);
		}
		return shape.contains(x, y);
	}
}
