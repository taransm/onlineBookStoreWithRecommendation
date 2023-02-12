package bookstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="User")
@NamedQueries({
    @NamedQuery(name = "User.findByUsername", query = "SELECT a FROM User a WHERE a.username = :username")
})
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private Integer userid;    
    private String username;
    private String password;
    private String role;
    
    
    public User() { 
    }
    
    public User(String username) {
       this.username = username;
    }
    
    public User(Integer userid, String username) {
        this.userid = userid;
        this.username = username;
    }

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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