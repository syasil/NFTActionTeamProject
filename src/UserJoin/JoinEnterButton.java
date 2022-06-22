package UserJoin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JoinEnterButton{ 
	
	private int x;
	private int y;
	private int width;
	private int height;
	private JFrame frame;
	
	private JButton button;

	public JoinEnterButton(int x, int y, int width, int height ,JFrame frame) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
		
		System.out.println("joinButton::buildButton");
		
		button = new JButton();
		setBoundButton(x, y, width, height);
		
		frame.getContentPane().add(button);
		
	}
	
	public void setBoundButton(int x, int y, int width, int height) {
		
		button.setBounds(x, y, width, height);
		
	}
	
}
