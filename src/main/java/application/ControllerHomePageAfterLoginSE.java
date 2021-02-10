package application;

import usersSingelton.TempUser;
import usersSingelton.User;

public class ControllerHomePageAfterLoginSE {
	private static User U = User.getInstance();
	private static singeltonSystemState vis = singeltonSystemState.getIstance() ;

	// qui ci va la funzione di logout
	
	public static boolean logout() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{	
		
		String n = U.getNome();
		System.out.println("Stai sloggando con il nome di : "+ n );
		U.setNull();
		
		if(U.getEmail() == null && U.getIdRuolo() == null)
		{
			System.out.println("Logout  utente" + U.getEmail());
			vis.setIsLogged(false);
			return true;
		}
		
		return false;
		
	}


}
