package application;

import java.util.ArrayList;


/**
 * @author Ash Parasa
 *
 */
/**
 * @author Ash Parasa
 *
 */
public class ContactList {
	private ArrayList<Contact> contactList = new ArrayList();
	
	public ContactList()
	{
		
	}
	
	/**
	 * Adds a contact to the list
	 * @param c Contact object to be added
	 */
	public void add(Contact c)
	{
		contactList.add(c);
	}
	
	/**
	 * Creates a contact with the specified params and adds to the list
	 * @param firstName First name of contact.
	 * @param lastName Last name of contact.
	 * @param number Phone number of contact.
	 * @param address Address of contact.
	 * @param birthday Birthday of contact. 
	 * @param email Email of contact.
	 */
	public void add(String firstName, String lastName, String number, String address, String birthday, String email)
	{
		Contact c = new Contact(firstName, lastName, number, address, birthday, email);
		contactList.add(c);
	}
	
	/**
	 * Removes specified contact.
	 * @param c Contact object to be removed.
	 */
	public void remove(Contact c)
	{
		int i = contactList.indexOf(c);
		contactList.remove(i);
	}
	
	/**
	 * Replaces contact with specified contact
	 * @param original Contact to find and replace
	 * @param replacement New contact to replace original with
	 */
	public void changeContact(Contact original, Contact replacement)
	{
		int i = contactList.indexOf(original);
		contactList.remove(i);
		contactList.add(i, replacement);
	}
	
	/**
	 * Gets the size of the list of contacts
	 * @return Returns an integer value representing the size of the list.
	 */
	public int getSize()
	{
		return contactList.size();
	}
	
	/**
	 * Gets the contact at the specified index
	 * @return Returns the found Contact object.
	 */
	public Contact getContact(int i)
	{
		return contactList.get(i);
	}
	
	/**
	 * Sorts contact list by first name
	 */
	public void sort()
	{
		for (int i = 0; i < contactList.size(); i++) 
        {
            for (int j = i + 1; j < contactList.size(); j++) 
            {
            	Contact a = contactList.get(i);
            	Contact b = contactList.get(j);
                if (a.toString().compareTo(b.toString())>0) 
                {
                    Contact temp = a;
                    contactList.add(i, b);
                    contactList.remove(i+1);
                    contactList.add(j, a);
                    contactList.remove(j+1);
                }
            }
        }
	}
}
