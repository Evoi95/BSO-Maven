package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;

import org.apache.ibatis.jdbc.RuntimeSqlException;
import org.apache.ibatis.jdbc.ScriptRunner;
import logger.Log;

public class PopulateDefaultDb {

	
	private static String qInsert ;
	private static PreparedStatement prepQ = null;
    private static Connection conn;
	
	public static boolean populateDefaultDb() throws FileNotFoundException
	{
		if(	createLibri() && createGiornale() && createRivista() && createUser() && createNegozio())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private static boolean createLibri() 
	{
		Log.logger.log(Level.INFO,"---------Chiamo stored insLibri---------\n\n");
		try 
		{
			
			conn=ConnToDb.generalConnection();
			 ScriptRunner sr = new ScriptRunner(conn);
			 
			 //&& preso come terminatore-> eseguito;	
			 sr.setSendFullScript(true);
		      //Creating a reader object
		      Reader reader = new BufferedReader(new FileReader("FileSql/storedInsLibri.sql"));
		      //Running the script
		      sr.runScript(reader);
			

			return true;
		}
	
		catch(FileNotFoundException | RuntimeSqlException e1) 
		{
			e1.printStackTrace();
			System.err.println("ERRORE DI SQL ");
		
		}
		
		return false;
	}

	private static boolean createGiornale() throws FileNotFoundException
	{
		Log.logger.log(Level.INFO,"---------Chiamo stored insGiornali---------\n\n");

		try {
			conn=ConnToDb.generalConnection();
			 ScriptRunner sr = new ScriptRunner(conn);
			 
			 //&& preso come terminatore-> eseguito;	
			 sr.setSendFullScript(true);
		      //Creating a reader object
		      Reader reader = new BufferedReader(new FileReader("FileSql/stroredInsGiornali.sql"));
		      //Running the script
		      sr.runScript(reader);
		      return true;
		} 
		catch (RuntimeSqlException e) {
		 
			
		}
		

		return false;
		
	}

	private static boolean createRivista() throws FileNotFoundException
	{
	Log.logger.log(Level.INFO,"---------Chiamo stored insRiviste---------\n\n");
	try 
	{
		
		conn=ConnToDb.generalConnection();
		 ScriptRunner sr = new ScriptRunner(conn);
		 
		 //&& preso come terminatore-> eseguito;	
		 sr.setSendFullScript(true);
	      //Creating a reader object
	      Reader reader = new BufferedReader(new FileReader("FileSql/storedInsRiviste.sql"));
	      //Running the script
	      sr.runScript(reader);
		

		return true;
	}

	catch(FileNotFoundException | RuntimeSqlException e1) 
	{
		e1.printStackTrace();
		System.err.println("ERRORE DI SQL ");
	
	}
	
	return false;
	}

	private static boolean createUser()
	{
			Log.logger.log(Level.INFO,"---------Chiamo stored insUtenti---------\n\n");

			try {
				conn=ConnToDb.generalConnection();
				 ScriptRunner sr = new ScriptRunner(conn);
				 
				 //&& preso come terminatore-> eseguito;	
				 sr.setSendFullScript(true);
			      //Creating a reader object
			      Reader reader;
				try {
					reader = new BufferedReader(new FileReader("FileSql/storedInsUtenti.sql"));
					sr.runScript(reader);

				} catch (FileNotFoundException e) {
				 
					
				}
			      //Running the script
				

			return true;
			} 
			catch (RuntimeSqlException e) {
			 
				
			}
			

		
		
				return false;

		
	}
	
	private static boolean createNegozio()
	{
			Log.logger.log(Level.INFO,"---------Chiamo stored insNEgozi---------\n\n");

			try {
				conn=ConnToDb.generalConnection();
				 ScriptRunner sr = new ScriptRunner(conn);
				 
				 //&& preso come terminatore-> eseguito;	
				 sr.setSendFullScript(true);
			      //Creating a reader object
			      Reader reader;
				try {
					reader = new BufferedReader(new FileReader("FileSql/storedInsNegozio.sql"));
					sr.runScript(reader);

				} catch (FileNotFoundException e) {
				 
					
				}
			      //Running the script
				

			return true;
			} 
			catch (RuntimeSqlException e) {
			 
				
			}
			

		
		
				return false;

		
	}
}
