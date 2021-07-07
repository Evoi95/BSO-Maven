package controller_app;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;

import database.UsersDao;
import users.singelton.User;
import logger.Log;

public class ControllerModificaUtente {
	private boolean state = false;

	
	
	public ControllerModificaUtente()
	{
		Log.logger.log(Level.INFO,"ControllerModifUtente");
	}



	public User prendi() {
		
		return UsersDao.pickData(User.getInstance());
		
		
	}

	public boolean aggiorna(String n, String c, String email, String pass, String desc, LocalDate localDate, String vecchiaMail) throws SQLException {
		
		
		try {
		if( !n.equals("") && n!=null && !n.equals(User.getInstance().getNome()))
		{
			
			User.getInstance().setNome(n);
			UsersDao.aggiornaNome(User.getInstance());
			state =  true; 

		}
		if (!c.equals("") && c!=(null) && !c.equals(User.getInstance().getCognome()))
		{
			User.getInstance().setCognome(c);
			UsersDao.aggiornaCognome(User.getInstance());
			state =  true; 

		}
		if(!email.equals("") && email!=null && !email.equals(vecchiaMail))
		{
			
			UsersDao.aggiornaEmail(User.getInstance(),email);
			state =  true; 

	
		}
		if(!pass.equals("") && pass!=null && !pass.equals(User.getInstance().getPassword()))
		{
			User.getInstance().setPassword(pass);
			UsersDao.aggiornaPass(User.getInstance());
			state =  true; 

		}
		if(!desc.equals("") && desc!=(null) && !desc.equals(User.getInstance().getDescrizione()))
		{
			User.getInstance().setDescrizione(desc);
			UsersDao.aggiornaDesc(User.getInstance());
			state =  true; 
		}

		if(!(localDate.toString().equals(" ")) && localDate!=(null) && !localDate.equals(User.getInstance().getDataDiNascita()))
		{
			User.getInstance().setDataDiNascita(localDate);
			state = true;
			
		}
		//qui controllo se i campi sono vuoti 
		else { 
			return state;
		}
			
		
		}
		catch(NullPointerException e)
		{
			Log.logger.log(Level.INFO,"Ho torvato LocalDate come . {}",localDate);
			
		}
		return state;
			
	}
}
