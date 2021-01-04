package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControllerPassword {
	
	public ControllerPassword()
	{
		
	}

	public void aggiornaPass(String email,String vecchiaP,String nuovaP)
	{
		/*
		 * todo daoUSer
		 */
		if(nuovaP.length()>=8 && !email.equals(""))
		{
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Cambio password");// line 2
			alert.setHeaderText(" Passowrd aggiornata ");// line 3
			alert.showAndWait(); // line 5

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
