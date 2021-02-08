package application;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;

import usersSingelton.User;
import database.UsersDao;

public class ControllerBsoRegister {
	private Boolean state=false;
	private User U ;
	private UsersDao Ud ;

	public Boolean registra(String n, String c, String email, String pwd, String pwdC, LocalDate LocalDate) throws SQLException {
		// TODO Auto-generated method stub
		
		U.getInstance().setEmail(email);
		U.getInstance().setPassword(pwd);
		//U = new User(email,pwd);
		
		if(checkData ( n,c,email,pwd,pwdC) )
		{
			if (UsersDao.checkUser(U) == 0)
			{
				// nuovo utente creo l'account
				U.getInstance().setNome(n);
				U.getInstance().setCognome(c);
				U.getInstance().setDataDiNascita(LocalDate);
				//User U1 = new User( n,c,email,pwd,LocalDate);
				state=Ud.createUser(U);
				//state=true;
			}
			else if (UsersDao.checkUser(U) == 1 || UsersDao.checkUser(U) == -1)
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
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean checkEmail(String email)
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
    
	public boolean checkPassword(String pwd, String pwdC )
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
	
	public boolean checkNomeCognome(String n, String c)
	{
		if (n != null && c != null)
		{
			return true;
		}else {
		return false;
		}
	}
	
	public ControllerBsoRegister()
	{
		//U.getInstance();
		Ud=new UsersDao();
	}
	
	// TO DO: checkData o lo facciamo diretti in mysql
}
