package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.ControllerHomePageAfterLoginSE;
import usersSingelton.User;

class TestControllerAfterLoginSE {

	@Test
	public void testLogout() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		boolean state;
		User.getInstance().setNome("pippo");
		
		state=ControllerHomePageAfterLoginSE.logout();
		assertNotEquals(false,state);
}

}
