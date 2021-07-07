package boundary.laptop;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import controller_app.ControllerScegliNegozio;
import controller_app.SingeltonSystemState;
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
	
	private ControllerScegliNegozio cSN;
	protected ObservableList<Negozio> listOfNegozi;
	protected String alertTitle = "Ordine ricevuto!";
	protected String alertHeaderTexr = "Il negozio che hai selezionato ha ricevuto il tuo ordine. \n Presentati dopo 3 giorni lavorativi per ritirare il tuo acquisto";
	protected String alertContentText = "Ricordati di presentarti con le credenziali con le quali accedi al sito e ti verrà consegnato il tuo ordine!\n";
	protected String warningTitle =" Negozio chiuso o non disponibile per il ritiro";
	protected String warningHeaderText = "Il negozio seleziopnato non è al momento pronto per questo tipo di operazioni";
	protected String warningContentText = "Torna indietro e seleziona un'altro negozio fra quelli che ti vengono mostrati ! ";
	protected String homePage = "homePage.fxml";
	protected String homePageA = "homePageAfterLogin.fxml" ;
	protected Boolean r1IsSelected = false;
	protected Boolean r2IsSelected = false;
	protected Boolean r3IsSelected = false;
	protected Boolean r4IsSelected = false;
	protected Boolean statusA = false ;
	protected Boolean statusB = false ;
	
	protected Scene scene;
	protected Alert alert;
	protected Alert alertE;
	protected FXMLLoader loader ;
	
	protected static String attenzione="warningContentText";
	
	public BoundaryScegliNegozio()
	{
		cSN = new ControllerScegliNegozio();
	}
	
	@FXML
	private void verifica() throws IOException, SQLException 
	{
		
		listOfNegozi=cSN.getNegozi();
		
		r1IsSelected = radio1.isSelected();
		r2IsSelected = radio2.isSelected();
		r3IsSelected = radio3.isSelected();
		r4IsSelected = radio4.isSelected();

		if(Boolean.TRUE.equals(r1IsSelected))
		{
			statusA = listOfNegozi.get(0).getIsOpen();
			statusB =  listOfNegozi.get(0).getIsValid();
			
		
			if( statusA && statusB)
			{
				
				procedi();
		        			
		    }
		        else
				{
				
					alertE = new Alert(AlertType.WARNING);
					alertE.setTitle(warningTitle);
					alertE.setHeaderText(warningHeaderText);
					alertE.setContentText(attenzione);
				
				}
			
			
			
		} // qui si chiude check button1
		else if(Boolean.TRUE.equals(r2IsSelected) && Boolean.TRUE.equals( listOfNegozi.get(1).getIsOpen()) && Boolean.TRUE.equals(listOfNegozi.get(1).getIsValid()))
		{
			
				procedi();
		        			
		        }
		        else
				{
				
					alertE = new Alert(AlertType.WARNING);
					alertE.setTitle(warningTitle);
					alertE.setHeaderText(warningHeaderText);
					alertE.setContentText(attenzione);
				}
			
			
			
		 // qui si chiude check button2
		
		if(Boolean.TRUE.equals(r3IsSelected) && Boolean.TRUE.equals(listOfNegozi.get(2).getIsOpen()) && Boolean.TRUE.equals(listOfNegozi.get(2).getIsValid()))
		{
			
			procedi();
				}
				
				
		            //Open another window on clicking the OK button

		        			
		        
		        else
				{
					alertE = new Alert(AlertType.WARNING);
					alertE.setTitle(warningTitle);
					alertE.setHeaderText(warningHeaderText);
					alertE.setContentText(attenzione);
				}
			
			
			
		 // qui si chiude check button1
		
		if(Boolean.TRUE.equals(r4IsSelected) && Boolean.TRUE.equals(listOfNegozi.get(3).getIsOpen()) && Boolean.TRUE.equals(listOfNegozi.get(3).getIsValid()))
		{
			procedi();
		        			
		        }
		        else
				{
					alertE = new Alert(AlertType.WARNING);
					alertE.setTitle(warningTitle);
					alertE.setHeaderText(warningHeaderText);
					alertE.setContentText(attenzione);
				}
			
			
			
		} // qui si chiude check button1

						
	
	
				
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			radio1.setText(cSN.getNegozi().get(0).getNome());
			radio2.setText(cSN.getNegozi().get(1).getNome());
			radio3.setText(cSN.getNegozi().get(2).getNome());
			radio4.setText(cSN.getNegozi().get(3).getNome());
		} catch (SQLException e) {
			e.printStackTrace(); 
			
		}
	}
	
	private void procedi() throws IOException
	{
		alert=new Alert(AlertType.CONFIRMATION);
		alert.setTitle(alertTitle);
		alert.setHeaderText(alertHeaderTexr);
		alert.setContentText(alertContentText);
		Optional<ButtonType> result = alert.showAndWait();
		
        if ((result.isPresent()) && (result.get() == ButtonType.OK) && SingeltonSystemState.getIstance().getIsLogged() )
        	
        {
        	
            	Stage stage;
                Parent root;
                stage = (Stage) buttonV.getScene().getWindow();
                loader = new FXMLLoader(getClass().getResource(homePageA));
                root = loader.load();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
            else {
            	Stage stage;
                Parent root;
                stage = (Stage) buttonV.getScene().getWindow();
                loader = new FXMLLoader(getClass().getResource(homePage));
                root = loader.load();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            	}
		
	}
}
