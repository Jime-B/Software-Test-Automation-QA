package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jime.Contact;
import com.jime.ContactService;

class ContactServiceTest {
	
	private ContactService contactService;
	private Contact contact;
	
	
	@BeforeEach
	void setup() {
		contactService = new ContactService();
		contact = new Contact("1234", "Jime", "Balvin", "1112223333", "12345 Van Buren St");
	}
	
	@Test
	void testAddContact() {
		contactService.addContact(contact);
		// ensure the contact was added
		assertEquals(contact, contactService.getContact("1234"));
	}
	
	@Test
	void testAddDuplicatedContactId() {
		contactService.addContact(contact);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(contact);
		});
	}
	
	@Test
	void testDeleteContact() {
		contactService.addContact(contact);
		contactService.deleteContact("1234");
		assertNull(contactService.getContact("1234"));
	}
	
	@Test
	void testDeleteContactNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact("5678");
		});
	}
	
	@Test
	void testUpdateContact() {
		contactService.addContact(contact);
		contactService.updateContact("1234", "Jime123", "Balvin456", "2223334444", "6789 Lombard St");
		
		Contact updatedContact = contactService.getContact("1234");
		assertNotNull(updatedContact);
		assertEquals("Jime123", updatedContact.getFirstName());
		assertEquals("Balvin456", updatedContact.getLastName());
		assertEquals("2223334444", updatedContact.getPhone());
		assertEquals("6789 Lombard St", updatedContact.getAddress());
	}
	
	@Test
	void testUpdateContactNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("12345", "Jime", "Balvin", "1112223333", "12345 Van Buren St");
		});
	}

	@Test
	void testGetContact() {
		contactService.addContact(contact);
		
		Contact retrievedContact = contactService.getContact("1234");
		assertNotNull(retrievedContact);
		assertEquals("1234", retrievedContact.getContactId());
		assertEquals("Jime", retrievedContact.getFirstName());
		assertEquals("Balvin", retrievedContact.getLastName());
		assertEquals("1112223333", retrievedContact.getPhone());
		assertEquals("12345 Van Buren St", retrievedContact.getAddress());
	}
	
	
}
