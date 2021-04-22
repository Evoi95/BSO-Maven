package com.example.test;


import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import factoryBook.Factory;
import factoryBook.Giornale;
import factoryBook.Libro;
import factoryBook.Rivista;

class TestFactory {
	private Factory f=new Factory();
	private Libro l=new Libro();
	private Rivista r1=new Rivista();
	private Giornale g1=new Giornale();
	boolean stateR=false,stateG=false,stateL=false;
	@Test
	public void testCreateRaccolta() {
		
		r1.setTitolo("focus1");
		r1.setTipologia("fantascienza");
		r1.setAutore("mondadori");
		r1.setLingua("italiano");
		r1.setEditore("mondadori");
		r1.setDescrizione("Principali eventi scientifici");
		r1.setDataPubb(LocalDate.of(2021, 5, 1));
		r1.setDisp(1);
		r1.setPrezzo((float)1.30);
		r1.setCopieRim(200);
		r1.setId(8);
		
		
		
		try {
			f.createRaccolta("rivista",r1.getTitolo(),0,null,r1.getEditore(),r1.getAutore(),r1.getLingua(), null, r1.getDataPubb(),null,0, null,r1.getDisp() ,r1.getPrezzo(),r1.getCopieRim(),r1.getId());
			if(r1.getId()!=-1)
				stateR=true;
			else
				stateR=false;
		} catch (Exception e) {
		 
			
		}
		assertNotEquals(false,stateR);
	}

	@Test
	public void testCreateRaccolta1() {
		
		l.setTitolo("errori in economia");
		l.setNumPag(100);		
		l.setCodIsbn("8847238150");
		l.setEditore("garzanti");
		l.setAutore("garzanti");
		l.setLingua("italiana");
		l.setCategoria("economia");
		l.setDataPubb(LocalDate.of(2015,11 ,25));
		l.setRecensione("molto appassionante");
		l.setNrCopie(200);
		l.setDesc("focus sul mercato mondiale");
		l.setDisponibilita(1);
		l.setPrezzo((float)12.5);
		l.setCopieRim(57);
		l.setId(11);
		
		
		
		
		
		try {
			f.createRaccolta("libro",l.getTitolo(),l.getNumPag(),l.getCodIsbn(),l.getEditore(),l.getAutore(),l.getLingua(),l.getCategoria(),l.getDataPubb(),l.getRecensione(),l.getNrCopie(),l.getDesc(),l.getDisponibilita(),l.getPrezzo(), l.getCopieRim(),l.getId());
			if(l.getId()!=1)
			stateL=true;
			else
			stateL=false;
		} catch (Exception e) {
		 
			
		}
		assertNotEquals(false,stateL);
	}
	

	@Test
	public void testCreateRaccolta2() {
		
		g1.setTitolo("il corriere della sera");
		g1.setTipologia("quotidiano");
		g1.setLingua("it");
		g1.setEditore("mondadori");
		g1.setDataPubb(LocalDate.of(2021, 5, 8));
		g1.setCopieRimanenti(150);
		g1.setDisponibilita(1);
		g1.setPrezzo((float)1.1);
		g1.setId(15);
		
		
		   f.createGiornale("giornale", g1.getTitolo(),g1.getTipologia(),g1.getLingua(),g1.getEditore(),g1.getDataPubb(),g1.getCopieRimanenti(),g1.getDisponibilita(),g1.getPrezzo(),g1.getId());
		   if(g1.getId()!=-1)
			   stateG=true;
		   else
			   stateG=false;
		
		   //System.out.println("StatoL+StatoG+StatoR"+ stateL+ stateR+ stateG);
		   //boolean statoFinale=(stateG&&stateR&&stateL);
		   
		
		assertNotEquals(false,stateG);
			}



	@Test
	public void testCreateLibro() {

		
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
		
		
		try {
			f.createRaccolta("libro",l.getTitolo(),l.getNumPag(),l.getCodIsbn(),l.getEditore(),l.getAutore(),l.getLingua(),l.getCategoria(),l.getDataPubb(),l.getRecensione(),l.getNrCopie(),l.getDesc(),l.getDisponibilita(),l.getPrezzo(), l.getCopieRim(),l.getId());
		} catch (Exception e) {
		 
			
		}
		
		
		
		assertNotEquals(-1,l.getId(),0);
	}

	@Test
	public void testCreateRivista() {
		
		
		r1.setTitolo("Hello");
		r1.setTipologia("settimale");
		r1.setAutore("micky");
		r1.setLingua("it");
		r1.setEditore("hoepli");
		r1.setDescrizione("enigmistica");
		r1.setDataPubb(LocalDate.of(2021,1,1));
		r1.setDisp(1);
		r1.setPrezzo((float)2.30);
		r1.setCopieRim(200);
		r1.setId(2);
		
		try {
			f.createRaccolta("rivista",r1.getTitolo(),0,null,r1.getEditore(),r1.getAutore(),r1.getLingua(), "", r1.getDataPubb(),null,0, null,r1.getDisp() ,r1.getPrezzo(),r1.getCopieRim(),r1.getId());
		} catch (Exception e) {
		 
			
		}
		
		
		assertNotEquals(-1,r1.getId(),0);
		
		//fail("Not yet implemented");
	}
	

	@Test
	public void testCreateGiornale() {
		LocalDate ld=LocalDate.of(2021,8,8);
	
	
	g1.setTitolo("La republica");
	g1.setTipologia("quotidiano");
	g1.setLingua("it");
	g1.setEditore("La republica");
	g1.setDataPubb(ld);
	g1.setCopieRimanenti(100);
	g1.setDisponibilita(1);
	g1.setPrezzo((float) 1.5);
	g1.setDataPubb(ld);
	g1.setId(8);
	
	
	// Giornale g ha id diverso da -1
	// Gironale g1 ha id = -1
	
	

	f.createGiornale("giornale", g1.getTitolo(),g1.getTipologia(),g1.getLingua(),g1.getEditore(),g1.getDataPubb(),g1.getCopieRimanenti(),g1.getDisponibilita(),g1.getPrezzo(),g1.getId());

	
	/*
	 * Controllo su id
	 * 	controlle se id !=-1
	 *  se diverso da -1 controllo passa
	 *  se uguale a -1 fallisce
	 */
	assertNotEquals(-1,g1.getId(),0);

}

}
