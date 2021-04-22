package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerPagamentoCC;
import pagamento.CartaCredito;

class TestControllerPagamentoCC {
	private boolean state=false;
	private ControllerPagamentoCC cPCC;
	private String d="2021-08-05";
	private String c="1965-6325-4521-6333";
	private String civ="965";
	@Test
	public void testControllaPag() {
		
		try {
			cPCC=new ControllerPagamentoCC();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(state,cPCC.controllaPag(d, c, civ));
		
	}

	@Test
	public void testAggiungiCartaDB() {
		try {
			cPCC=new ControllerPagamentoCC();
		
		cPCC.aggiungiCartaDB("mario","rossi", c, new Date(), civ, (float)0.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testRitornaElencoCC() throws Exception {
		cPCC=new ControllerPagamentoCC();

		assertNotNull(cPCC.ritornaElencoCC("pippo"));
	}

	@Test
	public void testTornaDalDb() throws Exception {
		
		
		
		cPCC=new ControllerPagamentoCC();
		assertNotNull(cPCC.tornaDalDb(c));
	}

}
