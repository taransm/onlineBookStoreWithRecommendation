package bookstore.service;

import bookstore.data.User;

public interface SecurityService {

    public Boolean validateUser(String username, String password);

	public User findByUsername(String username);
	
	public Boolean createCustomerUser(String username, String password);
}
