package com.testpet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.petfact.SpringBootWebApplication;
import com.petfact.entities.Pet;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testGetAllPets() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/pets",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}
	@Test
	public void testGetPetById() {
		Pet pet = restTemplate.getForObject(getRootUrl() + "/pets/1", Pet.class);
		System.out.println(pet.getName());
		Assert.assertNotNull(pet);
	}
	@Test
	public void testCreatePet() {
		Pet pet = new Pet();
		pet.setType("Dog5");
		pet.setName("adm");
		pet.setPrice(30);


		ResponseEntity<Pet> postResponse = restTemplate.postForEntity(getRootUrl() + "/pets", pet, Pet.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
	@Test
	public void testUpdatePet() {
		int id = 1;
		Pet pet = restTemplate.getForObject(getRootUrl() + "/pets/" + id, Pet.class);
		pet.setType("Dogxx");
		pet.setName("zzz");

		restTemplate.put(getRootUrl() + "/pets/" + id, pet);

		Pet updatedPet = restTemplate.getForObject(getRootUrl() + "/pets/" + id, Pet.class);
		Assert.assertNotNull(updatedPet);
	}
	@Test
	public void testDeletePet() {
		int id = 2;
		Pet pet = restTemplate.getForObject(getRootUrl() + "/pets/" + id, Pet.class);
		Assert.assertNotNull(pet);

		restTemplate.delete(getRootUrl() + "/pet/" + id);

		try {
			pet = restTemplate.getForObject(getRootUrl() + "/pets/" + id, Pet.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
