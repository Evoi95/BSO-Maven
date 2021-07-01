package boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controller_app.ControllerVisualizzaLibro;
import controller_app.SingeltonSystemState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoundaryVisualizzaLibro implements Initializable {
	
	@FXML
	private Pane pane;
	@FXML
	private GridPane gridpane ;
	@FXML
	private Label labelTitolo;
	@FXML 
	private Label labelNumeroPagine;
	@FXML
	private Label labelCodiceISBN;
	@FXML
	private Label labelEditore;
	@FXML
	private Label labelAutore;
	@FXML
	private Label labelLingua;
	@FXML
	private Label labelCategoria ;
	@FXML
	private Label labelDate;
	@FXML
	private Label labelRecensione;
	@FXML 
	private Label labelDescrizione;
	@FXML
	private Label labelDisp;
	@FXML
	private Label labelPrezzo;
	@FXML
	private Label labelCopieRimanenti;
	@FXML
	private Button buttonBack;
	@FXML
	private Button buttonA;
	@FXML
	private Label titoloL;
	@FXML
	private Label numeroPagineL;
	@FXML
	private Label codeIsbnL;
	@FXML
	private Label editoreL;
	@FXML
	private Label autoreL;
	@FXML
	private Label linguaL;
	@FXML
	private Label categoriaL;
	@FXML
	private Label dataL;
	@FXML
	private Label recensioneL;
	@FXML
	private Label descrizioneL;
	@FXML
	private Label disponibbilitaL;
	@FXML
	private Label prezzoL;
	@FXML
	private Label copieRimanenteL;
	
	private ControllerVisualizzaLibro cVB;
	protected int i;
	private Scene scene;
	
	public BoundaryVisualizzaLibro()
	{
		cVB = new ControllerVisualizzaLibro();
	}
	
	@FXML
	private void acquista() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonA.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("acquista.fxml"));
		stage.setTitle("Benvenuto nella schermata del riepilogo ordine");

		 scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void annulla() throws IOException
	{
		if (!SingeltonSystemState.getIstance().getIsSearch()) {
		Stage stage;
		Parent root;
		stage = (Stage) buttonBack.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("compravenditaLibri.fxml"));

		 scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
		else
		{
			Stage stage;
			Parent root;
			stage = (Stage) buttonBack.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("ricercaPage.fxml"));

			 scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		i = cVB.getID();
		
		// problema assegnazioni variabili nel dao o controller 
		try {
			labelTitolo.setText(cVB.getData(i).getTitolo());
			labelNumeroPagine.setText(""+cVB.getData(i).getNumPag());
			labelCodiceISBN.setText(cVB.getData(i).getCodIsbn());
			labelEditore.setText(cVB.getData(i).getEditore());
			labelAutore.setText(cVB.getData(i).getAutore());
			labelLingua.setText(cVB.getData(i).getLingua());
			labelCategoria.setText(cVB.getData(i).getCategoria());
			labelDate.setText(""+cVB.getData(i).getDataPubb());
			labelRecensione.setText(cVB.getData(i).getRecensione());
			labelDescrizione.setText(cVB.getData(i).getDesc());
			labelDisp.setText(""+cVB.getData(i).getDisponibilita());
			labelPrezzo.setText(cVB.getData(i).getPrezzo()+"");
			labelCopieRimanenti.setText(cVB.getData(i).getCopieRim()+"");
		} catch (SQLException e) {
			e.getCause();
			
		}
		

	}
	

}
