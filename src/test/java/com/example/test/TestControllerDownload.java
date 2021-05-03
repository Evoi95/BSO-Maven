package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.itextpdf.text.DocumentException;

import controller_app.ControllerDownload;
import factoryBook.Factory;
import factoryBook.Libro;

class TestControllerDownload {
	private ControllerDownload Cd=new ControllerDownload();
	private Factory f=new Factory();
	private Libro l;
	@Test
	void testScaricaLibro() {
		l=(Libro) f.createLibro("libro","Apocalypse town: Cronache dalla fine della civilta\' urbana", 239,"0000000001", "Laterza", "Alessandro Coppola", "Iataliano", "Architettura", LocalDate.of(2012,05,18), " urbanistica della contemporaneita\':Il libro esplora una condizione limite delle citta\' americane in decrescita, aprendo una prospettiva ed una riflessione sul futuro prossimo del territorio urbano europeo. Da leggere assolutamente ", 600, "Dalle praterie urbane di Youngstown, dove l\'amministrazione comunale si è ormai ridotta a pianificare con zelo l\'autodistruzione della citta\', all\'industria del riciclo e della decostruzione di Buffalo, in cui attivisti visionari smontano con dovizia e con amore cio\' che resta della citta\'; dai deserti alimentari di Detroit e Philadelphia, dove sono scomparsi negozi e supermercati e gli abitanti si organizzano con geniali intraprese agricole", 1,(float) 7.99, 5571, 1);
		try {
			Cd.scaricaLibro(l);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testAnnullaOrdine() {
		Cd.annullaOrdine(l);//fail("Not yet implemented");
	}

}

