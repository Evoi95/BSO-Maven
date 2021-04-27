package boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controller_app.ControllerVisualizzaOrdine;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pagamento.Pagamento;

public class BoundaryVisualizzaOrdine implements Initializable {
	
	@FXML
	private Pane panel;
	@FXML
	private Label header;
	@FXML
	private TableView<Pagamento> table;
	@FXML
	private TableColumn<Pagamento, SimpleIntegerProperty> id = new TableColumn<>("Id Operazione");
	@FXML
	private TableColumn<Pagamento, SimpleStringProperty> metodo = new TableColumn<>("Metodo Acquisto");
	@FXML
	private TableColumn<Pagamento, SimpleIntegerProperty> esito = new TableColumn<>("Esito");
	@FXML
	private TableColumn<Pagamento, SimpleStringProperty> nome = new TableColumn<>("Nome Utente");
	@FXML
	private TableColumn<Pagamento, SimpleStringProperty> spesa = new TableColumn<>("Spesa Totale ");
	@FXML
	private TableColumn<Pagamento, SimpleStringProperty> acquisto = new TableColumn<>("Tipo Acquisto ");
	@FXML
	private TableColumn<Pagamento, SimpleIntegerProperty> id_prod = new TableColumn<>("Id Prodotto ");

	@FXML
	private Button buttonI;
	@FXML
	private Button buttonHP;
	
		
	@FXML
	private Button buttonG;
	
	
	private ControllerVisualizzaOrdine cVO;
	
	@FXML
	private void riepilogo() throws SQLException
	{
		cVO.getDati();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		id.setCellValueFactory(new PropertyValueFactory<>("id")); 
		metodo.setCellValueFactory(new PropertyValueFactory<>("metodo"));
		esito.setCellValueFactory(new PropertyValueFactory<>("esito")); //da pagamento
		nome.setCellValueFactory(new PropertyValueFactory<>("nomeUtente")); //pag
		spesa.setCellValueFactory(new PropertyValueFactory<>("ammontare"));
		acquisto.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		id_prod.setCellValueFactory(new PropertyValueFactory<>("idOg"));


		//prezzo.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
		
		
		
	}
	
	public BoundaryVisualizzaOrdine()
	{
		cVO=new ControllerVisualizzaOrdine();
	}
	
	@FXML
	private void acquisti() throws SQLException
	{
		table.setItems(cVO.getDati());

	}
	@FXML
	private void indietro() throws IOException
	{
		
		   Stage stage;
			Parent root;
			stage = (Stage) buttonI.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("visualizzaProfilo.fxml"));
			stage.setTitle("Benvenuto nella schermata del riepilogo dei giornali");

			// Parent root = FXMLLoader.load(getClass().getResource("compravendita.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();

		 

	}
	@FXML
	private void home() throws IOException
	{ Stage stage;
			Parent root;
			stage = (Stage) buttonHP.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("homePageAfterLogin.fxml"));
			stage.setTitle("Benvenuto nella schermata del riepilogo dei giornali");

			// Parent root = FXMLLoader.load(getClass().getResource("compravendita.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();

		 

	}

}
