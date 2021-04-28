package controller_app;



import database.UsersDao;

public class ControllerUserPage {
	private UsersDao uD;
	
	public void getUtenti()  {
		 uD.getListaUtenti();
	}
	
	public ControllerUserPage()
	{
		uD=new UsersDao();
	}
	

}
