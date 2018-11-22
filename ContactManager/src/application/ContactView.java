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
public class ContactView {

	/**
	 * Displays selected contact information and allows for editing
	 * @param c Contact to display information
	 * @return returns updated contact
	 */
	public static Contact display(Contact contact)
	{
		Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("View Contact");
        
        VBox addLayout = new VBox(5);
		//Creates text fields and sets default values to values from contact object
		TextField inputFName = new TextField();
		inputFName.appendText(contact.getFirstName());
		Label fNameLabel = new Label("First Name");
		TextField inputLName = new TextField();
		inputLName.appendText(contact.getLastName());
		Label lNameLabel = new Label("Last Name");
		TextField inputPhone = new TextField();
		inputPhone.appendText(contact.getNumber());
		Label phoneLabel = new Label("Phone");
		TextField inputAddress = new TextField();
		inputAddress.appendText(contact.getAddress());
		Label addressLabel = new Label("Address");
		TextField inputBirthday = new TextField();
		inputBirthday.appendText(contact.getBirthday());
		Label birthdayLabel = new Label("Birthday");
		TextField inputEmail = new TextField();
		inputEmail.appendText(contact.getEmail());
		Label emailLabel = new Label("Email");
		Button back = new Button("Back");
		Button saveAdd = new Button("Save");
		//Clears fields before leaving window
		back.setOnAction(e -> {
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
			contact.changeFirstName(inputFName.getText());
			contact.changeLastName(inputLName.getText());
			contact.changeNumber(inputPhone.getText());
			contact.changeAddress(inputAddress.getText());
			contact.changeBirthday(inputBirthday.getText());
			contact.changeEmail(inputEmail.getText());
			//Clear all fields
			inputFName.clear();
			inputLName.clear();
			inputPhone.clear();
			inputAddress.clear();
			inputBirthday.clear();
			inputEmail.clear();
			window.close();
		});
		
		addLayout.getChildren().addAll(fNameLabel, inputFName, lNameLabel, inputLName, phoneLabel, inputPhone, addressLabel, inputAddress, birthdayLabel, inputBirthday, emailLabel, inputEmail, back, saveAdd);
		Scene scene = new Scene(addLayout, 400, 400);
		window.setScene(scene);
		window.showAndWait();
		
		return contact;
	}
}
