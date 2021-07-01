package controller_app;

import java.sql.SQLException;

import database.UsersDao;

import users.singelton.User;

public class ControllerPassword {
	private User u = User.getInstance();
	private boolean status;
	public ControllerPassword()
	{
		
	}

	public boolean aggiornaPass(String email,String vecchiaP,String nuovaP) throws SQLException
	{
		u.setEmail(email);
		u.setPassword(vecchiaP);
		if(u.getPassword().equals(vecchiaP)) 
		{
			if(nuovaP.length()>=8 || !email.equals(""))
			{
				u.setPassword(nuovaP);
				if(UsersDao.checkUser(u) == 1)
				{
					UsersDao.checkResetpass(u, nuovaP,email);
					status=true;
				}
				else if  (UsersDao.checkUser(u) == 0 || UsersDao.checkUser(u) == -1 )
				{
					status=false;
				}
				
			}
			else {
				status=false;
			}
		}
		return status;
	}
}
