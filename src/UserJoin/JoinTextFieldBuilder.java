package UserJoin;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JoinTextFieldBuilder {
	
	private JFrame frame;
	
	private JoinTextField joinIdTextField;
	private JoinTextField joinPasswordTextField;
	private JoinTextField joinPasswordCheckTextField;
	
	
	
	public JoinTextFieldBuilder(JFrame frame) {
		
		this.frame = frame;
		
	}

	public void buildJoinIdTextField(int x, int y, int width, int heigth) {
		
		joinIdTextField = new JoinIdTextField(x, y, width, heigth, frame);
		
	}

	public void buildJoinPassWordTextField(int x, int y, int width, int heigth) {
		
		joinPasswordTextField = new JoinPasswordTextField(x, y, width, heigth, frame);
		
	}

	public void buildJoinCheckPassWordTextField(int x, int y, int width, int heigth) {
		
		joinPasswordCheckTextField = new JoinPasswordCheckTextField(x, y, width, heigth, frame);
		
	}
	
}
