package bookstore.data;

public class User {

    private Integer userid;    
    private String username;
    private String role;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append("Users ").append("[")
			.append("userid=").append(userid).append(", ")
			.append("username=").append(username).append(", ")
			.append("role=").append(role)
			.append("]");
		return builder.toString();
	}
    
}
