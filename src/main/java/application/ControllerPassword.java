package application;

import java.sql.SQLException;

import abstractFactoryLogin.User;
import database.UserDao;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControllerPassword {
	private User U;
	private UserDao Ud;
	
	public ControllerPassword()
	{
		U = new User();
		Ud = new UserDao();
		
	}

	public void aggiornaPass(String email,String vecchiaP,String nuovaP) throws SQLException
	{
		/*
		 * todo daoUSer
		 */
		if(nuovaP.length()>=8 || !email.equals(""))
		{
			U = new User(email, vecchiaP);
			if(Ud.checkUser(U) == 1)
			{
				Ud.checkResetpass(U, nuovaP);
				Alert alert=new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Cambio password");// line 2
				alert.setHeaderText(" Passowrd aggiornata ");// line 3
				alert.showAndWait(); // line 5
			}
			else if  (Ud.checkUser(U) == 0 || Ud.checkUser(U) == -1 )
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
