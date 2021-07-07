package controller_app;


import java.sql.SQLException;

import database.GiornaleDao;
import factorybook.Giornale;
import factorybook.Raccolta;
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

	public ObservableList<Raccolta> getGiornali() throws SQLException  {
		
		
		return gD.getGiornali();

	}

	public boolean disponibilitaGiornale(String i )  {
		int id=0;
		 

		id= Integer.parseInt(i);
		
		return gD.checkDisp(g,id);
	}
	public String tipoUtente()
	{
		u.setIdRuolo("a");
		return u.getIdRuolo();
	}

}
