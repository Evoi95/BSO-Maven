package application;

import java.time.LocalDate;

import database.RivistaDao;
import factoryBook.Rivista;

public class ControllerAddRivistaPage {
	private RivistaDao rd;
	private Rivista r;

	public boolean checkData(String t, String tipologia, String a, String l, String ed, String desc, LocalDate data,
			int dispo, float prezzo, int copie) {
		
		if(data.equals(null) )
		{
			return false;

		}
		r.setTitolo(t);
		r.setTipologia(tipologia);
		r.setAutore(a);
		r.setLingua(l);
		r.setEditore(ed);
		r.setDescrizione(desc);
		r.setDataPubb(data);
		r.setDisp(dispo);
		r.setPrezzo(prezzo);
		r.setCopieRim(copie);

		rd.creaRivista(r);

		// TODO Auto-generated method stub
		return true;
	}
	
	public ControllerAddRivistaPage()
	{
		rd=new RivistaDao();
		r=new Rivista();
	}

}
