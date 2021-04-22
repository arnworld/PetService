package com.ensat.services;

import com.ensat.entities.Pet;
import com.ensat.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        petRepository.findAll().forEach(pets::add);
        return pets;
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
