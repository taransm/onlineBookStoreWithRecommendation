package bookstore.service;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import org.jboss.logging.Logger;

import bookstore.data.User;
import bookstore.ejb.UserSessionBeanRemote;

@SessionScoped
public class SecurityServiceImpl implements Serializable, SecurityService {

	private static final Logger LOGGER = Logger.getLogger(SecurityServiceImpl.class);

	@EJB
	UserSessionBeanRemote userSessionBeanRemote ;
	
	@Override
	public Boolean validateUser(String username, String password) {
		LOGGER.debug("Inside validateUser() : username : "+username);

		Boolean isValidUser = false; 
		try {
			
			//userSessionBeanRemote.findByUsername(username);
			isValidUser = userSessionBeanRemote.authenticate(username, password);
			LOGGER.debug("Inside validateUser() : Is user valid ? "+isValidUser);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return isValidUser;
	}

	@Override
	public User findByUsername(String username) {
		LOGGER.debug("Inside findByUsername() : username : "+username);

		User dataUser = null;
		try {
			
			bookstore.model.User user = userSessionBeanRemote.findByUsername(username);
			LOGGER.debug("Inside findByUsername() : User : "+user);
			if (user!=null) {
				dataUser = new User();
				dataUser.setRole(user.getRole());
				dataUser.setUserid(user.getUserid());
				dataUser.setUsername(user.getUsername());
				return dataUser;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Boolean createCustomerUser(String username, String password) {
		LOGGER.debug("Inside createCustomerUser() : username : "+username);

		Boolean isSuccessful = false; 
		try {
			bookstore.model.User user = new bookstore.model.User();
			user.setUsername(username);
			user.setPassword(password);
			user.setRole("Customer");
			bookstore.model.User savedUser = userSessionBeanRemote.createUser(user);
			LOGGER.debug("Inside createCustomerUser() : User : "+savedUser);
			if (savedUser != null) {
				isSuccessful = true;
			} 
		} catch (Exception ex) {
			ex.printStackTrace();
			isSuccessful = false;
		}
		return isSuccessful;
	}


}
