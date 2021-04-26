package com.petfact.repositories;

import org.springframework.data.repository.CrudRepository;

import com.petfact.entities.Pet;

public interface PetRepository extends CrudRepository<Pet, Integer> {

}
