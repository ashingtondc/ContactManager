package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import java.util.Collections;

import javafx.geometry.*;

/**
 * @author Ash Parasa
 *
 */
public class ContactListView {
	
	public static ListView<Contact> peopleList = new ListView<>();
	public static boolean madeChanges = false;
	
	/**
	 * Displays contacts from contact list and allows for editing or deleting
	 * @param contacts list of contacts
	 * @return Returns updated contact list
	 */
	public static ContactList display(ContactList contacts)
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Display Contacts");
		
		VBox personList = new VBox(5);
		Button back = new Button("Back");
		Button view = new Button("View & Edit");
		Button delete = new Button("Delete");
		Button sort = new Button("Sort");
		for (int i = 0; i < contacts.getSize(); i++)
		{
			Contact c = contacts.getContact(i);
			peopleList.getItems().add(c);
		}
		personList.getChildren().addAll(back, peopleList, view, delete, sort);
		
		//Goes back to Contact List window
		back.setOnAction(e -> {
			window.close();
			madeChanges = false;
		});
		//Contact Information Window
		view.setOnAction(e -> {
			Contact updatedContact;
			Contact originalContact;
			if (peopleList.getSelectionModel().isEmpty())
			{
				AlertBox.display("Error", "No contact selected.");
			}else {
				originalContact = peopleList.getSelectionModel().getSelectedItem();
				updatedContact = ContactView.display(originalContact);
				contacts.changeContact(originalContact, updatedContact);
				window.close();
				madeChanges = true;
			}	
		});
		//Deletes selection
		delete.setOnAction(e -> {
			Contact selectedContact;
			if (peopleList.getSelectionModel().isEmpty())
			{
				AlertBox.display("Error", "No contact selected.");
			}else {
				selectedContact = peopleList.getSelectionModel().getSelectedItem();
				
				contacts.remove(selectedContact);
				window.close();
				madeChanges = true;
			}
		});
		
		sort.setOnAction(e -> {
			contacts.sort();
			window.close();
			madeChanges = true;
		});
		Scene scene = new Scene(personList, 400, 400);
		window.setScene(scene);
        window.showAndWait();
        
        //Clears ListView to prevent duplicates
        peopleList.getItems().clear();
        
        if (madeChanges)
        {
        	return display(contacts); //Reopens to reload ListView with modified ContactList
        }else {
        	return contacts;
        }
	}

}
