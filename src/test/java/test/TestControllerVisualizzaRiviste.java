package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import application.ControllerVisualizzaRivista;

class TestControllerVisualizzaRiviste {
	private ControllerVisualizzaRivista cVR=new ControllerVisualizzaRivista();

	@Test
	public void testSetID() {
		String id="1";
		cVR.setID(id);
	
	}

	@Test
	public void testGetID() {
		int x=cVR.getID();
		assertNotEquals(-1,x);
		}

	@Test
	public void testGetData() throws SQLException {
		int i=1;
		cVR.getData(i);
		assertNotEquals(-1,i);
	
	}

}
