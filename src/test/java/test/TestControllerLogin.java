package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerLogin;

class TestControllerLogin {
	
	private boolean state;
	private String ruolo;
	private ControllerLogin cL;
	String email,pass;

	@Test
	public void testControlla() {
		cL=new ControllerLogin();
		
		//User.getInstance().setNull();
		
		email="Admin@Admin.com";/*"pippo@pippo.com"; 10.9*/
		pass="Admin871";/*"pippo871";10.9*/
		
		
		//User.getInstance().setEmail(email);
		//User.getInstance().setPassword(pass);
		
		
		try {
			state=cL.controlla(email,pass/*User.getInstance().getEmail(),User.getInstance().getPassword()*/);
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
		email="Admin@Admin.com";
		ruolo=cL.getRuoloTempUSer(email);
		//System.out.println("ruolo nel test "+ruolo);
		assertEquals("a",ruolo);
		
	}

}
