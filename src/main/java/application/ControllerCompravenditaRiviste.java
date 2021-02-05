package application;

import java.sql.SQLException;

import database.LibroDao;
import database.RivistaDao;
import factoryBook.Raccolta;
import factoryBook.Rivista;
import javafx.collections.ObservableList;
import usersSingelton.User;

public class ControllerCompravenditaRiviste {
	private RivistaDao rD;
	private Rivista R;
	private static User u=User.getInstance();

	public ControllerCompravenditaRiviste() {
		rD = new RivistaDao();
		R = new Rivista();
	}

	public ObservableList<Raccolta> getRiviste() throws SQLException {
		return rD.getRiviste();
	}
	

	public boolean disponibilitaRiviste(String i ) throws SQLException {
		
		int id = Integer.parseInt(i);
		
		return rD.checkDisp(R,id);
	}

	public String tipoUtente()
	{
		return u.getInstance().getIdRuolo();
	}

}
