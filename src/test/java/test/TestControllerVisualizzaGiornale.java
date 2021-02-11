package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerVisualizzaGiornale;

class TestControllerVisualizzaGiornale {
	private ControllerVisualizzaGiornale cVG=new ControllerVisualizzaGiornale();

	@Test
	void testSetID() {
		String id="1";
		cVG.setID(id);
	}

	@Test
	void testGetID() {
		int x=cVG.getID();
		assertNotEquals(-1,x);
		}

	@Test
	void testGetData() throws SQLException {
		int i=1;
		assertNotNull(cVG.getData(i));
	
	}

}
