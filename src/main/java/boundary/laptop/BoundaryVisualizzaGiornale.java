package boundary.laptop;

	import java.io.IOException;
	import java.net.URL;
	import java.sql.SQLException;
	import java.util.ResourceBundle;

import controller_app.ControllerVisualizzaGiornale;
import controller_app.SingeltonSystemState;
import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.fxml.Initializable;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.Pane;
	import javafx.stage.Stage;

	public class BoundaryVisualizzaGiornale implements Initializable {
		
		@FXML
		private Pane pane;
		@FXML
		private GridPane gridpane ;
		@FXML
		private Label labelTitolo;
		@FXML
		private Label labelTipologia;
		@FXML
		private Label labelEditore;
		@FXML
		private Label labelLingua;
		@FXML
		private Label labelDate;
		@FXML
		private Label labelDisp;
		@FXML
		private Label labelPrezzo;
		@FXML
		private Label labelCopieRimanenti;
		@FXML
		private Button buttonBack;
		@FXML
		private Button buttonA;
		@FXML
		private Label titoloL;
		@FXML
		private Label tipologiaL;
		@FXML
		private Label editoreL;
		@FXML
		private Label linguaL;
		@FXML
		private Label dataL;
		@FXML
		private Label disponibbilitaL;
		@FXML
		private Label prezzoL;
		@FXML
		private Label copieRimanentiL;
		
		private ControllerVisualizzaGiornale CVG;
		private int i;
		private SingeltonSystemState vis = SingeltonSystemState.getIstance() ;

		public BoundaryVisualizzaGiornale()
		{
			CVG = new ControllerVisualizzaGiornale();
		}
		
		@FXML
		private void acquista() throws IOException
		{
			
			Stage stage;
			Parent root;
			stage = (Stage) buttonA.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("acquista.fxml"));
			stage.setTitle("Benvenuto nella schermata del riepilogo ordine");

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		@FXML
		private void annulla() throws IOException
		{
			if (!vis.getIstance().getIsSearch()) {
			Stage stage;
			Parent root;
			stage = (Stage) buttonBack.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("compravenditaGiornali.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			}
			else
			{
				Stage stage;
				Parent root;
				stage = (Stage) buttonBack.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("ricercaPage.fxml"));

				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			i = CVG.getID();
			
			try {
				labelTitolo.setText(CVG.getData(i).getTitolo());
				labelEditore.setText(CVG.getData(i).getEditore());
				labelLingua.setText(CVG.getData(i).getLingua());
				labelDate.setText(""+CVG.getData(i).getDataPubb());
				labelDisp.setText(""+CVG.getData(i).getDisponibilita());
				labelPrezzo.setText(CVG.getData(i).getPrezzo()+"");
				labelCopieRimanenti.setText(CVG.getData(i).getCopieRimanenti()+"");
			} catch (SQLException e) {
				
			}
			

		}
		

}



