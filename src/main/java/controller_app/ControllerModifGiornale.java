package controller_app;

import java.sql.SQLException;
import java.time.LocalDate;

import database.GiornaleDao;
import factoryBook.Giornale;
import factoryBook.Libro;
import javafx.collections.ObservableList;

public class ControllerModifGiornale {
	private GiornaleDao gd;
	private Giornale g;
	
	public ObservableList<Giornale> getGiornaliById(int id) throws SQLException {
		g.setId(id);
		return gd.getGiornaliSingoloById(g);
	}
	
		
		public boolean checkData(String titolo, String tipo, String ed, String l, LocalDate d, int dispo, float prezzo,
				int copie,int id) throws SQLException {
			g.setTitolo(titolo);
			g.setTipologia(tipo);
			g.setEditore(ed);
			g.setLingua(l);
			g.setDataPubb(d);
			g.setDisponibilita(dispo);
			g.setPrezzo(prezzo);
			g.setCopieRimanenti(copie);
			g.setId(id);
			gd.aggiornaGiornale(g);
			
			return true;
		}
		
		public ControllerModifGiornale()
		{
			gd=new GiornaleDao();
			g=new Giornale();
		}
	


}
