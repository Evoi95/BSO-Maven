package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerModifUserPage;
import users.singelton.TempUser;

class TestControllerModifUserPageAdmin {
	private static TempUser u=TempUser.getInstance();
	private ControllerModifUserPage cMUP=new ControllerModifUserPage();

	@Test
	void testPrendiLista() {
		u.setIdU(2);
		try {
			cMUP.prendiLista(u.getIdU());
		} catch (SQLException e) {
		 
			
		}
	}

	@Test
	void testPrendiIdMax() throws SQLException {
		int x=cMUP.prendiIdMax();
		assertNotEquals(-1,x);
			}

	@Test
	void testAggiornaUtenteByAdmin() throws SQLException {
		u.setNome("alberto");
		u.setCognome("rossi");
		u.setEmail("albertorossi@gmail.com");
		u.setPassword("albertone15");
		u.setDescrizione("pelato");
		u.setDataDiNascita(LocalDate.of(1984, 5, 2));
		u.setIdRuolo("e");
		
		cMUP.aggiornaUtenteByAdmin(u.getNome(),u.getCognome() ,u.getEmail() ,u.getPassword() ,u.getDescrizione() , u.getDataDiNascita(),u.getIdRuolo());
	}
	
}
