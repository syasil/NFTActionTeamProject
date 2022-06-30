package dbBasic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Basic {
	public static void main(String[] args) throws SQLException {

		////////////////////////////////
		// 디비 연결할 변수 선언
		////////////////////////////////
		Connection conn = null; // DB와 연결하는 인터페이스
		PreparedStatement psmt = null; // sql 문 객체
		ResultSet rs = null; // sql에 대한 반환(쿼리 실행에 대한 결과값 저장

		////////////////////////////////
		// 디비 연결 및 쿼리 실행
		////////////////////////////////
		try {

			// 쿼리문 작성
			String sql = "select * from emp1";

			// 디비 연결, 실행
			conn = Db.get(); // DB연결
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				// DB에 있는 값들을 가져옴
				String empno = rs.getString(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				java.sql.Date hiredate = rs.getDate(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				System.out.println(empno + " " + ename + " " + job);
			}
			// 디비 닫기
			rs.close();
			psmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
