package com.petfact.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Pet entity.
 */
@Entity
public class Pet {

    public Pet() {
		super();
	}

	public Pet(String type, String name, int price) {
		super();
		this.type = type;
		this.name = name;
		this.price = price;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    

    private String type;
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
