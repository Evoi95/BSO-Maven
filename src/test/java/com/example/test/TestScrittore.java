package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import users.singelton.Scrittore;
import users.singelton.TempUser;

class TestScrittore {

	private Scrittore s=new Scrittore(TempUser.getInstance());

	@Test
	public void testGetIdRuolo() {
		s.setIdRuolo("w");
		assertEquals("w",s.getIdRuolo());
}

	@Test
	public void testSetIdRuolo() {
		s.setIdRuolo("w");
		assertEquals("w",s.getIdRuolo());

	}

	@Test
	public void testGetNome() {
		s.setNome("nico");
		assertEquals("nico",s.getNome());
		}

	@Test
	public void testSetNome() {
		s.setNome("nico");
		assertEquals("nico",s.getNome());
		}

	@Test
	public void testGetCognome() {
		s.setCognome("sardi");
		assertEquals("sardi",s.getCognome());	}

	@Test
	public void testSetCognome() {
		s.setCognome("sardi");
		assertEquals("sardi",s.getCognome());
		}

	@Test
	public void testGetEmail() {
		s.setEmail("NicoEISardi@gmail.com");
		assertEquals("NicoEISardi@gmail.com",s.getEmail());	
		}

	@Test
	public void testSetEmail() {

		s.setEmail("NicoEISardi@gmail.com");
		assertEquals("NicoEISardi@gmail.com",s.getEmail());	
		}

	@Test
	public void testGetPassword() {
		s.setPassword("sas369");
		assertEquals("sas369",s.getPassword());
	}

	@Test
	public void testSetPassword() {
		s.setPassword("sas369");
		assertEquals("sas369",s.getPassword());
		}

	@Test
	public void testGetDescrizione() {
		s.setDescrizione("fanno ridere");
		assertEquals("fanno ridere",s.getDescrizione());	}

	@Test
	public void testSetDescrizione() {

		s.setDescrizione("fanno ridere");
		assertEquals("fanno ridere",s.getDescrizione());		}

	@Test
	public void testGetDataDiNascita() {
		s.setDataDiNascita(LocalDate.of(1987, 4, 26));
		assertEquals(LocalDate.of(1987, 4, 26),s.getDataDiNascita());		}

	@Test
	public void testSetDataDiNascita() {
		s.setDataDiNascita(LocalDate.of(1987, 4,26));
		assertEquals(LocalDate.of(1987, 4, 26),s.getDataDiNascita());	
		}


}
