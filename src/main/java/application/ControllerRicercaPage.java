package application;

import java.sql.SQLException;

import database.*;
import factoryBook.*;
import javafx.collections.ObservableList;

public class ControllerRicercaPage {
	
	private LibroDao lD;
	private Libro L;
	private GiornaleDao gD;
	private Giornale G;
	private RivistaDao rD;
	private Rivista R;
	private int tempId;
	private singeltonSystemState vis = singeltonSystemState.getIstance() ;
	
	public ControllerRicercaPage()
	{
		lD = new LibroDao();
		gD = new GiornaleDao();
		rD =new RivistaDao();
		vis.getIstance().setIsSearch(true);
		
		
	}
	
	public ObservableList<Raccolta> cercaPerTipo (String S) throws SQLException
	{
		//3 if per i tipi 
		if(vis.getIstance().getType().equals("libro"))
		{
			//serach in libro dao
			return lD.getLibriByName(S);
		}
		else if(vis.getIstance().getType().equals("giornale"))
		{
			//search in giornale dao
			return gD.getGiornaliByName(S);
		}
		else if(vis.getIstance().getType().equals("rivista"))
		{
			//search in rivista dao
			return rD.getRivisteByName(S);
		}
		
		return null;
		
	}
	
	public String returnType()
	{
		return vis.getIstance().getType();
	}
	
	
}
