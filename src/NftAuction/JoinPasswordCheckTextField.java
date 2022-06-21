package NftAuction;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JoinPasswordCheckTextField implements JoinTextField{
	private JTextField joinPasswordCheckTextField;
	
	public void setTextField() {
		System.out.println("joinPasswordTextField::setTextField");
	}
	public JTextField getTextField() {
		return joinPasswordCheckTextField;
	}
}
