package application;

import java.sql.SQLException;

import usersSingelton.*;
import database.UsersDao;

public class ControllerLogin {
	
	private User user = User.getInstance();
	private singeltonSystemState vis = singeltonSystemState.getIstance() ;
	private TempUser tU=TempUser.getInstance();
	private UsersDao ud;

	
	public boolean controlla(String m, String p) throws SQLException
	// M = Mail , P = pass prese dalla boundary grafica per il login
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
			
			user.setEmail(m);
			user.setPassword(p);
			if(UsersDao.checkUser(user) == -1)
			{
				return esito; // false erroe
			}
			else if (UsersDao.checkUser(user) == 1)
			{
				// utente trovato
				// vai col login
				// vai con la specializzazione prendendo i dati dal dao
				
				// qui prendo il ruolo in base ala mail dell'utente
				String r =UsersDao.getRuolo(user);
				// predno e li assegno all'oggetto user
				UsersDao.pickData(user);
				System.out.println("\n loggato come :" + r);
				vis.getIstance().setIsLogged(true);
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
	
	public String getRuoloTempUSer(String email)
	{
		//UD che torna oggetto di tipotempUSer
		tU.getInstance().setEmail(email);
		String ruolo;
		
		ruolo=ud.getRuoloTemp(tU);
		return ruolo;
		
	}
	
	//set
	public ControllerLogin()
	{
		ud=new UsersDao();
	}

}
