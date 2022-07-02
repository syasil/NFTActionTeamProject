package ProductRegisterPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import FileFinder.FileFinder;
import ProductRegisterDataBase.DatabaseProductInsert;

public class ProductRegisterEnterButton implements ProductRegisterButton{
	private JFrame frame;
	private JButton button;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public ProductRegisterEnterButton(int x, int y, int width, int height ,JFrame frame, String text) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
		
		System.out.println("ProductRegisterEnterButton::buildJButton");
		
		button = new JButton();
		setBoundButton(x, y, width, height);
		setContentButton(text);
		frame.getContentPane().add(button);
		button.setBackground(Color.LIGHT_GRAY);
		button.setFont(new Font("맑은 고딕",Font.BOLD,20));
		
		
		
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("addActionListener::ProductRegisterEnterButton");
				DatabaseProductInsert databaseProductInsert = new DatabaseProductInsert();
				databaseProductInsert.dataInsert();
			
			}
		});
		
	}

	//  button 의 위치와 크기를 x, y, width, height 값으로 set
	@Override
	public void setBoundButton(int x,int y, int width, int height) {
		
		System.out.println("ProductRegisterEnterButton::setJButton");
		
		button.setBounds(x, y, width, height);
	}

	@Override
	public void setContentButton(String text) {
	
		button.setText(text);
		
	}

}
