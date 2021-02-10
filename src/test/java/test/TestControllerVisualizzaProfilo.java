package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.ControllerVisualizzaProfilo;
import usersSingelton.User;

class TestControllerVisualizzaProfilo {
	private ControllerVisualizzaProfilo cVP=new ControllerVisualizzaProfilo();
	private static User u=User.getInstance();
	

	@Test
	public void testGetCredenziali() {
		u.setNull();
		u.setNome("pippo");
		u.setEmail("Admin@Admin.com");
		System.out.println("CVO CREDENZIAL:"+cVP.getCredenziali());
		//User.getInstance().getNome();
		//assertNotNull(cVP.getCredenziali());
	}

	@Test
	public void testCancellaUtente() {
		//boolean state;
		//cVP.cancellaUtente();
		//assertNotEquals(false,state);
	}

}
