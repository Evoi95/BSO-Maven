package boundary.laptop;

import java.io.IOException;

import controller_app.SingeltonSystemState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BoundaryHomePage {
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
	@FXML
	private Button buttonC;

	protected Scene scene;

	@FXML
	private void getListaGiornali() throws IOException {
		SingeltonSystemState.getIstance().setIsSearch(false);
		SingeltonSystemState.getIstance().setTypeAsDaily();
		Stage stage;
		Parent root;
		stage = (Stage) buttonL.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("compravenditaGiornali.fxml"));
		stage.setTitle("Benvenuto nella schermata del riepilogo dei giornali");
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void getListaRiviste() throws IOException {
		SingeltonSystemState.getIstance().setIsSearch(false);
		SingeltonSystemState.getIstance().setTypeAsMagazine();
		Stage stage;
		Parent root;
		stage = (Stage) buttonL.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("compravenditaRivista.fxml"));
		stage.setTitle("Benvenuto nella schermata del riepilogo delle riviste");
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void getListaLibri() throws IOException {
		SingeltonSystemState.getIstance().setIsSearch(false);
		SingeltonSystemState.getIstance().setTypeAsBook();
		Stage stage;
		Parent root;
		stage = (Stage) buttonL.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("compravenditaLibri.fxml"));
		stage.setTitle("Benvenuto nella schermata del riepilogo dei libri");
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	private void login() throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) buttonL.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
		stage.setTitle("Benvenuto nella schermata del login");
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	@FXML
	private void cerca() throws IOException {
		SingeltonSystemState.getIstance().setIsSearch(true);
		Stage stage;
		Parent root;
		stage = (Stage) buttonC.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("ricercaPerTipo.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);

		stage.show();

	}

}
