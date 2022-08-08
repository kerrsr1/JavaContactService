package contact;

/**
 * Creates a contact containing a person's first name, last name, phone number, and address
 * 
 * @author Sarah Kerr
 * @version 1.0
 * Created with Eclipse IDE 4.18.0
 * 
 */
public class Contact {
	
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	/**
	 * Constructs a Contact with first name, last name, phone, and address.
	 * 
	 * @param firstName The first name of the contact
	 * @param lastName The last name of the contact
	 * @param phone The phone number of the contact
	 * @param address The address of the contact
	 */
	public Contact(String firstName, String lastName, String phone, String address) {
		
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);	
	}

	/**
	 * Sets first name if it is not null or greater than 10 characters
	 * 
	 * @param firstName The first name of the contact
	 * @throws IllegalArgumentException If input does not meet requirements
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("invalid first name");
		}
		this.firstName = firstName;
	}
	
	/**
	 * Sets last name if it is not null or greater than 10 characters
	 * 
	 * @param lastName The last name of the contact
	 * @throws IllegalArgumentException If input does not meet requirements
	 */
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("invalid last name");
		}
		this.lastName = lastName;
	}
	
	/**
	 * Sets phone number if it is not null or any length other than 10
	 * 
	 * @param phone The phone number of the contact
	 * @throws IllegalArgumentException If input does not meet requirements
	 */
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("invalid phone number");
		}
		this.phone = phone;
	}
	
	/**
	 * Sets address if it is not null or greater than 30 characters
	 * 
	 * @param address The address of the contact
	 * @throws IllegalArgumentException If input does not meet requirements
	 */
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("invalid address");
		}
		this.address = address;
	}

	// Getters
	/**
	 * Returns the contact's first name
	 * 
	 * @return This contact's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Returns the contact's last name
	 * 
	 * @return This contact's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Returns the contact's phone number
	 * 
	 * @return This contact's address
	 */
	public String getPhone() {
		return phone;
	}
	
	/** 
	 * Returns the contact's address
	 * 
	 * @return This contact's address
	 */
	public String getAddress() {
		return address;
	}
	
}
