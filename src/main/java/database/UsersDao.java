package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import usersSingelton.Admin;
import usersSingelton.Editore;
import usersSingelton.Scrittore;
import usersSingelton.User;



public class UsersDao {
	
	private static Statement st = null ;
	private static String query ;
	private static ResultSet rs;
	private static PreparedStatement prepQ = null;
    private Connection  conn;
	private User U = User.getInstance();

    //public boolean 
    // use this function on controller after you had check the email
    // add an user on db after registration
    // prende i dati dall'oggetto che gli abbiamo passato 
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
				prepQ.setString(1,U.getInstance().getNome()); // titolo
				prepQ.setString(2,U.getInstance().getCognome()); //
				prepQ.setString(3,U.getInstance().getEmail());
		 		prepQ.setString(4, U.getInstance().getPassword());
		 		// alternativa NO se rompe tutto se passi un oggetto di tipo data java lui
		 		// vuole un oggetto di tipo data sql 
				prepQ.setDate(5, java.sql.Date.valueOf(U.getInstance().getDataDiNascita().toString()));  
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
    	// ritorna int per motivi legati al controller
    	// anche se lo tratto come boolean
    	String email = U.getInstance().getEmail();
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
     
    public static String getRuolo (User U)
    {
    	String r = null ;

    	String email = U.getInstance().getEmail();
    	try 
		{
			if (ConnToDb.connection())
			{
				Connection conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query="USE ispw";
				st.executeQuery(query);
			 	query="SELECT idRuolo FROM ispw.users where Email = '"+email+"' ;";
			 	rs = st.executeQuery(query);
			 	if(rs.next())
			 	{
			 		r =rs.getString(1);
			 		U.getInstance().setIdRuolo(r);
				 	conn.close();				 	
			 		System.out.println("Ruolo utente : "+r);
			 		return r; // true
			 	}
			 	else
			 	{
				 	conn.close();				 	
			 		return null; // Errore
			 	}

			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	// errore

    	return r;
    	
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
    
    //
    public static Object findUser(User U)
    {
    	String r = U.getInstance().getIdRuolo();
    	if(r.contentEquals("U"))
    	{
    		return  U;
    	}
    	else if(r.contentEquals("A"))
    	{
    		Admin A = new Admin(U);
    		System.out.println(A);
    		return A;
    	}
    	else if(r.contentEquals("E"))
    	{
    		Editore E = new Editore(U);
    		System.out.println(E);

    		return E;
   		
    	}
    	else if(r.contentEquals("W"))
    	{
    		Scrittore W = new Scrittore(U);
    		System.out.println(W);
    		return W;
    	}
	return null;

    }
    
    // delete a user from db  terzo caso d'uso
    public static boolean deleteUser(User U)
    {
    	String Email = U.getInstance().getEmail();
    	try 
		{
			if (ConnToDb.connection())
			{
	    		Connection conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query="USE ispw";
				st.executeQuery(query);
			 	query="DELETE FROM users WHERE "+
				"Email = '"+ Email +"'";
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
    
   
    // Con pickData prendo i dati dall'utente creato per il login
    // per poi restituirlo in un nuovo oggetto di tipo User
    // e poi il controller lo specializza nelle 4 classi 
    public static User pickData(User U)
    {
    	String email = U.getInstance().getEmail();
    	try 
		{
			if (ConnToDb.connection())
			{
				Connection conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query="USE ispw";
				st.executeQuery(query);
			 	query="SELECT `idRuolo`,"
			 			+ "    `Nome`,"
			 			+ "    `Cognome`,"
			 			+ "    `Email`,"
			 			+ "    `descrizione`,"
			 			+ "    `DataDiNascita` "
			 			+ "		FROM users where Email = '"+email+"' ;";
			 	rs = st.executeQuery(query);
			 	if(rs.next())
			 	{
			 		// setto i vari dati 
			 		U.getInstance().setIdRuolo(rs.getString(1));
			 		U.getInstance().setNome(rs.getString(2));
			 		U.getInstance().setCognome(rs.getString(3));
			 		U.getInstance().setEmail(rs.getString(4));
			 		U.getInstance().setDescrizione(rs.getString(5));
			 		U.getInstance().setDataDiNascita(rs.getDate(6).toLocalDate());
			 				 		
			 		conn.close();	
			 	//	sono delle print messe per controllo 
			 	//	System.out.println("U: "+U+"\n Con i campi :\n Cognome "
			 	//			+ U.getCognome() + "\n email " + U .getEmail() + "\n ");
			 		return U ;
			 		 // true
			 		// account already exists
			 	}
			 	else
			 	{
				 	conn.close();				 	
				 	// false
			 		// new account
			 	}

			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	// errore
    	return null;
    }
    
    
    // TO DO : Robe per modificare e aggiornare i dati sono del terzo caso d'uso
    
	

}
