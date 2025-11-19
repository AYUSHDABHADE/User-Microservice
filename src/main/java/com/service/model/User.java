package com.service.model;

import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "User-Microservice")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String about;
  
	public User(Integer id, String name, String address,String about) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.address=address;
		this.about=about;
	}
	public User() {
	    // required by JPA
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Transient
	public java.util.List<Rateing> setrateing= new ArrayList<>();
	   

	public java.util.List<Rateing> getSetrate() {
		return setrateing;
	}

	public void setSetrate(java.util.List<Rateing> setrate) {
		this.setrateing = setrate;
	}
                                                                                            
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", about=" + about + "]";
	}

}
