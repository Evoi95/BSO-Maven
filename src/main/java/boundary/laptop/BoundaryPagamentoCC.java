package boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;

import controller_app.ControllerPagamentoCC;
import controller_app.SingeltonSystemState;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import pagamento.CartaCredito;
import logger.Log;

public class BoundaryPagamentoCC implements Initializable {

	@FXML
	private Pane panel;
	@FXML
	private GridPane grid;
	@FXML
	private Label header;
	@FXML
	private Label labelN;
	@FXML
	private Label labelC;
	@FXML
	private Label cartaC;
	@FXML
	private Label labelS;
	@FXML
	private TextField nomeTF;
	@FXML
	private TextField cognomeTF;
	@FXML
	private TextField codiceTF;
	@FXML
	private TextField scadTF;
	@FXML
	private Button buttonI;
	@FXML
	private Button buttonA;

	@FXML
	private Label labelCiv;
	@FXML
	private Button buttonReg;

	@FXML
	private TextField nomeInput;
	@FXML
	private RadioButton buttonPrendi;

	@FXML
	private PasswordField codiceTFCiv;

	@FXML
	private TableView<CartaCredito> tableCC;
	@FXML
	private TableColumn<CartaCredito, SimpleStringProperty> codiceCC = new TableColumn<>("CodiceCarta");
	@FXML
	private Label labelNU;

	private ControllerPagamentoCC cPCC;
	protected Boolean esito;
	protected Scene scene;
	protected java.sql.Date sql;
	protected SimpleDateFormat formatter;
	private static SingeltonSystemState vis = SingeltonSystemState.getIstance();

	@FXML
	private void procediCC() throws IOException {

		String cod = codiceTF.getText();
		String civ=codiceTFCiv.getText();
		
		
		esito = cPCC.controllaPag(scadTF.getText(), cod,civ);
		
		if (Boolean.TRUE.equals(esito)) {
			if(vis.getIstance().getIsPickup()) 
			{
				Stage stage;
				Parent root;
				stage = (Stage) buttonI.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("scegliNegozio.fxml"));
				stage.setTitle("Benvenuto nella schermata per il download");
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();	
			}
			else
			{
			Stage stage;
			Parent root;
			stage = (Stage) buttonI.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("download.fxml"));
			stage.setTitle("Benvenuto nella schermata per il download");
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			}
		} else {
			Log.logger.log(Level.INFO,"riprovare");
			Stage stage;
			Parent root;
			stage = (Stage) buttonI.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("PagamentoCC.fxml"));

			stage.setTitle("Benvenuto nella schermata per il pagamento");

			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

	}

	@FXML
	private void annullaCC() throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) buttonA.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("acquista.fxml"));
		stage.setTitle("benvenuto nella schermata del riepilogo ordine");

		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public BoundaryPagamentoCC()  {
		try {
			cPCC = new ControllerPagamentoCC();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@FXML
	public void registraCC() throws java.text.ParseException, SQLException {
		java.util.Date data = null;

		String nome = nomeTF.getText();

		String cognome = cognomeTF.getText();
		String codice = codiceTF.getText();
		String d = scadTF.getText();

		formatter = new SimpleDateFormat("yyyy/mm/dd");
		data = formatter.parse(d);
		sql = new java.sql.Date(data.getTime());

		String civ = codiceTFCiv.getText();

		cPCC.aggiungiCartaDB(nome, cognome, codice, sql, civ, (float) 0.0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		codiceCC.setCellValueFactory(new PropertyValueFactory<>("numeroCC"));
		if(!vis.getIstance().getIsLogged())
		{
			buttonPrendi.setDisable(true);
			buttonReg.setDisable(true);
		}


	}

	@FXML
	private void popolaTabella() throws SQLException {
		try {

			String nomeUt = nomeInput.getText();
			Log.logger.log(Level.INFO,"Nome utemte : {0}",nomeUt);
			if (nomeUt.equals("")) {
				buttonPrendi.setDisable(true);
				throw new IOException();
			}
			else {
				buttonPrendi.setDisable(false);
				tableCC.setItems(cPCC.ritornaElencoCC(nomeUt));
			}
		} catch (IOException e) {
			e.getMessage();
		}
		buttonPrendi.setDisable(false);
	}

	@FXML
	private void prova() throws SQLException
	{
		nomeTF.setText(cPCC.tornaDalDb(tableCC.getSelectionModel().getSelectedItem().getNumeroCC()).getUserNome());
		cognomeTF.setText(cPCC.tornaDalDb(tableCC.getSelectionModel().getSelectedItem().getNumeroCC()).getUserCognome());
		codiceTF.setText(cPCC.tornaDalDb(tableCC.getSelectionModel().getSelectedItem().getNumeroCC()).getNumeroCC());
		scadTF.setText(cPCC.tornaDalDb(tableCC.getSelectionModel().getSelectedItem().getNumeroCC()).getScadenza().toString());


	}
}
