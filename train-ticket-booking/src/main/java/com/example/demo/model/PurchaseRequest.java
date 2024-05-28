package com.example.demo.model;

public class PurchaseRequest {
	
	private String from;
	private String to;
	private String firstName;
	private String lastName;
	private String email;
	private String section;
	public PurchaseRequest() {
		super();
	}
	public PurchaseRequest(String from, String to, String firstName, String lastName, String email, String section) {
		super();
		this.from = from;
		this.to = to;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.section = section;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "PurchaseRequest [from=" + from + ", to=" + to + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", section=" + section + "]";
	}
	
}
