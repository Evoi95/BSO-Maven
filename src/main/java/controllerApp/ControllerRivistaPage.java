package controllerApp;

import java.sql.SQLException;

import database.RivistaDao;
import factoryBook.Rivista;
import javafx.collections.ObservableList;

public class ControllerRivistaPage {
	private RivistaDao rd;
	
	public ObservableList<Rivista> getRivistaS() throws SQLException {
		return rd.getRivistaSingolo();
	}
	
	
	public ControllerRivistaPage()
	{
		rd=new RivistaDao();
	}
}
