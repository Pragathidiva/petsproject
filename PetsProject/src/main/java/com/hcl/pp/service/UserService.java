package com.hcl.pp.service;

import java.util.List;
import java.util.Set;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

public interface UserService {
	public User addUser(User user) ;

	public User updateUser(User user) ;

	public List<User> listUsers() ;

	public User getUserById(long l) ;

	public boolean removeUser(User user) ;

	public User findByUserName(User user) ;

	public boolean buyPet(Pet pet, User user);

	public Set<Pet> getMyPets(User user) ;
}
