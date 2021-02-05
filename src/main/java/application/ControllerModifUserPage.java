package application;

import java.sql.SQLException;
import java.time.LocalDate;

import database.UsersDao;
import usersSingelton.TempUser;
import usersSingelton.User;

public class ControllerModifUserPage {
	private UsersDao ud;
	private TempUser uT=TempUser.getInstance();
	
	
	
	public ControllerModifUserPage()
	{
		ud=new UsersDao();
		
	}



	public TempUser prendiLista(int id) throws SQLException {
		System.out.println("id in controllerMUP :"+ id);
		
		uT.getInstance().setIdU(id);
		
		return ud.getTempUserSingolo(uT);
		// TODO Auto-generated method stub
		
	}
	
	public int  prendiIdMax() throws SQLException
	{
		return ud.maxIdUSer();
	}



	public void aggiornaUtenteByAdmin(String n, String c, String e, String p, String d, LocalDate data, String r) throws NullPointerException {
		// TODO Auto-generated method stub
		uT.getInstance().setNome(n);
		uT.getInstance().setCognome(c);
		uT.getInstance().setEmail(e);
		uT.getInstance().setPassword(p);
		uT.getInstance().setDescrizione(d);
		uT.getInstance().setDataDiNascita(data);
		uT.getInstance().setIdRuolo(r);
		
		ud.aggiornaUtenteTemp(uT);
		
		
	}
	
	
}
