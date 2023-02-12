package bookstore.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import bookstore.model.User;
import bookstore.repository.UserRepository;

/**
 * Session Bean implementation class UserSessionBean
 */
@Singleton
@LocalBean
public class UserSessionBean implements UserSessionBeanRemote, UserSessionBeanLocal {

	private static final Logger LOGGER = Logger.getLogger(UserSessionBean.class);

	@PersistenceContext(unitName="bookstore")
	private EntityManager entityManager;

	private UserRepository userRepository;

	/**
	 * Default constructor. 
	 */
	public UserSessionBean() {
	}

	@Override
	public Boolean validate(String username) {

		userRepository = new UserRepository(entityManager);
		LOGGER.info("check user: " + username );
		User user = userRepository.findByUsername(username);
		if (user != null) {
			LOGGER.info(username + ": valid" );
			return true;
		} else {
			LOGGER.info(username + ": invalid" );
			return false;
		}
	}

	@Override
	public Boolean authenticate(String username, String password) {

		userRepository = new UserRepository(entityManager);
		LOGGER.info("check user: " + username );
		User user = userRepository.findByUsername(username);
		if (user == null) {
			LOGGER.info(username + ": invalid user" );
			return false;
		}
		
		if (user.getPassword().equals(password)) {
			LOGGER.info(username + ": valid" );
			return true;
		} else {
			LOGGER.info(username + ": invalid credentails" );
			return false;
		}
		
	}

	@Override
	public User findByUsername(String username) {

		userRepository = new UserRepository(entityManager);
		LOGGER.info("check user: " + username );
		User user = userRepository.findByUsername(username);
		if (user == null) {
			LOGGER.info(username + ": invalid user" );
			return null;
		}
		
		return user;
	}
	
	@Override
	public User createUser(User user) {
		
		userRepository = new UserRepository(entityManager);
		LOGGER.debug("User: " + user);
		User savedUser = userRepository.create(user);
		if (savedUser != null) {
			LOGGER.debug("User creation successful" );
			return savedUser;
		} else {
			LOGGER.debug("User creation failed" );
			return null;
		}
	}
}
