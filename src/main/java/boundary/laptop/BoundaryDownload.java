package boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;

import com.itextpdf.text.DocumentException;

import controller_app.ControllerDownload;
import controller_app.SingeltonSystemState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import logger.Log;

public class BoundaryDownload implements Initializable {
	@FXML
	private SplitPane split;
	@FXML
	private AnchorPane ap1;
	@FXML
	private Label header;
	@FXML
	private AnchorPane ap2;
	@FXML
	private ImageView image;
	@FXML
	private Button buttonI;
	@FXML
	private Button buttonA;

	private ControllerDownload cD;
	protected Alert a;
	protected Scene scene;

	@FXML
	private void scarica() throws IOException, DocumentException {
		
		a = new Alert(Alert.AlertType.CONFIRMATION);
		a.setTitle("Download effettuato");
		a.setHeaderText("Premere ok per scaricarlo e leggerlo\n");
		Optional<ButtonType> result = a.showAndWait();
		
		
		 if ((result.isPresent()) && (result.get() == ButtonType.OK) && (SingeltonSystemState.getIstance().getIsLogged()))
	        	
	        {
	            Log.logger.log(Level.INFO,"ALL OK..!");
	            
	            cD.scaricaLibro(null);

	            
	            Stage stage;
				Parent root;
				stage = (Stage) buttonA.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();

	        }
	}

	@FXML
	private void pulisci() throws IOException {
		cD.annullaOrdine(null);
		if( SingeltonSystemState.getIstance().getIsLogged()) 
		{
			Stage stage;
			Parent root;
			stage = (Stage) buttonA.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("homePageAfterLogin.fxml"));
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else
		{
			Stage stage;
			Parent root;
			stage = (Stage) buttonA.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
				cD = new ControllerDownload();

	}

}
