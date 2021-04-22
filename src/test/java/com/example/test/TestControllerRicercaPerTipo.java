package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerRicercaPerTipo;
import controllerApp.SingeltonSystemState;

class TestControllerRicercaPerTipo {
	private ControllerRicercaPerTipo cRT=new ControllerRicercaPerTipo();
	private boolean state=false;

	@Test
	public void testSetRicercaL() {
		SingeltonSystemState.getIstance().setTypeAsBook();
		assertNotEquals(state,cRT.setRicercaL());
	}

	@Test
	public void testSetRicercaG() {
		SingeltonSystemState.getIstance().setTypeAsDaily();
		assertNotEquals(state,cRT.setRicercaG());	}

	@Test
	public void testSetRicercaR() {
		SingeltonSystemState.getIstance().setTypeAsMagazine();
		assertNotEquals(state,cRT.setRicercaR());
	}

}
