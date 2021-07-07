package boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controller_app.ControllerRicercaPage;
import controller_app.ControllerVisualizzaGiornale;
import controller_app.ControllerVisualizzaLibro;
import controller_app.ControllerVisualizzaRivista;
import factorybook.Raccolta;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class BoundaryRicercaPage  implements Initializable{
	
	@FXML
	private Pane pane;
	@FXML
	private Label labelT;
	@FXML
	private TextField cercaT;
	@FXML
	private TextField idT;
	@FXML
	private TableView <Raccolta> table;
	@FXML
	private TableColumn<Raccolta, SimpleStringProperty> titolo = new TableColumn<>("Titolo");
	@FXML
	private TableColumn<Raccolta, SimpleStringProperty> autore = new TableColumn<>("Autore");
	@FXML
	private TableColumn<Raccolta, SimpleStringProperty> id = new TableColumn<>("ID");
	@FXML
	private Button buttonC; 
	@FXML
	private Button buttonV; 
	@FXML
	private Button buttonB;
	
	private String title = "Benvenuto nella schermata del riepilogo ordine";
	private ControllerRicercaPage cRP;
	private ControllerVisualizzaLibro cVL;
	private ControllerVisualizzaGiornale cVG;
	private ControllerVisualizzaRivista cVR;
	protected Scene scene;
	protected Alert alert ;
	
	public BoundaryRicercaPage()
	{
		cRP = new ControllerRicercaPage();
		cVL = new ControllerVisualizzaLibro();
		cVG	= new ControllerVisualizzaGiornale();
		cVR	= new ControllerVisualizzaRivista();
	}
	@FXML
	private void cerca() throws SQLException
	{
		// e populo la tabella
		//col controller faccio la ricerca basandomi sul singerlton battona+
		table.setItems( cRP.cercaPerTipo(cercaT.getText()));
	}

	// mostro i dati e le relative schermate
	@FXML
	private void apri() throws IOException
	{
		String i = idT.getText();
		//col controller Apro basandomi sul singerlton battona
		if(cRP.returnType().equals("libro"))
		{
			cVL.setID(i);
			Stage stage;
			Parent root;
			stage = (Stage) buttonV.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("visualizzaBookPage.fxml"));
			stage.setTitle(title);
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else if(cRP.returnType().equals("giornale"))
		{
			cVG.setID(i);
			Stage stage;
			Parent root;
			stage = (Stage) buttonV.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("visualizzaDailyPage.fxml"));
			stage.setTitle(title);
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else if(cRP.returnType().equals("rivista"))
		{
			cVR.setID(i);
			Stage stage;
			Parent root;
			stage = (Stage) buttonV.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("visualizzaMagazinePage.fxml"));
			stage.setTitle(title);
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else
		{
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore Id inserito");
			alert.setHeaderText("Errore nei dati inseriti");
			alert.setContentText("Ricontrolla i dati che hai inserito !");
			alert.showAndWait();
		}
	}

	@FXML
	private void torna() throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) buttonB.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("ricercaPerTipo.fxml"));
		stage.setTitle(title);
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		titolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));
		autore.setCellValueFactory(new PropertyValueFactory<>("editore"));
		id.setCellValueFactory(new PropertyValueFactory<>("id"));

	}

	
}
