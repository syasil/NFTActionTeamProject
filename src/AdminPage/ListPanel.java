package AdminPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
	static String searchText="";

	ListPanel(String listTitle) {
		this.listTitle = listTitle;
		
		//상품 목록 영역
		JLabel jlListTitel = new JLabel(listTitle);
		
		//검색영역
		JTextField jtPdSearch = new JTextField();
		JButton btn_PdSearch = new JButton("검색");

		//DB 연결 테스트
		//받아온 pdlist(pdlistdata)를 jTable에 넣기
//		String[][] pdlistdata = DBConnAdmin.getPdList();
		String[][] pdSchData = DBConnAdmin.getPdSearch(searchText);
		String[] headers = new String[]{"No", "그림명","설명","낙찰가","등록인","등록일시"};

//		DefaultTableModel tableModel = new DefaultTableModel(pdlistdata, headers);
		DefaultTableModel tableModel = new DefaultTableModel(pdSchData, headers);
		
		//검색 버튼 이벤트
		btn_PdSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchText = jtPdSearch.getText();
				tableModel.setRowCount(0);
				//검색어를 where 절 조건으로, 검색된 데이터 불러오기
				String[][] pdSchData = DBConnAdmin.getPdSearch(searchText);
				tableModel.addRow(pdSchData);
				
				Arrays.toString(pdSchData);
				System.out.println(Arrays.toString(pdSchData));
				
			}
		});
		
		JTable table = new JTable(tableModel);
		JScrollPane scrollpane = new JScrollPane(table);	//스크롤설정
		
		
		//셀 간격 조정
		table.setRowHeight(30);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);

		//각 셀의 설정
		table.getColumn("No").setPreferredWidth(20);
		table.getColumn("No").setCellRenderer(celAlignCenter);
		table.getColumn("그림명").setPreferredWidth(200);
		table.getColumn("설명").setPreferredWidth(200);
		table.getColumn("낙찰가").setPreferredWidth(20);
		table.getColumn("등록인").setPreferredWidth(30);
		table.getColumn("등록일시").setPreferredWidth(80);
		
		table.setSize(550, 300);
		table.setPreferredScrollableViewportSize(new Dimension(550, 300));
		//DB 연결 테스트 끝
		
		//add
		add(jlListTitel);
		add(jtPdSearch);
		add(btn_PdSearch);
		add(scrollpane);

		//position setting
		jlListTitel.setBounds(10, 5, 100, 20);
		jtPdSearch.setBounds(200, 30, 200, 20);
		btn_PdSearch.setBounds(420, 30, 100, 20);
		scrollpane.setBounds(10, 60, 550, 300);
		
		
		//List Panel setting
		setLayout(null);
		setSize(500, 550);
		setBackground(Color.white);
	}



}
