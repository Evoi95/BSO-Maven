package controller_app;

import database.RivistaDao;
import factorybook.Rivista;

public class ControllerCancellaRivista {
	private Rivista r;
	private RivistaDao rd;

	public void cancella(int id) {
		r.setId(id);
		rd.cancella(r);
		
		
		
	}
	public ControllerCancellaRivista()
	{
		r=new Rivista();
		rd=new RivistaDao();
	}

}
