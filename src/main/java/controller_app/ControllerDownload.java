package controller_app;

import java.io.FileNotFoundException;

import java.util.UUID;

import com.itextpdf.text.DocumentException;

import factoryBook.Libro;


public class ControllerDownload {
	private String nrOrdine;
	private  Libro l;
	public void scaricaLibro(Libro l) throws FileNotFoundException, DocumentException {
		
		l.scarica();
		l.leggi();
	}

	public void annullaOrdine(Libro l) {
		
		l.setId(-1);
		
		
	}

	public ControllerDownload() {
		this.nrOrdine = UUID.randomUUID().toString();
		l = new Libro();
	}

}
