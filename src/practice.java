import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class practice extends JFrame{

	practice(){
	HashMap<String,String> h=new HashMap<String, String>();
	
	
	Container c=getContentPane();
	setLayout(null);
	setSize(300,300);
	JTextField j1=new JTextField(10);
	JTextField j2=new JTextField(10);
	JTextField j3=new JTextField(10);
	JLabel l1=new JLabel("영어");
	JLabel l2=new JLabel("한글");
	JButton b1=new JButton("삽입");
	JButton b2=new JButton("찾기");
	
	
	j1.setBounds(40, 10, 90, 20);
	j2.setBounds(160, 10, 90, 20);
	j3.setBounds(40, 70, 200, 150);
	l1.setBounds(10, 10, 30, 20);
	l2.setBounds(130, 10, 30, 20);
	b1.setBounds(70, 40, 60, 25);
	b2.setBounds(140, 40, 60, 25);
	
	b1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			h.put(j1.getText(), j2.getText());
			j3.setText("삽입되었습니다");
		}
	});
	b2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(h.containsKey(j1.getText())) {
			j3.setText(j1.getText()+" "+h.get(j1.getText()));}
			else {
				j3.setText("사전에 등록 되지 않았다");
			}
		}
	});
	
	
	
	c.add(l1);
	c.add(l2);
	c.add(j1);
	c.add(j2);
	c.add(j3);
	c.add(b1);
	c.add(b2);
	setVisible(true);
	}
	
	public static void main(String[] args) {
		new practice();
	}

}
