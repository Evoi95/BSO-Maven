package controller_app;

import java.io.IOException;
import java.util.UUID;

import com.itextpdf.text.DocumentException;

import factorybook.Libro;


public class ControllerDownload {
	private String nrOrdine;
	public String getNrOrdine() {
		return nrOrdine;
	}

	public void setNrOrdine(String nrOrdine) {
		this.nrOrdine = nrOrdine;
	}

	public Libro getL() {
		return l;
	}

	public void setL(Libro l) {
		this.l = l;
	}

	private  Libro l;
	public void scaricaLibro(Libro l) throws DocumentException, IOException {
		
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
