package controllerApp;

import java.sql.SQLException;

import database.LibroDao;
import factoryBook.Libro;
import factoryBook.Raccolta;
import javafx.collections.ObservableList;

public class ControllerBookPage {
	private LibroDao lD;
	
	public ObservableList<Libro> getLibriS() throws SQLException {
		return lD.getLibriSingolo();
	}
	
	public ControllerBookPage()
	{
		lD=new LibroDao();
	}
	

}
