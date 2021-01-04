package database;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PopulateDefaultDb {

	
	private static String qInsert ;
	private static PreparedStatement prepQ = null;
    private BufferedImage slate;
	
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
	
	private static boolean createLibri() throws FileNotFoundException
	{
		try 
		{
			// ibnserisco dei libri per il db
			qInsert="INSERT INTO `ispw`.`libro`"
					+ "(`titolo`,"
					+ "`numeroPagine`,"
					+ "`Cod_isbn`,"
					+ "`editore`,"
					+ "`autore`,"
					+ "`lingua`,"
					+ "`categoria`,"
					+ "`dataPubblicazione`,"
					+ "`recensione`,"
					+ "`copieVendute`,"
					+ "`breveDescrizione`,"
					+ "`disp`,"
					+ "`prezzo`,"
					+ "`copieRimanenti`,"
					+ "`img`)"
					+ "  "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			prepQ = ConnToDb.conn.prepareStatement(qInsert);
			prepQ.setString(1,"Kobane calling. Oggi"); // titolo varchar 
			prepQ.setInt(2, 312); // numero pagine int
			prepQ.setString(3,"8832734591"); // 
			prepQ.setString(4, "Bao Publishing");
			prepQ.setString(5,"Zerocalcare");
			prepQ.setString(6,"Italiano");
			prepQ.setString(7,"FumettiEManga");
			//ps.setDate(2, new java.sql.Date(endDate.getTime());
			prepQ.setDate(8, java.sql.Date.valueOf("2020-09-04"));  // date
			prepQ.setString(9,"assurdo"); // recensione
			prepQ.setInt(10, 2000); // copie vendute
			prepQ.setString(11, "ciao"); // breve drescizione
			prepQ.setInt(12,1);
			prepQ.setFloat(13, 12);
			prepQ.setInt (14, 15);
			FileInputStream fin = new FileInputStream("img/icon.png");//file:///C:/Users/dani/git/BSO-Maven/src/main/java/images/icon.png");
			prepQ.setBinaryStream(15, fin);
			prepQ.executeUpdate();

			//libro 2
			prepQ = ConnToDb.conn.prepareStatement(qInsert);
			prepQ.setString(1,"A babbo morto. Una storia di Natale "); // titolo varchar 
			prepQ.setInt(2, 0); // numero pagine int
			prepQ.setString(3,"8832735512"); // 
			prepQ.setString(4, "Bao Publishing");
			prepQ.setString(5,"Zerocalcare");
			prepQ.setString(6,"Italiano");
			prepQ.setString(7,"FumettiEManga");
			//ps.setDate(2, new java.sql.Date(endDate.getTime());
			prepQ.setDate(8, java.sql.Date.valueOf("2020-11-12"));  // date
			prepQ.setString(9,"100"); // recensione
			prepQ.setInt(10, 2000); // copie vendute
			prepQ.setString(11, "ciao"); // breve drescizione
			prepQ.setInt(12,1);
			prepQ.setFloat(13, 12);
			prepQ.setInt (14, 15);

			fin = new FileInputStream("img/icon.png");

			//fin = new FileInputStream("main/java/images/icon.png");

			prepQ.setBinaryStream(15, fin);
			prepQ.executeUpdate();
			
			
			//libro 3
			prepQ = ConnToDb.conn.prepareStatement(qInsert);
			prepQ.setString(1,"Scheletri"); // titolo varchar 
			prepQ.setInt(2, 240); // numero pagine int
			prepQ.setString(3,"8832734893"); // 
			prepQ.setString(4, "Bao Publishing");
			prepQ.setString(5,"Zerocalcare");
			prepQ.setString(6,"Italiano");
			prepQ.setString(7,"FumettiEManga");
			//ps.setDate(2, new java.sql.Date(endDate.getTime());
			prepQ.setDate(8, java.sql.Date.valueOf("2020-11-12"));  // date
			prepQ.setString(9,"vai ragazza"); // recensione
			prepQ.setInt(10, 2000); // copie vendute
			prepQ.setString(11, "aaer"); // breve drescizione
			prepQ.setInt(12,11);
			prepQ.setFloat(13, 121);
			prepQ.setInt (14, 1522);

			fin = new FileInputStream("img/icon.png");

			//fin = new FileInputStream("main/java/images/icon.png");

			prepQ.setBinaryStream(15, fin);
			prepQ.executeUpdate();
			// popolo il db con utenti e dati 
			return true;
		}
	
		catch(SQLException e1) 
		{
			e1.printStackTrace();
			System.err.println("ERRORE DI SQL ");
		
		}
		return false;
	}

	private static boolean createGiornale() throws FileNotFoundException
	{
		try {
		qInsert = "INSERT INTO `ispw`.`giornale`"
				+ "(`titolo`,"
				+ "`tipologia`,"
				+ "`lingua`,"
				+ "`editore`,"
				+ "`dataPubblicazione`,"
				+ "`copiRim`,"
				+ "`disp`,"
				+ "`prezzo`,"
				+ "`img`)"
				+ "VALUES"
				+ "	"
				+ "(?,?,?,?,?,?,?,?,?)";
		prepQ = ConnToDb.conn.prepareStatement(qInsert);	
		prepQ.setString(1,"Republica"); // titolo
		prepQ.setString(2,"Giornale"); //
		prepQ.setString(3,"Italiano");
 		prepQ.setString(4, "Republica");
		prepQ.setDate(5, java.sql.Date.valueOf("2020-09-04"));  // date
		prepQ.setInt(6, 20); // copie rimanenti
		prepQ.setInt(7,1);
		prepQ.setFloat(8, 1);

		FileInputStream fin = new FileInputStream("img/icon.png");



		prepQ.setBinaryStream(9, fin);
		prepQ.executeUpdate();
		
		//giornale 2
		prepQ = ConnToDb.conn.prepareStatement(qInsert);	
		prepQ.setString(1,"La stampa"); // titolo
		prepQ.setString(2,"Giornale"); //
		prepQ.setString(3,"Italiano");
 		prepQ.setString(4, "La stampa");
		prepQ.setDate(5, java.sql.Date.valueOf("2020-09-04"));  // date
		prepQ.setInt(6, 30); // copie rimanenti
		prepQ.setInt(7,1);
		prepQ.setFloat(8, 1);

		fin = new FileInputStream("img/icon.png");


		prepQ.setBinaryStream(9, fin);
		prepQ.executeUpdate();
		
		//giornale 3
		prepQ = ConnToDb.conn.prepareStatement(qInsert);	
		prepQ.setString(1,"Il fatto quotidiano"); // titolo
		prepQ.setString(2,"Giornale"); //
		prepQ.setString(3,"Italiano");
 		prepQ.setString(4, "BHO");
		prepQ.setDate(5, java.sql.Date.valueOf("2020-09-04"));  // date
		prepQ.setInt(6, 15); // copie rimanenti
		prepQ.setInt(7,1);
		prepQ.setFloat(8, 1);

		fin = new FileInputStream("img/icon.png");


		prepQ.setBinaryStream(9, fin);
		prepQ.executeUpdate();
		
		return true;
		} 
		catch (SQLException e) {
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
				+ "`copieRimanenti`,"
				+ "`img`)"
				+ "	"
				+ "VALUES"
				+ " (?,?,?,?,?,?,?,?,?,?,?)";
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

		FileInputStream fin = new FileInputStream("img/icon.png");



		prepQ.setBinaryStream(11, fin);
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
		try {
			qInsert ="INSERT INTO `ispw`.`users`"
				+ "(`idRuolo`,"
				+ "`Nome`,`Cognome`,"
				+ "`Email`,`pwd`,"
				+ "`descrizione`,`DataDiNascita`)"
				+ "VALUES\r\n"
				+ "(?,?,?,?,?,?,?);";
				 
			prepQ = ConnToDb.conn.prepareStatement(qInsert);
			prepQ.setString(1, "a");
			prepQ.setString(2,"Gianni"); // nome
			prepQ.setString(3, "Morandi"); // cognome
			prepQ.setString(4, "bigHand@gmail.com"); // email 
			prepQ.setString(5,"bigHand97"); // password
			prepQ.setString(6,"Grande uomo grandi mani grande cuore");
			prepQ.setDate(7, java.sql.Date.valueOf("1944-12-11"));  // date
			prepQ.executeUpdate();
			
			qInsert ="INSERT INTO `ispw`.`users`"
					+ "(`idRuolo`,"
					+ "`Nome`,`Cognome`,"
					+ "`Email`,`pwd`,"
					+ "`descrizione`,`DataDiNascita`)"
					+ "VALUES\r\n"
					+ "(?,?,?,?,?,?,?);";
					 
			prepQ = ConnToDb.conn.prepareStatement(qInsert);
			prepQ.setString(1, "a");
			prepQ.setString(2,"Admin"); // nome
			prepQ.setString(3, "Admin"); // cognome
			prepQ.setString(4, "Admin@Admin.com"); // email 
			prepQ.setString(5,"Admin871"); // password
			prepQ.setString(6,"Grande uomo grandi mani grande cuore");
			prepQ.setDate(7, java.sql.Date.valueOf("1970-01-01"));  // date
			prepQ.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
