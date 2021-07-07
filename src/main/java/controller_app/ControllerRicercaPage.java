package controller_app;

import java.sql.SQLException;
import java.util.logging.Level;

import database.*;
import factorybook.*;
import javafx.collections.ObservableList;
import logger.Log;

public class ControllerRicercaPage {
	
	private LibroDao lD;
	private GiornaleDao gD;
	private RivistaDao rD;
	public ControllerRicercaPage()
	{
		lD = new LibroDao();
		gD = new GiornaleDao();
		rD =new RivistaDao();
		SingeltonSystemState.getIstance().setIsSearch(true);
		Log.logger.log(Level.INFO,"vis nel costruttore {0}",SingeltonSystemState.getIstance());
		
	}
	
	public ObservableList<Raccolta> cercaPerTipo (String s) throws SQLException
	{
		Log.logger.log(Level.INFO,"Tipo e confronto : {0}",SingeltonSystemState.getIstance().getType().equals("libro"));
		if(SingeltonSystemState.getIstance().getType().equals("libro"))
		{
			//serach in libro dao
			return lD.getLibriByName(s);
		}
		else if(SingeltonSystemState.getIstance().getType().equals("giornale"))
		{
			//search in giornale dao
			return gD.getGiornaliByName(s);
		}
		else if(SingeltonSystemState.getIstance().getType().equals("rivista"))
		{
			//search in rivista dao
			return rD.getRivisteByName(s);
		}
		
		return null;
		
	}
	
	public String returnType()
	{
		return SingeltonSystemState.getIstance().getType();
	}
	
	
}
