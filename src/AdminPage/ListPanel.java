package AdminPage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * 목록 Panel
 * 	- 상품등록 목록
 * 	- 회원목록(미정)
 * @author harteh
 *
 */

public class ListPanel  extends JPanel {
	
	private String listTitle= "";

	ListPanel(String listTitle){
		this.listTitle = listTitle;
		
		//상품 목록 영역
		JLabel jlListTitel = new JLabel(listTitle);
		JTextArea jtList = new JTextArea(10, 20);
		jtList.setEditable(false);
		
		//setting
		setLayout(new GridLayout(2,1));
		setBackground(Color.green); //확인용배경색
		
		
		//add
		add(jlListTitel);
		add(jtList);
	}

}
