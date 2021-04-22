package com.ensat.controllers;

import com.ensat.entities.Pet;
import com.ensat.repositories.PetRepository;
import com.ensat.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import com.ensat.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
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
     * @param model
     * @return
     */
    //@RequestMapping(value = "/pets", method = RequestMethod.GET)
    //public String list(Model model) {
      //  model.addAttribute("Pets", petService.listAllPets());
        //System.out.println("Returning rpoducts:");
        //return "pets";
    //}
    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public List<Pet> getAllUsers() {
      return petService.listAllPets();
    }

    /**
     * View a specific Pet by its id.
     *
     * @param id
     * @param model
     * @return
     */
    //@RequestMapping("pet/{id}")
    //public String showPet(@PathVariable Integer id, Model model) {
      //  model.addAttribute("Pet", petService.getPetById(id));
        //return "petshow";
    //}
    
    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getUsersById(@PathVariable(value = "id") Integer petId){
      Pet pet =
    		  petService
              .getPetById(petId);
      return ResponseEntity.ok().body(pet);
    }
    
    

    // Afficher le formulaire de modification du Pet
    //@RequestMapping("pet/edit/{id}")
    //public String edit(@PathVariable Integer id, Model model) {
     //   model.addAttribute("Pet", petService.getPetById(id));
       // return "petform";
    //}
    
    
    
    @PutMapping("/pets/{id}")
    public ResponseEntity<Pet> updateUser(
        @PathVariable(value = "id") Integer petId, @Valid @RequestBody Pet petDetails) {

      Pet pet =
    		  petService.getPetById(petId);
      
      pet.setName(petDetails.getName());
      pet.setType(petDetails.getType());
      pet.setPrice(petDetails.getPrice());
      //user.setEmail(userDetails.getEmail());
      //user.setLastName(userDetails.getLastName());
      //user.setFirstName(userDetails.getFirstName());
      //user.setUpdatedAt(new Date());
      final Pet updatedPet = petService.savePet(pet);
      return ResponseEntity.ok(updatedPet);
    }
    /**
     * New Pet.
     *
     * @param model
     * @return
     */
    //@RequestMapping("pet/new")
    //public String newPet(Model model) {
      //  model.addAttribute("Pet", new Pet());
       // return "petform";
    //}

    /**
     * Save Pet to database.
     *
     * @param Pet
     * @return
     */
    //@RequestMapping(value = "pet", method = RequestMethod.POST)
    //public String savePet(Pet pet) {
      //  petService.savePet(pet);
        //return "redirect:/pet/" + pet.getId();
    //}

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
    //@RequestMapping("pet/delete/{id}")
    //public String delete(@PathVariable Integer id) {
      //  petService.deletePet(id);
      //  return "redirect:/pets";
    //}
    
    
    @DeleteMapping("/pet/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer petId) {
      petService.deletePet(petId);

      //userRepository.delete(user);
      Map<String, Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return response;
    }

}
