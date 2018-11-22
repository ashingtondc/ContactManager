package application;

/**
 * @author Ash Parasa
 *
 */
public interface ContactInterface {

	public void changeFirstName(String name);
	public void changeLastName(String name);
	public void changeNumber(String number);
	public void changeAddress(String address);
	public void changeBirthday(String birthday);
	public void changeEmail(String email);
	public String getFirstName();
	public String getLastName();
	public String getNumber();
	public String getAddress();
	public String getBirthday();
	public String getEmail();
	
}
