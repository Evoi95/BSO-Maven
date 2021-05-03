package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import negozio.Negozio;

class TestNegozio {
	private Negozio n=new Negozio();

	@Test
	void testGetNome() {
		n.setNome("negozio 5");
		assertNotNull(n.getNome());
	}

	@Test
	void testSetNome() {
		n.setNome("negozio1");
}

	@Test
	void testGetVia() {
		n.setVia("Via mughetti 12");
		assertNotNull(n.getVia());
	}

	@Test
	void testSetVia() {
		n.setVia("Via mughetti 172");
	}

	@Test
	void testGetIsValid() {
		n.setIsValid(true);
		assertEquals(true,n.getIsValid());
		}

	@Test
	void testSetIsValid() {
		n.setIsValid(false);
	}

	@Test
	void testGetIsOpen() {
		n.setIsOpen(true);
		assertEquals(true,n.getIsOpen());
	}

	@Test
	void testSetIsOpen() {
		n.setIsOpen(false);
	}

}
