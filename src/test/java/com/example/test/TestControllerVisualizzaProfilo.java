package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller_app.ControllerVisualizzaProfilo;
import users.singelton.User;

class TestControllerVisualizzaProfilo {
	private ControllerVisualizzaProfilo cVP=new ControllerVisualizzaProfilo();
	private static User u=User.getInstance();
	

	@Test
	void testGetCredenziali() {
		u.setNull();
		u.setNome("pippo");
		u.setEmail("Admin@Admin.com");
		//Log.logger.log(Level.INFO,"CVO CREDENZIAL:"+cVP.getCredenziali());
		//User.getInstance().getNome();
		//assertNotNull(cVP.getCredenziali());
	}

	@Test
	void testCancellaUtente() {
		//boolean state;
		//cVP.cancellaUtente();
		//assertNotEquals(false,state);
	}

}
