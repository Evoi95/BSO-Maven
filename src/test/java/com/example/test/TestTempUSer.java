package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import users.singelton.TempUser;

class TestTempUSer {
	private TempUser tU=TempUser.getInstance();

	@Test
	public void testGetIdRuolo() {
		tU.setIdRuolo("w");
		assertEquals("w",tU.getIdRuolo());
	}
	@Test
	public void testGetIdRuolo1() {
		tU.setIdRuolo("e");
		assertEquals("e",tU.getIdRuolo());
	}
	@Test
	public void testGetIdRuolo2() {
		tU.setIdRuolo("a");
		assertEquals("a",tU.getIdRuolo());
	}



	
	@Test
	public void testGetNome() {
		tU.setNome("franco");
		assertNotNull(tU.getNome());
}

	
	@Test
	void testGetCognome() {
		tU.setCognome("bianchi");
		assertNotNull(tU.getCognome());	}

	

	@Test
	void testGetEmail() {
		tU.setEmail("franco@bianchi.com");
		assertNotNull(tU.getEmail());
	}

	

	@Test
	void testGetPassword() {
		tU.setPassword("franco253");
		assertNotNull(tU.getPassword());	}

	

	@Test
	void testGetDescrizione() {
		tU.setDescrizione("non so");
		assertNotNull(tU.getDescrizione());	}

	

	@Test
	void testGetDataDiNascita() {
		tU.setDataDiNascita(LocalDate.of(1971, 6, 3));
		assertNotNull(tU.getDataDiNascita());
		
	}

	
	@Test
	public void testGetInstance() {
		assertNotNull(TempUser.getInstance());
	}

	@Test
	public void testSetNull() {
		tU.setNull();
		assertEquals(null,tU.getNome());
}

	@Test
	public void testGetIdU() {
		tU.setIdU(15);
		assertNotEquals(-1,tU.getIdU());
		
	}

	

}
