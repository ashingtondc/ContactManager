package application;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;



/**
 * @author Ash Parasa
 *
 */
public class Main extends Application {
	
	
	Stage window;
	Scene welcome, addContact, showList, viewContact;
	ContactList cList = new ContactList();

	@Override
	public void start(Stage primaryStage) {
		readData();
		try {
			window = primaryStage;
			window.setTitle("Contact Manager v1.0");
			//Layout Welcome Page
			VBox welcomeLayout = new VBox(5);
			
			Label welcomeLabel = new Label("Contact Manager by Ash Parasa");
			//Add Contact Window
			Button add = new Button("Add Contact");
			add.setOnAction(e -> {
				cList = addContactView.display(cList);
			});
			//Contact List Window
			Button list = new Button("Show Contacts");
			list.setOnAction(e -> {
				cList = ContactListView.display(cList);
			});
			
			welcomeLayout.getChildren().addAll(welcomeLabel, list, add);
			welcomeLayout.setAlignment(Pos.CENTER);
			welcome = new Scene(welcomeLayout,400,400);
			window.setScene(welcome);
			window.show();
			
			window.setOnCloseRequest(e -> {
				e.consume();
				closeProgram();
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Confirms before closing and saves data if confirmed.
	 */
	public void closeProgram()
	{
		boolean answer = ConfirmBox.display("Confirm", "Are you sure you want to save and close?");
		if (answer)
		{
			System.out.println("Saved changes.");
			saveData();
			window.close();
		}
	}
	
	/**
	 * Updates Contact List from data file.
	 */
	public void readData()
	{
        try {
            FileReader fileReader = new FileReader("contact");

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            if (line != null)
            {
            	int size = Integer.parseInt(line);
                for (int i = 0; i < size; i++)
                {
                	Contact c = new Contact(bufferedReader.readLine(), bufferedReader.readLine(), bufferedReader.readLine(), bufferedReader.readLine(), bufferedReader.readLine(), bufferedReader.readLine());
                	cList.add(c);
                }
            }

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + "contact" + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + "contact" + "'");                  
        }
	}
	
	/**
	 * Updates data file from Contact List.
	 */
	public void saveData()
	{
		try {
            FileWriter fileWriter = new FileWriter("contact");

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(cList.getSize()));
            bufferedWriter.newLine();
            for (int i = 0; i < cList.getSize(); i++)
            {
            	Contact c = cList.getContact(i);
            	bufferedWriter.write(c.getFirstName());
            	bufferedWriter.newLine();
            	bufferedWriter.write(c.getLastName());
            	bufferedWriter.newLine();
            	bufferedWriter.write(c.getNumber());
            	bufferedWriter.newLine();
            	bufferedWriter.write(c.getAddress());
            	bufferedWriter.newLine();
            	bufferedWriter.write(c.getBirthday());
            	bufferedWriter.newLine();
            	bufferedWriter.write(c.getEmail());
            	bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch(IOException ex) 
		{
            System.out.println("Error writing to file '" + "contact" + "'");
        }
	}
}
