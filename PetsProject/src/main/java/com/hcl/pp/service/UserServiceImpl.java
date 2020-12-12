package com.hcl.pp.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.pp.dao.UserDAO;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public User addUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public List<User> listUsers() {
		return userDAO.listUsers();
	}

	@Override
	public User getUserById(long USER_ID) {
		return userDAO.getUserById(USER_ID);
	}

	@Override
	public boolean removeUser(User user) {
		return userDAO.removeUser(user);
	}

	@Override
	public User findByUserName(User user) {
		return userDAO.findByUserName(user);
	}

	@Override
	public boolean buyPet(Pet pet, User user) {
		return userDAO.buyPet(pet, user);
	}

	@Override
	public Set<Pet> getMyPets(User user) {
		return userDAO.getMyPets(user);
	}

}
