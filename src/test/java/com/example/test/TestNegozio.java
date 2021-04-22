package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import negozio.Negozio;

class TestNegozio {
	private Negozio n=new Negozio();

	@Test
	public void testGetNome() {
		n.setNome("negozio 5");
		assertNotNull(n.getNome());
	}

	@Test
	public void testSetNome() {
		n.setNome("negozio1");
}

	@Test
	public void testGetVia() {
		n.setVia("Via mughetti 12");
		assertNotNull(n.getVia());
	}

	@Test
	public void testSetVia() {
		n.setVia("Via mughetti 172");
	}

	@Test
	public void testGetIsValid() {
		n.setIsValid(true);
		assertEquals(true,n.getIsValid());
		}

	@Test
	public void testSetIsValid() {
		n.setIsValid(false);
	}

	@Test
	public void testGetIsOpen() {
		n.setIsOpen(true);
		assertEquals(true,n.getIsOpen());
	}

	@Test
	public void testSetIsOpen() {
		n.setIsOpen(false);
	}

}
