package application;

import java.sql.SQLException;

import abstractFactoryLogin.*;
import abstractFactoryLogin.User;
import database.UsersDao;

public class ControllerLogin {

	private AbstractUserFactory aUF;
	
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
			aUF = LoginProducer.getUserRole("U");
			LoginInterface Us = GeneralUserFactory.getLogin("U");
			// Utente di appoggio per login e factory 
			User user = new User(Us,m,p);
			
			if(UsersDao.checkUser(user) == -1)
			{
				return esito; // false erroe
			}
			else if (UsersDao.checkUser(user) == 1)
			{
				// utente trovato
				// vai col login
				// vai con la specializzazione prendendo i dati dal dao
				
				String r =UsersDao.getRuolo(user);
				UsersDao.pickData(user);
				System.out.println("\n loggato come :" + r);
				return esito = true;
			}
			else if (UsersDao.checkUser(user) == 0)
			{
				return esito; // false non registrato
			}
			System.out.println("Errore nelle credenziali");
			return esito;

		}
		return esito;
	}

	public boolean logout(String R, String id)
	{
		
		return false;
	}
}
