package controllerApp;

import java.sql.SQLException;
import database.NegozioDao;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import negozio.Negozio;

public class ControllerScegliNegozio {
	
	private NegozioDao nD;
	private Negozio N;
	private ObservableList<Negozio> listOfNegozi;
	private SingeltonSystemState vis = SingeltonSystemState.getIstance() ;

	
	public ControllerScegliNegozio()
	{
		nD = new NegozioDao();
		N = new Negozio();
	}
	
	public ObservableList<Negozio> getNegozi() throws SQLException
	{
		listOfNegozi = nD.getNegozi();
		return listOfNegozi;
	}
	
	public boolean isLogged()
	{
		return vis.getIsLogged();
	}
}