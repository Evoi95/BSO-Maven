package controllerApp;

import users.singelton.User;

public class ControllerReportRaccolta {
	private static User u=User.getInstance();
	
	public String getTipo()
	{
		return u.getIdRuolo();
	}

}
