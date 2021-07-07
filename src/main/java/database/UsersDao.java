package database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;

import users.singelton.Admin;
import users.singelton.Editore;
import users.singelton.Scrittore;
import users.singelton.TempUser;
import users.singelton.User;
import logger.Log;

public class UsersDao  {
	
	private static Statement st = null ;
	private static String query ;
	private static ResultSet rs;
	private static PreparedStatement prepQ = null;
    private static Connection  conn;
	private static int max;
	private static String r;
	private static boolean state=false;
	private static String useDb="USE ISPW;";
	
	

    // use this function on controller after you had check the email
    // add an user on db after registration
    // prende i dati dall'oggetto che gli abbiamo passato 
    public static boolean createUser(User u) throws SQLException
    {
    	LocalDate d=u.getDataDiNascita();
    	
    	
    	try 
		{
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=useDb;
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
				prepQ.setString(1,User.getInstance().getNome()); 
				prepQ.setString(2,User.getInstance().getCognome()); 
				prepQ.setString(3,User.getInstance().getEmail());
		 		prepQ.setString(4, User.getInstance().getPassword());
		 		
		 		
				prepQ.setDate(5, java.sql.Date.valueOf(d));  
				prepQ.executeUpdate();
				
			 	state= true; 		 			 	
			}
			else {
		    	Log.logger.log(java.util.logging.Level.SEVERE,"Errore in inserimento utente");
		    	}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	// errore
    	finally {
    		conn.close();
    	}
		return state;
    	
    }
    
