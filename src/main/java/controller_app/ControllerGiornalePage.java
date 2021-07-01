package controller_app;


import database.GiornaleDao;
import factoryBook.Giornale;
import javafx.collections.ObservableList;

public class ControllerGiornalePage {

	private GiornaleDao gD;
	
	public ObservableList<Giornale> getGiornaliS()  {
		return gD.getLibriSingolo();
	}
	
	
	public ControllerGiornalePage() {
		gD=new GiornaleDao();
	}
}
