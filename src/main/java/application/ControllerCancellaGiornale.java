package application;

import database.GiornaleDao;
import factoryBook.Giornale;

public class ControllerCancellaGiornale {
	private Giornale g;
	private GiornaleDao gD;
	
	public void cancella(int id) {
		g.setId(id);
		gD.cancella(g);
		// TODO Auto-generated method stub
		
	}
	
	
	
	public ControllerCancellaGiornale()
	{
		g=new Giornale();
		gD=new GiornaleDao();
	}

}
