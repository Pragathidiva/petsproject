package com.hcl.pp.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pp.model.Pet;

@Transactional
@Repository("petDAO")
public class PetDAOImpl implements PetDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Pet getPetById(long PET_ID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createNamedQuery("getPetById");
		return (Pet) query.setParameter("id", PET_ID).getSingleResult();
	}

	@Override
	public boolean savePet(Pet pet) {
		Session session = sessionFactory.getCurrentSession();
		session.save(pet);
		return true;
	}

	@Override
	public List<Pet> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createNamedQuery("fetchAll").getResultList();
	}

}
