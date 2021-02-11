package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerAddUserPage;
import usersSingelton.TempUser;

class TestControllerAddUserPage {
	private ControllerAddUserPage cAUP=new ControllerAddUserPage();
	private static TempUser tu=TempUser.getInstance();

	@Test
	void testInsUtenteAsAdmin() throws SQLException {
		//public void insUtenteAsAdmin(String nome, String cognome, String email, String pwd, String desc, LocalDate data, String ruolo) throws SQLException

		tu.setNome("pippo");
		tu.setCognome("pluto");
		tu.setEmail("pippo@ll.com");
		tu.setPassword("pippo871");
		tu.setDescrizione("leggermente cattivo");
		tu.setDataDiNascita(LocalDate.of(2021,2,8));
		tu.setIdRuolo("w");
		cAUP.insUtenteAsAdmin(tu.getNome(),tu.getCognome(),tu.getEmail(),tu.getPassword(),tu.getDescrizione(),tu.getDataDiNascita(),tu.getIdRuolo());
		
	}

}
