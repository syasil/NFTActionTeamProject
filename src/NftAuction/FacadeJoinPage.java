package NftAuction;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FacadeJoinPage {
	public FacadeJoinPage(int x, int y, int width, int height, int state ,JFrame frame) {
		switch (state) {
		case 1:
			BuildGeneralUserJoinPage(x, y, width, height, frame);
			break;

		default:
			break;
		}
	}

	public void BuildGeneralUserJoinPage(int x, int y, int width, int height, JFrame frame) {
		JoinTextFieldBuilder joinTextFieldBuilder = new JoinTextFieldBuilder(x , y, width, height, frame);
		
		joinTextFieldBuilder.buildJoinIdTextField();
		//joinTextFieldBuilder.buildJoinPassWordTextField();
		//joinTextFieldBuilder.buildJoinCheckPassWordTextField();
		
	}
	public JTextField getGeneralUserJoinPage() {
		return getGeneralUserJoinPage();
	}
}
