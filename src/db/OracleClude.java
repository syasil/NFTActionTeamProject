package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleClude {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String que = "select * from t_user";

		try  {
			
			conn = DB.get();
			psmt = conn.prepareStatement(que);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString(1);

				System.out.println(name + " | " + rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
