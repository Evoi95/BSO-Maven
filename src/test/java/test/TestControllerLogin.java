package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import application.ControllerLogin;
import usersSingelton.User;

class TestControllerLogin {
	
	private boolean state;
	private String ruolo;
	private ControllerLogin cL;
	String email,pass;

	@Test
	public void testControlla() {
		cL=new ControllerLogin();
		
		email="admin@admin.com";
		pass="admin871";
		
		
		User.getInstance().setEmail(email);
		User.getInstance().setPassword(pass);
		
		
		try {
			state=cL.controlla(User.getInstance().getEmail(),User.getInstance().getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("Sate :"+ state);
		assertEquals(true,state);//fail("Not yet implemented");
	}

	@Test
	public void testGetRuoloTempUSer() {
		//fail("Not yet implemented");
		cL=new ControllerLogin();
		email="admin@admin.com";
		ruolo=cL.getRuoloTempUSer(email);
		//System.out.println("ruolo nel test "+ruolo);
		assertEquals(ruolo,"a");
		
	}

}
