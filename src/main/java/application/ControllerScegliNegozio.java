package application;

import java.sql.SQLException;
import database.NegozioDao;
import javafx.collections.ObservableList;
import negozio.Negozio;

public class ControllerScegliNegozio {
	
	private NegozioDao nD;
	private Negozio N;
	private ObservableList<Negozio> listOfNegozi;
	
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
	
	
	

}
