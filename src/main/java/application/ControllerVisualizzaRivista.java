package application;

import java.sql.SQLException;

import database.RivistaDao;
import factoryBook.Rivista;

public class ControllerVisualizzaRivista {
	
	private RivistaDao rD;
	private Rivista R;
	private int tempIdMag;
	private singeltonVisualizzaLibro vis = singeltonVisualizzaLibro.getIstance() ;
	
	public ControllerVisualizzaRivista()
	{
		rD = new RivistaDao();
	}
	public void setID(String i)
	{		
		tempIdMag = Integer.parseInt(i) ;
		vis.getIstance().setId(tempIdMag);
	}
	public int getID()
	{
		System.out.println(vis.getIstance().getId());
		return vis.getIstance().getId();
	}
	public Rivista getData(int i) throws SQLException
	{
		// imposto che è un libro nel controller
		vis.getIstance().setTypeAsMagazine();
		return  rD.getRivista(R,i);
		//return L;
	}
}
