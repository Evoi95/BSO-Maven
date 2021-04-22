package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerUserPage;

class TestControllerUserPage {
	private ControllerUserPage cUP=new ControllerUserPage();

	@Test
	void testGetUtenti() {
		cUP.getUtenti();
		}

	
}
