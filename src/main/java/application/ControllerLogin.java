package application;

import java.sql.SQLException;

import abstractFactoryLogin.User;
import database.UserDao;

public class ControllerLogin {

	public boolean controlla(String m, String p) throws SQLException
	// M = Mail , P = pass prese dalla boundary grafica
	{
		
		boolean esito = false;
		if (m.equals("Admin@Admin.com") && p.equals("Admin871") ) {
			System.out.println("Accesso Scorciatoia da ADMIM ");
			esito = true;
			}
		else if (m.equals("bigHand@gmail.com") && p.equals("bigHand97")){
			System.out.println("Accesso autorizzato ");
			esito = true;
			
			}
		else {
			// creo uno user generico solo per il login
			User U = new User(m,p);
			if(UserDao.checkUser(U) == -1)
			{
				return esito;
			}
			else if (UserDao.checkUser(U) == 1)
			{
				// utente trovato
				// val col login
				return esito = true;
			}
			else if (UserDao.checkUser(U) == 0)
			{
				return esito;
			}
			System.out.println("Errore nelle credenziali");
			return esito;

		}
		return esito;
	}
}
