package Auction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import Database.DatabaseLinker;

public class ProductList {
	
	DatabaseLinker databaseLinker = new DatabaseLinker();
	
	Connection connection; 
	PreparedStatement psmt = null;
	ResultSet rs = null;
	

	String sql;
	
	String[] columnType = { "번호", "이름", "등록인", "등록일", "버튼"};
	private DefaultTableModel dataModel = new DefaultTableModel(columnType, 0);
	
	public DefaultTableModel selectList(String reference) {

		try {
			
			connection = databaseLinker.connectDB();
			
			
			
			psmt = bindSQL(reference);
			rs = psmt.executeQuery();
			 //DML(insert, update, delete) executeUpdate();
			 
			while(rs.next()) {
				
				dataModel.addRow(new Object[] {
						
					rs.getString("pro_no"),
					rs.getString("pro_name"),	
					rs.getString("user_no"),	
					rs.getString("pro_regday"),	
						
				});
			}
			System.out.println("test:"+dataModel.getValueAt(1, 1));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return dataModel;
		
		
	}

	private PreparedStatement bindSQL(String reference) throws SQLException {
		
		sql ="SELECT pro_no, pro_name, user_no, pro_regday FROM t_product";
		if(!reference.equals("")) {
			
			sql += " where pro_name=? order by pro_no";
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, reference);
			
		}else {
			sql += " order by pro_no";
			psmt = connection.prepareStatement(sql);
			
		}
		return psmt;
		
		
		
	}

	public static void getRowData() {
		 
		
	}
}
