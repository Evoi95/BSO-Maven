package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controller_app.ControllerAddGiornalePage;

class TestControllerAddGiornalePage {
	private ControllerAddGiornalePage cAGP=new ControllerAddGiornalePage();

	@Test
	void testCheckData() {
		boolean status;
		String titolo="il messagero";
		String tipologia="giornaliero";
		String editore="il messagero";
		String lingua="it";
		LocalDate data=LocalDate.of(2021, 2, 10);
		int disp=1;
		float prezzo=(float)1.3;
		int copieRim=100;
		status=cAGP.checkData(titolo, tipologia, editore, lingua, data, disp, prezzo, copieRim);
		assertNotEquals(false,status);


	}

}
