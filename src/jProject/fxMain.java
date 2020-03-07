package jProject;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class fxMain extends javafx.application.Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage ps) throws Exception {
		URL res = this.getClass().getResource("Phonebook.fxml");
		Parent root = FXMLLoader.load(res);
		Scene scene = new Scene(root);
		ps.setScene(scene);
		ps.sizeToScene();
		ps.show();
	}
}