    //Uso questa funzione quando un admin deve creare un utente 
    //tramite il terzo caso d'uso per la gestione del sito  
    public static boolean createUser2(TempUser uT) throws SQLException
    {
    	
    	LocalDate d=uT.getDataDiNascita();
    	try 
		{
			
				 conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=useDb;
				st.executeQuery(query);
			 	query= "INSERT INTO `ispw`.`users`"
			 			+ "(`idRuolo`,"
			 			+ "`Nome`,"
			 			+ "`Cognome`,"
			 			+ "`Email`,"
			 			+ "`pwd`,"
			 			+ "`descrizione`,"
			 			+ "`DataDiNascita`)"
			 			+ "VALUES (?,?,?,?,?,?,?)";
			 	prepQ = ConnToDb.conn.prepareStatement(query);	
				prepQ.setString(1,uT.getIdRuolo());
			 	prepQ.setString(2,uT.getNome()); 
				prepQ.setString(3,uT.getCognome()); 
				prepQ.setString(4,uT.getEmail());
		 		prepQ.setString(5, uT.getPassword());
		 		prepQ.setString(6, uT.getDescrizione());
		 		// alternativa NO se rompe tutto se passi un oggetto di tipo data java lui
		 		// vuole un oggetto di tipo data sql 
				prepQ.setDate(7, java.sql.Date.valueOf(d)); 
				//prepQ.setString(7,U.getInstance())
				prepQ.executeUpdate();
				
			 	state= true; // true		 			 	
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	finally {conn.close();}
    	// errore
						 	
		return state;
    	
    }

    //check User email if we found that we return true else we return false
    //Qui viene passato dal controller un oggetto di tipo user
    public static    int checkUser(User u) throws SQLException
    {
    	// ritorna int per motivi legati al controller
    	// anche se lo tratto come boolean
    	String email = User.getInstance().getEmail();
    	
    	
    	int id;

    	try 
		{
			
				 conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=useDb;
				st.executeQuery(query);
			 	query="SELECT idUser FROM ispw.users where Email = '"+email+"' ;";
			 	rs = st.executeQuery(query);
			 	if(rs.next())
			 	{
			 		id=rs.getInt(1);
			 		
			 		if(id>0)
			 		{			 			
			 			Log.logger.log(Level.INFO,"utente trovato .{0}",u.getEmail());

			 			return 1;
			 		}		 		}
			 	else
			 	{
			 		return 0; // false
			 	}

			}
		
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	// errore
    	finally {
    		conn.close();
    	}
    	return -1 ;
    }
     
    //Questo check
    public static int checkTempUser(TempUser uT) throws SQLException
    {
    	// ritorna int per motivi legati al controller
    	// anche se lo tratto come boolean
    	String email = uT.getEmail();
    	try 
		{
			
				 conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=useDb;
				st.executeQuery(query);
			 	query="SELECT idUser FROM ispw.users where Email = '"+email+"' ;";
			 	rs = st.executeQuery(query);
			 	if(rs.next())
			 	{
				 	conn.close();				 	
			 		return 1; // true
			 		// account al ready exists
			 	}
			 	else
			 	{
				 	conn.close();				 	
			 		return 0; 
			 		// new account
			 	}

			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	return -1 ;
    }
     
    public static String getRuolo (User u)
    {

    	String email = u.getEmail();
    	try 
		{
			
				 conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=useDb;
				st.executeQuery(query);
			 	query="SELECT idRuolo FROM ispw.users where Email = '"+email+"' ;";
			 	rs = st.executeQuery(query);
			 	if(rs.next())
			 	{
			 		r =rs.getString(1);
			 		User.getInstance().setIdRuolo(r);
			 		
			 	}
			 	else
			 	{
			 		return null; // Errore
			 	}

			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	// errore
    	finally {
    		try {
				conn.close();
			} catch (SQLException e) {
				e.getMessage();
			 
				
			}
    	}

    	return r;
    	
    }
    
    // this function check if you have changed password successfully 
    public static boolean checkResetpass (User u, String pwd,String email ) throws SQLException
    {
    	
    	try 
		{
			
				 conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=useDb;
				st.executeQuery(query);
			 	query="Update users SET pwd = '"+pwd+"' where Email = '"+email+"'";
			 	st.executeUpdate(query);
			 	Log.logger.log(Level.INFO,"update pwd ok .{0}",u.getNome());

			 	return true;
			 	
			 	

			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	finally {
    		conn.close();
    	}
    	// errore
    	return false ;
    }
    
    //
    public static Object findUser(TempUser u)
    {
    	 r = TempUser.getInstance().getIdRuolo();
    	if(r.contentEquals("U"))
    	{
    		return  u;
    	}
    	else if(r.contentEquals("A"))
    	{
    		Admin a;
    		a=new Admin(u);
    		return a;
    	}
    	else if(r.contentEquals("E"))
    	{
    		
    		Editore e;
    		e=new Editore(u);
    		return e;
   		
    	}
    	else if(r.contentEquals("W"))
    	{
    		Scrittore w;
    		w=new Scrittore(u);
    		return w;
    	}
	return null;

    }
    
    // delete a user from db  terzo caso d'uso
   
    public static boolean deleteUser(User user)
    {
    	String email = user.getEmail();
    	String ruolo=user.getIdRuolo();
    	try 
		{
			if (ConnToDb.connection()  && ruolo.equals("U"))
			{
	    		 conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=useDb;
				st.executeQuery(query);
			 	query="DELETE FROM users WHERE Email = '"+ email +"'";
			 	st.executeUpdate(query);
			 	Log.logger.log(Level.INFO,"cancello utente user .{0}" ,user.getIdRuolo());
			 	return true;
			 	
			}
			else if (ConnToDb.connection()  && ruolo.equals("a"))
				{
		    		 conn = ConnToDb.generalConnection();
					st=conn.createStatement();
					query=useDb;
					st.executeQuery(query);
				 	query="DELETE FROM users WHERE idUser = '"+user.getIdU() +"'";
				 	st.executeUpdate(query);
				 	Log.logger.log(Level.INFO,"cancello utente admin .{0}" ,user.getIdRuolo());

				 	return true;
				 	
				}
				
				
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	finally {
    		try {
				conn.close();
			} catch (SQLException e) {
				e.getMessage();

			 
				
			}
    	}
    	return false ;
    }

    public static boolean deleteTempUser(TempUser uT) throws SQLException
    {
    	String email = uT.getEmail();
    	try 
		{
			
	    		 conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=useDb;
				st.executeQuery(query);
			 	query="DELETE FROM users WHERE Email = '"+ email +"'";
			 	st.executeUpdate(query);
			 	Log.logger.log(Level.INFO,"cancello utente di tipo generico .{0}" ,uT.getIdRuolo());
			 	return true;
			 	
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	finally {
    		conn.close();
    	}
    	return false ;
    }

    // Con pickData prendo i dati dall'utente creato per il login
    // per poi restituirlo in un nuovo oggetto di tipo User
    // e poi il controller lo specializza nelle 4 classi 
    public static User pickData(User u)
    {
    	String email = u.getEmail();
    	try 
		{
			
				 conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=useDb;
				st.executeQuery(query);
			 	query="SELECT `idRuolo`,"
			 			+ "    `Nome`,"
			 			+ "    `Cognome`,"
			 			+ "    `Email`,"
			 			+ "    `descrizione`,"
			 			+ "    `DataDiNascita` "
			 			+ "FROM users where Email = '"+email+"' ;";
			 	rs = st.executeQuery(query);
			 	while(rs.next())
			 	{
			 		// setto i vari dati 
			 		u.setIdRuolo(rs.getString(1));
			 		u.setNome(rs.getString(2));
			 		u.setCognome(rs.getString(3));
			 		u.setEmail(rs.getString(4));
			 		u.setDescrizione(rs.getString(5));
			 		u.setDataDiNascita(rs.getDate(6).toLocalDate());
			 				 		
			 		
			 		return u ;
			 		 
			 	}
			 	
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}
    	finally{
    		try {
				conn.close();
			} catch (SQLException e) {
				e.getMessage();

			 
				
			}
    	}
    	// errore
    	return u;
    }
         
    public static User aggiornaNome(User u) throws SQLException
    {
        String email = User.getInstance().getEmail();
        
        try 
    	{
    		
    		
    			
    			conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set Nome=? where Email='"+email+"'";
    		 	

    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,User.getInstance().getNome() );
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	conn.close();
        }
    	// errore
    	return u;
    }
    
    public static User aggiornaCognome(User u)
    {
        String email = User.getInstance().getEmail();
        
        try 
    	{
    		
    		
    			
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set Cognome=? where Email='"+email+"'";
    		 	

    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,User.getInstance().getCognome() );
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 		conn.close();	
    		 	
    		 
    	}  catch (SQLException e1) {
    		e1.printStackTrace();
    		}
    	// errore
    	return u;
    }
    
    public static User aggiornaEmail(User u,String m) throws SQLException
    {
        String email = u.getEmail();
        
        try 
    	{
    		
    		
    			
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set Email=? where Email='"+email+"'";
    		 	
    		 	u.setEmail(m);
    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,u.getEmail() );
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	conn.close();
        }
    	// errore
    	return u;
    }

	public static  User aggiornaPass(User u) throws SQLException {
		
		String email = u.getEmail();
        
        try 
    	{
    		
    		
    			
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set pwd=? where Email='"+email+"'";
    		 	
    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,u.getPassword());
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	conn.close();
        }
    	// errore
    	return u;
    }

	public static User aggiornaDesc(User u) {
		String email = u.getEmail();
        
        try 
    	{
    		
    		
    			
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set descrizione=? where Email='"+email+"'";
    		 	
    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,u.getDescrizione());
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    	return u;
    }

	public static User aggiornaData(User u) {
		String email = User.getInstance().getEmail();
		LocalDate data=u.getDataDiNascita();

        try 
    	{
    		
    		
    			
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set DataDiNascita=? where Email='"+email+"'";
    		 	
    		 	
    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,data.toString());
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 		
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    	return u;
    }

	// Per il terzo caso d'uso creo e uso sempre il temp user per appoggiarmi all'utente che modifico  e quindi 
	
    public static TempUser aggiornaTempNome(TempUser uT) throws SQLException
    {
        String email = uT.getEmail();
        
        try 
    	{
    		
    		
    			
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query="USE ispw";
    			st.executeQuery(query);
    		 	query="UPDATE users set Nome=? where Email='"+email+"'";
    		 	

    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,uT.getNome() );
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	conn.close();
        }
    	// errore
    	return uT;
    }
    
    public static TempUser aggiornaCognome(TempUser uT) throws SQLException
    {
        String email = uT.getEmail();
        
        try 
    	{
    		
    		
    			
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set Cognome=? where Email='"+email+"'";
    		 	

    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,uT.getCognome() );
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 			
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	conn.close();
        }
    	// errore
    	return uT;
    }
    
