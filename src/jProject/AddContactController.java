package jProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddContactController {
	@FXML private Button btnAddC,btnBack;
	@FXML private TextField txtName, txtNumber, txtEmail;
	public String path = "C:\\Users\\aryan\\OneDrive\\Desktop\\javahero\\Project\\src\\files\\project.txt";
	
	ArrayList<SaveInfo> ls = new ArrayList<SaveInfo>();
	
	public void SaveData() throws IOException {
		try
		{
			File f = new File(path);
			if(!f.exists()) {
				f.createNewFile();
				}
				FileWriter fw = new FileWriter(f,true);
				BufferedWriter bw=new BufferedWriter(fw);
				
			for(SaveInfo si: ls) {
			
				bw.write(si.getName());
				bw.append(" ");
				bw.write(si.getNumber());
				bw.append(" ");
				bw.write(si.getEmail());
				bw.append(".");
				bw.newLine();
				System.out.printf("%s %s %s %n",si.getName(), si.getNumber(), si.getEmail());
				
			}bw.close();
		}
		catch(FileNotFoundException e1){
			e1.printStackTrace();
		}
	}
	@FXML public void Back(ActionEvent e) throws IOException{
		FXMLLoader nw = new FXMLLoader(getClass().getResource("Phonebook.fxml"));
		Parent root = (Parent)nw.load();
		Stage st = new Stage();
		st.setScene(new Scene(root));
		st.setTitle("Phonebook");
		st.sizeToScene();
		st.show();
	}
	
	@FXML public void OnActionA(ActionEvent e) throws IOException {
			String s1 = txtName.getText();
			String s2 = txtEmail.getText();
			String s3 = txtNumber.getText();
			SaveInfo sf = new SaveInfo(s1, s3, s2);
			ls.add(sf);
			SaveData();
			txtName.clear();
			txtNumber.clear();
			txtEmail.clear();
			ls.clear();
		}
	}	
class SaveInfo{
	private String name, email;
	private String number;
	
	public SaveInfo(String name, String number, String email) {
		this.name = name;
		this.number = number;
		this.email = email;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
	
