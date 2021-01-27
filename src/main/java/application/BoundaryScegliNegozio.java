package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import negozio.Negozio;

public class BoundaryScegliNegozio implements Initializable {
	
	@FXML
	private Label labelL;
	@FXML
	private Pane pane;
	@FXML
	private RadioButton radio1;
	@FXML
	private RadioButton radio2;
	@FXML
	private RadioButton radio3;
	@FXML
	private RadioButton radio4;
	@FXML
	private Button buttonV;
	
	private ControllerScegliNegozio CSN;
	private ObservableList<Negozio> listOfNegozi;
	private singeltonSystemState vis = singeltonSystemState.getIstance() ;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public BoundaryScegliNegozio()
	{
		CSN = new ControllerScegliNegozio();
	}
	
	@FXML
	private void verifica() throws SQLException, IOException 
	{
		listOfNegozi = CSN.getNegozi();
		if(radio1.isSelected()) 
		{
			if (listOfNegozi.get(0).getIsOpen() && listOfNegozi.get(0).getIsValid())
			{
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Ordine ricevuto!");
				alert.setHeaderText("Il negozio che hai selezionato ha ricevuto il tuo ordine. \n Presentati dopo 3 giorni lavorativi per ritirare il tuo acquisto");
				alert.setContentText("Ricordati di presentarti con le credenziali con le quali accedi al sito e ti verrà consegnato il tuo ordine!");
				alert.showAndWait();
			}	
			else
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Negozio chiuso o non disponibile per il ritiro");
				alert.setHeaderText("Il negozio seleziopnato non è al momento pronto per questo tipo di operazioni");
				alert.setContentText("torna indietro e seleziona un'altro negozio fra quelli che ti vengono mostrati ! ");
				alert.showAndWait();
			}
			//do things
		}
		else if(radio2.isSelected())
		{
			if (listOfNegozi.get(1).getIsOpen() && listOfNegozi.get(1).getIsValid())
			{
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Ordine ricevuto!");
				alert.setHeaderText("Il negozio che hai selezionato ha ricevuto il tuo ordine. \n Presentati dopo 3 giorni lavorativi per ritirare il tuo acquisto");
				alert.setContentText("Ricordati di presentarti con le credenziali con le quali accedi al sito e ti verrà consegnato il tuo ordine!");
				alert.showAndWait();
			}	
			else
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Negozio chiuso o non disponibile per il ritiro");
				alert.setHeaderText("Il negozio seleziopnato non è al momento pronto per questo tipo di operazioni");
				alert.setContentText("torna indietro e seleziona un'altro negozio fra quelli che ti vengono mostrati ! ");
				alert.showAndWait();
			}		}
		else if(radio3.isSelected())
		{
			if (listOfNegozi.get(2).getIsOpen() && listOfNegozi.get(2).getIsValid())
			{
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Ordine ricevuto!");
				alert.setHeaderText("Il negozio che hai selezionato ha ricevuto il tuo ordine. \n Presentati dopo 3 giorni lavorativi per ritirare il tuo acquisto");
				alert.setContentText("Ricordati di presentarti con le credenziali con le quali accedi al sito e ti verrà consegnato il tuo ordine!");
				alert.showAndWait();
			}	
			else
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Negozio chiuso o non disponibile per il ritiro");
				alert.setHeaderText("Il negozio seleziopnato non è al momento pronto per questo tipo di operazioni");
				alert.setContentText("torna indietro e seleziona un'altro negozio fra quelli che ti vengono mostrati ! ");
				alert.showAndWait();
			}
		}
		else if(radio4.isSelected())
		{
			if (listOfNegozi.get(3).getIsOpen() && listOfNegozi.get(3).getIsValid())
			{
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Ordine ricevuto!");
				alert.setHeaderText("Il negozio che hai selezionato ha ricevuto il tuo ordine. \n Presentati dopo 3 giorni lavorativi per ritirare il tuo acquisto");
				alert.setContentText("Ricordati di presentarti con le credenziali con le quali accedi al sito e ti verrà consegnato il tuo ordine!");
				Optional<ButtonType> result = alert.showAndWait();
				ButtonType resButton = result.orElse(null);
				if(vis.getIstance().getIsLogged())	
				{
					//FXMLLoader loader = new FXMLLoader(getClass().getResource("homePageAfterLogin.fxml"));
					//Parent root = loader.load();
//					Object page = FXMLLoader.load(getClass().getResource("homePageAfterLogin.fxml"));
//					Parent root = page.load();
//
//					Scene scene = new Scene(root);
//					primaryStage.setScene(scene);
//					primaryStage.show();
					root = FXMLLoader.load(getClass().getResource("homePageAfterLogin.fxml"));
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				}
				else
				{
//					FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));
//					Parent root = loader.load();
					root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
					scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
				}
			}	
			else
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Negozio chiuso o non disponibile per il ritiro");
				alert.setHeaderText("Il negozio seleziopnato non è al momento pronto per questo tipo di operazioni");
				alert.setContentText("torna indietro e seleziona un'altro negozio fra quelli che ti vengono mostrati ! ");
				alert.showAndWait();
			}
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			radio1.setText(CSN.getNegozi().get(0).getNome());
			radio2.setText(CSN.getNegozi().get(1).getNome());
			radio3.setText(CSN.getNegozi().get(2).getNome());
			radio4.setText(CSN.getNegozi().get(3).getNome());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
