package functions;

import java.awt.Color;
import javax.swing.JPanel;

public class SlidingAnimate extends Thread {
	
	JPanel panel;
	String direction;

	public SlidingAnimate(JPanel panel, String direction) {
		this.panel = panel;
		this.direction = direction;
	}

	public void run() {
		panel.setLocation(panel.getX(), 0);
		panel.setVisible(true);
		
		if (direction.equals("DOWN")) {
			SlideDown();
		} else if (direction.equals("OUT")) {
			SlideOut();
		}
	}
	
	private void SlideDown() {
		int stopY = (panel.getParent().getHeight() - panel.getHeight()) / 2;
		int posX = panel.getX();
		int posY = 0;

		while (true) {
			posY = posY + 10;
			panel.setLocation(posX, posY);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (posY > stopY) {
				break;
			}
		}
	}
	
	private void SlideOut() {
		Color bgColor = panel.getBackground();
		
		int red = bgColor.getRed();
		int green = bgColor.getGreen();
		int blue = bgColor.getBlue();
		int alpha = bgColor.getAlpha();
		
		while (true) {
			System.out.println(alpha);
			alpha = alpha - 10;
			if (alpha <= 0) alpha = 0;
			panel.setBackground(new Color(red, blue, green, alpha) );
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (alpha <= 0) {
				panel.setVisible(false);
				break;
			}
		}
	}
	
}