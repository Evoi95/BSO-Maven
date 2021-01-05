package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoundaryHomePageAfterLogin {
	@FXML
	private Pane pane;
	@FXML
	private GridPane grid;
	@FXML
	private Label header;
	@FXML
	private Button buttonL;
	@FXML
	private Button buttonG;
	@FXML
	private Button buttonR;
	@FXML
	private ImageView imageL;
	@FXML
	private ImageView imageG;
	@FXML
	private ImageView imageR;
	@FXML
	private ImageView imageU;
	@FXML
	private Button buttonLogin;

	// private ControllerHomePageLibri cHPL;

	@FXML
	private void getListaGiornali() throws IOException {
		// stampa schermata giornali -> tabella;
		Stage stage;
		Parent root;
		stage = (Stage) buttonL.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("compravenditaGiornali.fxml"));
		stage.setTitle("Benvenuto nella schermata del riepilogo dei giornali");

		// Parent root = FXMLLoader.load(getClass().getResource("compravendita.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();
	}

	@FXML
	private void getListaRiviste() throws IOException {
		// stampa schermata riviste -> tabella;
		Stage stage;
		Parent root;
		stage = (Stage) buttonL.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("compravenditaRivista.fxml"));
		stage.setTitle("Benvenuto nella schermata del riepilogo delle riviste");

		// Parent root = FXMLLoader.load(getClass().getResource("compravendita.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();
	}

	@FXML
	private void getListaLibri() throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) buttonL.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("compravenditaLibri.fxml"));
		stage.setTitle("Benvenuto nella schermata del riepilogo dei libri");

		// Parent root = FXMLLoader.load(getClass().getResource("compravendita.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();

	}

	@FXML
	private void profile() throws IOException {
		// specificare controller logico
		/*
		 * Stage stage;
		 
		Parent root;
		stage = (Stage) buttonL.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("profile.fxml"));
		stage.setTitle("Benvenuto nel tuo profilo qui puoi visualizzare le tue informazioni");
	
		
		// Parent root = FXMLLoader.load(getClass().getResource("compravendita.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();
		*/
		System.out.println("Sto nel terzo caso d'urso lode");
	}

}
