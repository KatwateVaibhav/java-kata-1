package org.echocat.kata.java.part1.model;

public class AuthorsModel {
	String email;
    String firstName;
    String lastName;
	
	public AuthorsModel(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public AuthorsModel() {
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "AuthorsModel [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
    
}
