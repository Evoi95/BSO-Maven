package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller_app.ControllerHomePageAfterLoginSE;
import users.singelton.User;

class TestControllerHomePageAfterloginSE {
	private static User u=User.getInstance();
	boolean state=false;


	@Test
	void testLogout() {
		u.setNome("pippo");
		try {
			assertNotEquals(state,ControllerHomePageAfterLoginSE.logout());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}
