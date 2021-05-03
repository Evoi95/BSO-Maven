package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;

import controller_app.ControllerPagamentoCC;
import pagamento.CartaCredito;

class TestControllerPagamentoCC {
	private boolean state=false;
	private ControllerPagamentoCC cPCC;
	private String d="2021-08-05";
	private String c="1965-6325-4521-6333";
	private String civ="965";
	@Test
	void testControllaPag() {
		
		try {
			cPCC=new ControllerPagamentoCC();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(state,cPCC.controllaPag(d, c, civ));
		
	}

	@Test
	void testAggiungiCartaDB() {
		try {
			cPCC=new ControllerPagamentoCC();
		
		cPCC.aggiungiCartaDB("mario","rossi", c, new Date(), civ, (float)0.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void testRitornaElencoCC() throws Exception {
		cPCC=new ControllerPagamentoCC();

		assertNotNull(cPCC.ritornaElencoCC("pippo"));
	}

	@Test
	void testTornaDalDb() throws Exception {
		
		
		
		cPCC=new ControllerPagamentoCC();
		assertNotNull(cPCC.tornaDalDb(c));
	}

}
