package controller_app;

import java.sql.SQLException;

import database.UsersDao;
import users.singelton.TempUser;

public class ControllerCancUser {
	private static TempUser u=TempUser.getInstance();
	

	public void cancellaUtente(int id) throws SQLException
	{
		u.setIdU(id);
		UsersDao.deleteTempUser(u);
	}
	
	
}
