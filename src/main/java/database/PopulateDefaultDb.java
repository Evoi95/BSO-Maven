package database;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.RuntimeSqlException;
import org.apache.ibatis.jdbc.ScriptRunner;

public class PopulateDefaultDb {

	
	private static String qInsert ;
	private static PreparedStatement prepQ = null;
    private static Connection conn;
	
	public static boolean populateDefaultDb() throws FileNotFoundException
	{
		if(	createLibri() && createGiornale() && createRivista() && createUser())
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
		System.out.println("---------Chiamo stored insLibri---------\n\n");
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
		System.out.println("---------Chiamo stored insGiornali---------\n\n");

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return false;
		
	}

	private static boolean createRivista() throws FileNotFoundException
	
	{
		try 
		{
		qInsert = "INSERT INTO `ispw`.`rivista`"
				+ "(`titolo`,"
				+ "`tipologia`,"
				+ "`autore`,"
				+ "`lingua`,"
				+ "`editore`,"
				+ "`Descrizione`,"
				+ "`dataPubblicazione`,"
				+ "`disp`,"
				+ "`prezzo`,"
				+ "`copieRimanenti`)"
				//+ "`img`)"
				+ "	"
				+ "VALUES"
				+ " (?,?,?,?,?,?,?,?,?,?)";
		prepQ = ConnToDb.conn.prepareStatement(qInsert);
		prepQ.setString(1,"cioe"); // titolo varchar
		prepQ.setString(2, "settimanale");
		prepQ.setString(3,"Mondadori");
		prepQ.setString(4,"Italiano");
		prepQ.setString(5,"Mondadori");
		prepQ.setString(6, "Che feeels"); // breve drescizione
		//ps.setDate(2, new java.sql.Date(endDate.getTime());
		prepQ.setDate(7, java.sql.Date.valueOf("2020-09-04"));  // date
		prepQ.setInt(8,1);
		prepQ.setFloat(9, 12);
		prepQ.setInt(10, 2000); // copie rimaneti
		/*
		FileInputStream fin = new FileInputStream("img/icon.png");



		prepQ.setBinaryStream(11, fin);*/
		prepQ.executeUpdate();
		
		return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private static boolean createUser()
	{
			System.out.println("---------Chiamo stored insUtenti---------\n\n");

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      //Running the script
				

			return true;
			} 
			catch (RuntimeSqlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
		
				return false;

		
	}
}
