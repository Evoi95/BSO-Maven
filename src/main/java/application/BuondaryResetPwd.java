package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BuondaryResetPwd {
	@FXML
	private Pane pane;
	@FXML
	private GridPane grid;
	@FXML
	private Label header;
	@FXML
	private Label emailL;
	@FXML
	private Label vecchiaPL;
	@FXML
	private Label nuovaPL;
	@FXML
	private TextField emailTF;
	@FXML
	private PasswordField vecchiaPF;
	@FXML
	private PasswordField nuovaPF;
	@FXML
	private ImageView image;
	@FXML
	private Button buttonC;
	@FXML
	private Button buttonH;
	
	@FXML
	private void conferma()
	{
		//update pwd
	}
	@FXML
	private void ritorna() throws IOException
	{
		//torna a homePage;
		Stage stage;
		Parent root;
		stage = (Stage) buttonH.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
		stage.setTitle("Benvenuto nella schermata del login");

		// Parent root = FXMLLoader.load(getClass().getResource("compravendita.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);

	}

}
