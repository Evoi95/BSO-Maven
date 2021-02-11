package controllerApp;

import database.UsersDao;
import usersSingelton.TempUser;

public class ControllerCancUser {
	private static TempUser u=TempUser.getInstance();
	

	public void cancellaUtente(int id)
	{
		u.setIdU(id);
		UsersDao.deleteTempUser(u);
	}
	
	public ControllerCancUser()
	{
		
	}
}
