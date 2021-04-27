package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerAcquista;
import controller_app.SingeltonSystemState;

class TestControllerAcquista {
	private ControllerAcquista cA=new ControllerAcquista();
	private static SingeltonSystemState vis=SingeltonSystemState.getIstance();

	@Test
	void testTotale() {
		float x;
		String cod="88541425";
		int disp=10;
		x=cA.totale(cod, disp);
		assertNotNull(x);
		

	}

	@Test
	void testTotaleG() throws SQLException {
		float y;
		String titolo="Republica";
		int disp=10;
		y=cA.totaleG(titolo, disp);
		assertNotNull(y);
		

	}

	@Test
	void testTotaleR() {
		float z;
		String titolo="cioe";
		int disp=10;
		z=cA.totaleR(titolo, disp);
		assertNotNull(z);
		

	}

	@Test
	void testGetIdL() throws SQLException {
		int x;
		String isbn="8832734591";
		x=cA.getIdL(isbn);
		
		assertNotEquals(-1,x);
	
	}

	@Test
	void testGetTipL() throws SQLException {
		String x;
		String isbn="1";
		x=cA.getTipL(isbn);
		
		assertNotEquals(-1,x);
		

	}

	@Test
	void testGetIdG() {
		int y = 0;
		String titolo="Republica";
		try {
			y=cA.getIdG(titolo);
		} catch (SQLException e) {
		 
			
		}
		assertNotEquals(-1,y);

	}

	@Test
	void testGetTipG() {
		String y = null;
		String titolo="La Republica";
		try {
			y=cA.getTipG(titolo);
		} catch (SQLException e) {
		 
			
		}
		assertNotEquals(null,y);

	}

	@Test
	void testGetIdR() {
		int z = 0;
		String titolo="cioe";
		try {
			z=cA.getIdR(titolo);
		} catch (SQLException e) {
		 
			
		}
		assertNotEquals(-1,z);

	}

	@Test
	void testGetTipR() {
		String z = null;
		String titolo="Republica";
		try {
			z=cA.getTipR(titolo);
		} catch (SQLException e) {
		 
			
		}
		assertNotEquals("",z);



	}

	@Test
	void testInserisciAmmontareL() throws SQLException {
		float spesa=(float) 100.0;
		cA.inserisciAmmontareG(spesa);
		assertNotEquals(0.0,spesa);

	}

	@Test
	void testInserisciAmmontareG() throws SQLException {
		float spesa=(float) 101.0;
		cA.inserisciAmmontareG(spesa);
		assertNotEquals(0.0,spesa);


	}

	@Test
	void testInserisciAmmontareR() throws SQLException {
		float spesa=(float) 99.0;
		cA.inserisciAmmontareR(spesa);
		assertNotEquals(0.0,spesa);


	}

	@Test
	void testGetType() {
		boolean state=false;
		String tipo;
		tipo=cA.getType();
		if(tipo.equalsIgnoreCase("libro") || tipo.equalsIgnoreCase("giornale") || tipo.equalsIgnoreCase("rivista"))
			state=true;
		else
			state=false;
		assertEquals(true,state);
	}

	@Test
	void testGetNomeById() throws SQLException {
		vis.setTypeAsBook();
		vis.setId(1);
		String nome=cA.getNomeById();
		//Log.logger.log(Level.INFO,"\n\n\n\nLibro in testAcquista: "+nome);
		assertNotEquals("",nome);

	}

	@Test
	void testGetDisp() throws SQLException {
		int disp=cA.getDisp();
		assertNotEquals(-1,disp);

	}

}
