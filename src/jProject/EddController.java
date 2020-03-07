package jProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

public class EddController implements Initializable{
	@FXML private TextField txtEdname, txtEdnum,txtEdmail;
	@FXML private Button btnSC,btnc;
	@FXML private Label lblEdite;
	
	public String path = "C:\\\\Users\\\\aryan\\\\OneDrive\\\\Desktop\\\\javahero\\\\Project\\\\src\\\\files\\\\project.txt";
	ArrayList<SaveChanges> ls = new ArrayList<SaveChanges>();
	
	public void SavaMethod() throws IOException {
		try
		{
			File f = new File(path);
			if(!f.exists()) {
				f.createNewFile();
				}
				FileWriter fw = new FileWriter(f,true);
				BufferedWriter bw=new BufferedWriter(fw);
				
			for(SaveChanges si: ls) {
			
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
	
	@FXML public void Sc(ActionEvent e) throws IOException{
		String s1 = txtEdname.getText();
		String s2 = txtEdnum.getText();
		String s3 = txtEdmail.getText();
		SaveChanges sf = new SaveChanges(s1, s3, s2);
		ls.add(sf);
		SavaMethod();
		lblEdite.setText("Contact has been saved");
		ls.clear();
	}
	
	@FXML public void cancelD(ActionEvent e) throws IOException{
		System.exit(0);
	}
	
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
			String number = fields.next();
			String email= fields.next();
			SaveChanges se = new SaveChanges(name, number, email);
			ls.add(se);
			fields.close();
		}
		records.close();
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
class SaveChanges{
	private String name, email;
	private String number;
	
	public SaveChanges(String name, String number, String email) {
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
