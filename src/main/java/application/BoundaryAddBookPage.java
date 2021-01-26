package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

public class BoundaryAddBookPage {
	
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
	private ListView categoriaList ;
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
	
	@FXML
	private void conferma()
	{
		
		int nPagine;
		try {
			nPagine= Integer.parseInt(numeroPagineT.getText());
		}
		catch (NumberFormatException e)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("Look, a Warning Dialog");
			alert.setContentText("Careful with the next step!");

			alert.showAndWait();
		}
		/*if (cABP.checkData(titoloT.getText(), nPagine , codeIsbnT.getText(), editoreT.getText(), autoreT.getText(), linguaT.getText(),
				categoriaList, dataP, recensioneT.getText(), descrizioneA.getText(), disponibilitaC, prezzoT.getText(), copieRimanentiT.getText())
		{
			System.out.println(" dati inseriti conrretti");
		}
		else
		{
			System.err.println(" Qualcosa e andato storto");
		}*/
		
	}
	
	@FXML
	private void annulla() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonA.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("bookPage.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
			
}
