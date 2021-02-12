package boundary.laptop;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BoundaryRegistrazioneOk {
	@FXML
	private Pane pane;
	@FXML 
	private VBox vbox;
	@FXML
	private Button loginB;
	@FXML
	private Label labelScelta;
	@FXML
	private Button homePageB;
	@FXML
	private Label header;
	@FXML
	private ImageView image;
	
	@FXML
	private void vaiLogin() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) loginB.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
		stage.setTitle("Registazione andata a buon fine");

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		//ricarico schermata login;
	}
	@FXML
	private void vaiHome() throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) homePageB.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
		stage.setTitle("Registazione andata a buon fine");

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		//roicarico schermata home
	}
	

}
