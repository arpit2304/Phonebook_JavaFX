package jProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.prism.paint.Color;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ContactDetailsController {

	@FXML private Button btnRemove,btnEdit;
	@FXML public Label lblName,lblPhoneN,lblEmail,lblRm;
	
	public String path = "C:\\\\Users\\\\aryan\\\\OneDrive\\\\Desktop\\\\javahero\\\\Project\\\\src\\\\files\\\\project.txt";
	ArrayList<Search> ls = new ArrayList<Search>();
	public void loadFromFile() throws FileNotFoundException {
		File f = new File(path);
		if(!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		Scanner records = new Scanner(f);
		while(records.hasNextLine()){
			String record = records.nextLine();
			Scanner fields = new Scanner(record);
			fields.useDelimiter(" \\s*");
			String name = fields.next();
			String num = fields.next();
			String email= fields.next();
			Search se = new Search(name, email, num);
			ls.add(se);
			fields.close();
		}
		records.close();
	}
	
	@FXML public void OnActionR(ActionEvent e) throws IOException
	{
		lblName.setText("");
		lblPhoneN.setText("");
		lblEmail.setText("");
		lblRm.setText("Contact has been Removed");
		btnEdit.setStyle("-fx-background-color:black");
	}
	@FXML public void OnActionE(ActionEvent e) throws IOException
	{
		FXMLLoader nw = new FXMLLoader(getClass().getResource("EditContact.fxml"));
		Parent root = (Parent)nw.load();
		Stage st = new Stage();
		st.setScene(new Scene(root));
		st.setTitle("Edit your profile here");
		st.sizeToScene();
		st.show();
	}//end of the method
}//end of the class
