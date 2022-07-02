package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseLinker {
	
	Connection connection = null; 
	
	public Connection connectDB() throws Exception{
		
			String id = "NFT_AUCTION";
			String pw = "4312";
			String url="jdbc:oracle:thin:@localhost:1521/xe";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection(url,id,pw);
						
			return connection;
	}
	
}
