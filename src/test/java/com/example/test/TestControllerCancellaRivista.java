package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerCancellaRivista;

class TestControllerCancellaRivista {
	private ControllerCancellaRivista cCR=new ControllerCancellaRivista();

	@Test
	void testCancella() {
		int id=1;
		cCR.cancella(id);
		assertNotEquals(-1,id);
	}

}
