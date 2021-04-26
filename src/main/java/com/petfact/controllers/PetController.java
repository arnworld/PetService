package com.petfact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petfact.entities.Pet;
import com.petfact.exception.ResourceNotFoundException;
import com.petfact.repositories.PetRepository;
import com.petfact.services.PetService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Pet controller.
 */
@RestController
public class PetController {

    private PetService petService;

    @Autowired
    public void setPetService(PetService petService) {
        this.petService = petService;
    }
    @Autowired
    private PetRepository petRepository;
    /**
     * List all Pets.
     *
     * 
     * @return
     */
    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public List<Pet> getAllUsers() {
      return petService.listAllPets();
    }

    /**
     * View a specific Pet by its id.
     *
     * @param id
     * 
     * @return
     */

    
    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getUsersById(@PathVariable(value = "id") Integer petId) throws ResourceNotFoundException {

      Pet pet =
    		  petService
              .getPetById(petId);
      if (pet == null) throw new ResourceNotFoundException("Pet not found on :: " + petId);
      return ResponseEntity.ok().body(pet);    	
    }
    
    /**
     * Update Pet in database.
     * @param id
     * @param Pet
     * @return
     */
    
    
    
    @PutMapping("/pets/{id}")
    public ResponseEntity<Pet> updateUser(
        @PathVariable(value = "id") Integer petId, @Valid @RequestBody Pet petDetails) throws ResourceNotFoundException {

      Pet pet = petService.getPetById(petId);
      if (pet == null) throw new ResourceNotFoundException("Pet not found on :: " + petId);
      pet.setName(petDetails.getName());
      pet.setType(petDetails.getType());
      pet.setPrice(petDetails.getPrice());
      final Pet updatedPet = petService.savePet(pet);
      return ResponseEntity.ok(updatedPet);
    }

    /**
     * Save Pet to database.
     *
     * @param Pet
     * @return
     */

    @PostMapping("/pets")
    public Pet createPet(@Valid @RequestBody Pet pet) {
      return petService.savePet(pet);
    }
    
    /**
     * Delete Pet by its id.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/pet/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer petId)throws ResourceNotFoundException {
      Pet pet =
      		  petService
                .getPetById(petId);
        if (pet == null) throw new ResourceNotFoundException("Pet not found on :: " + petId);
      petService.deletePet(petId);

      Map<String, Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return response;
    }

}
