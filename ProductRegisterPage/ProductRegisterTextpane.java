package ProductRegisterPage;

import java.awt.SystemColor;

import javax.swing.JTextPane;

public interface ProductRegisterTextpane {
	JTextPane textPane = null;
	public void setBoundTextPane(int x, int y, int width, int height);
	public void SetBackgroundTextPane(SystemColor color);
	public static void setContentTextPane(String text) {
		
		textPane.setText(text);
		
	}
}
