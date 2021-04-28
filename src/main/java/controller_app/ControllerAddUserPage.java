package controller_app;

import java.sql.SQLException;
import java.time.LocalDate;

import database.UsersDao;
import users.singelton.TempUser;

public class ControllerAddUserPage {
	private UsersDao uD;
	private static TempUser u=TempUser.getInstance();
	
	public ControllerAddUserPage()
	{
		uD=new UsersDao();
	}

	public void insUtenteAsAdmin(String nome, String cognome, String email, String pwd, String desc, LocalDate data, String ruolo) throws SQLException
	{
		u.setNome(nome);
		u.setCognome(cognome);
		u.setEmail(email);
		u.setPassword(pwd);
		u.setDescrizione(desc);
		u.setDataDiNascita(data);
		u.setIdRuolo(ruolo);
		uD.createUser2(u);
	}
}
