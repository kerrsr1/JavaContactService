package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Contains the test methods for ContactService.java
 * 
 * testAddContactSuccessfully() - Test adding a contact with unique ID
 * testRemoveContactSuccessful() - Test to ensure contact has been deleted successfully
 * testUpdateContactSuccessful() - Test to ensure successful update of an existing contact
 * testAddContactForExceptionUse() - Testing that exceptions are thrown for errors in 
 *  adding a contact
 * testDeleteContactForExceptionUse() - Testing that exceptions are thrown if not able to delete a
 *  contact
 * 
 * @author Sarah Kerr
 * @version 1.0
 */
class ContactServiceTest {
	
	private String firstname1, firstname2, firstname3, lastname1, lastname2, lastname3;
	private String phone1, phone2, phone3, address1, address2, address3;

	@BeforeEach
	void setup() {
		
		firstname1 = "Amy";
		firstname2 = "Bob";
		firstname3 = "Suzanne";
		lastname1 = "Smith";
		lastname2 = "Miller";
		lastname3 = "Peterson";
		phone1 = "1235551234";
		phone2 = "1235557890";
		phone3 = "4565557845";
		address1 = "93 Orchid Street";
		address2 = "555 W. 23rd Ave";
		address3 = "13876 Horseshoe Lane Apt 3";
		
	}
	
	@Test
	/*
	* testing to successfully add contacts with unique ID. The ContactService creates a unique
	* ID by starting with 1 and incrementing each time a Contact object is created. It then makes
	* this Id number the key for the hashmap, so we can use int 1 and int 2 as keys to get the 
	* corresponding contact object. From there we can get each element.
	*/
	void testAddContactSuccessfully() {		
		ContactService service = new ContactService();
		
		service.addContact(firstname1, lastname1, phone1, address1);
		Contact contact1 = service.getContact(1); // The first contact added will have an Id of 1 which we use as the hashmap key
		
		assertTrue(contact1.getFirstName().equals(firstname1));
		assertTrue(contact1.getLastName().equals(lastname1));
		assertTrue(contact1.getPhone().equals(phone1));
		assertTrue(contact1.getAddress().equals(address1));
		
		service.addContact(firstname2, lastname2, phone2, address2);
		Contact contact2 = service.getContact(2); // The second contact added will have an Id of 2 which we use as the hashmap key
		
		assertTrue(contact2.getFirstName().equals(firstname2));
		assertTrue(contact2.getLastName().equals(lastname2));
		assertTrue(contact2.getPhone().equals(phone2));
		assertTrue(contact2.getAddress().equals(address2));		
	}

	@Test
	/*
	 * Testing to ensure a contact has been deleted successfully. The ContactService creates a unique
	 * ID by starting with 1 and incrementing each time a Contact object is created. It then makes
	 * this Id number the key for the hashmap, so we can use int 1, 2, 3 as the keys to get our
	 * contact objects after adding 3 unique contacts.
	 */
	void testRemoveContactSuccessful() {		
		ContactService service = new ContactService();
		
		// Add 3 contacts
		service.addContact(firstname1, lastname1, phone1, address1);
		service.addContact(firstname2, lastname2, phone2, address2);
		service.addContact(firstname3, lastname3, phone3, address3);
		
		// Using assertTrue to detect successful deletion of contact
		assertTrue(service.deleteContact(1)); // Delete contact with key (Id) of 1
		assertTrue(service.deleteContact(3)); // Delete contact with key (Id) of 3
		
		// Make sure contact with key (Id) of 2 hasn't been deleted
		Contact contact1 = service.getContact(2);
		assertTrue(contact1.getFirstName().equals(firstname2));
		assertTrue(contact1.getLastName().equals(lastname2));
		assertTrue(contact1.getPhone().equals(phone2));
		assertTrue(contact1.getAddress().equals(address2));		
	}	
	
	@Test
	/*
	 * Testing to ensure successful update of existing contact. A contact is first added and then is updated and
	 * checked to make sure the contact object elements have been replaced.
	 */
	void testUpdateContactSuccessful() {
		ContactService service = new ContactService();
		
		service.addContact(firstname1, lastname1, phone1, address1);
		int contactKey = 1; // The first contact added will have a unique Id (which is the key) of 1
		
		service.updateContact(contactKey, firstname2, lastname2, phone2, address2);
		
		Contact contact1 = service.getContact(1);
		
		assertTrue(contact1.getFirstName().equals(firstname2));
		assertTrue(contact1.getLastName().equals(lastname2));
		assertTrue(contact1.getPhone().equals(phone2));
		assertTrue(contact1.getAddress().equals(address2));		
	}
	 
	@Test 
	/* Test attempting to get a contact mapped to a key that does not exists in hashmap */
	void testAddContactForExceptionUse() {
		ContactService service = new ContactService();
		
		// Add 1 contact which will have unique ID of 1
		service.addContact(firstname1, lastname1, phone1, address1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getContact(2); //contact with ID 2 should not exist yet	
		});
	}
	
	@Test
	/* Test attempting to delete a contact mapped to a key that does not exist in hashmap */
	void testDeleteContactForExceptionUse() {	
		ContactService service = new ContactService();
		service.addContact(firstname1, lastname1, phone1, address1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact(2); //contact with ID 2 should not exist yet, so can't delete	
		});
	}
}
