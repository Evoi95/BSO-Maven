package application;

import database.RivistaDao;
import factoryBook.Rivista;

public class ControllerCancellaRivista {
	private Rivista r;
	private RivistaDao rd;

	public void cancella(int id) {
		r.setId(id);
		rd.cancella(r);
		
		// TODO Auto-generated method stub
		
	}
	public ControllerCancellaRivista()
	{
		r=new Rivista();
		rd=new RivistaDao();
	}

}
