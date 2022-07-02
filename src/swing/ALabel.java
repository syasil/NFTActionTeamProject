
package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class ALabel extends JLabel {
	public ALabel() {
		this("");
	}
	
	public ALabel(String text) {
		super(text);
		setFont(new Font("맑은 고딕", Font.PLAIN ,16));
		setBackground(new Color(29, 38, 48));
	}
}