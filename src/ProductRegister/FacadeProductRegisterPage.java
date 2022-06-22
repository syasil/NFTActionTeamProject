package ProductRegister;

import java.awt.SystemColor;

import javax.swing.JFrame;

public class FacadeProductRegisterPage {

	
	public FacadeProductRegisterPage(JFrame frame) {
		
		BuildProductRegisterPage(frame);
		
	}
	public void BuildProductRegisterPage(JFrame frame) {
		
		ProductRegisterTextPaneBuilder productRegisterTextPaneBuilder = new ProductRegisterTextPaneBuilder(frame);
		ProductRegisterTextFieldBuilder productRegisterTextFieldBuilder = new ProductRegisterTextFieldBuilder(frame);
		ProductRegisterButtonbuilder productRegisterButtonbuilder = new ProductRegisterButtonbuilder(frame);
		
		productRegisterTextPaneBuilder.BuildProductRegisterNameTextPane(15, 50, 60, 20, SystemColor.menu, "상품명");
		
		productRegisterTextFieldBuilder.BuildProductRegisterNameTextField(120, 50, 300, 20);
		
		
		
		productRegisterTextPaneBuilder.BuildProductRegisterContentTextPane(15, 100, 60, 20, SystemColor.menu, "상품 상세");
		
		productRegisterTextFieldBuilder.BuildProductRegisterContentTextField(120, 100, 500, 200);
		
		
		
		productRegisterButtonbuilder.BuildProductRegisterNameTextField(15, 500, 120, 20, "이미지 업로드");
		productRegisterTextPaneBuilder.BuildProductRegisterNameTextPane(150, 500, 120, 20, SystemColor.menu, "");
		
		
		
		
		
		
		
	}
	

}
