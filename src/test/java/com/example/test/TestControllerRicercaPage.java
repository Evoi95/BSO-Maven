package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerRicercaPage;
import controller_app.SingeltonSystemState;

class TestControllerRicercaPage {
	private ControllerRicercaPage cRP=new ControllerRicercaPage();

	@Test
	void testCercaPerTipo() {
		//per libro
		SingeltonSystemState.getIstance().setTypeAsBook();
		try {
			assertNotNull(cRP.cercaPerTipo("Dodici"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	
	@Test
	void testCercaPerTipo1() {
		//per libro
		SingeltonSystemState.getIstance().setTypeAsDaily();
		try {
			assertNotNull(cRP.cercaPerTipo("Il Fatto Quotidiano"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	@Test
	void testCercaPerTipo2() {
		//per libro
		SingeltonSystemState.getIstance().setTypeAsMagazine();
		try {
			assertNotNull(cRP.cercaPerTipo("focus"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	

	@Test
	void testReturnType() {
		SingeltonSystemState.getIstance().setTypeAsBook();

		assertEquals("libro",cRP.returnType());
	}
	@Test
	void testReturnType1() {
		SingeltonSystemState.getIstance().setTypeAsMagazine();

		assertEquals("rivista",cRP.returnType());
	}
	@Test
	void testReturnType2() {
		SingeltonSystemState.getIstance().setTypeAsDaily();

		assertEquals("giornale",cRP.returnType());
	}


}
