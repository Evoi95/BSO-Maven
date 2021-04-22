package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import database.GiornaleDao;
import factoryBook.Giornale;

class TestGiornaleDao {
	private GiornaleDao gD=new GiornaleDao();
	private Giornale g=new Giornale();

	@Test
	public void testGetDesc() {
		g.setTitolo("il messagero");
		gD.getDesc(g);
}

	@Test
	public void testGetCosto() {
		g.setTitolo("La republica");
		assertNotEquals(0.0,gD.getCosto(g));
		}

	@Test
	public void testAggiornaDisponibilita() {
		g.setTitolo("La republica");
		g.setDisponibilita(20);
		gD.aggiornaDisponibilita(g);
}

	@Test
	public void testDaiPrivilegi() {
		gD.daiPrivilegi();	}

	@Test
	public void testGetGiornali() {
		assertNotNull(gD.getGiornali());
		}

	@Test
	public void testGetGiornale() {
	//	g.setId(6);
		gD.getGiornale(g,6);
	}

	@Test
	public void testRetId() throws SQLException {
		g.setTitolo("Il Fatto Quotidiano");
		assertNotEquals(0,gD.retId(g));
		}

	@Test
	public void testRetTip() {
		g.setTitolo("il messagero");
		assertNotEquals("",gD.retTip(g));
	}

	@Test
	public void testGetNome() {
		g.setId(7);
		assertNotEquals(0,gD.getNome(g));
	}

	@Test
	public void testGetDisp() {
		g.setId(10);
		assertNotEquals(0,gD.getDisp(g));
	}

	@Test
	public void testGetQuantita() {
		g.setId(3);
		assertNotEquals(0,gD.getQuantita(g));
	}

	@Test
	public void testCheckDisp() {
		g.setId(1);
		assertEquals(false,gD.checkDisp(g, g.getId()));
	}

	@Test
	public void testGetLibriSingolo() {
		assertNotNull(gD.getLibriSingolo());
	}

	@Test
	void testCreaGiornale() {
		g.setTitolo("la gazzetta del profeta");
		g.setTipologia("quotidiano");
		g.setLingua("it");
		g.setEditore("il ministero");
		g.setDataPubb(LocalDate.of(2021, 5, 8));
		g.setCopieRimanenti(250);
		g.setDisponibilita(1);
		g.setPrezzo((float)1.6);
		assertNotEquals(false,gD.creaGiornale(g));
		
	}

	@Test
	public void testCancella() {
		g.setId(5);
		gD.cancella(g);

	}

	@Test
	public void testGetGiornaliSingoloById() {
		g.setId(2);
		assertNotNull(gD.getGiornaliSingoloById(g));

	}

	@Test
	public void testGetGiornaliByName() {
		//faccio per titolo
		g.setTitolo("il messagero");
		try {
			assertNotNull(gD.getGiornaliByName(g.getTitolo()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void testGetGiornaliByName1() {
		g.setEditore("Il Fatto Quotidiano");
		try {
			assertNotNull(gD.getGiornaliByName(g.getEditore()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//faccio per editore

	}

	@Test
	public void testAggiornaGiornale() {
		g.setTitolo("la gazzetta del profeta");
		g.setTipologia("quotidiano");
		g.setLingua("it");
		g.setEditore("il ministero");
		g.setDataPubb(LocalDate.of(2021, 5, 8));
		g.setCopieRimanenti(250);
		g.setDisponibilita(1);
		g.setPrezzo((float)1.6);
		g.setId(6);
		gD.aggiornaGiornale(g);
	}

	@Test
	public void testGeneraReport() {
		gD.generaReport();
}

}
