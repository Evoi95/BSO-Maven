package database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import factorybook.Factory;
import factorybook.Libro;
import factorybook.Raccolta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logger.Log;

public class LibroDao  {
	private Factory f;
	
	private  Statement st=null  ;
	private  String query ;
	private  PreparedStatement prepQ =null; 
	private  Connection conn ;
	private  int q; // quantita'
	private  ResultSet rs;
	private Statement stmt;
	private boolean state=false;
	private int row=0;
	int disp=0;
	int id=0;
	int rowAffected=0;
	
	private String usaDB="USE ISPW;";
	private String li="libro";


	
	
	//getIstance 
	
	public void getDesc(factorybook.Libro l) throws SQLException
	{	           
		conn = ConnToDb.generalConnection();

		 try {
	             stmt = conn.createStatement();
	 
	            rs = stmt.executeQuery("select * from libro where Cod_isbn ='"+l.getCodIsbn()+"'");
	            while ( rs.next() ) {
	                 rs.getString("titolo");
	               rs.getInt("numeroPagine");
	                rs.getString("Cod_isbn");
	                rs.getString("editore");
	                rs.getString("autore");
	                rs.getString("lingua");
	                rs.getString("categoria");
	                rs.getDate("dataPubblicazione");
	                rs.getString("recensione");
	                rs.getInt("copieVendute");
	                rs.getString("breveDescrizione");
	                rs.getInt("disp");
	                rs.getFloat("prezzo");
	                rs.getInt("copieRimanenti");


	                
	                
	            }
	        } catch (Exception e) {
	            Log.logger.log(Level.SEVERE, e.getMessage());
	        }
		 finally {
			 conn.close();
		 }
	    }
	
	public float getCosto(Libro l) throws SQLException
	{
		float prezzo=(float) 0.0;
		  conn = ConnToDb.generalConnection();
		 try {
          stmt = conn.createStatement();

         rs = stmt.executeQuery("select * from libro where idProd ='"+l.getId()+"'");
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
		Double d=(double)l.getDisponibilita();

		 try {
			  conn = ConnToDb.generalConnection();
		      stmt = conn.prepareStatement("update libro set copieRimanenti=copieRimanenti-'"+d+"' where Cod_isbn='"+l.getAutore()+"'");
			

	            
	         }catch(SQLException e)
	         {
	        	e.getMessage();

	         }	
		 finally {
			 conn.close();
			 Log.logger.log(Level.INFO,"Ho chiuso tutto");
			 
		 }

		 Log.logger.log(Level.INFO,"LibroDao. questy");

		}
	
	public void daiPrivilegi() throws SQLException
	{

		 try {
			  conn = ConnToDb.generalConnection();
			  stmt = conn.prepareStatement("SET SQL_SAFE_UPDATES=0");

	            
	         }catch(SQLException e)
	         {
	        	e.getMessage();

	         }	
		 finally {
			 conn.close();
			 Log.logger.log(Level.INFO,"Ho chiuso tutto");
			 
		 }

		 Log.logger.log(Level.INFO,"LibroDao. privilegi");

}

	public ObservableList<Raccolta> getLibri() throws SQLException
	{
		conn= ConnToDb.generalConnection();
		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("SELECT * FROM libro");

            while(rs.next())
            {

        		try {
					catalogo.add(f.createLibro(li,rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate(),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getFloat(13),rs.getInt(14),rs.getInt(15)));
        		} catch (Exception e) {
        			e.getMessage();
				 
					
				}

            }
		
		Log.logger.log(Level.INFO,"{0}",catalogo);
		return catalogo;
		
	}

	public ObservableList<Raccolta> getLibriByName(String s) throws SQLException
	{
		conn= ConnToDb.generalConnection();
		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("SELECT * FROM libro where titolo = '"+s+"' OR autore = '"+s+"'");

            while(rs.next())
            {

        		try {
					catalogo.add(f.createLibro(li,rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate(),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getFloat(13),rs.getInt(14),rs.getInt(15)));
        		} catch (Exception e) {
        			e.getMessage();

				 
					
				}

            }
		conn.close();
		Log.logger.log(Level.INFO,"{0}",catalogo);
		return catalogo;
		
	}


	
	public Libro getLibro(Libro l,int id) throws SQLException
	{

		conn= ConnToDb.generalConnection();
		stmt=conn.createStatement();
         rs=stmt.executeQuery("SELECT * FROM libro where idProd = "+id+" ");
        if (rs.next())
        {
        	l = (Libro) f.createLibro(li,rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate(),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getFloat(13),rs.getInt(14),rs.getInt(15));
        	return l;
        }
        else {
        	Log.logger.log(Level.INFO,"non ho torvato un cazzo e ritorno null");
            return l;

        }
	}
	
	public LibroDao()
	{
		f=new Factory();
	}

	public int retId(Libro l) throws SQLException {
		 conn = ConnToDb.generalConnection();
		 try {
          stmt = conn.createStatement();

         rs = stmt.executeQuery("select idProd from libro where Cod_isbn ='"+l.getCodIsbn()+"'");
         while ( rs.next() ) {
              id=rs.getInt("idProd");

         }
		 }catch(SQLException e)
		 {
			 e.getCause();
		 }finally {
			 conn.close();
		 }
		return id;

		
		
	}
	
	public String retTip(Libro l) throws SQLException {
		
		String categoria=l.getCategoria();
		  conn = ConnToDb.generalConnection();
		 try {
          stmt = conn.createStatement();

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

		 try {
			  conn = ConnToDb.generalConnection();
		      stmt = conn.prepareStatement("update libro set copieVendute=copievendute+'"+n+"' where Cod_isbn='"+l.getCodIsbn()+"'");

	            
	         }catch(SQLException e)
	         {
	        	e.getMessage();

	         }	
		 finally {
			 conn.close();
		}


	}
	
	// Creo il libro nel terzo caso d'uso per l'aggiunta manuale
	public boolean creaLibrio(Libro l)
	{


    	try 
		{
    		if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				st.executeQuery(usaDB);
			 	query= "INSERT INTO `ispw`.`libro`"
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
			 			+ "`copieRimanenti`)"
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
			 	Log.logger.log(Level.INFO,"Libro Inserito con successo");
			 	state= true; // true		 			 	
			}
			else {
				Log.logger.log(Level.SEVERE,"errore in inserimento libro");
				state= false ;
		    	}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}

		return state;
		
		
	}
	
	// uso questa funzione quando clicco sul pulsante acquista dopo aver
	//inserito la quantita da acquistare
	public int getDisp(Libro l) throws SQLException
	{
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				
				st.executeQuery(usaDB);
		         stmt = conn.createStatement();

				rs=  stmt.executeQuery(
						"SELECT `libro`.`disp` FROM `ispw`.`libro` where `idProd` = `"+l.getId()+"` ;");
				disp = rs.getInt(1);
				if (disp >= 1)
					disp=1;
				else if (disp == 0)
						disp=0;	
				}
		} catch (SQLException e) {
			e.getMessage();
		 
			
		}
		
