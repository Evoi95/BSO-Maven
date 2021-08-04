package boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import controller_app.ControllerAddRivistaPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class BoundaryAddRivistaPage implements Initializable{
	@FXML
	private Pane pane;
	@FXML
	private Label header;
	@FXML
	private GridPane grid;
	@FXML
	private Label labelT;
	@FXML
	private Label labelTipo;
	@FXML
	private Label labelA;
	@FXML
	private Label labelLingua;
	@FXML
	private Label labelE;
	@FXML
	private Label labelDesc;
	@FXML
	private Label labelData;
	@FXML
	private Label labelDisp;
	@FXML
	private Label labelP;
	@FXML
	private Label labelCopie;
	@FXML
	private TextField titoloTF;
	@FXML
	private ListView<String> tipologiaTF;
	@FXML
	private TextField autoreTF;
	@FXML
	private TextField linguaTF;
	@FXML
	private TextField editoreTF;
	@FXML
	private TextArea descTA;
	@FXML
	private DatePicker datePick;
	@FXML
	private CheckBox dispCheck;
	@FXML
	private TextField prezzoTF;
	@FXML
	private TextField copieTF;
	@FXML
	private Button buttonAdd;
	@FXML
	private Button buttonI;
	
	private ControllerAddRivistaPage cARP;
	
	protected Scene scene; 
	protected float prezzo ; 
	protected int copie;
	protected boolean esito ;
	private ObservableList<String> items = FXCollections.observableArrayList();

	
	@FXML
	private void aggiungi()
	{
		int dispo;
		String t=titoloTF.getText();
		String tipologia=tipologiaTF.getSelectionModel().getSelectedItem();
		String a=autoreTF.getText();
		String l=linguaTF.getText();
		String ed=editoreTF.getText();
		String desc=descTA.getText();
		LocalDate data=datePick.getValue();

		boolean disp=dispCheck.isPressed();
		
		
		if(disp)
		{
			dispo=1;
			//disponibile
		}
		else {
			dispo=0;
		}
		prezzo=Float.parseFloat(prezzoTF.getText());
		copie=Integer.parseInt(copieTF.getText());
		
		
		esito= cARP.checkData(t,tipologia,a,l,ed,desc,data,dispo,prezzo,copie);

	}
	@FXML 
	private void torna() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonI.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("rivistaPage.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		 cARP=new ControllerAddRivistaPage ();
		 tipologiaTF.setItems(items);
		 
		 items.add("SETTIMANALE");
		 items.add("BISETTIMANALE");
		 items.add("MENSILE");
		 items.add("BIMESTRALE");
		 items.add("TRIMESTRALE");
		 items.add("ANNUALE");
		 items.add("ESTIVO");
		 items.add("INVERNALE");
		 items.add("SPORTIVO");
		 items.add("CINEMATOGRAFICA");
		 items.add("GOSSIP");
		 items.add("TELEVISIVO");
		 items.add("MILITARE");
		 items.add("INFORMATICA");
		

		 
		
	}
	
	

}
