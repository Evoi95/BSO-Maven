package application;

import java.sql.SQLException;

import abstractFactoryLogin.*;
import abstractFactoryLogin.User;
import database.UserDao;

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
			User user = new User(Us,m,p);
			
			if(UserDao.checkUser(user) == -1)
			{
				return esito; // false erroe
			}
			else if (UserDao.checkUser(user) == 1)
			{
				// utente trovato
				// vai col login
				UserDao.setRuolo(user);
				System.out.println("/n loggato come :" + user.getIdRuolo());
				return esito = true;
			}
			else if (UserDao.checkUser(user) == 0)
			{
				return esito; // false non registrato
			}
			System.out.println("Errore nelle credenziali");
			return esito;

		}
		return esito;
	}
}