		return disp;
	}
	
	public int getQuantita(Libro l) throws SQLException
	{
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
		        stmt = conn.createStatement();
				st.executeQuery(usaDB);
				rs=  stmt.executeQuery(	"SELECT `libro`.`copieRimanenti` FROM `ispw`.`libro` where `idProd` = "+l.getId()+" ");
				if (rs.next()) {
					q = rs.getInt(1);
				}
			
			}
		} catch (SQLException e) {
			e.getMessage();

		 
			
		}

		return q;
	}

	// Uso questo pulseante quando clicco sul pulsante mostra libro 
	public boolean checkDisp(Libro l,int id) throws SQLException
	{
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				st.executeQuery(usaDB);
		         stmt = conn.createStatement();

				
				rs=  stmt.executeQuery("SELECT disp FROM ispw.libro where idProd = '"+id+"' ;");
				if(rs.next())
					{
					disp = rs.getInt(1);
					if (disp >= 1)
						state=true;
			        Log.logger.log(Level.INFO, "libro trovato : .{0} ", l.getTitolo());
					}
			}
		} catch (SQLException e) {
			e.getMessage();
		 
			
		}
		return state;
	}

	//fare singoli get dal db con associazione alle funzioni 
	//o fare associazioni dal contoller
	
	public String getNome(Libro l) throws SQLException
	{
		String name;
		conn= ConnToDb.generalConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("SELECT libro.titolo FROM ispw.libro where idProd = '"+l.getId()+"' ");
        if (rs.next())
        {
        	name = rs.getString(1);
        }
        else {
        	Log.logger.log(Level.INFO,"non ho torvato un cazzo e ritorno null");
        	name=null;

        }	
        conn.close();
        return name;
   }
	
	public ObservableList<Libro> getLibriSingolo() throws SQLException
	{
		conn= ConnToDb.generalConnection();
		ObservableList<Libro> catalogo=FXCollections.observableArrayList();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("SELECT * FROM libro");
		 
             

            while(rs.next())
            {

        		try {
					catalogo.add((Libro) f.createLibro(li,rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate(),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getFloat(13),rs.getInt(14),rs.getInt(15)));
        		} catch (Exception e) {
        			e.getMessage();

				 
					
				}

            }
		
		Log.logger.log(Level.INFO,"{0}",catalogo);
		return catalogo;
		
	}

	public void cancella(Libro l) {
		

		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				st.executeQuery(usaDB);
				
				 prepQ=conn.prepareStatement("delete  FROM ispw.libro where idProd = "+l.getId()+" ;");
				 row=prepQ.executeUpdate();
				}
		} catch (SQLException e) {
			e.getMessage();
		 
			
		}
		
		Log.logger.log(Level.INFO,"Libro cancellato : .{0}",row);
	}
	
	public ObservableList<Libro> getLibriSingoloById(Libro l) throws SQLException
	{
		conn= ConnToDb.generalConnection();
		ObservableList<Libro> catalogo=FXCollections.observableArrayList();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("SELECT * FROM libro where idProd="+l.getId()+"");

            while(rs.next())
            {

        		try {
					catalogo.add((Libro) f.createLibro(li,rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8).toLocalDate(),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getFloat(13),rs.getInt(14),rs.getInt(15)));
        		} catch (Exception e) {
        			e.getMessage();

				 
					
				}

            }
		
		Log.logger.log(Level.INFO,"{0}",catalogo);
		return catalogo;
		
	}
	
	public void aggiornaLibro(Libro l) throws SQLException,NullPointerException
	{

		
		
			
			Log.logger.log(Level.INFO,"IdLibro prima del try nel dao: .{0}",l.getId());

			
		 	 

				 conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				
				Log.logger.log(Level.INFO,"Titolo dopo use ispw:.{0}",l.getTitolo());

				st.executeQuery(usaDB);
				
			 	 query=" UPDATE libro "
			 			+ "SET "
			 			+ " `titolo` =?,"
			 			+ " `numeroPagine` = ?,"
			 			+ " `Cod_isbn` = ?,"
			 			+ " `editore` = ?,"
			 			+ " `autore` = ?,"
			 			+ " `lingua` = ?,"
			 			+ " `categoria` = ?,"
			 			+ " `dataPubblicazione` = ?,"
			 			+ " `recensione` = ?,"
			 			+ " `copieVendute` = ?,"
			 			+ " `breveDescrizione` =?,"
			 			+ " `disp` = ?,"
			 			+ " `prezzo` = ?,"
			 			+ " `copieRimanenti` =?"
			 			+ " WHERE `idProd` ="+l.getId()+";";
				prepQ=conn.prepareStatement(query);
				
				prepQ.setString(1,l.getTitolo());
				prepQ.setInt(2,l.getNumPag());
				prepQ.setString(3,l.getCodIsbn());
				prepQ.setString(4,l.getEditore());
				prepQ.setString(5,l.getAutore());
				prepQ.setString(6,l.getLingua());
				prepQ.setString(7,l.getCategoria());
				prepQ.setString(8, l.getDataPubb().toString());
				prepQ.setString(9,l.getRecensione());
				prepQ.setInt(10,l.getNrCopie());
				prepQ.setString(11,l.getDesc());
				prepQ.setInt(12,l.getDisponibilita());
				prepQ.setFloat(13,l.getPrezzo());
				prepQ.setInt(14,l.getCopieRim());

	
				rowAffected = prepQ.executeUpdate();
				prepQ.close();
				
	            Log.logger.log(Level.INFO, "row affected .{0}", rowAffected);

			 
			 	
			
					

	


		 }	
			

	public void generaReport() throws SQLException, IOException
	{
		 FileWriter w;
         w=new FileWriter("ReportFinale\\riepilogoLibro.txt");

         BufferedWriter b;
         b=new BufferedWriter (w);
			try(b){
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				st.executeQuery(usaDB);
				
				
				stmt=conn.createStatement();
				rs=stmt.executeQuery("select titolo,copieVendute,prezzo as totale  from libro;");
				
				
		            while(rs.next())
		            {
		        		

				
								rs.getString(1);
								rs.getInt(2);
								rs.getFloat(3);
										
				
		        		b.write("Titolo :"+rs.getString(1)+"\t"+"Ricavo totale :" +rs.getInt(2)*rs.getFloat(3)+"\n");




		     			b.flush();


				}
		            stmt.close();
			
			}catch(SQLException | IOException e)
			{
				e.getMessage();
			}
		
	}

}

	


