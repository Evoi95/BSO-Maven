package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerModifGiornale;
import factoryBook.Giornale;

class TestControllerModifGiornale {
	private Giornale g;
	private ControllerModifGiornale cMG=new ControllerModifGiornale();
	private boolean state=false;
	@Test
	public void testGetGiornaliById() {
		g=new Giornale();
		g.setId(1);
		try {
			assertNotNull(cMG.getGiornaliById(g.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	@Test
	public void testCheckData() {
		g=new Giornale();
		g.setTitolo("la stampa");
		g.setTipologia("Quotidiano");
		g.setEditore("la stampa");
		g.setLingua("Italiano");
		g.setDataPubb(LocalDate.of(2021, 5,7));
		g.setDisponibilita(1);
		g.setPrezzo((float)1.5);
		g.setCopieRimanenti(100);
		g.setId(1);
		try {
			assertNotEquals(state,cMG.checkData(g.getTitolo(),g.getTipologia(),g.getEditore(),g.getLingua(),g.getDataPubb(), g.getDisponibilita(),g.getPrezzo(),g.getCopieRimanenti()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
