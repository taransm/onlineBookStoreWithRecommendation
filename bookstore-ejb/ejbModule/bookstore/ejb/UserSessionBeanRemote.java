package bookstore.ejb;

import javax.ejb.Remote;

import bookstore.model.User;

@Remote
public interface UserSessionBeanRemote {

	public Boolean validate(String username);

	public Boolean authenticate(String username, String password);
	
	public User findByUsername(String username);
	
	public User createUser(User user);
	
}
