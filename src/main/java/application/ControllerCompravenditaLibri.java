package application;

import java.sql.SQLException;

import database.LibroDao;
import factoryBook.Libro;
import factoryBook.Raccolta;
import javafx.collections.ObservableList;
import usersSingelton.User;

public class ControllerCompravenditaLibri {
	private LibroDao lD;
	private Libro l;
	private int tempIdLib;
	private ControllerVisualizzaLibro CVL;
	private static User u=User.getInstance();



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
	
	public String retTipoUser()
	{
		
		// usato per torare tipo utente e 
		//switchare schermata opportuna
		return u.getInstance().getIdRuolo();
	}


	
}
