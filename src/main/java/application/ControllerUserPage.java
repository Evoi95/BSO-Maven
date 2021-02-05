package application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import database.UsersDao;

public class ControllerUserPage {
	private UsersDao ud;
	
	public void getUtenti()  {
		 try {
			 
	          // System.out.println("Scrivo nel Controller");

			ud.getListaUtenti();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ControllerUserPage()
	{
		ud=new UsersDao();
	}
	

}
