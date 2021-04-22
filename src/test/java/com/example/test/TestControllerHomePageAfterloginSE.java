package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerHomePageAfterLoginSE;
import users.singelton.User;

class TestControllerHomePageAfterloginSE {
	private static User u=User.getInstance();
	boolean state=false;


	@Test
	public void testLogout() {
		u.setNome("pippo");
		try {
			assertNotEquals(state,ControllerHomePageAfterLoginSE.logout());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
