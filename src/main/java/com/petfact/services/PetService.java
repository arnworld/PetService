package com.petfact.services;

import java.util.ArrayList;
import java.util.List;

import com.petfact.entities.Pet;

public interface PetService {

    List<Pet> listAllPets();

    Pet getPetById(Integer id);

    Pet savePet(Pet pet);

    void deletePet(Integer id);

}
