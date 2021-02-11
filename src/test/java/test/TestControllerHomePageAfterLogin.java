package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerHomePageAfterLogin;
import usersSingelton.User;

class TestControllerHomePageAfterLogin {
	//private ControllerHomePageAfterLogin cHAL=new ControllerHomePageAfterLogin();
	private static User u=User.getInstance();

	@Test
	public void testLogout() {
		boolean state = false;
		u.setNome("pippo");
		try {
			state=ControllerHomePageAfterLogin.logout();
		} catch (Exception e) {
		 
			e.printStackTrace();
		}
		assertEquals(true,state);
		
	}

}
