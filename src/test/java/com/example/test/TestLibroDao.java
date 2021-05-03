package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import database.LibroDao;
import factoryBook.Libro;

class TestLibroDao {
	private LibroDao lD=new LibroDao();
	private Libro l=new Libro();

	@Test
	void testGetDesc() {
		l.setCodIsbn("8817061622");
		try {
			lD.getDesc(l);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetCosto() {
		l.setId(6);
		try {
			assertNotEquals(0.0,lD.getCosto(l));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testAggiornaDisponibilita() {
		l.setId(2);
		l.setCopieRim(2);
		try {
			lD.aggiornaDisponibilita(l);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testDaiPrivilegi() {
		try {
			lD.daiPrivilegi();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetLibri() {
		try {
			assertNotNull(lD.getLibri());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetLibriByName() {
		//titolo
		l.setTitolo("Scheletri");
		try {
			assertNotNull(lD.getLibriByName(l.getTitolo()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void testGetLibriByName1() throws SQLException {
		//autore
		l.setAutore("mondadori");
		assertNotNull(lD.getLibriByName(l.getAutore()));

		
	}

	@Test
	void testGetLibro() throws SQLException {
		l.setId(5);
		assertNotNull(lD.getLibro(l,l.getId()));
	}

	@Test
	void testRetId() throws SQLException {
		l.setCodIsbn("1722235608");
		assertNotEquals(0,lD.retId(l));
	}

	@Test
	void testRetTip() throws SQLException {
		l.setCodIsbn("1722235608");
		assertNotNull(lD.retTip(l));

	}

	@Test
	void testAggiornaCopieVendute() throws SQLException {
		l.setCodIsbn("1722235608");
		lD.aggiornaCopieVendute(l, 6);
	}

	@Test
	void testCreaLibrio() {
		
		//String x=UUID.randomUUID().toString().length()=10;
		l.setTitolo("ricette culinarie facili ");
		l.setNumPag(50);		
		l.setCodIsbn("8835238150");
		l.setEditore("garzanti");
		l.setAutore("garzanti");
		l.setLingua("italiana");
		l.setCategoria("culinaria");
		l.setDataPubb(LocalDate.of(2015,11 ,25));
		l.setRecensione("ricette facili, squisite e veloci");
		l.setNrCopie(200);
		l.setDesc("se cominci... non smetti piu");
		l.setDisponibilita(1);
		l.setPrezzo((float)12.5);
		l.setCopieRim(57);
		assertNotNull(lD.creaLibrio(l));
	}

	@Test
	void testGetDisp() throws SQLException {
		l.setId(4);
		assertNotEquals(-1,lD.getDisp(l));
		
	}

	@Test
	void testGetQuantita() throws SQLException {
		l.setId(6);
		assertNotEquals(0,lD.getQuantita(l));
	}

	@Test
	void testCheckDisp() throws SQLException {
		l.setId(1);
		assertNotEquals(0,lD.checkDisp(l,l.getId()));
	}

	@Test
	void testGetNome() throws SQLException {
		l.setId(3);
		assertNotNull(lD.getNome(l));
	}

	@Test
	void testGetLibriSingolo() throws SQLException {
		assertNotNull(lD.getLibriSingolo());
	}

	@Test
	void testCancella() {
		l.setId(15);
		lD.cancella(l);
	}

	@Test
	void testGetLibriSingoloById() throws SQLException {
		l.setId(4);
		assertNotNull(lD.getLibriSingoloById(l));
	}

	@Test
	void testAggiornaLibro() throws NullPointerException, SQLException {
		l.setTitolo("ricette culinarie facili ");
		l.setNumPag(50);
		l.setCodIsbn("8845133250");
		l.setEditore("garzanti");
		l.setAutore("garzanti");
		l.setLingua("italiana");
		l.setCategoria("culinaria");
		l.setDataPubb(LocalDate.of(2015,11 ,25));
		l.setRecensione("ricette facili, squisite e veloci");
		l.setNrCopie(200);
		l.setDesc("se cominci... non smetti piu");
		l.setDisponibilita(1);
		l.setPrezzo((float)12.5);
		l.setCopieRim(57);
		l.setId(20);
		lD.aggiornaLibro(l);
	}

	@Test
	void testGeneraReport() throws SQLException, IOException {
		lD.generaReport();
	}

}
