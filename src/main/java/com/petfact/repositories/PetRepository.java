package com.petfact.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.petfact.entities.Pet;

//public interface PetRepository extends CrudRepository<Pet, Integer> {

//}
public interface PetRepository extends PagingAndSortingRepository<Pet, Integer> {
	Page<Pet> findAll(Pageable pageable);
}