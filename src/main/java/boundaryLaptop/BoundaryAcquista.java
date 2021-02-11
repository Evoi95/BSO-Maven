package boundaryLaptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controllerApp.ControllerAcquista;
import controllerApp.singeltonSystemState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BoundaryAcquista implements Initializable {
	@FXML
	private SplitPane split;
	@FXML
	private AnchorPane ap1;
	@FXML
	private AnchorPane ap2;
	@FXML
	private Label header;
	@FXML
	private Label labelN;
	@FXML
	private Label labelCosto;
	@FXML
	private Label labelQ;
	@FXML
	private Label labelT;
	@FXML
	private Label  nome;
	@FXML
	private Label  dispLabel;
	@FXML
	private Label costo;
	@FXML
	private TextField quantita;
	@FXML
	private CheckBox ritiroN;

	@FXML
	private Label totale;
	@FXML
	private Label labelPag;
	@FXML
	private RadioButton buttonCC;
	@FXML
	private RadioButton buttonCash;
	@FXML
	private Button calcola;
	@FXML
	private Button link;

	private ControllerAcquista CA;
	private String scelta;
	private singeltonSystemState vis = singeltonSystemState.getIstance() ;

	
	
	@FXML

	private void pagaCC() throws IOException {
		if(ritiroN.isSelected()) {
		vis.setPickup(true);

		}
		else
		{
		vis.setPickup(true);
		}
		Stage stage;
		Parent root;
		stage = (Stage) buttonCC.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("pagamentoCC.fxml"));
		stage.setTitle("Benvenuto nella schermata dell'acquisto con carta credito");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();


	}

	@FXML
	private void pagaCash() throws IOException, SQLException {
		// String tot=totale.getText();
		// System.out.println("totale :"+tot);

		Stage stage;
		Parent root;
		stage = (Stage) buttonCash.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("pagamentoContrassegno.fxml"));
		stage.setTitle("Benvenuto nella schermata dell'acquisto in contanti");

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	private void initialize() {
		costo.setText("");
		quantita.setText("");
		totale.setText("");
	}

	@FXML
	private void importo() throws IOException, SQLException {
		if (!nome.getText().equals("")) {
			buttonCC.setDisable(false);
			buttonCash.setDisable(false);

			scelta = CA.getType();
			// qui mettere un controllo dal db oer il tipo di prodotto scelto usando l'istanza visualizza
			if (scelta.equals("libro")) {
				float x = CA.totale(nome.getText(), Integer.parseInt(quantita.getText()));
				costo.setText("" + x);
				float tot;
				tot = x * (Float.parseFloat(quantita.getText()));
				totale.setText("" + tot);
				CA.inserisciAmmontareL(tot);
			} else if (scelta.equals("giornale")) {
				labelN.setText("Leggere nome giornale");
				float y = CA.totaleG(nome.getText(), Integer.parseInt(quantita.getText()));
				costo.setText("" + y);

				float tot1;
				tot1 = y * (Float.parseFloat(quantita.getText()));
				totale.setText("" + tot1);
				CA.inserisciAmmontareG(tot1);



			} else if (scelta.equals("rivista")) {
				float z = CA.totaleR(nome.getText(), Integer.parseInt(quantita.getText()));
				costo.setText("" + z);
				float tot2;
				tot2 = z * (Float.parseFloat(quantita.getText()));
				totale.setText("" + tot2);
				CA.inserisciAmmontareR(tot2);

				

			} else {
				throw new IOException();
			}

		}
		//CA.returnSpesa(totale.getText());

	}

	public BoundaryAcquista() throws SQLException {
		CA = new ControllerAcquista();
	}

	@FXML
	private void indietro() throws IOException {
		if( vis.getIsLogged()) {
		Stage stage;
		Parent root;
		stage = (Stage) link.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("homePageAfterLogin.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
		else
		{
			Stage stage;
			Parent root;
			stage = (Stage) link.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		buttonCC.setDisable(true);
		buttonCash.setDisable(true);
		try {
			nome.setText(CA.getNomeById());
			dispLabel.setText(""+CA.getDisp());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
