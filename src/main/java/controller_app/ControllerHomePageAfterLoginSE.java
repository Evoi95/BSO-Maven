package controller_app;

import users.singelton.User;

import java.util.logging.Level;

import logger.Log;

public class ControllerHomePageAfterLoginSE {
	private static User u = User.getInstance();
	private static SingeltonSystemState vis = SingeltonSystemState.getIstance() ;

	// qui ci va la funzione di logout
	
	public static boolean logout() throws   SecurityException, IllegalArgumentException
	{	
		
		String n = u.getNome();
		Log.logger.log(Level.INFO,"Stai sloggando con il nome di : {0}", n );
		u.setNull();
		
		if(u.getEmail() == null && u.getIdRuolo() == null)
		{
			Log.logger.log(Level.INFO,"Logout  utente {0}",u.getEmail());
			vis.setIsLogged(false);
			return true;
		}
		
		return false;
		
	}
	private ControllerHomePageAfterLoginSE()
	{
		Log.logger.log(Level.INFO, "controllerHPAfterLoginSE");
	}


}
