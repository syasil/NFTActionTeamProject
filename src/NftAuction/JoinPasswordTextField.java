package NftAuction;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JoinPasswordTextField implements JoinTextField{
	private JTextField joinPasswordTextField;
	
	public void setTextField() {
		System.out.println("joinPasswordTextField::setTextField");
	}
	public JTextField getTextField() {
		return joinPasswordTextField;
	}
}

