package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerBookPage;

class TestControllerBookPage {
	private ControllerBookPage cBP=new ControllerBookPage();

	@Test
	public void testGetLibriS() {
		try {
			assertNotNull(cBP.getLibriS());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
