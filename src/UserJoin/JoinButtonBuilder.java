package UserJoin;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JoinButtonBuilder {
	
	private JFrame frame;
	
	private JoinEnterButton joinButton;

	public JoinButtonBuilder(JFrame frame) {
		
		this.frame = frame;
		
	}
	public void buildJoinEnterButton(int x, int y, int width, int heigth) {
		
		joinButton = new JoinEnterButton(x, y, width, heigth, frame);
		
	}
}
