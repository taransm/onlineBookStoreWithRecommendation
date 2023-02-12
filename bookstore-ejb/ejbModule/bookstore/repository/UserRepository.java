package bookstore.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import bookstore.model.User;

public class UserRepository {

	private EntityManager entityManager;

	public UserRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public User update(User user) {
		try {
			//entityManager.getTransaction().begin();
			entityManager.merge(user);
			//entityManager.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public User create(User user) {
		try {
			//entityManager.getTransaction().begin();
			entityManager.persist(user);
			//entityManager.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void delete(User user) {
		try {
			entityManager.remove(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return entityManager
				.createQuery("from User")
				.getResultList();
	}

	public User findById(Integer id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
			return user;
		}
		return null;
	}

	public User findByID(int id) {
		User user = entityManager
				.createQuery("select u from Users u where u.id = :userid",  User.class)
				.setParameter("userid", id)
				.getSingleResult();
		if (user != null) {
			return user;
		}
		return null;
	}

	public User findByUsername(String username) {

		try {
			User user = entityManager
					.createNamedQuery("User.findByUsername", User.class)
					.setParameter("username", username)
					.getSingleResult();

			if (user != null) {
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}