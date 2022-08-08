package contact;

import java.util.HashMap;
import java.util.Map;

/**
 * The Contact Service can create a contact with a unique ID an add it to a hashmap
 * as well as get, delete, and update an existing contact.
 * 
 * @author Sarah Kerr
 * @version 1.0
 * Created with Eclipse IDE 4.18.0
 */
public class ContactService {
	
	int Id = 0;

	private final Map<Integer, Contact> contactList = new HashMap<>();
	
	/**
	 * Gives the contact a unique ID and adds it to the hashmap
	 * 
	 * @param firstName The first name of the contact
	 * @param lastName The last name of the contact
	 * @param phone The phone number of the contact
	 * @param address The address of the contact
	 * @return contact object
	 */
	public Contact addContact(String firstName, String lastName, String Phone, String Address) {
		Id++;
			
		Contact contact = new Contact(firstName, lastName, Phone, Address);
		
		contactList.put(Id, contact); //Map unique Id to each contact
			
		return contact;		
		}
	
	/**
	 * Searches for an existing contact and returns it if found
	 * 
	 * @param ID The unique ID mapped to each contact
	 * @return contact object with the specified ID
	 * @throws IllegalArgumentException if no contact exists with that ID
	 */
	public Contact getContact(Integer ID)
	{	
		if (contactList.get(ID) == null)
		{
			throw new IllegalArgumentException("no such contact");
		}
		else {
			return contactList.get(ID);
		}
	}	
	
	/**
	 * Deletes a contact with the given ID and returns true if successful
	 * 
	 * @param ID The unique ID mapped to each contact
	 * @return True if contact successfully deleted
	 * @throws IllegalArgumentException if no contact exists with that ID
	 */
	public boolean deleteContact(Integer ID) {
		if (contactList.get(ID) == null)
		{
			throw new IllegalArgumentException("Can't delete, no such contact");	
		}
		else {
			contactList.remove(ID);
			return true;
		}
	}
	
	/**
	 * Updates an existing contact's firstname, lastname, phone, and address
	 * 
	 * @param ID The unique ID mapped to each contact
	 * @param firstName The first name of the contact
	 * @param lastName The last name of the contact
	 * @param phone The phone number of the contact
	 * @param address The address of the contact
	 */
	public void updateContact(Integer ID, String firstName, String lastName, String phone, String address) {	
		Contact contact = contactList.get(ID);
				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setPhone(phone);
				contact.setAddress(address);
		}		
	}
	
	
	

