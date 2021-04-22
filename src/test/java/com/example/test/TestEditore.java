package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import users.singelton.Editore;
import users.singelton.TempUser;

class TestEditore {
	private Editore e=new Editore(TempUser.getInstance());

	@Test
	public void testGetIdRuolo() {
		e.setIdRuolo("e");
		assertEquals("e",e.getIdRuolo());
}

	@Test
	public void testSetIdRuolo() {
		e.setIdRuolo("e");
		assertEquals("e",e.getIdRuolo());

	}

	@Test
	public void testGetNome() {
		e.setNome("Aldo");
		assertEquals("Aldo",e.getNome());
		}

	@Test
	public void testSetNome() {
		e.setCognome("Aldo");
		assertEquals("Aldo",e.getCognome());
		}

	@Test
	public void testGetCognome() {
		e.setCognome("Baglio");
		assertEquals("Baglio",e.getCognome());	}

	@Test
	public void testSetCognome() {
		e.setCognome("Baglio");
		assertEquals("Baglio",e.getCognome());
		}

	@Test
	public void testGetEmail() {
		e.setEmail("AldoBaglio@gmail.com");
		assertEquals("AldoBaglio@gmail.com",e.getEmail());	
		}

	@Test
	public void testSetEmail() {

		e.setEmail("AldoBaglio@gmail.com");
		assertEquals("AldoBaglio@gmail.com",e.getEmail());	
		}

	@Test
	public void testGetPassword() {
		e.setPassword("Aldo635");
		assertEquals("Aldo635",e.getPassword());
	}

	@Test
	public void testSetPassword() {
		e.setPassword("Aldo635");
		assertEquals("Aldo635",e.getPassword());	}

	@Test
	public void testGetDescrizione() {
		e.setDescrizione("fa ridere");
		assertEquals("fa ridere",e.getDescrizione());	}

	@Test
	public void testSetDescrizione() {
		e.setDescrizione("fa ridere");
		assertEquals("fa ridere",e.getDescrizione());		}

	@Test
	public void testGetDataDiNascita() {
		e.setDataDiNascita(LocalDate.of(1987, 6, 5));
		assertEquals(LocalDate.of(1987, 6, 5),e.getDataDiNascita());		}

	@Test
	public void testSetDataDiNascita() {
		e.setDataDiNascita(LocalDate.of(1987, 6, 5));
		assertEquals(LocalDate.of(1987, 6, 5),e.getDataDiNascita());	
		}

}
