package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller_app.ControllerHomePageAfterLogin;
import users.singelton.User;

class TestControllerHomePageAfterLogin {
	//private ControllerHomePageAfterLogin cHAL=new ControllerHomePageAfterLogin();
	private static User u=User.getInstance();

	@Test
	void testLogout() {
		boolean state = false;
		u.setNome("pippo");
		try {
			state=ControllerHomePageAfterLogin.logout();
		} catch (Exception e) {
		 
			
		}
		assertEquals(true,state);
		
	}

}
