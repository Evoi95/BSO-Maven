package controller_app;

import java.util.logging.Level;

import database.UsersDao;
import logger.Log;
import users.singelton.User;

public class ControllerVisualizzaProfilo {
	private boolean status=false;

	public User getCredenziali() {
		
		return UsersDao.pickData(User.getInstance());
		
	}
	
	public ControllerVisualizzaProfilo()
	{
		Log.logger.log(Level.INFO,"ControllerVisualizzaProfilo");
	}

	public boolean cancellaUtente() {
		if(UsersDao.deleteUser(User.getInstance()))
		{
			User.getInstance().setNull();
			status=true;
		}
		return status;

		}
}
		
		
		
		
	


