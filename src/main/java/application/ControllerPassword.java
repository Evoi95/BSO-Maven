package application;

import java.sql.SQLException;

import database.UsersDao;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import usersSingelton.User;

public class ControllerPassword {
	private User U = User.getInstance();
	private UsersDao Ud;
	
	public ControllerPassword()
	{
		Ud = new UsersDao();
		
	}

	public void aggiornaPass(String email,String vecchiaP,String nuovaP) throws SQLException
	{
		
		if(nuovaP.length()>=8 || !email.equals(""))
		{
			U.setEmail(email);
			U.setPassword(nuovaP);
			if(UsersDao.checkUser(U) == 1)
			{
				UsersDao.checkResetpass(U, nuovaP,email);
				Alert alert=new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Cambio password");// line 2
				alert.setHeaderText(" Passowrd aggiornata ");// line 3
				alert.showAndWait(); // line 5
			}
			else if  (UsersDao.checkUser(U) == 0 || UsersDao.checkUser(U) == -1 )
			{
				Alert alert=new Alert(AlertType.ERROR);
				alert.setTitle("Credenziali errate");// line 2
				alert.setHeaderText("Utente non trovato ");// line 3
				alert.setContentText(" Per favore re immettere o registrasi! ");// line 4
				alert.showAndWait(); // line 5
			}
			
		}
		else {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Credenziali errate");// line 2
			alert.setHeaderText("Credenziali non valide ");// line 3
			alert.setContentText(" Per favore re immettere ");// line 4
			alert.showAndWait(); // line 5

		}
	}
}
