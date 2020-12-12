package com.hcl.pp.dao;

import java.util.List;

import com.hcl.pp.model.Pet;

public interface PetDAO {
	public Pet getPetById(long PET_ID);

	public boolean savePet(Pet pet);

	public List<Pet> fetchAll();
}
