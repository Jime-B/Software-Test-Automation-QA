package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jime.Appointment;
import com.jime.Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("1234", "Jime", "Balvin", "1112223333", "12345 Van Buren St");
		assertTrue(contact.getContactId().equals("1234"));
		assertTrue(contact.getFirstName().equals("Jime"));
		assertTrue(contact.getLastName().equals("Balvin"));
		assertTrue(contact.getPhone().equals("1112223333"));
		assertTrue(contact.getAddress().equals("12345 Van Buren St"));
	}
	
	@Test
	void testContactContactIdToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "Jime5678910", "Balvin", "1112223333", "12345 Van Buren St");
		});
	}
	
	@Test
	void testContactContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Jime", "Balvin", "1112223333", "12345 Van Buren St");
		});
	}
	
	@Test
	void testContactFirstNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Jime5678910", "Balvin", "1112223333", "12345 Van Buren St");
		});
	}
	
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", null, "Balvin", "1112223333", "12345 Van Buren St");
		});
	}
	
	@Test
	void testContactLastNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Jime", "Balvin78910", "1112223333", "12345 Van Buren St");
		});
	}
	
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Jime", null, "1112223333", "12345 Van Buren St");
		});
	}
	
	@Test
	void testContactPhoneToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Jime", "Balvin", "12345678910", "12345 Van Buren St");
		});
	}
	
	@Test
	void testContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Jime", "Balvin", null, "12345 Van Buren St");
		});
	}

	@Test
	void testContactAddressToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Jime", "Balvin", "1112223333", "1234567891234567891234567891234");
		});
	}
	
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Jime", "Balvin", "1112223333", null);
		});
	}
	
	@Test
	void testSetFirstName() {
		Contact contact = new Contact("1234", "Jime", "Balvin", "1112223333", "12345 Van Buren St");
        contact.setFirstName("test");
        assertTrue(contact.getFirstName() == "test");
	}
	
	@Test
	void testSetLastName() {
		Contact contact = new Contact("1234", "Jime", "Balvin", "1112223333", "12345 Van Buren St");
        contact.setLastName("test");
        assertTrue(contact.getLastName() == "test");
	}
	
	@Test
	void testSetPhone() {
		Contact contact = new Contact("1234", "Jime", "Balvin", "1112223333", "12345 Van Buren St");
        contact.setPhone("9998887777");
        assertTrue(contact.getPhone() == "9998887777");
	}
	
	@Test
	void testSetAddress() {
		Contact contact = new Contact("1234", "Jime", "Balvin", "1112223333", "12345 Van Buren St");
        contact.setAddress("test");
        assertTrue(contact.getAddress() == "test");
	}
}
