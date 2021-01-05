package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import abstractFactoryLogin.User;


public class UserDao {
	
	private static Statement st = null ;
	private static String query ;
	private static ResultSet rs;
	private static PreparedStatement prepQ = null;
    private Connection  conn;

    //public boolean 
    // use this function on controller after you had check the email
    // add an user on db after registration
    public boolean createUser(User U) throws SQLException
    {
    	boolean state=false;
    	try 
		{
			if (ConnToDb.connection())
			{
				 conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query="USE ispw";
				st.executeQuery(query);
			 	query= "INSERT INTO `ispw`.`users`"
			 			+ "(`Nome`,"
			 			+ "`Cognome`,"
			 			+ "`Email`,"
			 			+ "`pwd`,"
			 			+ "`DataDiNascita`)"
			 			+ "VALUES"
			 			+" "
			 			+ "(?,?,?,?,?)";
				prepQ = ConnToDb.conn.prepareStatement(query);	
				prepQ.setString(1,U.getNome()); // titolo
				prepQ.setString(2,U.getCognome()); //
				prepQ.setString(3,U.getEmail());
		 		prepQ.setString(4, U.getPassword());
		 		// alternativa NO se rompe tutto se passi un oggetto di tipo data java lui
		 		// vuole un oggetto di tipo data sql 
				prepQ.setDate(5, java.sql.Date.valueOf(U.getDataDiNascita().toString()));  
				prepQ.executeUpdate();
				//conn.close();
			 	System.out.println("utente Inserito con successo");
			 	state= true; // true		 			 	
			}
			else {
		    	System.err.print("Errore inserimento utenete");
		    	state= false ;
		    	}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	// errore
		//conn.close();				 	
		return state;
    	
    }
    
    //check User email if we found that we retun true else we return false
    //Qui viene passato dal controller un oggetto di tipo user
    public static int checkUser(User U) throws SQLException
    {
    	String email = U.getEmail();
    	try 
		{
			if (ConnToDb.connection())
			{
				Connection conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query="USE ispw";
				st.executeQuery(query);
			 	query="SELECT idUser FROM ispw.users where Email = '"+email+"' ;";
			 	rs = st.executeQuery(query);
			 	if(rs.next())
			 	{
				 	conn.close();				 	
			 		System.out.println("utente già registarto");
			 		return 1; // true
			 		// account al ready exists
			 	}
			 	else
			 	{
				 	conn.close();				 	
			 		return 0; // false
			 		// new account
			 	}

			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	// errore
    	return -1 ;
    }
     
 
    // this function check if you have changed password successfully 
    public static boolean checkResetpass (User U, String pwd,String email )
    {
    	//String email = U.getEmail();
    	System.out.println("Email : "+email);
    	try 
		{
			if (ConnToDb.connection())
			{
				Connection conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query="USE ispw";
				st.executeQuery(query);
			 	query="Update users SET pwd = '"+pwd+"' where Email = '"+email+"'";
			 	st.executeUpdate(query);
			 	conn.close();
			 	return true;
			 	
			 	

			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	// errore
    	return false ;
    }
    
    
    // delete a user from db 
    public static boolean deleteUser(int userId)
    {
    	try 
		{
			if (ConnToDb.connection())
			{
	    		Connection conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query="USE ispw";
				st.executeQuery(query);
			 	query="DELETE FROM user WHERE "+
				"userId = "+ userId +";";
			 	st.executeUpdate(query);
			 	conn.close();
			 	return true;
			 	
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	return false ;
    }
    
    
    // TO DO : Robe per modificare e aggiornare i dati sono del terzo caso d'uso
    
	

}
