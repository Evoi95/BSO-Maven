package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controllerApp.SingeltonSystemState;
import database.UsersDao;
import users.singelton.TempUser;
import users.singelton.User;

class TestUsersDao {
	private UsersDao ud=new UsersDao();
	private static User u=User.getInstance();
	private static TempUser tu=TempUser.getInstance();
	private static controllerApp.SingeltonSystemState vis=controllerApp.SingeltonSystemState.getIstance();
	private boolean state=false;
	private int state1;
	private String ruolo;
	

	@Test
	void testCreateUser() throws SQLException {
		u.setNome("lucio");
		u.setCognome("dalla");
		u.setEmail("luciodalla@gmail.com");
		u.setPassword("lucio851");
		u.setDataDiNascita(LocalDate.of(1940, 11,5));
		state=ud.createUser(u);
		assertEquals(true,state);
	}

	@Test
	void testCreateUser2() throws SQLException {
		tu.setNome("aldo");
		tu.setCognome("baglio");
		tu.setEmail("aldobaglio@gmail.com");
		tu.setPassword("aldooooo852");
		tu.setDescrizione("passeggero sbagiato nella subaru");
		tu.setDataDiNascita(LocalDate.of(1970, 3, 6));
		state=ud.createUser2(tu);
		assertEquals(true,state);		
		
		
	}

	@Test
	void testCheckUser() throws SQLException {
		u.setEmail("luciodalla@gmail.com");
		state1=UsersDao.checkUser(u);
		assertEquals(-1,state1);
		
	}

	@Test
	void testCheckTempUser() throws SQLException {
		tu.setEmail("aldobaglio@gmail.com");
		state1=UsersDao.checkTempUser(tu);
		assertNotEquals(-1,state1);
	}

	@Test
	void testGetRuolo() {
		u.setEmail("baoPublishing@gmail.com");
		ruolo=UsersDao.getRuolo(u);
		assertNotNull(ruolo);
	}

	@Test
	void testCheckResetpass() {
		state=UsersDao.checkResetpass(u, "lucio852","luciodalla@gmail.com");
		assertNotEquals(false,state);

	}

	@Test
	void testFindUser() {
		// vedere come fare
		tu.setIdRuolo("w");
	}

	@Test
	void testDeleteUser() {
		u.setEmail("luciodalla@gmail.com");
		state=UsersDao.deleteUser(u);
		assertNotEquals(false,state);
	}

	@Test
	void testDeleteTempUser() {
		u.setEmail("aldobaglio@gmail.com");
		u.setIdRuolo("U");
		state=UsersDao.deleteUser(u);
		assertNotEquals(false,state);
	}

	@Test
	void testPickData() {
		u.setEmail("luciodalla@gmail.com");
		assertNotNull(UsersDao.pickData(u));
}

	@Test
	void testAggiornaNome() {
		u.setNome("lucio1");
		u.setEmail("luciodalla@gmail.com");
		assertNotNull(UsersDao.aggiornaNome(u));
}

	@Test
	void testAggiornaCognomeUser() {
		u.setCognome("dalla1");
		u.setEmail("luciodalla@gmail.com");
		assertNotNull(UsersDao.aggiornaCognome(u));
}

	@Test
	void testAggiornaEmailUserString() {
		u.setEmail("luciodalla@gmail.com");
		assertNotNull(UsersDao.aggiornaEmail(u,"lucio1dalla1@gmail.com"));
		
	}

	
	@Test
	void testAggiornaPass() {
		u.setEmail("lucio1dalla1@gmail.com");
		u.setPassword("lucione963");
		assertNotNull(ud.aggiornaPass(u));
	}

	@Test
	void testAggiornaDesc() {
		u.setEmail("lucio1dalla1@gmail.com");
		u.setDescrizione("musica spettacolare");
		assertNotNull(ud.aggiornaDesc(u));
	}

	@Test
	void testAggiornaData() {
		u.setEmail("lucio1dalla1@gmail.com");
		u.setDataDiNascita(LocalDate.of(1940, 5, 6));
		assertNotNull(ud.aggiornaData(u));
		
	}

