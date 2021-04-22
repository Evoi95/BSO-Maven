package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import users.singelton.Admin;
import users.singelton.TempUser;

class TestAdmin {
	private Admin a=new Admin(TempUser.getInstance());

	@Test
	public void testGetIdRuolo() {
		a.setIdRuolo("a");
		assertEquals("a",a.getIdRuolo());
}

	@Test
	public void testSetIdRuolo() {
		a.setIdRuolo("w");
		assertEquals("w",a.getIdRuolo());

	}

	@Test
	public void testGetNome() {
		a.setNome("Admin");
		assertEquals("Admin",a.getNome());
	}

	@Test
	public void testSetNome() {
		a.setNome("Admin1");
		assertEquals("Admin1",a.getNome());	}

	@Test
	public void testGetCognome() {
		a.setCognome("Admin");
		assertEquals("Admin",a.getCognome());
	}

	@Test
	public void testSetCognome() {
		a.setCognome("Admin");
		assertEquals("Admin",a.getCognome());	}

	@Test
	public void testGetEmail() {
		a.setEmail("admin@admin.com");
		assertEquals("admin@admin.com",a.getEmail());
	}

	@Test
	public void testSetEmail() {
		a.setEmail("admin@admin1.com");
		assertEquals("admin@admin1.com",a.getEmail());	}

	@Test
	public void testGetPassword() {
		a.setPassword("admin871");
		assertEquals("admin871",a.getPassword());
		}

	@Test
	public void testSetPassword() {
		a.setPassword("admin875");
		assertEquals("admin875",a.getPassword());
		}

	@Test
	public void testGetDescrizione() {
		a.setDescrizione("troppo egocentrico");
		assertEquals("troppo egocentrico",a.getDescrizione());
		}

	@Test
	public void testSetDescrizione() {
		a.setDescrizione("troppo egocentrico");
		assertEquals("troppo egocentrico",a.getDescrizione());
		

	}

	@Test
	public void testGetDataDiNascita() {
		a.setDataDiNascita(LocalDate.of(1965, 8, 2));
		assertEquals(LocalDate.of(1965, 8, 2),a.getDataDiNascita());
		
	}

	@Test
	public void testSetDataDiNascita() {
		a.setDataDiNascita(LocalDate.of(1980, 11, 5));
		assertEquals(LocalDate.of(1980, 11, 5),a.getDataDiNascita());
		
	}

}
