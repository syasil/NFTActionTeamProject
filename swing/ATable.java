package swing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ATable extends JTable {

	public ATable () {
	}
	
	public ATable(TableModel text) {
		super(text);
		setFont(new Font("맑은 고딕", Font.PLAIN ,14));
		setBackground(new Color(245, 248, 255));
		setRowHeight(30);
		setAutoCreateRowSorter(true);	//테이블 데이터 행 정렬 설정
//		setEnabled(false);	
	}

}
