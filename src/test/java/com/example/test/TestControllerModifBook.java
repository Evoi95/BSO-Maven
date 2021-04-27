package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controller_app.ControllerModifBook;
import factoryBook.Factory;
import factoryBook.Libro;

class TestControllerModifBook {
	private Libro l;
	private ControllerModifBook cMB=new ControllerModifBook();

	@Test
	void testGetLibriById() {
		l=new Libro();
		l.setId(5);
		try {
			assertNotNull(cMB.getLibriById(l.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testCheckData() throws NullPointerException, SQLException {
		l=new Libro();
		l.setTitolo("aaa");
		l.setNumPag(1500);
		l.setCodIsbn("000015260");
		l.setEditore("bbb");
		l.setEditore("mondadori");
		l.setLingua("Italiana");
		l.setCategoria("articolo cronaca");
		l.setDataPubb(LocalDate.of(1987, 5, 6));
		l.setRecensione("illuminante dal punto di vista filosofico");
		l.setNrCopie(150);
		l.setDesc(" occhio a non perdersi tra le righe");
		l.setDisponibilita(1);
		l.setPrezzo((float)15.36);
		l.setCopieRim(300);
		l.setId(20);
		cMB.checkData(l.getTitolo(),l.getNumPag(),l.getCodIsbn(),l.getEditore(), l.getAutore(),l.getLingua(), l.getCategoria(),l.getDataPubb(), l.getRecensione(),l.getDisponibilita(),l.getPrezzo(),l.getCopieRim(),l.getId());
	}

}
