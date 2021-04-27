package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import users.singelton.Editore;
import users.singelton.TempUser;

class TestEditore {
	private Editore e=new Editore(TempUser.getInstance());

	@Test
	void testGetIdRuolo() {
		e.setIdRuolo("e");
		assertEquals("e",e.getIdRuolo());
}

	@Test
	void testSetIdRuolo() {
		e.setIdRuolo("e");
		assertEquals("e",e.getIdRuolo());

	}

	@Test
	void testGetNome() {
		e.setNome("Aldo");
		assertEquals("Aldo",e.getNome());
		}

	@Test
	void testSetNome() {
		e.setCognome("Aldo");
		assertEquals("Aldo",e.getCognome());
		}

	@Test
	void testGetCognome() {
		e.setCognome("Baglio");
		assertEquals("Baglio",e.getCognome());	}

	@Test
	void testSetCognome() {
		e.setCognome("Baglio");
		assertEquals("Baglio",e.getCognome());
		}

	@Test
	void testGetEmail() {
		e.setEmail("AldoBaglio@gmail.com");
		assertEquals("AldoBaglio@gmail.com",e.getEmail());	
		}

	@Test
	void testSetEmail() {

		e.setEmail("AldoBaglio@gmail.com");
		assertEquals("AldoBaglio@gmail.com",e.getEmail());	
		}

	@Test
	void testGetPassword() {
		e.setPassword("Aldo635");
		assertEquals("Aldo635",e.getPassword());
	}

	@Test
	void testSetPassword() {
		e.setPassword("Aldo635");
		assertEquals("Aldo635",e.getPassword());	}

	@Test
	void testGetDescrizione() {
		e.setDescrizione("fa ridere");
		assertEquals("fa ridere",e.getDescrizione());	}

	@Test
	void testSetDescrizione() {
		e.setDescrizione("fa ridere");
		assertEquals("fa ridere",e.getDescrizione());		}

	@Test
	void testGetDataDiNascita() {
		e.setDataDiNascita(LocalDate.of(1987, 6, 5));
		assertEquals(LocalDate.of(1987, 6, 5),e.getDataDiNascita());		}

	@Test
	void testSetDataDiNascita() {
		e.setDataDiNascita(LocalDate.of(1987, 6, 5));
		assertEquals(LocalDate.of(1987, 6, 5),e.getDataDiNascita());	
		}

}
