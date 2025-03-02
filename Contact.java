package com.jime;

public class Contact {
	
	// variables
	private final String contactID; // can't be updateable
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// constructor
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		
		// fields validation
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Contact ID is a required field and must contain max 10 characters.");
		}
		
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First Name is a required field and must contain max 10 characters.");
		}
		
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last Name is a required field and must contain max 10 characters.");
		}
		
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Phone number is a required field and should be 10 digits.");
		}
		
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address is a required field and must contain max 30 characters.");
		}
		
		// initialize after validation
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		
	}
	
	// getters
	public String getContactId() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone; 
	}
	
	public String getAddress() {
		return address;
	}
	
	// setters
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("First Name is a required field and must contain max 10 characters.");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Last Name is a required field and must contain max 10 characters.");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null || phone.length() !=10) {
			throw new IllegalArgumentException("Phone number is a required field and should be 10 digits.");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Address is a required field and must contain max 30 characters.");
		}
		this.address = address;
	}
	
	
}
