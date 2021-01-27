package application;

import java.sql.SQLException;

import database.GiornaleDao;
import factoryBook.Giornale;
import factoryBook.Raccolta;
import javafx.collections.ObservableList;

public class ControllerCompravenditaGiornali {
	private GiornaleDao gD;
	private Giornale g;

	public ControllerCompravenditaGiornali() {
		gD = new GiornaleDao();
		g = new Giornale();
	}

	public ObservableList<Raccolta> getGiornali() throws SQLException {
		// TODO Auto-generated method stub
		
		return gD.getGiornali();

	}

	public boolean disponibilitaGiornale(String i ) throws SQLException {
		
		int id = Integer.parseInt(i);
		
		return gD.checkDisp(g,id);
	}

}
