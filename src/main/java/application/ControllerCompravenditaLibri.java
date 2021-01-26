package application;

import java.sql.SQLException;

import database.LibroDao;
import factoryBook.Libro;
import factoryBook.Raccolta;
import javafx.collections.ObservableList;

public class ControllerCompravenditaLibri {
	private LibroDao lD;
	private Libro l;
	private int tempIdLib;
	private ControllerVisualizzaLibro CVL;



	public boolean disponibilitaLibro(String i ) throws SQLException {
	
		int id = Integer.parseInt(i);
		
		return lD.checkDisp(l,id);
	}

	public ControllerCompravenditaLibri() {
		lD = new LibroDao();
		CVL = new ControllerVisualizzaLibro();
	//	l = new Libro();
	}

	public ObservableList<Raccolta> getLibri() throws SQLException {
		return lD.getLibri();
	}
	


	
}
