package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class CLabel extends JLabel {
	public CLabel() {
		this("");
	}
	
	public CLabel(String text) {
		super(text);
		setFont(new Font("맑은 고딕", Font.BOLD, 16));
		setForeground(Color.WHITE);
	}
}
