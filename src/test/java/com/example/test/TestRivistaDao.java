package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import database.RivistaDao;
import factoryBook.Rivista;

class TestRivistaDao {
	private RivistaDao rd=new RivistaDao();
	private Rivista r=new Rivista();
	private boolean state=false;

	@Test
	void testGetDesc() {
		r.setTitolo("cioe");
		rd.getDesc(r);
	}

	@Test
	void testGetCosto() throws SQLException {
		float prezzo=0;
		r.setTitolo("focus");
		prezzo=rd.getCosto(r);
		assertNotEquals(0,prezzo);
	}

	@Test
	void testAggiornaDisponibilita() {
		r.setTitolo("cioe");
		r.setCopieRim(100);
		try {
			rd.aggiornaDisponibilita(r);
		} catch (SQLException e) {
		 
			
		}
	}

	@Test
	void testDaiPrivilegi() {
		try {
			rd.daiPrivilegi();
		} catch (SQLException e) {
		 
			
		}	
		}

	@Test
	void testGetRiviste() {
		try {
			state=rd.getRiviste().isEmpty();
		} catch (SQLException e) {
		 
			
		}
		assertNotEquals(true,state);
		
	}

	@Test
	void testGetRivisteByName() {
		//r.setAutore("garzanti");
		r.setTitolo("cioe");
		try {
			state=rd.getRivistaSingoloById(r).isEmpty();
		} catch (SQLException e) {
		 
			
		}
		assertNotEquals(true,state);
	}

	@Test
	void testGetRivista() {
		r.setId(2);
		try {
			assertNotNull(rd.getRivista(r, r.getId()));
		} catch (SQLException e) {
		 
			
		}

	}

	@Test
	void testRetId() {
		r.setTitolo("Rivista A");
		int status = 0;
		try {
			status=rd.retId(r);
		} catch (SQLException e) {
		 
			
		}
		assertNotEquals(0,status);
	}

	@Test
	void testRetTip() {
		String tipo=null;
		r.setTitolo("Rivista B");
		try {
			tipo=rd.retTip(r);
		} catch (SQLException e) {
		 
			
		}
		assertEquals("sportivo",tipo);
	}

	@Test
	void testGetNome() {
		String nome=null;
		r.setId(2);
		try {
			nome=rd.getNome(r);
		} catch (SQLException e) {
		 
			
		}
		assertNotNull(nome);
		
	}

	@Test
	void testGetDisp() {
		int disp=0;
		r.setId(1);
		try {
			disp=rd.getDisp(r);
		} catch (SQLException e) {
		 
			
		}
		assertNotEquals(0,disp);
	}

	@Test
	void testGetQuantita() {
		int quantita=0;
		r.setId(5);
		try {
			quantita=rd.getQuantita(r);
		} catch (SQLException e) {
		 
			
		}
		assertNotEquals(0,quantita);
		
	}

	@Test
	void testCheckDisp() {
		r.setId(5);
		try {
			state=rd.checkDisp(r, r.getId());
		} catch (SQLException e) {
		 
			
		}
		//String x=""+state;
		assertEquals(true,state);	
		}

	@Test
	void testGetRivistaSingolo() {
		
		try {
			state=rd.getRivistaSingolo().isEmpty();
		} catch (SQLException e) {
		 
			
		}
		assertNotEquals(true,state);
	}

	@Test
	void testCreaRivista() {
		r.setTitolo("focus");
		r.setTipologia("fantascienza");
		r.setAutore("mondadori");
		r.setLingua("italiano");
		r.setEditore("mondadori");
		r.setDescrizione("Principali eventi scientifici");
		r.setDataPubb(LocalDate.of(2021, 5, 1));
		r.setDisp(1);
		r.setPrezzo((float)1.30);
		r.setCopieRim(200);
		state=rd.creaRivista(r);
		assertEquals(true,state);
	}

	@Test
	void testCancella() {
		r.setId(3);
		rd.cancella(r);
	}

	@Test
	void testGetRivistaSingoloById() {
		try {
			assertNotNull(rd.getRivistaSingoloById(r));
		} catch (SQLException e) {
		 
			
		}
	}

	@Test
	void testAggiornaRivista() {
		r.setTitolo("focus");
		r.setTipologia("fantascienza");
		r.setAutore("mondadori");
		r.setLingua("italiano");
		r.setEditore("mondadori");
		r.setDescrizione("Principali eventi scientifici");
		r.setDataPubb(LocalDate.of(2021, 5, 1));
		r.setDisp(1);
		r.setPrezzo((float)1.30);
		r.setCopieRim(200);
		r.setId(4);
		try {
			rd.aggiornaRivista(r);
		} catch (SQLException e) {
		 
			
		}
		}

	@Test
	void testGeneraReport() {
		try {
			rd.generaReport();
		} catch (SQLException | IOException e) {
		 
			
		}
	}

}
