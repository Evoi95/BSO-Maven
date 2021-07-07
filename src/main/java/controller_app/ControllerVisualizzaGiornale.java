package controller_app;

import java.sql.SQLException;
import java.util.logging.Level;

import database.GiornaleDao;
import factorybook.Giornale;
import logger.Log;

public class ControllerVisualizzaGiornale {
	
	private GiornaleDao gD;
	private Giornale g;
	
	public ControllerVisualizzaGiornale()
	{
		gD = new GiornaleDao();
	}
	
	public void setID(String i)
	{		
		 int tempIdGior;

		tempIdGior = Integer.parseInt(i) ;
		SingeltonSystemState.getIstance().setId(tempIdGior);
	}
	public int getID()
	{
		Log.logger.log(Level.INFO,"{0}",SingeltonSystemState.getIstance().getId());
		return SingeltonSystemState.getIstance().getId();
	}
	public Giornale getData(int i) throws SQLException 
	{
		// imposto che è un giornale nel controller
		SingeltonSystemState.getIstance().setTypeAsDaily();
		return  gD.getGiornale(g,i);
	}

}
