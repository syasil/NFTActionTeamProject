package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ATextField extends JTextField {
	private Shape shape;
	
	public ATextField() {
		this(50);
	}
	
	public ATextField(int size) {
		super(size);
		setOpaque(false);
		setForeground(Color.DARK_GRAY);
		//setBackground(Color.decode("#1A1A25"));
		setBackground(Color.WHITE);
		setFont(new Font("맑은 고딕", Font.PLAIN, 14));
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