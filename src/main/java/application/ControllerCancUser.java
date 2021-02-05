package application;

import database.UsersDao;
import usersSingelton.User;

public class ControllerCancUser {
	private UsersDao ud;
	private User u;
	

	public void cancellaUtente(int id)
	{
		u.getInstance().setIdU(id);
		ud.deleteUser(u);
	}
	
	public ControllerCancUser()
	{
		ud=new UsersDao();
		
	}
}
