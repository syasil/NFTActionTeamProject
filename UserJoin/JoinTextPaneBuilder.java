package UserJoin;

import java.awt.SystemColor;

import javax.swing.JFrame;

public class JoinTextPaneBuilder {
	
	private JFrame frame;
	
	private JoinIdTextPane joinIdTextPane;
	private JoinIdTextPane joinPasswordTextPane;
	private JoinIdTextPane joinPasswordCheckTextPane;
	
	public JoinTextPaneBuilder(JFrame frame) {
		
		this.frame = frame;
		
	}
	public void buildJoinIdTextpane(int x, int y, int width, int heigth, SystemColor color, String text) {
		joinIdTextPane = new JoinIdTextPane(x, y, width, heigth, frame, color, text);
		
		
	}
	
}
