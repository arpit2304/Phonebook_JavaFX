package jProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchController implements Initializable{
	@FXML private Button btnSearch;
	@FXML private Label lblError;
	@FXML private TextField txtSearch;
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

@FXML public void OnActionS(ActionEvent e) throws IOException
{
//	String s5= txtSearch.getText();
	
	for(Search sr: ls)
	{
		String s5= txtSearch.getText();
		if(s5.equals(sr.getName()))
		{
			FXMLLoader nw = new FXMLLoader(getClass().getResource("ContactDetails.fxml"));
			Parent root = (Parent)nw.load();
			
			Stage st = new Stage();
			ContactDetailsController cc= nw.getController();
			cc.lblName.setText(sr.getName());
			cc.lblPhoneN.setText(sr.getNum());
			cc.lblEmail.setText(sr.getEmail());
			st.setScene(new Scene(root));
			st.setTitle("ContactDetails");
			st.sizeToScene();
			st.show();	
		}
		else if(s5.equals(" "))
		{
			lblError.setText("Not found");
		}
		else if(s5.equals(""))
		{
			lblError.setText("Not found");
			
		}
	}//end of the for loop
	
	
	
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	try {
		loadFromFile();
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	
}
}
class Search{
public String name,email,num;
public Search(String name,String email,String num)
{
	this.name=name;
	this.email=email;
	this.num=num;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
}