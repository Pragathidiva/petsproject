package com.hcl.pp.dao;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		return null;
	}

	@Override
	public List<User> listUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createNamedQuery("listUsers").getResultList();
		return users;
	}

	@Override
	public User getUserById(long USER_ID) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, USER_ID);
	}

	@Override
	public boolean removeUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.get(User.class, user.getId());
		session.remove(user);
		return true;
	}

	@Override
	public User findByUserName(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User user where user.username=:name and user.userPassword=:password");
		query.setParameter("name", user.getUsername());
		query.setParameter("password", user.getUserPassword());
		if (query.getResultList() != null)
			return user;
		else {
			return null;
		}
	}

	@Override
	public boolean buyPet(Pet pet, User user) {
		Session session = sessionFactory.getCurrentSession();
		pet.setUser(user);
		session.update(pet);
		return true;
	}

	@Override
	public Set<Pet> getMyPets(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.get(User.class, user.getId());
		return user.getPets();

	}

}
