package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerAddBookPage;

class TestControllerAddBookPage {
	private ControllerAddBookPage cABP=new ControllerAddBookPage();

	@Test
	public void testCheckData() {
		boolean state;
		String titolo="ricette a base di pessce";
		int numPag=100;
		String codIsbn="852416321";
		String editore="momdadori";
		String autore="mondadori";
		String lingua="it";
		String categoria="culinaria";
		LocalDate data = LocalDate.of(2005,8,8);
		String recensione="bello e divertente";
		String desc="Ti fa venire voglia di mangiare";
		int disp=1;
		float prezzo=(float)15.2;
		int copieRim=80;
		
		state=cABP.checkData(titolo, numPag, codIsbn, editore, autore, lingua, categoria, data, recensione, desc, disp, prezzo, copieRim);
		
		assertNotEquals(false,state);
}

}
