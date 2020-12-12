package com.hcl.pp.service;

import java.util.List;
import java.util.Set;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

public interface PetService {
	public Pet getPetById(long PET_ID);

	public boolean savePet(Pet pet);

	public List<Pet> getAllPets();
}
