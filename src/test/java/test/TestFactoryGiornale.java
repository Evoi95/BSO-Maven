package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import factoryBook.Factory;
import factoryBook.Giornale;

class TestFactoryGiornale {
	
	@Test
	public void testCreateRaccolta() {
		
		LocalDate ld=LocalDate.of(2021,8,8);
		int id=-1;
		
		Giornale g =new Giornale();
		Factory f =new Factory();
		g.setTitolo("La republica");
		g.setTipologia("quotidiano");
		g.setLingua("it");
		g.setEditore("La republica");
		g.setDataPubb(ld);
		g.setCopieRimanenti(100);
		g.setDisponibilita(1);
		g.setPrezzo((float) 1.5);
		g.setId(8);
		
		Giornale g1=new Giornale();
		
		// Giornale g ha id diverso da -1
		// Gironale g1 ha id = -1
		
		
	    f.createGiornale("giornale", g1.getTitolo(),g1.getTipologia(),g1.getLingua(),g1.getEditore(),g1.getDataPubb(),g1.getCopieRimanenti(),g1.getDisponibilita(),g1.getPrezzo(),g1.getId());
	
		f.createGiornale("giornale", g.getTitolo(),g.getTipologia(),g.getLingua(),g.getEditore(),g.getDataPubb(),g.getCopieRimanenti(),g.getDisponibilita(),g.getPrezzo(),g.getId());

		
		/*
		 * Controllo su id
		 * 	controlle se id !=-1
		 *  se diverso da -1 controllo passa
		 *  se uguale a -1 fallisce
		 */
		assertNotEquals(id,g.getId(),0);

		//fail("Not yet implemented");
	}

}
