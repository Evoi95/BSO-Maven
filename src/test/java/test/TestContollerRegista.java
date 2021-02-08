package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import application.ControllerBsoRegister;
import usersSingelton.User;

class TestContollerRegista {
	private ControllerBsoRegister cR;


	@Test
	public void testRegistra() {
		cR=new ControllerBsoRegister();
		 String n,c,p,pV;
		 LocalDate dataN;
		 boolean state = false;


		n="daniele";
		c="cinu";
		p="daniele10";
		pV="daniele10";
		dataN=LocalDate.of(1995, 10, 31);
		User.getInstance().setNome(n);
		User.getInstance().setCognome(c);
		User.getInstance().setPassword(p);
		User.getInstance().setDataDiNascita(dataN);
		User.getInstance().setEmail("danielecinus10@gmail.com");
		try {
			state=cR.registra(User.getInstance().getNome(),User.getInstance().getCognome() ,User.getInstance().getEmail(), pV,User.getInstance().getPassword(),User.getInstance().getDataDiNascita());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		System.out.println("State in testRegistra()"+state);
		assertNotEquals(-1,state);
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckData() {
		cR=new ControllerBsoRegister();

		String n=User.getInstance().getNome();
		String c=User.getInstance().getCognome();
		String e=User.getInstance().getEmail();
		String pV="daniele10";
		String p=User.getInstance().getPassword();
		boolean state;
		state=cR.checkData(n, c, e ,pV, p);
		assertEquals(true,state);

		
		//("Not yet implemented");
	}

	@Test
	public void testCheckEmail() {
		String e;
		cR=new ControllerBsoRegister();

		User.getInstance().setEmail("danielecinus10@gmail.com");
		boolean state ;
		e=User.getInstance().getEmail();
		//System.out.println("e vale :" +e);

		state=cR.checkEmail(e);
		assertEquals(true,state);
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckPassword() {
		cR=new ControllerBsoRegister();

		String p,pV;
		 pV="daniele10";

		p=User.getInstance().getPassword();
		boolean state;
		state=cR.checkPassword(pV, p);
		assertEquals(true,state);
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckNomeCognome() {
		cR=new ControllerBsoRegister();

		String n,c;
		boolean state;
		n=User.getInstance().getNome();
		c=User.getInstance().getCognome();
		
		state=cR.checkNomeCognome(n, c);
		assertEquals(true,state);
		//fail("Not yet implemented");
	}

}
