package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


/**
 * @author Ash Parasa
 *
 */
public class addContactView {
	
	private static String firstName = "";
	private static String lastName = "";
	private static String phone = "";
	private static String address = "";
	private static String birthday = "";
	private static String email = "";

	/**
	 * Displays input fields to create and add a Contact object to the contact list
	 * @param l ContactList to add to
	 * @return returns updated ContactList
	 */
	public static ContactList display(ContactList contacts)
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add Contact");
		VBox addLayout = new VBox(5);
		
		TextField inputFName = new TextField();
		Label fNameLabel = new Label("First Name");
		TextField inputLName = new TextField();
		Label lNameLabel = new Label("Last Name");
		TextField inputPhone = new TextField();
		Label phoneLabel = new Label("Phone");
		TextField inputAddress = new TextField();
		Label addressLabel = new Label("Address");
		TextField inputBirthday = new TextField();
		Label birthdayLabel = new Label("Birthday");
		TextField inputEmail = new TextField();
		Label emailLabel = new Label("Email");
		Button cancelAdd = new Button("Cancel");
		Button saveAdd = new Button("Save");
		
		cancelAdd.setOnAction(e -> {
			inputFName.clear();
			inputLName.clear();
			inputPhone.clear();
			inputAddress.clear();
			inputBirthday.clear();
			inputEmail.clear();
			window.close();
		});
		saveAdd.setOnAction(e -> {
			//Get text from fields
			firstName = inputFName.getText();
			lastName = inputLName.getText();
			phone = inputPhone.getText();
			address = inputAddress.getText();
			birthday = inputBirthday.getText();
			email = inputEmail.getText();
			//Add to Contact List
			Contact c = new Contact(firstName, lastName, phone, address, birthday, email);
			contacts.add(c);
			//Clear all fields
			inputFName.clear();
			inputLName.clear();
			inputPhone.clear();
			inputAddress.clear();
			inputBirthday.clear();
			inputEmail.clear();
			
			window.close();
		});
		
		addLayout.getChildren().addAll(fNameLabel, inputFName, lNameLabel, inputLName, phoneLabel, inputPhone, addressLabel, inputAddress, birthdayLabel, inputBirthday, emailLabel, inputEmail, cancelAdd, saveAdd);
		Scene scene = new Scene(addLayout, 400, 400);
		window.setScene(scene);
		window.showAndWait();
		
		return contacts;
	}
}
