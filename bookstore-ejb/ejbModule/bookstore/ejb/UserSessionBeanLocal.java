package bookstore.ejb;

import javax.ejb.Local;

import bookstore.model.User;

@Local
public interface UserSessionBeanLocal {

	public Boolean validate(String username);
	
	public Boolean authenticate(String username, String password);

	public User findByUsername(String username);
	
	public User createUser(User user);
}
