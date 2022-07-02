package AdminPage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBConnection.JdbcUtil;
import swing.*;

public class ListUser  extends JFrame {
	//회원목록 패널
	
	static JdbcUtil dbConn = new JdbcUtil();
	private APanel contentPane;
	private ATextField jtSearch;
	
	private DefaultTableModel model;
	private ATable UserListTable;
	
	public static void main(String[] args) {
		new ListUser();
	}
	
	public ListUser() {
		initSet();
		getUserList();
	}
	
	private void initSet() {
		contentPane = new APanel();
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		
		//회원목록 타이틀 영역
		ALabel jlListTitel = new ALabel("회원목록");
		jlListTitel.setBounds(40, 25, 100, 20);
		contentPane.add(jlListTitel);
		
		//회원목록 안내 텍스트 영역
		ALabel jlListText = new ALabel("회원이름과 닉네임으로 검색가능합니다");
		jlListText.setBounds(270, 65, 500, 20);
		contentPane.add(jlListText);
		
		//검색어 입력 영역
		jtSearch = new ATextField();
		jtSearch.setBounds(270, 90, 200, 25);
		contentPane.add(jtSearch);
		
		//검색버튼 영역
		AButton btn_PdSearch = new AButton("검색");
		btn_PdSearch.setBounds(480, 90, 100, 25);
		contentPane.add(btn_PdSearch);
		
		btn_PdSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getUserList();
			}
		});
		
		//테이블 생성
		model = new DefaultTableModel(new String[]{"No", "아이디", "닉네임", "생일","가입일",}, 0);
		UserListTable = new ATable(model);
		
		//각 셀 사이즈 설정
		UserListTable.getColumn("No").setPreferredWidth(50);
		UserListTable.getColumn("아이디").setPreferredWidth(100);
		UserListTable.getColumn("닉네임").setPreferredWidth(100);
		UserListTable.getColumn("생일").setPreferredWidth(150);
		UserListTable.getColumn("가입일").setPreferredWidth(150);
		UserListTable.setSize(550, 300);
		UserListTable.setPreferredScrollableViewportSize(new Dimension(550, 300));
		
		
		AScrollPane scrollPane = new AScrollPane(UserListTable);
		scrollPane.setBounds(40, 125, 550, 300);
		contentPane.add(scrollPane);
		
		//List Panel setting
		setBounds(350,200,650,500);
		contentPane.setBackground(Color.white);
	}
	
	private void getUserList() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		model.setRowCount(0);
		
		try {
			String que = "";
			String keyword = jtSearch.getText();
			
			que = "SELECT USER_NO, USER_ID, USER_NICK, USER_BIR, USER_CREDAY "
					+ "FROM T_USER ";
			
			if (!keyword.equals("")) {
//				que += " WHERE USER_ID LIKE '%"+ keyword +"%'";
				que += " WHERE USER_ID LIKE '%"+ keyword +"%' OR USER_NICK LIKE '%"+ keyword +"%'";
			}
			
			//DB 연결
			conn = dbConn.getConnection();
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String userNo = rs.getString(1);
				String userId = rs.getString(2);
				String userNick = rs.getString(3);
				String userBir = rs.getString(4).substring(0, 11);
				String userDay = rs.getString(5).substring(0, 11);
				
				String[] userlist = {userNo, userId, userNick, userBir, userDay};
				model.addRow(userlist);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
