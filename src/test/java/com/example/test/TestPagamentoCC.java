package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controller_app.ControllerPagamentoCC;

class TestPagamentoCC {

	@Test
	void testControllaPag() throws Exception {
		String d=LocalDate.of(2021, 2, 8).toString();
		String cod="1526-6362-5236-9652";
		String civ="111";
		boolean state;
		ControllerPagamentoCC cP=new ControllerPagamentoCC();
		state=cP.controllaPag(d, cod, civ);
		assertEquals(true,state);
		}

	@Test
	void testAggiungiCartaDB() throws Exception {
		String n,c,cod,civ;
		LocalDate ld=LocalDate.of(2021,2,8);
		java.util.Date data =java.sql.Date.valueOf(ld) ;

		

		n="pippo";
		c="pluto";
		cod="1526-6362-5236-9652";
		civ="111";
			ControllerPagamentoCC cP=new ControllerPagamentoCC();
			cP.aggiungiCartaDB(n, c, cod, data, civ, 0);
		assertNotEquals(null,cod);
	}

	@Test
	void testRitornaElencoCC() throws Exception {
		ControllerPagamentoCC cP=new ControllerPagamentoCC();
		String n="pippo";
		cP.ritornaElencoCC(n);
		assertNotEquals(null,n);
			}

	@Test
	void testTornaDalDb() throws Exception {
		ControllerPagamentoCC cP=new ControllerPagamentoCC();
		String cod="1526-6362-5236-9652";
		//cP.ritornaElencoCC(cod);
		boolean state=cP.ritornaElencoCC(cod).isEmpty();
		assertNotEquals(false,state);
	}

}
