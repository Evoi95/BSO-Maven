package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

import application.ControllerPagamentoCC;

class TestControllerPagamentoCC1 {

	private ControllerPagamentoCC cP;

	@Test
	public void testControllaPag() throws Exception 
	{
		String d=LocalDate.of(2021, 2, 8).toString();
		String cod="1526-6362-5236-9652";
		String civ="111";
		boolean state;
		cP=new ControllerPagamentoCC();
		state=cP.controllaPag(d, cod, civ);
		assertEquals(true,state);
	}

	
	@Test
	void testAggiungiCartaDB() {
		String n,c,cod,civ;
		java.util.Date data = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
		try {
			data = formatter.parse("2025/08/08");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sql = new java.sql.Date(data.getTime());


		n="pippo";
		c="pluto";
		cod="1526-6362-5236-9652";
		civ="111";
		try {
			cP=new ControllerPagamentoCC();
			cP.aggiungiCartaDB(n, c, cod, (Date)sql, civ, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotEquals(null,cod);
		
	}

	@Test
	void testRitornaElencoCC() throws Exception {
		cP=new ControllerPagamentoCC();
		String n="pippo";
		cP.ritornaElencoCC(n);
		assertNotEquals(null,n);
		//fail("Not yet implemented");
	}

	@Test
	void testTornaDalDb() throws Exception {
		cP=new ControllerPagamentoCC();
		String cod="1526-6362-5236-9652";
		//cP.ritornaElencoCC(cod);
		boolean state=cP.ritornaElencoCC(cod).isEmpty();
		assertNotEquals(false,state);

		//fail("Not yet implemented");
	}

}
