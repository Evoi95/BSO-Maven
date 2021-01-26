package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factoryBook.Factory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import factoryBook.Libro;
import factoryBook.Raccolta;

public class LibroDao  {
	private Factory f;
	private String titolo;
	private int numPag;
	private String codIsbn,editore,autore,lingua,categoria;
	private Date dataPubb;
	private String recensione;
	private int nrCopie; // numero copie vendute
	private String desc;
	private int disponibilita;
	private float prezzo;
	private int copieRim;
	private static Statement st = null ;
	private static String query ;
	private static String qTrigger ;
	private static PreparedStatement prepQ = null; 
	private static Connection conn ;
	private String name; 
	private static int q; // quantita'
	
	
	//getIstance 
	//select * from libro where codice=isbn;
	
	public void getDesc(factoryBook.Libro l) throws SQLException
	{	           
		conn = ConnToDb.generalConnection();

		 try {
	            //String url = "jdbc:msql://200.210.220.1:1114/Demo";
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("select * from libro where Cod_isbn ='"+l.getCodIsbn()+"'");
	            while ( rs.next() ) {
	                String titolo = rs.getString("titolo");
	                int pagine=rs.getInt("numeroPagine");
	                String codice=rs.getString("Cod_isbn");
	                String editore=rs.getString("editore");
	                String autore=rs.getString("autore");
	                String lingua=rs.getString("lingua");
	                String categoria=rs.getString("categoria");
	                Date data=rs.getDate("dataPubblicazione");
	                String recensione=rs.getString("recensione");
	                int copie=rs.getInt("copieVendute");
	                String desc=rs.getString("breveDescrizione");
	                int disp=rs.getInt("disp");
	                float prezzo=rs.getFloat("prezzo");
	                int copieR=rs.getInt("copieRimanenti");
	             //   InputStream img=rs.getBinaryStream("img");


	                
	                Alert alert = new Alert(AlertType.INFORMATION);
	    	        alert.setTitle("  Riepilogo  ");
	    	        alert.setHeaderText("Ecco il riepigolo del libro");
	    	        alert.setContentText("  Titolo : "+titolo+"\n"+"numero pagine : "+pagine+"\n"+"codice isbn :"+codice
	    	        		+"\n"+"editore : "+editore+ "\n"+"autore :"+autore+"\n"+"lingua :"+lingua+"\n"+"categoria :"+categoria+
	    	        		"\n"+"data pubblicazione : "+data+"\n"+"recensione :"+recensione+"\n"+"numero copie vendute :"+copie
	    	        		+"\n"+"descrizione :"+desc+"\n"+"copie disponibili :"+disp+"\n"+"prezzo :"+prezzo
	    	        		+"\n"+"copieRimanenti : "+copieR+"\n");
	    	        alert.showAndWait();
	    	        
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
		 finally {
			 conn.close();
		 }
	    }
	
	public float getCosto(Libro l) throws SQLException
	{
		float prezzo=(float) 0.0;
		 Connection conn = ConnToDb.generalConnection();
		 try {
         Statement stmt = conn.createStatement();
         ResultSet rs;

         rs = stmt.executeQuery("select * from libro where id_prod ='"+l.getIdBook()+"'");
         while ( rs.next() ) {
              prezzo=rs.getFloat("prezzo");

         }
		 }catch(SQLException e)
		 {
			 e.getCause();
		 }
		 finally {
			 conn.close();
		 }
		return prezzo;
		
	}
	
	public void aggiornaDisponibilita(Libro l) throws SQLException
	{
		PreparedStatement stmt=null;
		Double d=(double)l.getDisponibilita();

		 try {
			  conn = ConnToDb.generalConnection();
		      stmt = conn.prepareStatement("update libro set copieRimanenti=copieRimanenti-'"+d+"' where Cod_isbn='"+l.getAutore()+"'");
			  stmt.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	// esito=false;
	        	e.getMessage();

	         }	
		 finally {
			 stmt.close();
			 conn.close();
			 System.out.println("Ho chiuso tutto");
			 
		 }

		 System.out.println("LibroDao. questy");

		}
	
	public void daiPrivilegi() throws SQLException
	{
		PreparedStatement stmt=null;
	//	Double d=(double) disp;

		 try {
			  conn = ConnToDb.generalConnection();
			  stmt = conn.prepareStatement(" SET SQL_SAFE_UPDATES=0");
			         stmt.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	// esito=false;
	        	e.getMessage();

	         }	
		 finally {
			 stmt.close();
			 conn.close();
			 System.out.println("Ho chiuso tutto");
			 
		 }

		 System.out.println("LibroDao. privilegi");

}

	public ObservableList<Raccolta> getLibri() throws SQLException
	{
		Connection c= ConnToDb.generalConnection();
		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		 
            ResultSet rs=c.createStatement().executeQuery("SELECT * FROM libro");

            while(rs.next())
            {

        		try {
					catalogo.add(f.createLibro("libro",rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate(),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getFloat(13),rs.getInt(14),rs.getInt(15)));
					//rs=rs.next();
        		} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
		
		System.out.println(catalogo);
		return catalogo;
		
	}
	
	public Libro getLibro(Libro L,int id) throws SQLException
	{

		Connection c= ConnToDb.generalConnection();
        ResultSet rs=c.createStatement().executeQuery("SELECT * FROM libro where id_prod = "+id+" ");
        if (rs.next())
        {
        	L = (Libro) f.createLibro("libro",rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate(),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getFloat(13),rs.getInt(14),rs.getInt(15));
        	return L;
        }
        else {
        	System.out.println("non ho torvato un cazzo e ritorno null");
            return L;

        }
	}
	
	public LibroDao()
	{
		f=new Factory();
	}

	public int retId(Libro l) throws SQLException {
		int id = 0;
		 conn = ConnToDb.generalConnection();
		 try {
         Statement stmt = conn.createStatement();
         ResultSet rs;

         rs = stmt.executeQuery("select id_prod from libro where Cod_isbn ='"+l.getCodIsbn()+"'");
         while ( rs.next() ) {
              id=rs.getInt("id_prod");

         }
		 }catch(SQLException e)
		 {
			 e.getCause();
		 }finally {
			 conn.close();
		 }
		 //return id;
		return id;

		// TODO Auto-generated method stub
		
	}
	
	public String retTip(Libro l) throws SQLException {
		// TODO Auto-generated method stub
		String categoria=l.getCategoria();
		  conn = ConnToDb.generalConnection();
		 try {
         Statement stmt = conn.createStatement();
         ResultSet rs;

         rs = stmt.executeQuery("select categoria from libro where Cod_isbn ='"+l.getCodIsbn()+"'");
         while ( rs.next() ) {
              categoria=rs.getString("categoria");

         }
		 }catch(SQLException e)
		 {
			 e.getCause();
		 }finally {
				conn.close();
			}
			
		return categoria;

		
	}
	
	public void aggiornaCopieVendute(Libro l,int n) throws SQLException
	{
		PreparedStatement stmt=null;

		 try {
			  conn = ConnToDb.generalConnection();
		      stmt = conn.prepareStatement("update libro set copieVendute=copievendute+'"+n+"' where Cod_isbn='"+l.getCodIsbn()+"'");
			  stmt.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	// esito=false;
	        	e.getMessage();

	         }	
		 finally {
			 stmt.close();
			 conn.close();
		}


	}
	
	// Creo il libro nel terzo caso d'uso per l'aggiunta manuale
	public boolean creaLibrio(Libro l)
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
			 	query= "SELECT * FROM ispw.libro;INSERT INTO `ispw`.`libro`"
			 			+ "(`titolo`,"
			 			+ "`numeroPagine`,"
			 			+ "`Cod_isbn`,"
			 			+ "`editore`,"
			 			+ "`autore`,"
			 			+ "`lingua`,"
			 			+ "`categoria`,"
			 			+ "`dataPubblicazione`,"
			 			+ "`recensione`,"
			 			+ "`breveDescrizione`,"
			 			+ "`disp`,"
			 			+ "`prezzo`,"
			 			+ "`copieRimanenti`,"
			 			+ "VALUES"
			 			+ "(?,?,?,?,?,?,?,?,?,?,?,?,?);";
				prepQ = ConnToDb.conn.prepareStatement(query);	
				prepQ.setString(1,l.getTitolo()); 
				prepQ.setInt(2,l.getNrCopie());
				prepQ.setString(3,l.getCodIsbn());
				prepQ.setString(4,l.getEditore());
				prepQ.setString(5,l.getAutore());
				prepQ.setString(6,l.getLingua());
				prepQ.setString(7,l.getCategoria());
				prepQ.setDate(8, java.sql.Date.valueOf(l.getDataPubb().toString()));  
				prepQ.setString(9, l.getRecensione());
				prepQ.setString(10, l.getDesc());
				prepQ.setInt(11, l.getDisponibilita());
				prepQ.setFloat(12, l.getPrezzo());
				prepQ.setInt(13,l.getCopieRim());
				prepQ.executeUpdate();
				//conn.close();
			 	System.out.println("Libro Inserito con successo");
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

    	//conn.close();				 	
		return state;
		
		
	}
	
	// uso questa funzione quando clicco sul pulsante acquista dopo aver
	//inserito la quantita da acquistare
	public int getDisp(Libro l) throws SQLException
	{
		int disp;
        ResultSet rs;
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
		        Statement stmt = conn.createStatement();
				query="USE ispw";
				st.executeQuery(query);
				rs=  stmt.executeQuery(
						"SELECT `libro`.`disp` FROM `ispw`.`libro` where `id_prod` = `"+l.getIdBook()+"` ;");
				disp = rs.getInt(1);
				if (disp >= 1)
					return disp;
				else if (disp == 0)
					return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if (l.getDisponibilita()>=1)
		{
			return true;
		}*/
		return -1;
	}
	
	public int getQuantita(Libro l) throws SQLException
	{
        ResultSet rs;
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
		        Statement stmt = conn.createStatement();
				query="USE ispw";
				st.executeQuery(query);
				rs=  stmt.executeQuery(	"SELECT `libro`.`copieRimanenti` FROM `ispw`.`libro` where `id_prod` = "+l.getIdBook()+" ");
				if (rs.next()) {
					q = rs.getInt(1);
				}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return q;
	}

	// Uso questo pulseante quando clicco sul pulsante mostra libro 
	public boolean checkDisp(Libro l,int id) throws SQLException
	{
		int disp;
        ResultSet rs;
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
		        Statement stmt = conn.createStatement();
				query="USE ispw";
				st.executeQuery(query);
				
				rs=  stmt.executeQuery("SELECT disp FROM ispw.libro where id_prod = '"+id+"' ;");
				if(rs.next())
					{
					disp = rs.getInt(1);
					if (disp >= 1)
						return true;
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//fare singoli get dal db con associazione alle funzioni 
	//o fare associazioni dal contoller
	
	public String getNome(Libro L) throws SQLException
	{
		Connection c= ConnToDb.generalConnection();
        ResultSet rs=c.createStatement().executeQuery("SELECT libro.titolo FROM ispw.libro where id_prod = '"+L.getIdBook()+"' ");
        if (rs.next())
        {
        	name = rs.getString(1);
        	return name;
        }
        else {
        	System.out.println("non ho torvato un cazzo e ritorno null");
            return null;

        }	
   }


}
	


