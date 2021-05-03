package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import users.singelton.Scrittore;
import users.singelton.TempUser;

class TestScrittore {

	private Scrittore s=new Scrittore(TempUser.getInstance());

	@Test
	void testGetIdRuolo() {
		s.setIdRuolo("w");
		assertEquals("w",s.getIdRuolo());
}

	@Test
	void testSetIdRuolo() {
		s.setIdRuolo("w");
		assertEquals("w",s.getIdRuolo());

	}

	@Test
	void testGetNome() {
		s.setNome("nico");
		assertEquals("nico",s.getNome());
		}

	@Test
	void testSetNome() {
		s.setNome("nico");
		assertEquals("nico",s.getNome());
		}

	@Test
	void testGetCognome() {
		s.setCognome("sardi");
		assertEquals("sardi",s.getCognome());	}

	@Test
	void testSetCognome() {
		s.setCognome("sardi");
		assertEquals("sardi",s.getCognome());
		}

	@Test
	void testGetEmail() {
		s.setEmail("NicoEISardi@gmail.com");
		assertEquals("NicoEISardi@gmail.com",s.getEmail());	
		}

	@Test
	void testSetEmail() {

		s.setEmail("NicoEISardi@gmail.com");
		assertEquals("NicoEISardi@gmail.com",s.getEmail());	
		}

	@Test
	void testGetPassword() {
		s.setPassword("sas369");
		assertEquals("sas369",s.getPassword());
	}

	@Test
	void testSetPassword() {
		s.setPassword("sas369");
		assertEquals("sas369",s.getPassword());
		}

	@Test
	void testGetDescrizione() {
		s.setDescrizione("fanno ridere");
		assertEquals("fanno ridere",s.getDescrizione());	}

	@Test
	void testSetDescrizione() {

		s.setDescrizione("fanno ridere");
		assertEquals("fanno ridere",s.getDescrizione());		}

	@Test
	void testGetDataDiNascita() {
		s.setDataDiNascita(LocalDate.of(1987, 4, 26));
		assertEquals(LocalDate.of(1987, 4, 26),s.getDataDiNascita());		}

	@Test
	void testSetDataDiNascita() {
		s.setDataDiNascita(LocalDate.of(1987, 4,26));
		assertEquals(LocalDate.of(1987, 4, 26),s.getDataDiNascita());	
		}


}
