package com.jime;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	// map a contact with their unique ID
	private final Map<String, Contact> contacts = new HashMap<>();
	
	// add a contact
	public void addContact(Contact contact) {
		if(contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("A contact with this ID already exist.");		
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	// delete contact per ID
	public void deleteContact(String contactId) {
		// ensure contact exists
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact with this ID doesn't exist");
		}
		contacts.remove(contactId);
	}
	
	// update a contact
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		Contact contact = contacts.get(contactId);
		// ensure contact exists
		if (contact == null) {
			throw new IllegalArgumentException("Contact with this ID doesn't exist");
		}
		
		if (firstName != null) {
			contact.setFirstName(firstName);
		}
		
		if (lastName != null) {
			contact.setLastName(lastName);
		}
		
		if (phone != null) {
			contact.setPhone(phone);
		}
		
		if (address != null) {
			contact.setAddress(address);
		}
	}

	// get contact by ID
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
	
}
