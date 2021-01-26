package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import factoryBook.Libro;
import factoryBook.Raccolta;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoundaryBookPage implements Initializable {
	
	@FXML
	private Pane pane ;
	@FXML
	private Label header;
	@FXML
	private TableView<Libro> table = new TableView<Libro>();
	@FXML
	private TableColumn<Libro, SimpleStringProperty> titolo = new TableColumn<>("Titolo");
	@FXML
	private TableColumn<Libro, SimpleStringProperty> isbn = new TableColumn<>("CodiceIsbn");
	@FXML
	private TableColumn<Libro, SimpleStringProperty> editore = new TableColumn<>("Editore");
	@FXML
	private TableColumn<Libro, SimpleStringProperty> autore = new TableColumn<>("Autore");
	@FXML
	private TableColumn<Libro, SimpleStringProperty> categoria = new TableColumn<>("Categoria");
	@FXML
	private TableColumn<Libro, SimpleFloatProperty> prezzo = new TableColumn<>("Prezzo");
	@FXML
	private TableColumn<Libro, SimpleIntegerProperty> id = new TableColumn<>("ID Prodotto");
	@FXML
	private Button buttonAdd;
	@FXML
	private Button modB;
	@FXML
	private Button buttonDel;
	@FXML
	private Button buttonB;
	@FXML
	private Button buttonGL;
	
	@FXML
	private void aggiungi() 
	{
		// apro la boundary di aggiunta dei dati e inserimento nel db
	}
	
	@FXML
	private void modifica()
	{
		//appro una prima schemata di allert che mi chede l'id del libro da modificare
		// poi quella schermata di aller mi riporta alla pagina di modifica dove mostro tutti
		// i dati del libro gia' presenti nel mio9 db e poi li modifico 
	}
	
	@FXML
	private void cancella()
	{
		// come nella modifica si apre una schemrata che chiedi il codice del libro da modiciare
		// inserito quel codice io posso clicare ok o indietro
		// se clicco ok allora apro la pagina di modifica altrimenti niente
		
	}
	
	@FXML
	private void indietro() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonB.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void genera()
	{
		// get del controller libri
	}
	@Override
	
public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		titolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));
		isbn.setCellValueFactory(new PropertyValueFactory<>("codIsbn"));
		editore.setCellValueFactory(new PropertyValueFactory<>("editore"));
		autore.setCellValueFactory(new PropertyValueFactory<>("autore"));
		categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
	}
	// to do mettere funzione franco
	// to do mettere funzione camilla
	
}
