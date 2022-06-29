package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SampleProc {
	public static void main(String[] args) throws SQLException {
		Connection conn = null; // DB와 연결하는 인터페이스
		PreparedStatement psmt = null; // sql 문 객체
		ResultSet rs = null; // sql에 대한 반환(쿼리 실행에 대한 결과값 저장
		
		

		
		
		
		
		
		try {
			String proc = "proc_emp_get_all";

			conn = DB.get(); // DB연결

			// 프로시저 호출
			 CallableStatement cs = conn.prepareCall("begin proc_emp_get_all(?); end;");

			// 입력 파라메터
			//cs.setInt(1, 1000);
			
			// 출력 파라메터
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			 
			// 실행
			cs.execute();
			rs = (ResultSet)cs.getObject(1);
			
			
			while(rs.next()) {
				int empno = rs.getInt(1);
				// String empno = rs.getString(1);
				String ename = rs.getString(2);
				String job = rs.getString("JOB");
				Date hiredate = rs.getDate("hiredate");
				
				int sal = rs.getInt("sal");
				int comm = rs.getInt("COMM");
				System.out.println(empno + " | " + ename + "\t| " + job + "\t| " + hiredate + "\t|" + rs.getInt("deptno"));
			}
			
			
			rs.close();
			cs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
