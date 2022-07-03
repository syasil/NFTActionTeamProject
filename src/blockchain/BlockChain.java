package blockchain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Database.DatabaseLinker;

public class BlockChain implements Runnable{
	
	
	private Connection connection;
	private PreparedStatement psmt;
	private ResultSet rs;
	private String sql;
	private int random;
	private ArrayList<String> element;
	
	ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	private String previousHash;
	
	private MessageDigest md;
	private String hex;
	private String binaryStr;
	private String newHash;
	private Connection conn;
	private String token;
	private int resultset;


	
	private void getPreviousBlock() {
		
		try {
			
			connection = DatabaseLinker.getInstance().connectDB();
			
			sql = "select max(user_no),max(PRO_NO),max(PRO_NAME),max(AUC_LOG_NO),max(AUC_LOG_DATE), max(TOKEN_ID), max(PREVIOUS_HASH),max(MINE_DATE) "
					+ "from t_blocks a inner join(select max(token_id) as max_token_id   from t_blocks GROUP BY auc_log_no) b on a.token_id = b.max_token_id";
			
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				element = new ArrayList<String>();
				element.add(rs.getString("max(user_no)"));         //1
				element.add(rs.getString("max(PRO_NO)"));          //2
				element.add(rs.getString("max(PRO_NAME)"));        //3
				element.add(rs.getString("max(AUC_LOG_NO)"));      //4
				element.add(rs.getString("max(AUC_LOG_DATE)"));    //5
				element.add((Integer.parseInt(rs.getString("max(TOKEN_ID)"))+1)+"");        //6
				element.add(rs.getString("max(PREVIOUS_HASH)"));   //7
				element.add(rs.getString("max(MINE_DATE)"));       //8
				list.add(element);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {

		try {
			
			md = MessageDigest.getInstance("SHA-256");
			
		} catch (NoSuchAlgorithmException e) {
			
		}
		while(true) {
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			getPreviousBlock();
			
			random = (int) (Math.random() * (list.size()));
			
			System.out.println("경매기록고유번호 : " + list.get(random).get(3)+"의 "+list.get(random).get(5)+ "번째 블럭 채굴을 시작합니다.");
			token = list.get(random).get(5);
			previousHash = list.get(random).get(6);
			
			newHash = proof_of_work(previousHash); 
			System.out.println("succes : " + newHash);
			
			try {
				
				sql = "select * from t_blocks where token_id = ?";
				psmt = connection.prepareStatement(sql);
				psmt.setString(1, token);
				psmt.executeQuery();
				
				if(rs.next()) continue;
				
				
				sql = "insert into t_blocks VALUES (?, ?, ?, ?, to_date((?), 'YYYY-MM-DD HH24:MI:SS'), ?, ?, sysdate)";
				psmt = connection.prepareStatement(sql);
				psmt.setString(1, list.get(random).get(0));
				psmt.setString(2, list.get(random).get(1));
				psmt.setString(3, list.get(random).get(2));
				psmt.setString(4, list.get(random).get(3));
				psmt.setString(5, list.get(random).get(4));
				psmt.setString(6, token);
				psmt.setString(7, newHash);
				
				resultset = psmt.executeUpdate();
				System.out.println("변경된 row 수 : " + resultset);
				list.clear();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	private String proof_of_work(String previousHash) {
		
		while(true) {
			
		
			binaryStr="";
			md.update(previousHash.getBytes());
			hex = bytesToHex(md.digest());
			hexToBinary();
			
			if(binaryStr.contains("0000")) return hex;

			
		}

	}

	
	private static String bytesToHex(byte[] digest) {
		
		StringBuilder sb = new StringBuilder();
		for(byte b : digest) {
			sb.append(String.format("%02x", b));
		}
			
		return sb.toString();
	}

	private void hexToBinary() {
		
		char[] hexaarray = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		String[] binarray = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
		
		for (int i = 0; i < hex.length(); i++) {
			for (int j = 0; j < hexaarray.length; j++) {
				if(hex.charAt(i) ==hexaarray[j]){
					binaryStr+=binarray[j];
				}
				
			}
			
		}
	}

}
