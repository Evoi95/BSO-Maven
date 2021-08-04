package boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;

import controller_app.ControllerAddBookPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import logger.Log;

public class BoundaryAddBookPage implements Initializable {
	
	@FXML
	private Pane pane;
	@FXML
	private GridPane gridpane ;
	@FXML
	private TextField titoloT;
	@FXML 
	private TextField numeroPagineT;
	@FXML
	private TextField codeIsbnT;
	@FXML
	private TextField editoreT;
	@FXML
	private TextField autoreT;
	@FXML
	private TextField linguaT;
	@FXML
	private ListView<String> categoriaList ;
	@FXML
	private DatePicker dataP;
	@FXML
	private TextField recensioneT;
	@FXML 
	private TextArea descrizioneA;
	@FXML
	private CheckBox disponibilitaC;
	@FXML
	private TextField prezzoT;
	@FXML
	private TextField copieRimanentiT;
	@FXML
	private Button buttunC;
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
	private Label disponibilitaL;
	@FXML
	private Label prezzoL;
	@FXML
	private Label copieRimanentiL;
	
	private ControllerAddBookPage cABP;
	
	protected int np;
	protected Scene scene; 
	protected float prezzo;
	protected int copie;
	private ObservableList<String> items = FXCollections.observableArrayList();

	@FXML
	private void conferma()
	{
		
		
		String t=titoloT.getText();
		np=Integer.parseInt(numeroPagineT.getText());
		String cod=codeIsbnT.getText();
		String ed=editoreT.getText();
		String a=autoreT.getText();
		String l=linguaT.getText();
		String c= categoriaList.getSelectionModel().getSelectedItem();

		LocalDate d=dataP.getValue();
		String r=recensioneT.getText();
		String desc=descrizioneA.getText();
		boolean disp=disponibilitaC.isPressed();
		
		int dispo;
		
		if(disp)
		{
			dispo=1;
			//disponibile
		}
		else {
			dispo=0;
		}
		prezzo=Float.parseFloat(prezzoT.getText());
		copie=Integer.parseInt(copieRimanentiT.getText());
		
		Log.logger.log(Level.INFO,"Categoria scleta : {0}",c);

		Log.logger.log(Level.INFO,"dispo :{0}",dispo);
		boolean esito=cABP.checkData(t,np,cod,ed,a,l,c,d,r,desc,dispo,prezzo,copie);
		
		Log.logger.log(Level.INFO,"Esito : {0}",esito);

	}
	
	@FXML
	private void annulla() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonA.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("bookPage.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cABP=new ControllerAddBookPage();
		
		categoriaList.setItems(items);

		items.add("ADOLESCENTI_RAGAZZI");
		items.add("ARTE");
		items.add("CINEMA_FOTOGRAFIA");
		items.add("BIOGRAFIE");
		items.add("DIARI_MEMORIE");
		items.add("CALENDARI_AGENDE");
		items.add("DIRITTO");
		items.add("DIZINARI_OPERE");
		items.add("ECONOMIA");
		items.add("FAMIGLIA");
		items.add("SALUTE_BENESSERE");
		items.add("FANTASCIENZA_FANTASY");
		items.add("FUMETTI_MANGA");
		items.add("GIALLI_THRILLER");
		items.add("SELFHELP");
		items.add("COMPUTER_GIOCHI");
		items.add("HUMOR");
		items.add("INFORMATICA");
		items.add("WEB_DIGITAL_MEDIA");
		items.add("LETTERATURA_NARRATIVA");
		items.add("LIBRI_BAMBINI");
		items.add("LIBRI_SCOLASTICI");
		items.add("LIBRI_UNIVERSITARI");
		items.add("RICETTARI_GENERALI");
		items.add("LINGUISTICA_SCRITTURA");
		items.add("POLITICA");
		items.add("RELIGIONE");
		items.add("ROMANZI_ROSA");
		items.add("SCIENZE");
		items.add("TECNOLOGIA_MEDICINA");
		items.add("SPORT");
		items.add("STORIA");
		items.add("TEMPO_LIBERO");
		items.add("VIAGGI");
		items.add("ALTRO");
		
		
		
	     
		
		
		
	}
	
			
}
