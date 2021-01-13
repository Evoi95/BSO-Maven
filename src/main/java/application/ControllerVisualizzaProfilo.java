package application;

import database.UsersDao;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import usersSingelton.User;

public class ControllerVisualizzaProfilo {
	private UsersDao ud;
	private User u;
	private boolean status=false;

	public User getCredenziali() {
		
		return ud.pickData(u.getInstance());
		
	}
	
	public ControllerVisualizzaProfilo()
	{
		ud=new UsersDao();
	}

	public boolean cancellaUtente() {
		if(ud.deleteUser(u.getInstance())==true )
		{
		
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Cancellazione profilo");// line 2
				alert.setHeaderText("cancellazione");// line 3
				alert.setContentText("!--Utente  cancellato--!");// line 4
				alert.showAndWait(); // line 5
				
				
				u.getInstance().setNull();
				return true;
				//System.out.println("USer @"+u.getInstance());

				/*
				 * TODO settare istanze a null oppure checkuser
				 */
		}
		return false;
				
				//		return status;


		}
}
		
		
		// TODO Auto-generated method stub
		
	


