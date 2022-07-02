package AdminPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBConnection.JdbcUtil;
import swing.*;

public class ListPd extends JFrame {
	//상품목록 패널
	//ListPanel.java를 새로 작업 중
	
	static JdbcUtil dbConn = new JdbcUtil();
	private APanel contentPane;
	private ATextField jtPdSearch;
	
	private DefaultTableModel model;
	private ATable pdListTable;
	
	public static void main(String[] args) {
		new ListPd();
	}
	
	public ListPd() {
		initSet();
		getPdList();
	}
	
	private void initSet() {
		contentPane = new APanel();
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		
		//상품 목록 타이틀 영역
		ALabel jlListTitel = new ALabel("상품목록");
		jlListTitel.setBounds(40, 25, 100, 20);
		contentPane.add(jlListTitel);
		
		//상품 목록 안내 텍스트 영역
		ALabel jlListText = new ALabel("상품명 검색 시 대,소문자를 구분해서 입력하세요");
		jlListText.setBounds(210, 65, 500, 20);
		contentPane.add(jlListText);
		
		//검색어 입력 영역
		jtPdSearch = new ATextField();
		jtPdSearch.setBounds(270, 90, 200, 25);
		contentPane.add(jtPdSearch);
		
		//검색버튼 영역
		AButton btn_PdSearch = new AButton("검색");
		btn_PdSearch.setBounds(480, 90, 100, 25);
		contentPane.add(btn_PdSearch);
		
		btn_PdSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//검색버튼 클릭 시 getPdList() 호출
				getPdList();
			}
		});
		
		//테이블 생성
		model = new DefaultTableModel(new String[]{"No", "상품명","설명","가격","등록인","등록일시"}, 0);
		pdListTable = new ATable(model);
		
		//각 셀 사이즈 설정
		pdListTable.getColumn("No").setPreferredWidth(20);
		pdListTable.getColumn("상품명").setPreferredWidth(150);
		pdListTable.getColumn("설명").setPreferredWidth(200);
		pdListTable.getColumn("가격").setPreferredWidth(50);
		pdListTable.getColumn("등록인").setPreferredWidth(30);
		pdListTable.getColumn("등록일시").setPreferredWidth(100);
		pdListTable.setSize(550, 300);
		pdListTable.setPreferredScrollableViewportSize(new Dimension(550, 300));
		
		
		AScrollPane scrollPane = new AScrollPane(pdListTable);
		scrollPane.setBounds(40, 125, 550, 300);
		contentPane.add(scrollPane);
		

		//List Panel setting
		setBounds(350,200,650,500);
		contentPane.setBackground(Color.white);
	}
	
	//목록 가져오기, 검색기능
	private void getPdList() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		model.setRowCount(0);
		
		try {
			String que = "";
			String keyword = jtPdSearch.getText();
			
			que = "SELECT PRO_NO, PRO_NAME, PRO_EXP, PRO_PRICE, USER_NO, PRO_REGDAY FROM T_PRODUCT ";
			
			if (!keyword.equals("")) {
				que += " WHERE PRO_NAME LIKE '%"+ keyword +"%'";
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
				String pdRegDate = rs.getString(6).substring(0, 11);
				
				String[] pdlist = {pdNo, pdName, pdDesc, pdprice, pdRegUser, pdRegDate};
				model.addRow(pdlist);
			}
			System.out.println("DBConnAdmin: 데이터 가져오기 성공");
			
			rs.close();
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("getPdList()"+e.getMessage());
		}
	}
	

}
