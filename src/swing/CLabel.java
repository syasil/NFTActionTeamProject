package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class CLabel extends JLabel {
	private String fontName = "맑은 고딕";
	
	public CLabel() {
		this("");
	}
	
	public CLabel(String text) {
		this(text, 16);
	}
	
	public CLabel(String text, int size) {
		super(text);
		setFont(new Font(fontName, Font.BOLD, size));
		setForeground(Color.WHITE);
	}
	
	public void setFontSize(int size) {
		setFont(new Font(fontName, Font.BOLD,  size));
	}
}
