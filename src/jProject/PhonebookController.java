package jProject;


import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PhonebookController {
	@FXML private Button btAddContact,btSearch;
	
@FXML public void OnAddC(ActionEvent e) throws IOException
{
	
	FXMLLoader nw = new FXMLLoader(getClass().getResource("AddContact.fxml"));
	Parent root = (Parent)nw.load();
	Stage st = new Stage();
	st.setScene(new Scene(root));
	st.setTitle("AddContcat");
	st.sizeToScene();
	st.show();
}
@FXML public void OnSearch(ActionEvent e) throws IOException 
{
	FXMLLoader nw = new FXMLLoader(getClass().getResource("SearchController.fxml"));
	Parent root = (Parent)nw.load();
	Stage st = new Stage();
	st.setScene(new Scene(root));
	st.setTitle("Search The Contact");
	st.sizeToScene();
	st.show();
}
}
