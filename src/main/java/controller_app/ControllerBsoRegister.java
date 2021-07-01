package controller_app;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.regex.Pattern;
import logger.Log;

import database.UsersDao;
import users.singelton.User;

public class ControllerBsoRegister {
	private Boolean state=false;
	private UsersDao uD ;
	private User u=User.getInstance();
	private Pattern pattern;

	public Boolean registra(String n, String c, String email, String pwd, String pwdC, LocalDate LocalDate) throws SQLException {
		
		
		u.setEmail(email);
		u.setPassword(pwd);
		u.setDataDiNascita(LocalDate);
		
		if(checkData ( n,c,email,pwd,pwdC) )
		{
			if (UsersDao.checkUser(u) == 0)
			{
				// nuovo utente creo l'account
				u.setNome(n);
				u.setCognome(c);
				
				Log.logger.log(Level.INFO,"data in controller {0}",u.getDataDiNascita());
				state=uD.createUser(u);
			}
			else if (UsersDao.checkUser(u) == 1 || UsersDao.checkUser(u) == -1)
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
	
	
	//le chiamo protected perchele uso nel controller stesso e basta 
	public boolean checkData (String n, String c, String email, String pwd, String pwdC)
	// controll  all data
	{
		if(checkEmail(email) && checkPassword(pwd,pwdC) && checkNomeCognome(n,c))
		{
			state=true;
		}
		return state;
	}
	
	public boolean checkEmail(String email)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		pattern = Pattern.compile(emailRegex); 
		if (email == null) 
			return false; 
		return pattern.matcher(email).matches();
	}
    
	public boolean checkPassword(String pwd, String pwdC )
	{
		if(pwd.length()>=8 && pwdC.length()>=8 && pwd.equals(pwdC)) {
			state= true;
		}
		return state;
	}
	
	public boolean checkNomeCognome(String n, String c)
	{
		if (n != null && c != null)
		{
			state= true;
		}
		return state;
	}
	
	public ControllerBsoRegister()
	{
		uD=new UsersDao();
	}
	
	// TO DO: checkData o lo facciamo diretti in mysql
}
