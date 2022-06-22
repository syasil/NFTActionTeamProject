package NftAuction;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class JoinIdTextPane implements JoinTextPane {

	private JFrame frame;
	private JTextPane textPane;
	
	private int x;
	private int y;
	private int width;
	private int height;
	private SystemColor color;
	private String text;
	
	public JoinIdTextPane(int x, int y, int width, int height, JFrame frame, SystemColor color, String text) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frame = frame;
		this.color = color;
		this.text = text;
		
		System.out.println("joinIdTextPane::buildTextField");
		
		textPane = new JTextPane();
		setBoundTextPane(x, y, width, height);
		SetBackgroundTextPane(color);
		setContentTextPane(text);
		frame.getContentPane().add(textPane);
		
	}

	//textPane�� ��ġ �� ũ�⸦ �����ϴ� �Լ�
	@Override
	public void setBoundTextPane(int x, int y, int width, int height) {
		
		textPane.setBounds(x, y, width, height);
		
	}
	
	//textPane�� ������ �����ϴ� �Լ�
	@Override
	public void SetBackgroundTextPane(SystemColor color) {
	
		textPane.setBackground(color);
		
	}
	
	//textPane�� ������ �����ϴ� �Լ�
	@Override
	public void setContentTextPane(String text) {
	
		textPane.setText(text);
		
	}

}
