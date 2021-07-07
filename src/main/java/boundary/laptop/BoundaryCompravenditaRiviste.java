package boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controller_app.ControllerCompravenditaRiviste;
import controller_app.ControllerVisualizzaRivista;
import controller_app.SingeltonSystemState;
import factorybook.Raccolta;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoundaryCompravenditaRiviste implements Initializable {

	private ControllerCompravenditaRiviste cCR;
	private ControllerVisualizzaRivista cVR;

	
	@FXML
	private Pane panel;
	@FXML
	private Label header;
	@FXML
	private TableView<Raccolta> table;
	@FXML
	private TableColumn<Raccolta, SimpleStringProperty> titolo = new TableColumn<>("Titolo");
	@FXML
	private TableColumn<Raccolta, SimpleStringProperty> editore = new TableColumn<>("Editore");
		@FXML
	private TableColumn<Raccolta, SimpleStringProperty> dataPubb = new TableColumn<>("DataPubblicazione");
	@FXML
	private TableColumn<Raccolta, SimpleIntegerProperty> categoria = new TableColumn<>("tipologia");
	@FXML
	private TableColumn<Raccolta, SimpleFloatProperty> prezzo = new TableColumn<>("Prezzo");
	@FXML
	private TableColumn<Raccolta, SimpleIntegerProperty> idRivista = new TableColumn<>("Id Rivista" );
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
	@FXML
	
	protected Scene scene;
	protected Alert alert;
	
	private void vediListaRiviste() throws SQLException {
		table.setItems(cCR.getRiviste());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cCR = new ControllerCompravenditaRiviste();
		cVR = new ControllerVisualizzaRivista();

		titolo.setCellValueFactory(new PropertyValueFactory<>("titolo"));
		editore.setCellValueFactory(new PropertyValueFactory<>("editore"));
		dataPubb.setCellValueFactory(new PropertyValueFactory<>("dataPubb"));
		categoria.setCellValueFactory(new PropertyValueFactory<>("tipologia"));
		prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
		idRivista.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		try {
			vediListaRiviste();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	@FXML
	private void torna() throws IOException {
		String tipoU=cCR.tipoUtente();
		if( SingeltonSystemState.getIstance().getIsLogged() &&  tipoU.equalsIgnoreCase("A")) {
			Stage stage;
			Parent root;
			stage = (Stage) buttonI.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("homePageAfterLogin.fxml"));
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			}
			 if( SingeltonSystemState.getIstance().getIsLogged() && (tipoU.equalsIgnoreCase("W") || tipoU.equalsIgnoreCase("E")) ) {
				Stage stage;
				Parent root;
				stage = (Stage) buttonI.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("homePageAfterLoginES.fxml"));
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
			else {
				
					Stage stage;
					Parent root;
					stage = (Stage) buttonI.getScene().getWindow();
					root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
					scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				}

	}

	
	@FXML
	private void verifica() throws  IOException, SQLException {
		try
		{
			String i = entryText.getText();
		if( cCR.disponibilitaRiviste(i)) {
			cVR.setID(i);
			Stage stage;
			Parent root;
			stage = (Stage) buttonV.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("visualizzaMagazinePage.fxml"));
			stage.setTitle("Benvenuto nella schermata del riepilogo ordine");
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
			
		else
		{
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Errore Id rivista inserito");
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
		if( cCR.disponibilitaRiviste(i)) {
			cVR.setID(i);
			Stage stage;
			Parent root;
			stage = (Stage) buttonA.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("acquista.fxml"));
			stage.setTitle("Benvenuto nella schermata del riepilogo ordine");
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else
		{
			alert = new Alert(AlertType.ERROR);
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
