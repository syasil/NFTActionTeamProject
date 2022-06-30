package wook;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbBasic.Db;

public class Test {
	public static String[][] getData() {
		Connection conn = null; // DB와 연결하는 인터페이스
		PreparedStatement psmt = null; // sql문 객체
		ResultSet rs = null; // sql에 대한 반환(쿼리 실행에 대한 결과값 저장)
		try {
			conn = Db.get();
//		   String que="select * from sp";
//		   conn=Db.get(); //DB연결
//		   psmt=conn.prepareStatement(que);
//		   rs=psmt.executeQuery();
			CallableStatement cs = conn.prepareCall("begin proc_emp_get_all(?); end;");
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet) cs.getObject(1);

			ArrayList<String[]> ar = new ArrayList<>();
			while (rs.next()) {
				ar.add(new String[] { rs.getString(1), rs.getString(2), rs.getString(3) });
			}
			System.out.println("성공");
			return ar.toArray(new String[ar.size()][3]);
//		   String[][] arr = new String[ar.size()][3];
//		   return ar.toArray(arr);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
			return null;
		}
//		rs.close();
//		psmt.close();
//		conn.close();
	}
}