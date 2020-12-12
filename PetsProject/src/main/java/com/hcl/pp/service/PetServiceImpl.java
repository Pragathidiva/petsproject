package com.hcl.pp.service;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hcl.pp.dao.PetDAO;
import com.hcl.pp.dao.UserDAO;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

@Service("petService")
public class PetServiceImpl implements PetService {

	@Autowired
	private PetDAO petDAO;

	@Override
	public boolean savePet(Pet pet)  {
		return petDAO.savePet(pet);
	}

	@Override
	public List<Pet> getAllPets()  {
		return petDAO.fetchAll();
	}

	@Override
	public Pet getPetById(long PET_ID) {
		return petDAO.getPetById(PET_ID);
	}

}
