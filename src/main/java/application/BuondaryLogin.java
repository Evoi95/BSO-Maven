package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BuondaryLogin implements Initializable {
	@FXML
	private Label labelUser, labelPwd,labelB;
	@FXML
	private javafx.scene.layout.GridPane grid;
	@FXML
	private TextField textFieldUsername;
	@FXML
	private PasswordField pwdField;
	@FXML
	private Button buttonI, buttonA;
	@FXML
	private Pane panel;
	@FXML
	private ImageView image;
	@FXML
	private Button buttonReg;
	@FXML
	private Button buttonReset;
	private ControllerLogin cL;

	// private Stage stage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cL = new ControllerLogin();

	}

	@FXML
	private void controllaCredenziali() throws IOException, SQLException {
		
		Boolean v;
		String u="";
		String p="";
		
		u = textFieldUsername.getText();
		p = pwdField.getText();
		

		v=cL.controlla(u,p);

		if (v) {
		
			Stage stage;
			Parent root;
			stage = (Stage) buttonI.getScene().getWindow();
			/*
			 * modificare schermata
			 */
			root = FXMLLoader.load(getClass().getResource("homePageAfterLogin.fxml"));
			stage.setTitle("Benvenuto nella schermata del catalogo libri ");

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} 
		else {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Credenziali errate");// line 2
			alert.setHeaderText("Credenziali non valide ");// line 3
			alert.setContentText(" Per favore registrarsi o reinsci credenziali");// line 4
			alert.showAndWait(); // line 5


		}
	}

	@FXML
	private void annullaCredenziali() throws IOException {
		Stage stage;
		Parent root;
		stage = (Stage) buttonA.getScene().getWindow();
		/*
		 * modificare schermata
		 */
		root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
		stage.setTitle("Benvenuto nella schermata del catalogo libri ");

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	@FXML
	private void register() throws IOException
	{
		/*
		 * carico scehrmata register
		 */
		Stage stage;
		Parent root;
		stage = (Stage) buttonReg.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("bsoRegister.fxml"));
		stage.setTitle("Benvenuto nella schermata del login");

		// Parent root = FXMLLoader.load(getClass().getResource("compravendita.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);

	}
	@FXML
	private void azzeraPwd() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonReg.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("resetPwd.fxml"));
		stage.setTitle("Benvenuto nella schermata del login");

		// Parent root = FXMLLoader.load(getClass().getResource("compravendita.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		
		//Controller password 
//caricare nuocva schermata eccecc
	}
}
