package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import application.ControllerBsoRegister;
import usersSingelton.User;

class TestControllerRegister {
	private static User u=User.getInstance();
	private ControllerBsoRegister bReg;
	private boolean state=false;

	@Test
	public void testRegistra() throws SQLException {
		bReg=new ControllerBsoRegister();
		//boolean state = false;
		u.setNome("pippo");
		u.setCognome("pluto");
		u.setEmail("pluto10@gmail.com");
		u.setPassword("pluto723");
		u.setDataDiNascita(LocalDate.of(1995,10,31));
		
		System.out.println("Data in testControllerReg :"+u.getDataDiNascita());
		
		state=bReg.registra(u.getNome(), u.getCognome(),u.getEmail(), u.getPassword(), u.getPassword(),u.getDataDiNascita());
		
		System.out.println("State in bsroREg:"+state);
		assertEquals(true,state);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckData() {
		bReg=new ControllerBsoRegister();
		boolean state=false;
		state=bReg.checkData( u.getNome(),u.getCognome(),u.getEmail(), "pippo745", u.getPassword());
		assertEquals(false,state);


		//public boolean checkData (String n, String c, String email, String pwd, String pwdC)

		//fail("Not yet implemented");
	}

	@Test
	public void testCheckEmail() {
		bReg=new ControllerBsoRegister();
		
		u.setEmail("pluto10@gmail.com");
		state=bReg.checkEmail(u.getEmail());
		assertNotEquals(false,state);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckPassword() {
		bReg=new ControllerBsoRegister();
		
		String pwd="pluto723";
		state=bReg.checkPassword(pwd,u.getPassword());
		
		assertEquals(true,state);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckNomeCognome() {
		bReg=new ControllerBsoRegister();
		state=bReg.checkNomeCognome(u.getNome(),u.getCognome() );
		assertEquals(true,state);
		//fail("Not yet implemented");
	}

}
