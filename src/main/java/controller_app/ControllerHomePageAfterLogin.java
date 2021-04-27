package controller_app;


import users.singelton.User;

import java.util.logging.Level;

import logger.Log;

public class ControllerHomePageAfterLogin {
	
	private static User U = User.getInstance();
	private static SingeltonSystemState vis = SingeltonSystemState.getIstance() ;

	// qui ci va la funzione di logout
	
	public static boolean logout() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{	
		
		String n = U.getNome();
		Log.logger.log(Level.INFO,"Stai sloggando con il nome di : {0}", n );
		U.setNull();
		
		if(U.getEmail() == null && U.getIdRuolo() == null)
		{
			Log.logger.log(Level.INFO,"Logout  utente {0}", U.getEmail());
			vis.setIsLogged(false);
			return true;
		}
		
		return false;
		
	}
}
