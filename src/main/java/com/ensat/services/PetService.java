package com.ensat.services;

import com.ensat.entities.Pet;
import java.util.ArrayList;
import java.util.List;

public interface PetService {

    List<Pet> listAllPets();

    Pet getPetById(Integer id);

    Pet savePet(Pet pet);

    void deletePet(Integer id);

}
