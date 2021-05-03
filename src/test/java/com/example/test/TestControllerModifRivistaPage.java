package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controller_app.ControllerModifRivistaPage;
import factoryBook.Rivista;

class TestControllerModifRivistaPage {
	private ControllerModifRivistaPage cMP=new ControllerModifRivistaPage();
	private Rivista r;

	@Test
	void testGetRivistaById() {
		r=new Rivista();
		r.setId(8);
		try {
			assertNotNull(cMP.getRivistaById(r.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testCheckData() {
		r=new Rivista();
		r.setTitolo("Rivista C");
		r.setTipologia("sportivo");
		r.setAutore("la gazzetta");
		r.setLingua("italiano");
		r.setEditore("la gazzetta");
		r.setDescrizione("cronaca della grionata sportiva");
		r.setDataPubb(LocalDate.of(2021,4,4));
		r.setDisp(0);
		r.setPrezzo((float) 0.90);
		r.setCopieRim(100);
		r.setId(24);
		try {
			cMP.checkData(r.getTitolo(),r.getTipologia(),r.getAutore(),r.getLingua(),r.getEditore(),r.getDescrizione(), r.getDataPubb(),r.getDisp(), r.getPrezzo(), r.getCopieRim(),r.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
