package com.example.test;
//package test;
//
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertEquals;
//
//
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.Test;
//import factoryBook.Factory;
//import factoryBook.Giornale;
//import factoryBook.Libro;
//import factoryBook.Rivista;
//
//class TestFactory {
//
//	@Test
//	void testCreateRaccolta() {
//		Factory f=new Factory();
//		Libro l=new Libro();
//		Rivista r1=new Rivista();
//		Giornale g1=new Giornale();
//		boolean stateR=false,stateG=false,stateL=false;
//		
//		try {
//			f.createRaccolta("rivista",r1.getTitolo(),0,null,r1.getEditore(),r1.getAutore(),r1.getLingua(), null, r1.getDataPubb(),null,0, null,r1.getDisp() ,r1.getPrezzo(),r1.getCopieRim(),r1.getId());
//			if(r1.getId()!=-1)
//				stateR=true;
//			else
//				stateR=false;
//		} catch (Exception e) {
//		 
//			
//		}
//		
//		
//		
//		try {
//			f.createRaccolta("libro",l.getTitolo(),l.getNumPag(),l.getCodIsbn(),l.getEditore(),l.getAutore(),l.getLingua(),l.getCategoria(),l.getDataPubb(),l.getRecensione(),l.getNrCopie(),l.getDesc(),l.getDisponibilita(),l.getPrezzo(), l.getCopieRim(),l.getId());
//			if(l.getId()!=1)
//			stateL=true;
//			else
//			stateL=false;
//		} catch (Exception e) {
//		 
//			
//		}
//		
//		   f.createGiornale("giornale", g1.getTitolo(),g1.getTipologia(),g1.getLingua(),g1.getEditore(),g1.getDataPubb(),g1.getCopieRimanenti(),g1.getDisponibilita(),g1.getPrezzo(),g1.getId());
//		   if(g1.getId()!=-1)
//			   stateG=true;
//		   else
//			   stateG=false;
//		
//		   System.out.println("StatoL+StatoG+StatoR"+ stateL+ stateR+ stateG);
//		   boolean statoFinale=(stateG&&stateR&&stateL);
//		   
//		
//		assertEquals(false,statoFinale);
//			}
//
//
//
//	@Test
//	void testCreateLibro() {
//
//		Factory f=new Factory();
//		Libro l=new Libro();
//		
//		l.setTitolo("Il mago di oz");
//		l.setNumPag(250);
//		l.setCodIsbn("8852645");
//		l.setEditore("non so");
//		l.setAutore("non so");
//		l.setLingua("it");
//		l.setCategoria("Fantasia");
//		l.setDataPubb(LocalDate.of(2021,2,1));
//		l.setRecensione("avventuta intrigante");
//		l.setNrCopie(200);
//		l.setDesc("avvincente");
//		l.setDisponibilita(1);
//		l.setPrezzo((float)10.3);
//		l.setCopieRim(163);
//		l.setId(4);
//		
//		
//		try {
//			f.createRaccolta("libro",l.getTitolo(),l.getNumPag(),l.getCodIsbn(),l.getEditore(),l.getAutore(),l.getLingua(),l.getCategoria(),l.getDataPubb(),l.getRecensione(),l.getNrCopie(),l.getDesc(),l.getDisponibilita(),l.getPrezzo(), l.getCopieRim(),l.getId());
//		} catch (Exception e) {
//		 
//			
//		}
//		
//		
//		
//		assertNotEquals(-1,l.getId(),0);
//	}
//
//	@Test
//	void testCreateRivista() {
//		Rivista r=new Rivista();
//		Factory f=new Factory();
//		
//		r.setTitolo("Hello");
//		r.setTipologia("settimale");
//		r.setAutore("micky");
//		r.setLingua("it");
//		r.setEditore("hoepli");
//		r.setDescrizione("enigmistica");
//		r.setDataPubb(LocalDate.of(2021,1,1));
//		r.setDisp(1);
//		r.setPrezzo((float)2.30);
//		r.setCopieRim(200);
//		r.setId(2);
//		
//		try {
//			f.createRaccolta("rivista",r.getTitolo(),0,null,r.getEditore(),r.getAutore(),r.getLingua(), "", r.getDataPubb(),null,0, null,r.getDisp() ,r.getPrezzo(),r.getCopieRim(),r.getId());
//		} catch (Exception e) {
//		 
//			
//		}
//		
//		
//		assertNotEquals(-1,r.getId(),0);
//		
//		//fail("Not yet implemented");
//	}
//	
//
//	@Test
//	void testCreateGiornale() {LocalDate ld=LocalDate.of(2021,8,8);
//	int id=-1;
//	
//	Giornale g =new Giornale();
//	Factory f =new Factory();
//	g.setTitolo("La republica");
//	g.setTipologia("quotidiano");
//	g.setLingua("it");
//	g.setEditore("La republica");
//	g.setDataPubb(ld);
//	g.setCopieRimanenti(100);
//	g.setDisponibilita(1);
//	g.setPrezzo((float) 1.5);
//	g.setId(8);
//	
//	
//	// Giornale g ha id diverso da -1
//	// Gironale g1 ha id = -1
//	
//	
//
//	f.createGiornale("giornale", g.getTitolo(),g.getTipologia(),g.getLingua(),g.getEditore(),g.getDataPubb(),g.getCopieRimanenti(),g.getDisponibilita(),g.getPrezzo(),g.getId());
//
//	
//	/*
//	 * Controllo su id
//	 * 	controlle se id !=-1
//	 *  se diverso da -1 controllo passa
//	 *  se uguale a -1 fallisce
//	 */
//	assertNotEquals(id,g.getId(),0);
//
//}
//
//}
