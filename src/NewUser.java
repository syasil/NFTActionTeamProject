import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewUser {
	NewUser(){
	JFrame frame= new JFrame();

	frame.setSize(300,500);
	
	
	
	
	JPanel newuserPanel=new JPanel();
	JLabel newuserTitle=new JLabel("회원가입");
	JLabel newuserIdLabel=new JLabel("ID: ");
	JLabel newuserPassLabel=new JLabel("PW:");
	JLabel newuserBirthLabel=new JLabel("Birth: ");
	JLabel newuserwhatLabel=new JLabel("what: ");		//뭐할지???
	JTextField newuserIdText=new JTextField(10);
	JPasswordField newuserPassText=new JPasswordField(10);
	JTextField newuserBirthText=new JTextField(10);
	JTextField newuserwhatText=new JTextField(10);      // 뭐할지???
	JButton newuserCancleButton=new JButton("취소");
	JButton newuserSignupButton=new JButton("회원가입");

	//***********좌표 설정***************
	newuserPanel.setLayout(null);
	newuserTitle.setBounds(60,10,150,100);
	newuserIdLabel.setBounds(50,100,30,30);
	newuserIdText.setBounds(100,100,100,30);
	newuserPassLabel.setBounds(50,150, 30, 30);
	newuserPassText.setBounds(100,150,100,30);
	newuserBirthLabel.setBounds(50,200, 40, 30);
	newuserBirthText.setBounds(100,200,100,30);
	newuserwhatLabel.setBounds(50,250,40,30);
	newuserwhatText.setBounds(100,250,100,30);
	
	newuserSignupButton.setBounds(20,300,100,20);
	newuserCancleButton.setBounds(140,300,100,20);
	
	
	
	//************색상********************
	newuserCancleButton.setBackground(Color.LIGHT_GRAY);
	newuserSignupButton.setBackground(Color.LIGHT_GRAY);
	newuserCancleButton.setBackground(Color.LIGHT_GRAY);
	
	
	//*************폰트*********************
	Font font=new Font("궁서",Font.BOLD,30);
	
	newuserTitle.setFont(font);
	
	//***********add*******************
	frame.add(newuserPanel);
	
	newuserPanel.add(newuserTitle);
	newuserPanel.add(newuserIdLabel);
	newuserPanel.add(newuserIdText);
	newuserPanel.add(newuserPassLabel);
	newuserPanel.add(newuserPassText);
	newuserPanel.add(newuserBirthLabel);
	newuserPanel.add(newuserBirthText);
	newuserPanel.add(newuserwhatLabel);		//	
	newuserPanel.add(newuserwhatText);		//
	newuserPanel.add(newuserCancleButton);
	newuserPanel.add(newuserSignupButton);
	
	frame.setVisible(true);

}
	public static void main(String[] args) {
	
}
}