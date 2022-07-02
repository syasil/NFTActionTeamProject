package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelOpaque extends JPanel {
	public PanelOpaque() {
		setBounds(0, 0, 600, 900);
		setVisible(false);
		setOpaque(false);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(new Color(26, 26, 37, 150));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}