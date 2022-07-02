package ProductRegisterPage;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;

import GuiBuilder.ButtonBuilder;
import GuiBuilder.LabelBuilder;
import GuiBuilder.TextFieldBuilder;
import GuiBuilder.TextPaneBuilder;

public class FacadeProductRegisterPage {
		
	private JFrame productRegisterFrame;
	
	public FacadeProductRegisterPage() {
		
		productRegisterFrame = new JFrame();
		productRegisterFrame.setBounds(100, 100, 600, 630);
		productRegisterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		productRegisterFrame.getContentPane().setLayout(null);
		
		productRegisterFrame.setVisible(true);
		
		BuildProductRegisterPage();
		
	}
	public void BuildProductRegisterPage() {
		
		TextPaneBuilder textPaneBuilder = new TextPaneBuilder(productRegisterFrame);
		TextFieldBuilder textFieldBuilder = new TextFieldBuilder(productRegisterFrame);
		ButtonBuilder buttonbuilder = new ButtonBuilder(productRegisterFrame);
		LabelBuilder labelBuilder = new LabelBuilder(productRegisterFrame);
		
		
		textPaneBuilder.BuildProductRegisterTitleTextPane(15, 15, 500, 80, SystemColor.menu, "상품등록");
		textPaneBuilder.BuildProductRegisterNameTextPane(15, 260, 60, 40, SystemColor.menu, "상품명");
		textPaneBuilder.BuildProductRegisterContentTextPane(15, 310, 80, 40, SystemColor.menu, "상품 상세");
		textPaneBuilder.BuildProductRegisterImageContentTextPane(220, 220, 500, 20, SystemColor.menu, "");
		
		textFieldBuilder.BuildProductRegisterNameTextField(120, 260, 400, 40);
		textFieldBuilder.BuildProductRegisterContentTextField(120, 310, 400, 200);
		
		
		labelBuilder.BuildProductRegisterImageLabel(120, 140, 100, 100);
		//productRegisterLabelBuilder.BuildProductRegisterImageLabel(120, 300, 100, 100);
		
		
		//productRegisterButtonbuilder.BuildProductRegisterImageButton(15, 500, 120, 20, "이미지 업로드");
		
		buttonbuilder.BuildProductRegisterEnterButton(120, 530, 80, 50, "등록");
		
	
		
	}

	
	

}
