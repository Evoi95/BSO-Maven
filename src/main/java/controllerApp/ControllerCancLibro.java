package controllerApp;

import database.LibroDao;
import factoryBook.Libro;

public class ControllerCancLibro {
	
	private LibroDao lD;
	private Libro l;

	public void cancella(int id) {
		l.setId(id);
		lD.cancella(l);
		
		
	}
	
	public ControllerCancLibro()
	{
		lD=new LibroDao();
		l=new Libro();
	}
	

}
