package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerVisualizzaLibro;

class TestControllerVisualizzaLibro {
	private ControllerVisualizzaLibro cVL=new ControllerVisualizzaLibro();

	@Test
	void testSetID() {
		String id="1";
		cVL.setID(id);
	}

	@Test
	void testGetID() {
		int x=cVL.getID();
		assertNotEquals(-1,x);
		
	}

	@Test
	void testGetData() throws SQLException {
		int i=1;
		assertNotNull(cVL.getData(i));
	}

}
