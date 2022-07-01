package functions;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
	// 이거는 그냥... 나중에는 salt 까지 넣어서 해야한다.
	public static String make(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		String hex = String.format("%064x", new BigInteger(1, md.digest()));
		return hex;
	}
}
