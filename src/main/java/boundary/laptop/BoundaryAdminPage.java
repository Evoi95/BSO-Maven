package boundary.laptop;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class BoundaryAdminPage {
	
	// Finita !
	@FXML
	private Pane pane;
	@FXML
	private Label header ;
	@FXML
	private Button buttonR;
	@FXML
	private Button raccoltaB;
	@FXML 
	private Button buttonU;
	@FXML
	private Button buttonL;
	
	@FXML
	private void logout() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonL.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML 
	private void  raccolta() throws IOException
	{
		/*flusso di report qui*/

		Stage stage;
		Parent root;
		stage = (Stage) raccoltaB.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("raccoltaPage.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void utenti() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonU.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("userPage.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void report() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonR.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("reportPage.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
}
