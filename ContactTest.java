package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Contains the test methods for Contact.java
 * 
 * testContact() - Testing to make sure each variable can be added to contact
 * testFirstNameForExceptionUse() - Testing that exceptions are thrown for invalid first name
 * testLastNameForExceptionUse() - Testing that exceptions are thrown for invalid last name
 * testPhoneForExceptionUse() - Testing that exceptions are thrown for invalid phone number
 * testAddressForExceptionUse() - Testing that exceptions are thrown for invalid address
 * 
 * @author Sarah Kerr
 * @version 1.0
 * 
 */
class ContactTest {
	
	private String firstname, lastname, phone, address;
	private String tooLongFirstName, tooLongLastName, badPhone, tooLongAddress;
	
	@BeforeEach
	void setup() {

		firstname = "FirstName1";
		lastname = "LastName12";
		phone = "1235551111";
		address = "address Less Than 30 123456789";
		tooLongFirstName = "FirstName12";
		tooLongLastName = "LastName123";
		badPhone = "123555111";
		tooLongAddress = "address is too long if over 30 characters long";
	}

	//testing to make sure each variable can be added to Contact
	@Test
	void testContact() {
		Contact contact = new Contact(firstname, lastname, phone, address);
		assertTrue(contact.getFirstName().equals(firstname));
		assertTrue(contact.getLastName().equals(lastname));
		assertTrue(contact.getPhone().equals(phone));
		assertTrue(contact.getAddress().equals(address));
	}
	
	//testing for exceptions thrown when too many characters entered and when null value entered for first name
	@Test
	void testFirstNameForExceptionUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(tooLongFirstName, lastname, phone, address);
			new Contact(null, lastname, phone, address);
		});
	}
	
	//testing for exceptions thrown when too many characters entered and when null value entered for last name
	@Test
	void testLastNameForExceptionUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstname, tooLongLastName, phone, address);
			new Contact(firstname, null, phone, address);
		});
	}
	
	//testing for exceptions thrown when too many characters entered and when null value entered for phone
	@Test
	void testPhoneForExceptionUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstname, lastname, badPhone, address);
			new Contact(firstname, lastname, null, address);
		});
	}
	
	//testing for exceptions thrown when too many characters entered and when null value entered for address
	@Test
	void testAddressForExceptionUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(firstname, lastname, phone, tooLongAddress);
			new Contact(firstname, lastname, phone, null);
		});
	}

}
