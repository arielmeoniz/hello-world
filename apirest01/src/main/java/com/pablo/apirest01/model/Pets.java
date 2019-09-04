package com.pablo.apirest01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pets")
public class Pets {
	
	private long id;
	private String name;
	private String age;
	
	
	@Id
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="name",nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="age",nullable=false)
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

}