	@Test
	void testAggiornaTempNome() {
		tu.setEmail("albobaglio@gmail.com");
		tu.setNome("aldino");
		assertNotNull(UsersDao.aggiornaTempNome(tu));

	}

	@Test
	void testAggiornaCognomeTempUser() {
		tu.setEmail("albobaglio@gmail.com");
		tu.setCognome("baglino");
		assertNotNull(UsersDao.aggiornaCognome(tu));
	}

	@Test
	void testAggiornaEmailTempUserString() {
		tu.setEmail("aldobaglio@gmail.com");
		assertNotNull(UsersDao.aggiornaEmail(tu, "aldinobaglino@gmail.com"));
	}

	@Test
	void testAggiornaTempUtente() {
		tu.setNome("aldo2");
		tu.setCognome("baglio2");
		tu.setEmail("aldobaglio2@gmail.com");
		tu.setPassword("aldoo2oo852");
		tu.setDescrizione("passeggero sbagiato nella subaru");
		tu.setDataDiNascita(LocalDate.of(1970, 3, 6));
		tu.setIdRuolo("u");
		assertNotNull(UsersDao.aggiornaTempUtente(tu,"aldo1baglio1@gmail.com"));
	}

	@Test
	void testAggiornaTempPass() {
		tu.setEmail("aldo1baglio1@gmail.com");
		tu.setPassword("aldo142");
		assertNotNull(ud.aggiornaTempPass(tu));
	}

	@Test
	void testAggiornaTempDesc() {
		tu.setEmail("aldo1baglio1@gmail.com");
		tu.setDescrizione("non ci arrivo a pc");
		assertNotNull(ud.aggiornaTempDesc(tu));

	}

	@Test
	void testAggiornaTempData() {
		tu.setEmail("aldo1baglio1@gmail.com");
		tu.setDataDiNascita(LocalDate.of(1976,5,2));
		assertNotNull(ud.aggiornaTempDesc(tu));

	}

	@Test
	void testGetListaUtenti() {
		ud.getListaUtenti();
	}

	@Test
	void testGetTempUserSingolo() throws SQLException {
		tu.setIdU(2);
		assertNotNull(ud.getTempUserSingolo(tu));		//fail("Not yet implemented");
	}

	@Test
	void testAggiornaUtenteUser() {
		u.setIdU(3);
		u.setIdRuolo("a");
	 	u.setNome("pippo");//prepQ.setString(2,User.getInstance().getNome() );
	 	u.setCognome("paperino");//prepQ.setString(3, User.getInstance().getCognome());
	 	u.setEmail("pippo@gmail.com");//prepQ.setString(4, User.getInstance().getEmail());
	 	u.setPassword("pippo963");//prepQ.setString(5, User.getInstance().getPassword());
	 	u.setDescrizione("non lo so");//prepQ.setString(6, User.getInstance().getDescrizione());
	 	u.setDataDiNascita(LocalDate.of(1965, 7, 7));//prepQ.setString(7, User.getInstance().getDataDiNascita().toString());
	 	assertNotNull(UsersDao.aggiornaUtente(u));
	}

/*	@Test
	void testCreateTempUser() throws SQLException {
		vis.setIsLogged(true);
		
		tu.setNome("giulio");
		tu.setCognome("rossi");
		tu.setEmail("giuliorossi@gmail.com");
		tu.setPassword("giulio521");
		tu.setDataDiNascita(LocalDate.of(1994,11 ,9));
		
		//u.setIdRuolo("a");
		state=ud.createTempUser(tu);
		assertNotEquals(false,state);
	}
*/
	@Test
	void testMaxIdUSer() throws SQLException {
		state1=ud.maxIdUSer();
		assertNotEquals(-1,state1);
	}

	@Test
	void testAggiornaUtenteTemp() {
		tu.setIdRuolo("e");
		tu.setIdU(3);
		tu.setNome("alberto");
		tu.setCognome("binachi");
		tu.setEmail("albertoBianchi@gmail.com");
		tu.setPassword("albertino415");
		tu.setDescrizione("capoccione");
		tu.setDataDiNascita(LocalDate.of(1945,4,8));
		assertNotNull(UsersDao.aggiornaUtenteTemp(tu));
	
	}

}
