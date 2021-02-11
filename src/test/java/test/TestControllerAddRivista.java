package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerAddRivistaPage;
import factoryBook.Rivista;

class TestControllerAddRivista {

	@Test
	void testCheckData() {
		ControllerAddRivistaPage cAP=new ControllerAddRivistaPage();
		Rivista r=new Rivista();
		boolean status=false;
		
		r.setTitolo("focus");
		r.setTipologia("scientifico");
		r.setAutore("hoepli");
		r.setLingua("it");
		r.setEditore("hoepli");
		r.setDescrizione("tratta argomenti principali");
		r.setDataPubb(LocalDate.of(2021, 2, 2));
		r.setDisp(1);
		r.setPrezzo((float)1.65);
		r.setCopieRim(200);
		status=cAP.checkData(r.getTitolo(),r.getTipologia(),r.getAutore(),r.getLingua(),r.getEditore(),r.getDescrizione(),r.getDataPubb(), r.getDisp(),r.getPrezzo(),r.getCopieRim());
		
		assertEquals(true,status);
		//fail("Not yet implemented");
	}

}
