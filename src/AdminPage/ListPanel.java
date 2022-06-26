package AdminPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import DBConnection.DBConnAdmin;

/**
 * 목록 Panel
 * 	- 상품등록 목록
 * 	- 회원목록(미정)
 * @author harteh
 *
 */

public class ListPanel  extends JPanel {
	
	private String listTitle= "";

	ListPanel(String listTitle) {
		this.listTitle = listTitle;
		
		//상품 목록 영역
		JLabel jlListTitel = new JLabel(listTitle);

		//받아온 pdlist를 jTable에 넣기
		//DB 연결 테스트
		String[][] pdlistdata = DBConnAdmin.getPdList();
		String[] headers = new String[]{"No", "그림명","설명","낙찰가","등록인","등록일시"};
		
		JTable table = new JTable(pdlistdata, headers);
//		table.setRowHeight(30);
//		table.setFont(new Font("Sanserif", Font.BOLD, 15));
//		table.setAlignmentX(0);
//		table.setSize(800,600);
//		table.setPreferredScrollableViewportSize(new Dimension(800,600));
		
		//DB 연결 테스트 끝
		
		
		//setting
		setLayout(new GridLayout(2,1));
//		setBackground(Color.green); //확인용배경색
		
		
		//add
		add(jlListTitel);
		add(table);
	}

}
