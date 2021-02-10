package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import application.ControllerModifUserPage;
import usersSingelton.TempUser;

class TestControllerModifUserPageAdmin {
	private static TempUser u=TempUser.getInstance();
	private ControllerModifUserPage cMUP=new ControllerModifUserPage();

	@Test
	public void testPrendiLista() {
		u.setIdU(2);
		try {
			cMUP.prendiLista(u.getIdU());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testPrendiIdMax() throws SQLException {
		int x=cMUP.prendiIdMax();
		assertNotEquals(-1,x);
			}

	@Test
	public void testAggiornaUtenteByAdmin() throws SQLException {
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
