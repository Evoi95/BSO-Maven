package controller_app;

import java.sql.SQLException;

import database.RivistaDao;
import factorybook.Raccolta;
import factorybook.Rivista;
import javafx.collections.ObservableList;
import users.singelton.User;

public class ControllerCompravenditaRiviste {
	private RivistaDao rD;
	private Rivista r;
	private static User u=User.getInstance();

	public ControllerCompravenditaRiviste() {
		rD = new RivistaDao();
		r = new Rivista();
	}

	public ObservableList<Raccolta> getRiviste() throws SQLException {
		return rD.getRiviste();
	}
	

	public boolean disponibilitaRiviste(String i ) throws SQLException {
		 int id;

		
		 id = Integer.parseInt(i);
		
		return rD.checkDisp(r,id);
	}

	public String tipoUtente()
	{
		u.setIdRuolo("e");
		return u.getIdRuolo();
	}

}
