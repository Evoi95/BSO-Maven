package controllerApp;

import java.sql.SQLException;

import database.GiornaleDao;
import factoryBook.Giornale;
import factoryBook.Raccolta;
import javafx.collections.ObservableList;
import users.singelton.User;

public class ControllerCompravenditaGiornali {
	private GiornaleDao gD;
	private Giornale g;
	private User u=User.getInstance();

	public ControllerCompravenditaGiornali() {
		gD = new GiornaleDao();
		g = new Giornale();
	}

	public ObservableList<Raccolta> getGiornali() throws SQLException {
		
		
		return gD.getGiornali();

	}

	public boolean disponibilitaGiornale(String i ) throws SQLException {
		
		int id = Integer.parseInt(i);
		
		return gD.checkDisp(g,id);
	}
	public String tipoUtente()
	{
		u.setIdRuolo("a");
		return u.getIdRuolo();
	}

}
