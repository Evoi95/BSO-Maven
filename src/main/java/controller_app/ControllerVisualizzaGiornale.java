package controller_app;

import java.sql.SQLException;
import java.util.logging.Level;

import database.GiornaleDao;
import factoryBook.Giornale;
import logger.Log;

public class ControllerVisualizzaGiornale {
	
	private GiornaleDao gD;
	private Giornale g;
	private int tempIdGior;
	private SingeltonSystemState vis = SingeltonSystemState.getIstance() ;
	
	public ControllerVisualizzaGiornale()
	{
		gD = new GiornaleDao();
	}
	
	public void setID(String i)
	{		
		tempIdGior = Integer.parseInt(i) ;
		vis.getIstance().setId(tempIdGior);
	}
	public int getID()
	{
		Log.logger.log(Level.INFO,"{0}",vis.getIstance().getId());
		return vis.getIstance().getId();
	}
	public Giornale getData(int i) throws SQLException
	{
		// imposto che è un giornale nel controller
		vis.getIstance().setTypeAsDaily();
		return  gD.getGiornale(g,i);
	}

}
