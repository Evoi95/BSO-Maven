package application;

import java.sql.SQLException;

import database.LibroDao;
import factoryBook.Libro;

public class ControllerVisualizzaLibro {
	
	private LibroDao ld;
	private Libro b;
	private int tempIdLib;
	private singeltonSystemState vis = singeltonSystemState.getIstance() ;
	
	public ControllerVisualizzaLibro()
	{
		ld = new LibroDao();
	}
	public void setID(String i)
	{		
		tempIdLib = Integer.parseInt(i) ;
		vis.getIstance().setId(tempIdLib);
	}
	public int getID()
	{
		System.out.println(vis.getIstance().getId());
		return vis.getIstance().getId();
	}
	public Libro getData(int i) throws SQLException
	{
		// imposto che è un libro nel controller
		vis.getIstance().setTypeAsBook();
		return  ld.getLibro(b,i);
		//return L;
	}
}