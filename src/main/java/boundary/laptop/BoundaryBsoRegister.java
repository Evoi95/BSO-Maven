package boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;

import controller_app.ControllerBsoRegister;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logger.Log;


public class BoundaryBsoRegister implements Initializable {
	@FXML
	private Pane pane;
	@FXML
	private GridPane grid;
	@FXML
	private ImageView image;
	@FXML 
	private Label nomeL;
	@FXML
	private Label cognomeL;
	@FXML
	private Label emailL;
	@FXML
	private Label passwordL;
	@FXML
	private Label confermaPassL;
	@FXML
	private TextField nomeTF;
	@FXML
	private TextField cognomeTF;
	@FXML
	private TextField emailTF;	
	@FXML
	private PasswordField passwordTF;
	@FXML
	private PasswordField passCheckTF;
	@FXML
	private Button buttonReg;
	@FXML
	private Button buttonA;
	@FXML
	private Label dataL;
	@FXML 
	private DatePicker calendarL;
	protected Scene scene;
	protected Alert alert;
	protected Boolean state;
	protected String message;	
	private ControllerBsoRegister cR;

	
	@FXML
	private void procedi() throws IOException, SQLException {
		LocalDate data=calendarL.getValue();
		Log.logger.log(Level.INFO,"Data {0}",data);
		state = cR.registra(nomeTF.getText(),cognomeTF.getText(),emailTF.getText(),passwordTF.getText(),passCheckTF.getText(),data);
		if(Boolean.TRUE.equals(state)) // cosi' controllo e includo i casi di false e null
		{

			message = calendarL.getValue().toString();
			Log.logger.log(Level.INFO,"Data inserita in procedi : {0}",message);
			Stage stage;
			Parent root;
			stage = (Stage) buttonReg.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("registrazioneOk.fxml"));
			stage.setTitle("Registazione andata a buon fine");

			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();


		}
		else {
			alert=new Alert(AlertType.ERROR);
			alert.setTitle("Credenziali errate");// line 2
			alert.setHeaderText("Credenziali non valide ");// line 3
			alert.setContentText(" Per favore reiimetterle");// line 4
			alert.showAndWait(); // line 5

		}
		
		
				
	}
	@FXML
	private void annulla() throws IOException
	{
		
		Stage stage;
		Parent root;
		stage = (Stage) buttonA.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
		stage.setTitle("Registazione andata a buon fine");

		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
				cR=new ControllerBsoRegister();

	}
	
	

}
