package Database;

import java.sql.Connection;
import java.sql.DriverManager;

import blockchain.BlockChain;

public class DatabaseLinker {
	
	public static DatabaseLinker instance = new DatabaseLinker();
	private DatabaseLinker() {}
	public static DatabaseLinker getInstance() {
		return instance;
	}
	
	Connection connection = null; 
	
	public Connection connectDB() throws Exception{
		
			String id = "NFT_AUCTION";
			String pw = "4312";
			String url="jdbc:oracle:thin:@localhost:1521/xe";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection(url,id,pw);
			System.out.println("test");			
			return connection;
	}
	
}
