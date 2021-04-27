package com.petfact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.petfact.entities.Pet;
import com.petfact.repositories.PetRepository;

import java.util.ArrayList;
import java.util.List;
/**
 * Pet service implement.
 */
@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<Pet> listAllPets() {
    	List<Pet> pets = new ArrayList<>();
        //petRepository.findAll(new PageRequest(1, 100, 
          //      new Sort(new Sort.Order(Sort.Direction.ASC, "id")))).forEach(pets::add);
        Page<Pet> petsRecord = petRepository.findAll(new PageRequest(0, 100));
        return petsRecord.getContent();
    }

    @Override
    public Pet getPetById(Integer id) {
        return petRepository.findOne(id);
    }

    @Override
    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void deletePet(Integer id) {
        petRepository.delete(id);
    }

}
