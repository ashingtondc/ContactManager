package application;

/**
 * @author Ash Parasa
 *
 */
public class Contact implements ContactInterface
{
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String birthday;
	private String email;

	public Contact()
	{
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return firstName + " " + lastName;
	}
	
	/**
	 * Creates a contact with the specified parameters
	 * @param firstName First Name
	 * @param lastName Last Name
	 * @param number Phone Number
	 * @param address Address
	 * @param birthday Birthday
	 * @param email Email
	 */
	public Contact(String firstName, String lastName, String number, String address, String birthday, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = number;
		this.address = address;
		this.birthday = birthday;
		this.email = email;
	}
	
	/**
	 * Changes first name
	 * @param name First Name
	 */
	public void changeFirstName(String name) {
		firstName = name;
		
	}

	/**
	 * Changes last name
	 * @param name Last Name
	 */
	public void changeLastName(String name) {
		lastName = name;
		
	}

	/**
	 * Changes phone number
	 * @param number Phone Number
	 */
	public void changeNumber(String number) {
		phone = number;
		
	}

	/**
	 * Changes address
	 * @param address Address
	 */
	public void changeAddress(String address) {
		this.address = address;
		
	}

	/**
	 * Changes birthday
	 * @param birthday Birthday
	 */
	public void changeBirthday(String birthday) {
		this.birthday = birthday;
		
	}

	/**
	 * Changes email
	 * @param email Email
	 */
	public void changeEmail(String email) {
		this.email = email;
		
	}

	/**
	 * Gets first name
	 * @return firstName returns first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets last name
	 * @return lastName returns last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Gets phone number
	 * @return phone returns phone number
	 */
	public String getNumber() {
		return phone;
	}

	/**
	 * Gets address
	 * @return address returns address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Gets birthday
	 * @return birthday returns birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * Gets email
	 * @return email returns email
	 */
	public String getEmail() {
		return email;
	}

}
