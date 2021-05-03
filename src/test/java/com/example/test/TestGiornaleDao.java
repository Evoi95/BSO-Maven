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
	void testGetDesc() {
		g.setTitolo("il messagero");
		gD.getDesc(g);
}

	@Test
	void testGetCosto() {
		g.setTitolo("La republica");
		assertNotEquals(0.0,gD.getCosto(g));
		}

	@Test
	void testAggiornaDisponibilita() {
		g.setTitolo("La republica");
		g.setDisponibilita(20);
		gD.aggiornaDisponibilita(g);
}

	@Test
	void testDaiPrivilegi() {
		gD.daiPrivilegi();	}

	@Test
	void testGetGiornali() {
		assertNotNull(gD.getGiornali());
		}

	@Test
	void testGetGiornale() {
	//	g.setId(6);
		gD.getGiornale(g,6);
	}

	@Test
	void testRetId() throws SQLException {
		g.setTitolo("Il Fatto Quotidiano");
		assertNotEquals(0,gD.retId(g));
		}

	@Test
	void testRetTip() {
		g.setTitolo("il messagero");
		assertNotEquals("",gD.retTip(g));
	}

	@Test
	void testGetNome() {
		g.setId(7);
		assertNotEquals(0,gD.getNome(g));
	}

	@Test
	void testGetDisp() {
		g.setId(10);
		assertNotEquals(0,gD.getDisp(g));
	}

	@Test
	void testGetQuantita() {
		g.setId(3);
		assertNotEquals(0,gD.getQuantita(g));
	}

	@Test
	void testCheckDisp() {
		g.setId(1);
		assertEquals(false,gD.checkDisp(g, g.getId()));
	}

	@Test
	void testGetLibriSingolo() {
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
	void testCancella() {
		g.setId(5);
		gD.cancella(g);

	}

	@Test
	void testGetGiornaliSingoloById() {
		g.setId(2);
		assertNotNull(gD.getGiornaliSingoloById(g));

	}

	@Test
	void testGetGiornaliByName() {
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
	void testGetGiornaliByName1() {
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
	void testAggiornaGiornale() {
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
	void testGeneraReport() {
		gD.generaReport();
}

}
