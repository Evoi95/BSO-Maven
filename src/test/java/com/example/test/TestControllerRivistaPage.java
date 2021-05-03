package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerRivistaPage;

class TestControllerRivistaPage {
	private ControllerRivistaPage cRP=new ControllerRivistaPage();

	@Test
	void testGetRivistaS() {
		try {
			assertNotNull(cRP.getRivistaS());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
