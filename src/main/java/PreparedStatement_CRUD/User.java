package PreparedStatement_CRUD;

public class User {

	private String username;
	private String PASSWORD;

	public User() {
	}

	public User(String username, String PASSWORD) {
		super();
		this.username = username;
		this.PASSWORD = PASSWORD;
	}

	@Override
	public String toString() {
		return "User [user=" + username + ", PASSWORD=" + PASSWORD + "]";
	}

	public String getUser() {
		return username;
	}

	public void setUser(String user) {
		this.username = user;
	}

	public String getPassword() {
		return PASSWORD;
	}

	public void setPassword(String password) {
		this.PASSWORD = PASSWORD;
	}

}
