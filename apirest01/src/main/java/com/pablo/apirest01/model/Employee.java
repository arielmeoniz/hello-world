package com.pablo.apirest01.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="employees")

public class Employee {

	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private List<Pets> pets;
	private Cards card;

	
	
	public Employee() {
	 }
	 public Employee(String firstName, String lastName, String emailId) {
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.emailId = emailId;
	 }
	
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column (name="first_name", nullable=false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column (name="last_name", nullable=false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	@Column (name="email_address", nullable=false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Override
	 public String toString() {
	  return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
	    + "]";
	 }
	
	@ManyToMany (cascade=CascadeType.ALL )
	
	public List<Pets> getPets() {
		return pets;
	}
	public void setPets(List<Pets> pets) {
		this.pets = pets;
	}
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    
	public Cards getCard() {
		return card;
	}
	public void setCard(Cards card) {
		this.card = card;
	}
	
}
