package AdminPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DBConnection.JdbcUtil;

public class ListPd extends JFrame {
	//상품목록 패널
	//ListPanel.java를 새로 작업 중
	
	static JdbcUtil dbConn = new JdbcUtil();
	private JPanel contentPane;
	private JTextField jtPdSearch;
	
	private DefaultTableModel model;
	private JTable pdListTable;
	
	public static void main(String[] args) {
		new ListPd();
	}
	
	public ListPd() {
		initSet();
		getPdList();
	}
	
	private void initSet() {
		contentPane = new JPanel();
		setContentPane(contentPane);
		setBounds(200,100,650,800);
		//List Panel setting
		setVisible(true);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//상품 목록 영역
		JLabel jlListTitel = new JLabel("상품목록");
		jlListTitel.setBounds(10, 5, 100, 20);
		contentPane.add(jlListTitel);
		
		//검색어 입력 영역
		jtPdSearch = new JTextField();
		jtPdSearch.setBounds(120, 30, 200, 20);
		contentPane.add(jtPdSearch);
		
		//검색버튼 영역
		JButton btn_PdSearch = new JButton("검색");
		btn_PdSearch.setBounds(350, 30, 100, 20);
		contentPane.add(btn_PdSearch);
		
		btn_PdSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//검색버튼 클릭 시 getPdList() 호출
				getPdList();
			}
		});
		
		//테이블 생성
		model = new DefaultTableModel(new String[]{"No", "그림명","설명","낙찰가","등록인","등록일시"}, 0);
		pdListTable = new JTable(model);
//		pdListTable.setEnabled(false);
//		pdListTable.setAutoCreateRowSorter(true);
		pdListTable.setRowHeight(30);
		
		//각 셀 사이즈 설정
		pdListTable.getColumn("No").setPreferredWidth(20);
		pdListTable.getColumn("그림명").setPreferredWidth(200);
		pdListTable.getColumn("설명").setPreferredWidth(200);
		pdListTable.getColumn("낙찰가").setPreferredWidth(20);
		pdListTable.getColumn("등록인").setPreferredWidth(30);
		pdListTable.getColumn("등록일시").setPreferredWidth(80);
		pdListTable.setSize(550, 300);
		pdListTable.setPreferredScrollableViewportSize(new Dimension(550, 300));
		
		
		JScrollPane scrollPane = new JScrollPane(pdListTable);
		scrollPane.setBounds(100, 60, 550, 300);
		contentPane.add(scrollPane);
		
		
	}
	
	//목록 가져오기, 검색기능
	private void getPdList() {
		System.out.println("1.getPdList()");
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		model.setRowCount(0);
		
		try {
			String que = "";
			String keyword = jtPdSearch.getText();
			
			que = "SELECT PRODUCT_NUMBER, PRODUCT_NAME, PRODUCT_DESCRIPTION, "
					+ "PRODUCT_PRICE, PRODUCT_REGISTER_USER, "
					+ "PRODUCT_REGISTER_DATE "
					+ "FROM PRODUCT_B ";
			
			if (!keyword.equals("")) {
				que += " WHERE PRODUCT_NAME LIKE '%"+ keyword +"%'";
			}
			
			//DB 연결
			conn = dbConn.getConnection();
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String pdNo = rs.getString(1);
				String pdName = rs.getString(2);
				String pdDesc = rs.getString(3);
				String pdprice = rs.getString(4);
				String pdRegUser = rs.getString(5);
				String pdRegDate = rs.getString(6);
				
				String[] pdlist = {pdNo, pdName, pdDesc, pdprice, pdRegUser, pdRegDate};
				model.addRow(pdlist);
			}
			System.out.println(que);
			System.out.println("DBConnAdmin: 데이터 가져오기 성공");
			
			rs.close();
			psmt.close();
			conn.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