    public static TempUser aggiornaEmail(TempUser uT,String m) throws SQLException
    {
        String email = uT.getEmail();
        
        try 
    	{
    		
    		
    			
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set Email=? where Email='"+email+"'";
    		 	
    		 	TempUser.getInstance().setEmail(m);
    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,uT.getEmail() );
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	conn.close();
        }
    	// errore
    	return uT;
    }
    
    public static TempUser aggiornaTempUtente(TempUser uT, String emailN) throws SQLException
    {
    String email = uT.getEmail();
   
	try 
	{
		
		
			
			 conn = ConnToDb.generalConnection();
			st=conn.createStatement();
			query=useDb;
			st.executeQuery(query);
		 	query="UPDATE users set idRuolo=?,Nome=?,Cognome=?,Email=?,pwd=?,descrizione=?,DataDiNascita=? where Email='"+email+"'";
		 	
			uT.setEmail(emailN);

		 	
			prepQ = conn.prepareStatement(query);

		 		
		 		// setto i vari dati 
		 	prepQ.setString(1,uT.getIdRuolo());
		 	prepQ.setString(2,uT.getNome() );
		 	prepQ.setString(3, uT.getCognome());
		 	prepQ.setString(4, uT.getEmail());
		 	prepQ.setString(5, uT.getPassword());
		 	prepQ.setString(6, uT.getDescrizione());
		 	prepQ.setString(7, uT.getDataDiNascita().toString());




			prepQ.executeUpdate();

		 		
		 				 		
		 		
		 	
		 
	}
	catch (SQLException e1) {
		e1.printStackTrace();
		}
	finally {
		conn.close();
	}
	// errore
	return uT;
}
   
	public static TempUser aggiornaTempPass(TempUser uT) throws SQLException {
		
		String email = uT.getEmail();
        
        try 
    	{
    		
    		
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set pwd=? where Email='"+email+"'";
    		 	
    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,uT.getPassword());
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 		
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	conn.close();
        }
    	// errore
    	return uT;
    }

	public static TempUser aggiornaTempDesc(TempUser uT) {
		String email = uT.getEmail();
        
        try 
    	{
    		
    		
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set descrizione=? where Email='"+email+"'";
    		 	
    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,uT.getDescrizione());
       			prepQ.executeUpdate();  		 		
    		 				 		
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	try {
				conn.close();
			} catch (SQLException e) {
				e.getMessage();

			 
				
			}
        }
    	// errore
    	return uT;
    }

	public static TempUser aggiornaTempData(TempUser uT) throws SQLException {
		String email = uT.getEmail();
        
        try 
    	{
    		
    		
    			
    			 conn = ConnToDb.generalConnection();
    			st=conn.createStatement();
    			query=useDb;
    			st.executeQuery(query);
    		 	query="UPDATE users set DataDiNascita=? where Email='"+email+"'";
    		 	
    		 	
    			prepQ = conn.prepareStatement(query);

       		 	prepQ.setString(1,uT.getDataDiNascita().toString());
       			prepQ.executeUpdate();  		 		
    		 			 		
    		 	
    		 
    	}
    	catch (SQLException e1) {
    		e1.printStackTrace();
    		}
        finally {
        	conn.close();
        }
    	// errore
    	return null;
    }
	

	public static  void getListaUtenti() throws IOException  {
		
		conn= ConnToDb.generalConnection();
		FileWriter w;
        w=new FileWriter("ReportFinale\\riepilogoUtenti.txt");

        BufferedWriter b;
        b=new BufferedWriter (w);
			try (b) {
				
				st=conn.createStatement();
					rs = st.executeQuery("SELECT * FROM users");
				
            

            
           while(rs.next())
            {
        			 
        		TempUser.getInstance().setIdU(rs.getInt(1));
        		TempUser.getInstance().setIdRuolo(rs.getString(2));
       			TempUser.getInstance().setNome(rs.getString(3));
       			TempUser.getInstance().setCognome(rs.getString(4));
       			TempUser.getInstance().setEmail(rs.getString(5));
       			TempUser.getInstance().setDescrizione(rs.getString(7));
       			TempUser.getInstance().setDataDiNascita(rs.getDate(8).toLocalDate());
       			
       			
       			
       			b.write(""+TempUser.getInstance().getIdU()+"\t"+TempUser.getInstance().getIdRuolo()+"\t"+TempUser.getInstance().getNome()+"\t"+TempUser.getInstance().getCognome()+
       					"\t"+TempUser.getInstance().getEmail()+"\t"+TempUser.getInstance().getDescrizione()+"\t"+TempUser.getInstance().getDataDiNascita().toString()+"\n");
       			




       			b.flush();


        			
        		
            }
            }catch(IOException |SQLException  e)
        		{
					e.getMessage();
        		} 
           finally {

        	   try {
				conn.close();
			} catch (SQLException e) {
				e.getMessage();

			 
				
			}           
           }
		}
            
	
	
	public static TempUser getTempUserSingolo(TempUser uT) throws SQLException
	{
		int id=uT.getIdU();
		
		
		
		
		 conn = ConnToDb.generalConnection();
		st=conn.createStatement();
		query=useDb;
		st.executeQuery(query);
		query="SELECT * FROM ispw.users where idUser = "+id+" ;";

	 	rs = st.executeQuery(query);
	 	

		 

            while(rs.next())
            {
            	
            	uT.setIdRuolo(rs.getString(2));
            	uT.setNome(rs.getString(3));
            	uT.setCognome(rs.getString(4));
            	uT.setEmail(rs.getString(5));
            	uT.setPassword(rs.getString(6));
            	uT.setDescrizione(rs.getString(7));
            	uT.setDataDiNascita(rs.getDate(8).toLocalDate());
            	

            }
            
		return uT;
	}
	
	public static User aggiornaUtente(User u) throws SQLException
    {
    
		LocalDate d=u.getDataDiNascita();

	try 
	{
		
		
			
			 conn = ConnToDb.generalConnection();
			st=conn.createStatement();
			query=useDb;
			st.executeQuery(query);
		 	query="UPDATE users set idRuolo=?,Nome=?,Cognome=?,Email=?,pwd=?,descrizione=?,DataDiNascita=? where idUser="+u.getIdU()+"";
		 	

		 	
			prepQ = conn.prepareStatement(query);

		 		// setto i vari dati 
		 	prepQ.setString(1,u.getIdRuolo());
		 	prepQ.setString(2,u.getNome() );
		 	prepQ.setString(3, u.getCognome());
		 	prepQ.setString(4, u.getEmail());
		 	prepQ.setString(5,u.getPassword());
		 	prepQ.setString(6, u.getDescrizione());
		 	prepQ.setString(7,d.toString());




			prepQ.executeUpdate();

		 		
		 				 		
		 		
		 	
		 	
		 
	}
	catch (SQLException e1) {
		e1.printStackTrace();
		}
	finally {
		conn.close();
	}
	return u;
}

	public static int maxIdUSer() throws SQLException
	{
			 conn=ConnToDb.generalConnection();
			 st=conn.createStatement();
			 st.execute("select max(idUser) from ispw.users");
	           rs=st.getResultSet();
	          if (rs.next())
	          {
	        	  max=rs.getInt(1);
	          }
		return max;
}
	
	public static TempUser aggiornaUtenteTemp(TempUser uT) throws NullPointerException, SQLException
    {
    
	try 
	{
		
		
			
			 conn = ConnToDb.generalConnection();
			st=conn.createStatement();
			query=useDb;
			st.executeQuery(query);
		 	query="UPDATE users set idRuolo=?,Nome=?,Cognome=?,Email=?,pwd=?,descrizione=?,DataDiNascita=? where idUser="+uT.getIdU()+"";
		 	

		 	
			prepQ = conn.prepareStatement(query);

		 		// setto i vari dati 
		 	prepQ.setString(1,uT.getIdRuolo());
		 	prepQ.setString(2,uT.getNome() );
		 	prepQ.setString(3, uT.getCognome());
		 	prepQ.setString(4, uT.getEmail());
		 	prepQ.setString(5, uT.getPassword());
		 	prepQ.setString(6, uT.getDescrizione());
		 	prepQ.setString(7, uT.getDataDiNascita().toString());




			prepQ.executeUpdate();

		 		
		 				 		
		 	
		 
	}
	catch (SQLException e1) {
		e1.printStackTrace();
		}
	finally {
		conn.close();
	}
	// errore
	return uT;
}

private UsersDao()
{
	
}

}
