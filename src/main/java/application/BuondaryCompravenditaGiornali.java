package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import factoryBook.Raccolta;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BuondaryCompravenditaGiornali implements Initializable {

	@FXML
	private Pane panel;
	@FXML
	private Label header;
	@FXML
	private TableView<Raccolta> table;
	@FXML
	private TableColumn<Raccolta, SimpleStringProperty> titolo = new TableColumn<>("Titolo");
	@FXML
	private TableColumn<Raccolta, SimpleStringProperty> Tipologia = new TableColumn<>("Tipologia");
	@FXML
	private TableColumn<Raccolta, SimpleStringProperty> autore = new TableColumn<>("Autore");
	@FXML
	private TableColumn<Raccolta, SimpleStringProperty> dataPub = new TableColumn<>("Data Pubblicazione");
	@FXML
	private TableColumn<Raccolta, SimpleFloatProperty> prezzo = new TableColumn<>("Prezzo");
	@FXML
	private TableColumn<Raccolta, SimpleIntegerProperty> idGiornale = new TableColumn<>("Id Giornale");
	
	@FXML
	private TableColumn<Raccolta, SimpleIntegerProperty> disponibilita = new TableColumn<>("Disponibilita");
	/*
	 * TODO sistemare altre righe tabella dal db
	 */
	@FXML
	private Button buttonL;
	@FXML
	private TextField entryText;
	@FXML
	private Button buttonV;
	@FXML
	private Button buttonI;
	@FXML
	private Button buttonA;

	private ControllerCompravenditaGiornali CCG;
	private ControllerVisualizzaGionarle CVG;

	
	@FXML
	private void vediListaGiornali() throws SQLException {

		table.setItems(CCG.getGiornali());

	}

	public BuondaryCompravenditaGiornali() {
		CCG = new ControllerCompravenditaGiornali();
		CVG = new ControllerVisualizzaGionarle();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		titolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));
		Tipologia.setCellValueFactory(new PropertyValueFactory<>("tipologia"));
		autore.setCellValueFactory(new PropertyValueFactory<>("editore"));
		dataPub.setCellValueFactory(new PropertyValueFactory<>("dataPubb"));
		prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
		idGiornale.setCellValueFactory(new PropertyValueFactory<>("id"));

	}

	@FXML
	private void torna() throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) buttonI.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
		stage.setTitle("Benvenuto nella schermata del riepilogo ordine");

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	
	@FXML
	private void verifica() throws  IOException, SQLException {
		try
		{
			String i = entryText.getText();
		if( CCG.disponibilitaGiornale(i)) {
			CVG.setID(i);
			Stage stage;
			Parent root;
			stage = (Stage) buttonV.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("visualizzaDailyPage.fxml"));
			stage.setTitle("Benvenuto nella schermata del riepilogo ordine");

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
			
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore Id libro inserito");
			alert.setHeaderText("Errore nei dati inseriti");
			alert.setContentText("Ricontrolla i dati che hai inserito !");
			alert.showAndWait();
		}
		}
		catch (NumberFormatException e)
		{
			e.getMessage();
		}

	}

	@FXML
	private void procedi() throws IOException, SQLException {
		try
		{
			String i = entryText.getText();
		if( CCG.disponibilitaGiornale(i)) {
			CVG.setID(i);
			Stage stage;
			Parent root;
			stage = (Stage) buttonA.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("acquista.fxml"));
			stage.setTitle("Benvenuto nella schermata del riepilogo ordine");

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore Id libro non inserito");
			alert.setHeaderText("Errore nei dati inseriti");
			alert.setContentText("Ricontrolla i dati che hai inserito !");
			alert.showAndWait();
		}
		}
		catch (NumberFormatException e)
		{
			e.getMessage();
		}

		
	}



}
