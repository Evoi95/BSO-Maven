package boundaryLaptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controllerApp.ControllerPassword;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoundaryResetPwd implements Initializable{
	@FXML
	private Pane pane;
	@FXML
	private GridPane grid;
	@FXML
	private Label header;
	@FXML
	private Label emailL;
	@FXML
	private Label vecchiaPL;
	@FXML
	private Label nuovaPL;
	@FXML
	private TextField emailTF;
	@FXML
	private PasswordField vecchiaPF;
	@FXML
	private PasswordField nuovaPF;
	@FXML
	private ImageView image;
	@FXML
	private Button buttonC;
	@FXML
	private Button buttonH;
	
	private ControllerPassword cP;
	
	@FXML
	private void conferma() throws SQLException
	{
		//update pwd
		String email,vecchiaP,nuovaP;
		
		email=emailTF.getText();
		vecchiaP=vecchiaPF.getText();
		nuovaP=nuovaPF.getText();
		cP.aggiornaPass(email,vecchiaP,nuovaP);
		
		
	}
	@FXML
	private void ritorna() throws IOException
	{
		//torna a homePage;
		Stage stage;
		Parent root;
		stage = (Stage) buttonH.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
		stage.setTitle("Benvenuto nella schermata del login");

		// Parent root = FXMLLoader.load(getClass().getResource("compravendita.fxml"));

		Scene scene = new Scene(root);
		stage.setScene(scene);

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
				cP=new ControllerPassword();

	}

}
