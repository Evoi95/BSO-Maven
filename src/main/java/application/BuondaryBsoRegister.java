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
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class BuondaryBsoRegister {
	@FXML
	private Pane pane;
	@FXML
	private GridPane grid;
	@FXML
	private ImageView image;
	@FXML 
	private Label nomeL;
	@FXML
	private Label cognomeL;
	@FXML
	private Label emailL;
	@FXML
	private Label passwordL;
	@FXML
	private Label confermaPassL;
	@FXML
	private TextField nomeTF;
	@FXML
	private TextField cognomeTF;
	@FXML
	private TextField emailTF;	
	@FXML
	private PasswordField passwordTF;
	@FXML
	private PasswordField passCheckTF;
	@FXML
	private Button buttonReg;
	@FXML
	private Button buttonA;
	
	@FXML
	private void procedi() throws IOException {
		/*
		 * carico schermata coso successo
		 * query> insert into users values();
		 * registrazioneOk
		 */
		Stage stage;
		Parent root;
		stage = (Stage) buttonReg.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("registrazioneOk.fxml"));
		stage.setTitle("Registazione andata a buon fine");

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

		
	}
	@FXML
	private void annulla()
	{
		
	}
	
	
	

}
