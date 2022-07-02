package Auction;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import ProductRegisterDataBase.DatabaseProductInsert;

public class ProductSearchButton {
	private JFrame frame;
	private JButton button;
	

	public ProductSearchButton(int x, int y, int width, int height ,JFrame frame, String text) {
	
		this.frame = frame;
		
		button = new JButton();
		setBoundButton(x, y, width, height);
		setContentButton(text);
		frame.getContentPane().add(button);
		button.setBackground(Color.LIGHT_GRAY);
		button.setFont(new Font("맑은 고딕",Font.BOLD,20));
		
		
		
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("addActionListener::ProductRegisterEnterButton");
				ProductList productList = new ProductList();
				productList.selectList(ProductSearchTextField.getTextFieldValue());
				
			
			}
		});
		
	}

	//  button 의 위치와 크기를 x, y, width, height 값으로 set
	public void setBoundButton(int x,int y, int width, int height) {
		
		System.out.println("ProductRegisterEnterButton::setJButton");
		
		button.setBounds(x, y, width, height);
	}

	public void setContentButton(String text) {
	
		button.setText(text);
		
	}
}
