package controller_app;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;

import database.UsersDao;
import users.singelton.TempUser;
import logger.Log;

public class ControllerModifUserPage {
	private UsersDao uD;
	private static TempUser uT=TempUser.getInstance();
	
	
	
	public ControllerModifUserPage()
	{
		uD=new UsersDao();
		
	}



	public TempUser prendiLista(int id) throws SQLException {
		Log.logger.log(Level.INFO,"id in controllerMUP : {0}", id);
		
		uT.setIdU(id);
		
		return uD.getTempUserSingolo(uT);
		
		
	}
	
	public int  prendiIdMax() throws SQLException
	{
		return uD.maxIdUSer();
	}



	public void aggiornaUtenteByAdmin(String n, String c, String e, String p, String d, LocalDate data, String r) throws NullPointerException {
		
		uT.setNome(n);
		uT.setCognome(c);
		uT.setEmail(e);
		uT.setPassword(p);
		uT.setDescrizione(d);
		uT.setDataDiNascita(data);
		uT.setIdRuolo(r);
		
		UsersDao.aggiornaUtenteTemp(uT);
		
		
	}
	
	
}
