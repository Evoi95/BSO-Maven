package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import factoryBook.Libro;
import factoryBook.Factory;

class TestFactoryLibro {

	@Test
	void testCreateRaccolta() {
		Factory f=new Factory();
		Libro l=new Libro();
		
		l.setTitolo("Il mago di oz");
		l.setNumPag(250);
		l.setCodIsbn("8852645");
		l.setEditore("non so");
		l.setAutore("non so");
		l.setLingua("it");
		l.setCategoria("Fantasia");
		l.setDataPubb(LocalDate.of(2021,2,1));
		l.setRecensione("avventuta intrigante");
		l.setNrCopie(200);
		l.setDesc("avvincente");
		l.setDisponibilita(1);
		l.setPrezzo((float)10.3);
		l.setCopieRim(163);
		l.setId(4);
		
		Libro l1=new Libro();
		
		try {
			f.createRaccolta("libro",l.getTitolo(),l.getNumPag(),l.getCodIsbn(),l.getEditore(),l.getAutore(),l.getLingua(),l.getCategoria(),l.getDataPubb(),l.getRecensione(),l.getNrCopie(),l.getDesc(),l.getDisponibilita(),l.getPrezzo(), l.getCopieRim(),l.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			f.createRaccolta("libro",l1.getTitolo(),l1.getNumPag(),l1.getCodIsbn(),l1.getEditore(),l1.getAutore(),l1.getLingua(),l1.getCategoria(),l1.getDataPubb(),l1.getRecensione(),l1.getNrCopie(),l1.getDesc(),l1.getDisponibilita(),l1.getPrezzo(), l1.getCopieRim(),l1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertNotEquals(-1,l.getId(),0);
		//fail("Not yet implemented");

		//fail("Not yet implemented");
	}

}
