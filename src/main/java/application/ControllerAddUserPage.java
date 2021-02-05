package application;

import java.sql.SQLException;
import java.time.LocalDate;

import database.UsersDao;
import usersSingelton.TempUser;

public class ControllerAddUserPage {
	private UsersDao ud;
	private TempUser u;
	
	public ControllerAddUserPage()
	{
		ud=new UsersDao();
	}

	public void insUtenteAsAdmin(String nome, String cognome, String email, String pwd, String desc, LocalDate data, String ruolo) throws SQLException
	{
		u.getInstance().setNull();
		u.getInstance().setNome(nome);
		u.getInstance().setCognome(cognome);
		u.getInstance().setEmail(email);
		u.getInstance().setPassword(pwd);
		u.getInstance().setDescrizione(desc);
		u.getInstance().setDataDiNascita(data);
		u.getInstance().setIdRuolo(ruolo);
		ud.createUser2(u);
	}
}
