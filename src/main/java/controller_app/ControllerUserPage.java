package controller_app;



import java.io.IOException;
import java.util.logging.Level;

import database.UsersDao;
import logger.Log;

public class ControllerUserPage {
	
	public void getUtenti() throws IOException  {
		 UsersDao.getListaUtenti();
	}
	
	public ControllerUserPage()
	{
		Log.logger.log(Level.INFO,"ControllerUserPage");
	}
	

}
