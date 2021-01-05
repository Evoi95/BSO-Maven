package application;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;

import abstractFactoryLogin.User;
import database.UserDao;

public class ControllerBsoRegister {
	private Boolean state=false;
	private User U ;
	private UserDao Ud ;

	public Boolean registra(String n, String c, String email, String pwd, String pwdC, LocalDate LocalDate) throws SQLException {
		// TODO Auto-generated method stub
		
		U.setEmail(email);
		U.setPassword(pwd);
		//U = new User(email,pwd);
		
		if(checkData ( n,c,email,pwd,pwdC) )
		{
			if (UserDao.checkUser(U) == 0)
			{
				// nuovo utente creo l'account
				U.setNome(n);
				U.setCognome(c);
				U.setDataDiNascita(LocalDate);
				//User U1 = new User( n,c,email,pwd,LocalDate);
				state=Ud.createUser(U);
				//state=true;
			}
			else if (UserDao.checkUser(U) == 1 || UserDao.checkUser(U) == -1)
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
	
	public ControllerBsoRegister()
	{
		U=new User();
		Ud=new UserDao();
	}
	
	// TO DO: checkData o lo facciamo diretti in mysql
}
