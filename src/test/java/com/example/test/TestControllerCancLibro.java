package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerCancLibro;

class TestControllerCancLibro {
	private ControllerCancLibro cCL=new ControllerCancLibro();

	@Test
	void testCancella() {
		int id=5;
		cCL.cancella(id);
		assertNotEquals(-1,id);
	}

}
