package AdminPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import DBConnection.DBConnAdmin;

/**
 * 목록 Panel
 * 	- 등록된 전체상품 목록 (낙찰가제외)
 *  - 낙찰된 상품 목록 (그림명, 낙찰가, 낙찰인ID, 낙찰일시 )
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
		JScrollPane scrollpane = new JScrollPane(table);	//스크롤설정
		table.setRowHeight(30);
		
		//셀 간격 조정
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		//각 셀의 설정
		table.getColumn("No").setPreferredWidth(1);
		table.getColumn("No").setCellRenderer(celAlignCenter);
		table.getColumn("그림명").setPreferredWidth(100);
		table.getColumn("설명").setPreferredWidth(80);
		table.getColumn("낙찰가").setPreferredWidth(5);
		table.getColumn("등록인").setPreferredWidth(5);
		table.getColumn("등록일시").setPreferredWidth(30);
		
//		table.setAlignmentX(0);
//		table.setSize(800,600);
//		table.setPreferredScrollableViewportSize(new Dimension(800,600));
		
		//DB 연결 테스트 끝
		
		
		//setting
//		setLayout(new GridLayout(2,1));
		setLayout(null);
		setSize(500, 550);
		setBackground(Color.white); //확인용배경색
		
		jlListTitel.setBounds(5, 5, 600, 20);
		scrollpane.setBounds(5, 30, 600, 400);
		
		
		//add
		add(jlListTitel);
		add(scrollpane);
	}

}
