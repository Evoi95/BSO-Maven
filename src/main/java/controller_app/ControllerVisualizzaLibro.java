package controller_app;

import java.sql.SQLException;
import java.util.logging.Level;

import database.LibroDao;
import factorybook.Libro;
import logger.Log;

public class ControllerVisualizzaLibro {
	
	private LibroDao ld;
	private Libro b;
	private SingeltonSystemState vis = SingeltonSystemState.getIstance() ;
	
	public ControllerVisualizzaLibro()
	{
		ld = new LibroDao();
	}
	public void setID(String i)
	{		 int tempIdLib;
	
		tempIdLib = Integer.parseInt(i) ;
		vis.setId(tempIdLib);
	}
	public int getID()
	{
		Log.logger.log(Level.INFO,"{0}",vis.getId());
		return vis.getId();
	}
	public Libro getData(int i) throws SQLException
	{
		// imposto che è un libro nel controller
		vis.setTypeAsBook();
		return  ld.getLibro(b,i);
	}
}