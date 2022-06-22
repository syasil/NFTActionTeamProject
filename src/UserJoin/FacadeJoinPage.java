package UserJoin;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FacadeJoinPage {
	public FacadeJoinPage(int state ,JFrame frame) {
		switch (state) {
		case 1:
			BuildGeneralUserJoinPage(frame);
			break;

		default:
			break;
		}
	}

	public void BuildGeneralUserJoinPage(JFrame frame) {
		
		JoinTextFieldBuilder joinTextFieldBuilder = new JoinTextFieldBuilder(frame);
		JoinTextPaneBuilder joinTextPaneBuilder = new JoinTextPaneBuilder(frame);
		JoinButtonBuilder joinButtonBuilder = new JoinButtonBuilder(frame);
		
		
		joinTextPaneBuilder.buildJoinIdTextpane(15, 50, 60, 20,SystemColor.menu, "\uC544\uC774\uB514"); 
		//x =15, y=50, width=60 height =20, backgroundColor = SystemColor.menu, text = id  idtextField 생성
		
		joinTextFieldBuilder.buildJoinIdTextField(120, 50, 150, 20); 
		//x =120, y=50, width=150, height =20 idtextField 생성
		
		

		
		joinTextFieldBuilder.buildJoinPassWordTextField(120, 100, 150, 20); //x =120, y=100, width=150, height =20 passwordtextField 생성
		joinTextFieldBuilder.buildJoinCheckPassWordTextField(120, 150, 150, 20); //x =120, y=100, width=150, height =20 passwordCHecktextField 생성
		
		
		
		joinButtonBuilder.buildJoinEnterButton(70, 400, 100, 25);//x =70, y=400, width=100, height =25 joinButton 생성
		
	}
}
