package application;

import java.sql.SQLException;

import abstractFactoryLogin.User;
import database.UsersDao;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControllerPassword {
	private User U;
	private UsersDao Ud;
	
	public ControllerPassword()
	{
		U = new User();
		Ud = new UsersDao();
		
	}

	public void aggiornaPass(String email,String vecchiaP,String nuovaP) throws SQLException
	{
		/*
		 * todo daoUSer
		 */
		if(nuovaP.length()>=8 || !email.equals(""))
		{
			U = new User(email, vecchiaP);
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
