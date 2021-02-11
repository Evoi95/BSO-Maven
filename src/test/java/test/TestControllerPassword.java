package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerPassword;

class TestControllerPassword {
	private ControllerPassword cP;
	boolean status=false;

	@Test
	void testControllerPassword() throws SQLException {
		cP=new ControllerPassword();
		
		String email="Admin@Admin.com";
		String vecchiaP="Admin871";
		String nuovaP="Admin872";
		status=cP.aggiornaPass(email, vecchiaP, nuovaP);
		
		assertEquals(true,status);
		
		//String email,String vecchiaP,String nuovaP
		//fail("Not yet implemented");
	}

}
