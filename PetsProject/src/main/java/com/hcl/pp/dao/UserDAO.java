package com.hcl.pp.dao;

import java.util.List;
import java.util.Set;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

public interface UserDAO {

	public User addUser(User user);

	public User updateUser(User user) ;

	public List<User> listUsers() ;

	public User getUserById(long USER_ID) ;

	public boolean removeUser(User user) ;

	public User findByUserName(User user) ;

	public boolean buyPet(Pet pet, User user) ;

	public Set<Pet> getMyPets(User user);
}