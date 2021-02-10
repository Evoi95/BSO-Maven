package application;

import java.sql.SQLException;
import java.time.LocalDate;

import database.UsersDao;
import usersSingelton.TempUser;
import usersSingelton.User;

public class ControllerModifUserPage {
	private UsersDao ud;
	private static TempUser uT=TempUser.getInstance();
	
	
	
	public ControllerModifUserPage()
	{
		ud=new UsersDao();
		
	}



	public TempUser prendiLista(int id) throws SQLException {
		System.out.println("id in controllerMUP :"+ id);
		
		uT.setIdU(id);
		
		return ud.getTempUserSingolo(uT);
		// TODO Auto-generated method stub
		
	}
	
	public int  prendiIdMax() throws SQLException
	{
		return ud.maxIdUSer();
	}



	public void aggiornaUtenteByAdmin(String n, String c, String e, String p, String d, LocalDate data, String r) throws NullPointerException {
		// TODO Auto-generated method stub
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
