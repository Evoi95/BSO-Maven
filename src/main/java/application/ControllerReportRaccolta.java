package application;

import usersSingelton.User;

public class ControllerReportRaccolta {
	User u=User.getInstance();
	
	public String getTipo()
	{
		return u.getInstance().getIdRuolo();
	}

}
