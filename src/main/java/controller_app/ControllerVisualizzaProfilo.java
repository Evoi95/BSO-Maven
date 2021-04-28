package controller_app;

import database.UsersDao;
import users.singelton.User;

public class ControllerVisualizzaProfilo {
	private UsersDao uD;
	private boolean status=false;

	public User getCredenziali() {
		
		return UsersDao.pickData(User.getInstance());
		
	}
	
	public ControllerVisualizzaProfilo()
	{
		uD=new UsersDao();
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
		
		
		
		
	


