package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller_app.ControllerRicercaPerTipo;
import controller_app.SingeltonSystemState;

class TestControllerRicercaPerTipo {
	private ControllerRicercaPerTipo cRT=new ControllerRicercaPerTipo();
	private boolean state=false;

	@Test
	void testSetRicercaL() {
		SingeltonSystemState.getIstance().setTypeAsBook();
		assertNotEquals(state,cRT.setRicercaL());
	}

	@Test
	void testSetRicercaG() {
		SingeltonSystemState.getIstance().setTypeAsDaily();
		assertNotEquals(state,cRT.setRicercaG());	}

	@Test
	void testSetRicercaR() {
		SingeltonSystemState.getIstance().setTypeAsMagazine();
		assertNotEquals(state,cRT.setRicercaR());
	}

}
