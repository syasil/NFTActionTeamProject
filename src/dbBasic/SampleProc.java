package dbBasic;

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
			conn = Db.get(); // DB연결

			/////////////////////////////////////
			// 프로시져로 실행하는 방법 구조
			/////////////////////////////////////
			CallableStatement cs = conn.prepareCall("begin proc_emp_get_all(?); end;");
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet) cs.getObject(1); // 인덱스 주위

//			CallableStatement cs = conn.prepareCall("begin proc_emp_get_with_empno(? , ?); end;");
//			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
//			cs.setString(2, "7839");

			/////////////////////////////////////
			// 레코드셋 받아오기
			/////////////////////////////////////
			cs.execute();
			rs = (ResultSet) cs.getObject(1);

			/////////////////////////////////////
			// 레코드셋 가지고 뭔가 하기.
			/////////////////////////////////////
			while (rs.next()) {
				int empno = rs.getInt(1);
				// String empno = rs.getString(1);
				String ename = rs.getString(2);
				String job = rs.getString("JOB");
				Date hiredate = rs.getDate("hiredate");

				int sal = rs.getInt("sal");
				int comm = rs.getInt("COMM");
				System.out.println(
						empno + " | " + ename + "\t| " + job + "\t| " + hiredate + "\t|" + rs.getInt("deptno"));
			}

			rs.close();
			cs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}