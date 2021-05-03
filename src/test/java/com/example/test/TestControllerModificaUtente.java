package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controller_app.ControllerModificaUtente;
import users.singelton.User;

class TestControllerModificaUtente {
	private ControllerModificaUtente cMU=new ControllerModificaUtente();
	private boolean state=false;

	@Test
	void testPrendi() {
		assertNotNull(cMU.prendi());
	}

	@Test
	void testAggiorna() {
		User.getInstance().setEmail("pippo@gmail.com");
		assertNotEquals(state,cMU.aggiorna("alfredo","alcaldo","alfredo@htomail.com" ,"alfredo852","molto simpatico",LocalDate.of(1965, 8, 8),User.getInstance().getEmail()));
	}

}
