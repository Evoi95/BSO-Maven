package gestioneSito;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;

import database.UsersDao;
import usersSingelton.TempUser;
import usersSingelton.User;

public class ControllerGestioneUsers {
	
	private User U ;
	private TempUser Ut;
	private UsersDao Ud;
	private boolean state = false ;
	
	// chiamo questa funzione nel terzo caso d'uso quando voglio aggiungere manualmente un utente
	public boolean add(String n, String c,String r, String email, String pwd, String pwdC, LocalDate LocalDate) throws SQLException 
	{
		// TODO Auto-generated method stub
		
		Ut.getInstance().setEmail(email);
		Ut.getInstance().setPassword(pwd);

		if(checkData ( n,c,email,pwd,pwdC) )
		{
			if (UsersDao.checkTempUser(Ut) == 0)
			{
				Ut.getInstance().setIdRuolo(r);
				Ut.getInstance().setNome(n);
				Ut.getInstance().setCognome(c);
				Ut.getInstance().setDataDiNascita(LocalDate);
				Ut.getInstance();
				//User U1 = new User( n,c,email,pwd,LocalDate);
				state=Ud.createUser2(Ut);
			}
			else if (UsersDao.checkTempUser(Ut) == 1 || UsersDao.checkTempUser(Ut) == -1)
			{
				// utente gia registrato o errore 
				state = false;
			}
		}
		else {
			state=false;
		}
		return state;
	}

	private boolean checkData (String n, String c, String email, String pwd, String pwdC)
	// controll  all data
	{
		if(checkEmail(email) && checkPassword(pwd,pwdC) && checkNomeCognome(n,c))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	private boolean checkEmail(String email)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) 
			return false; 
		return pat.matcher(email).matches();
	}
    
	private boolean checkPassword(String pwd, String pwdC )
	{
		if(pwd.length()>=8 && pwdC.length()>=8 && pwd.equals(pwdC)) {
			return true;
		}
		else
		{
			return false;
			// to do : approfondire regex password
		}
	}
	
	private boolean checkNomeCognome(String n, String c)
	{
		if (n != null && c != null)
		{
			return true;
		}else {
		return false;
		}
	}
	
	// uso il temp user per 
	public TempUser getUserToModify(String Email)
	{
		// poi lo passpo al modify set boolean
		
		Ut.getInstance().setEmail(Email);
		if (true) {
			return Ut;
		}
		return null;		
	}
	
	// anche qui uso il temp user per associare la mail dell'utente da cancellare
	
	public boolean delete(String mail)
	{
		// associo la  mail netrante al temp user e la passo al dao che la elimina
		Ut.getInstance().setEmail(mail);
		if(Ud.deleteTempUser(Ut))
		{
			return true ; 
		}
		
		return false;
	}
	
	public boolean getReport()
	{
		return false ;
	}
}
