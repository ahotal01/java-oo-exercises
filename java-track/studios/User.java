import java.util.regex.Pattern;

public class User {
	private String username;
	private String hash_pass;
	
	public User(String username, String password) {
		this.username = username;
		try {
			if (!isValidUsername(this.username)) {
				throw new Exception("Invalid username");
			}
		} catch (Exception e) {
			
		}
		this.hash_pass = hashPassword(password);
	}
	
	private static String hashPassword(String password) {
		return password;
	}
	
	public boolean isValidPassword (String password) {
		if (this.hash_pass == password) {
			return true;
		} else return false;
	}
	
	public static boolean isValidUsername (String username) {
		boolean b = Pattern.matches(username, "[a-zA-Z][a-zA-Z0-9_-]{4,11}");
		return b;
	}
}
