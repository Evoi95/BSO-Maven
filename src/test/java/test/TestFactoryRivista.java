package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import factoryBook.Rivista;
import factoryBook.Factory;

class TestFactoryRivista {

	@Test
	public void testCreateRaccolta() {
		Rivista r=new Rivista();
		Factory f=new Factory();
		
		r.setTitolo("Hello");
		r.setTipologia("settimale");
		r.setAutore("micky");
		r.setLingua("it");
		r.setEditore("hoepli");
		r.setDescrizione("enigmistica");
		r.setDataPubb(LocalDate.of(2021,1,1));
		r.setDisp(1);
		r.setPrezzo((float)2.30);
		r.setCopieRim(200);
		r.setId(2);
		Rivista r1=new Rivista();
		
		try {
			f.createRaccolta("rivista",r.getTitolo(),0,null,r.getEditore(),r.getAutore(),r.getLingua(), null, r.getDataPubb(),null,0, null,r.getDisp() ,r.getPrezzo(),r.getCopieRim(),r.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			f.createRaccolta("rivista",r1.getTitolo(),0,null,r1.getEditore(),r1.getAutore(),r1.getLingua(), null, r1.getDataPubb(),null,0, null,r1.getDisp() ,r1.getPrezzo(),r1.getCopieRim(),r1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotEquals(-1,r.getId(),0);
		
		//fail("Not yet implemented");
	}

}
