package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerBookPage;

class TestControllerBookPage {
	private ControllerBookPage cBP=new ControllerBookPage();

	@Test
	void testGetLibriS() {
		try {
			assertNotNull(cBP.getLibriS());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
