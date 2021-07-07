package controller_app;

import java.sql.SQLException;
import java.util.logging.Level;

import database.RivistaDao;
import factorybook.Rivista;
import logger.Log;

public class ControllerVisualizzaRivista {
	
	private RivistaDao rD;
	private Rivista r;
	private static SingeltonSystemState vis = SingeltonSystemState.getIstance() ;
	
	public ControllerVisualizzaRivista()
	{
		rD = new RivistaDao();
	}
	public void setID(String i)
	{			 int tempIdMag;

		tempIdMag = Integer.parseInt(i) ;
		vis.setId(tempIdMag);
	}
	public int getID()
	{
		Log.logger.log(Level.INFO,"{0}",vis.getId());
		return vis.getId();
	}
	public Rivista getData(int i) throws SQLException
	{
		// imposto che è un libro nel controller
		vis.setTypeAsMagazine();
		return  rD.getRivista(r,i);
	}
}
