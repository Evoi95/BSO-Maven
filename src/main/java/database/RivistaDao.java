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
import factorybook.Raccolta;
import factorybook.Rivista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logger.Log;

public class RivistaDao {
	private Factory f;
	private  Statement st = null ;
	private  String query ;
	private  PreparedStatement prepQ = null; 
	private  Connection conn ;
	private  int q;
	private  ResultSet rs;
	private int row=0;
	private int id = 0;
	private 		boolean state=false;
	private String rivista="SELECT * FORM RIVISTA;";
	private String usaDB="USE ISPW;";
	private String riv="rivista";


	
	
	
	public void getDesc(Rivista r)
	{
		 try {
	             conn = ConnToDb.generalConnection();
	             st = conn.createStatement();
	 
	            rs = st.executeQuery("select * from rivista where titolo ='"+r.getTitolo()+"'");
	            while ( rs.next() ) {
	                rs.getString("titolo");
	               rs.getString("tipologia");
	               rs.getString("autore");
	               rs.getString("lingua");	   
	               rs.getString("editore");
	               rs.getString("Descrizione");

	               rs.getDate("dataPubblicazione");
	               
	               rs.getInt("disp");
	               rs.getFloat("prezzo");
	               rs.getInt("copieRimanenti");


	                
	                
	    	        
	            }
	        } catch (Exception e) {
	            Log.logger.log(Level.SEVERE,"Errore in mysql");
	        }
		 finally {
			 try {
				conn.close();
			} catch (SQLException e) {
    			e.getMessage();

			 
				
			}
		 }
	    }
	
	public float getCosto(Rivista r) throws SQLException
	{
		float prezzo=(float) 0.0;
		  conn = ConnToDb.generalConnection();
         st = conn.createStatement();

         rs = st.executeQuery("select * from rivista  where titolo='"+r.getTitolo()+"'");
         while ( rs.next() ) {
              prezzo=rs.getFloat("prezzo");

         }
		return prezzo;
		
	}
	
	public void aggiornaDisponibilita(Rivista r) throws SQLException
	{
		int d=r.getCopieRim();

		 try {
			  conn = ConnToDb.generalConnection();
		      prepQ = conn.prepareStatement("update rivista set copieRimanenti=copieRimanenti-'"+d+"' where titolo='"+r.getTitolo()+"'");
			  prepQ.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	e.getMessage();

	         }	
		 finally {
			 prepQ.close();
			 conn.close();
			 Log.logger.log(Level.INFO,"Ho chiuso tutto");
			 
		 }

		 Log.logger.log(Level.INFO,"LibroDao. questy");

		}

	public void daiPrivilegi() throws SQLException
	{

		 try {
			  conn = ConnToDb.generalConnection();
			  prepQ = conn.prepareStatement(" SET SQL_SAFE_UPDATES=0");
			         prepQ.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	e.getMessage();

	         }	
		 finally {
			 prepQ.close();
			 conn.close();
			 Log.logger.log(Level.INFO,"Ho chiuso tutto");
			 
		 }

		 Log.logger.log(Level.INFO,"LibroDao. privilegi");

}
	
	public ObservableList<Raccolta> getRiviste() throws SQLException
	{
		 conn= ConnToDb.generalConnection();

		
		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		 
		st=conn.createStatement();
		rs=st.executeQuery(rivista);
            while(rs.next())
            {

        		try {
					catalogo.add(f.createRivista(riv,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toLocalDate(), rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11)));
					
					
        		} catch (Exception e) {
        			e.getMessage();

				 
					
				}

            }
		return catalogo;
		
	}
	
	public ObservableList<Raccolta> getRivisteByName(String s) throws SQLException
	{
		 conn= ConnToDb.generalConnection();

		
		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		 
		st=conn.createStatement();
		rs=st.executeQuery("SELECT * FROM ispw.rivista where titolo = '"+s+"' OR autore = '"+s+"'");
            while(rs.next())
            {

        		try {
					catalogo.add(f.createRivista(riv,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toLocalDate(), rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11)));
					
					
        		} catch (Exception e) {
        			e.getMessage();

				 
					
				}
        		
            }
	
			
		Log.logger.log(Level.INFO,"{0}",catalogo);
		return catalogo;
		
	}


	public Rivista getRivista(Rivista r,int id) throws SQLException
	{

		 conn= ConnToDb.generalConnection();
		 st=conn.createStatement();
		 rs=st.executeQuery("SELECT * FROM rivista where id = "+id+" ");
        while (rs.next())
        {
        	r = (Rivista) f.createRivista(riv, rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toLocalDate(),rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11)); 
        }
             return r;
	}

	public RivistaDao()
	{
		f=new Factory();
	}
	
	public int retId(Rivista r) throws SQLException {
		
		String titolo=r.getTitolo();
		  conn = ConnToDb.generalConnection();
		 try {
         st = conn.createStatement();

         rs = st.executeQuery("select id from rivista where titolo ='"+titolo+"'");
         while ( rs.next() ) {
              id=rs.getInt("id");

         }
		 }catch(SQLException e)
		 {
			 e.getCause();
		 }finally {
			 conn.close();
		 }
		return id;

		
		
	}

	public String retTip(Rivista r) throws SQLException {
		
		String categoria=null;
		  conn = ConnToDb.generalConnection();
		 try {
          st = conn.createStatement();

         rs = st.executeQuery("select tipologia from rivista where titolo ='"+r.getTitolo()+"'");
         while ( rs.next() ) {
              categoria=rs.getString("tipologia");

         }
		 }catch(SQLException e)
		 {
			 e.getCause();
		 }finally {
				conn.close();
			}
			
		return categoria;

		
	}
	
	public String getNome(Rivista r) throws SQLException
	{
		String name;

	 conn= ConnToDb.generalConnection();
	 st=conn.createStatement();
			 rs=st.executeQuery("SELECT titolo FROM rivista where id = "+r.getId()+" ");
        if (rs.next())
        {
        	name = rs.getString(1);
        	return name;
        }
        else {
        	Log.logger.log(Level.INFO,"non ho torvato un cazzo e ritorno null");
            return null;

        }	
   }

	public int getDisp(Rivista r) throws SQLException
	{
		int disp;
		try {
			conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=usaDB;

				st.executeQuery(query);
		         st = conn.createStatement();

				rs=  st.executeQuery(
						"SELECT `rivista`.`disp` FROM `ispw`.`rivista` where `id` = `"+r.getId()+"` ;");
				disp = rs.getInt(1);
				if (disp >= 1)
					return disp;
				else if (disp == 0)
					return 0;
			
		} catch (SQLException e) {
			e.getMessage();

		 
			
		}
		
		return -1;
	}
	
	public int getQuantita(Rivista r) throws SQLException
	{
        
		try {
			
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=usaDB;
				st.executeQuery(query);
				st=conn.createStatement();
				rs=  st.executeQuery(
						"SELECT `rivista`.`copieRimanenti` FROM `ispw`.`rivista` where `id` = "+r.getId()+" ;");
				if (rs.next()) {
					q = rs.getInt(1);
				}			
			
		} catch (SQLException e) {
		 e.getMessage();
			
		}

		return q;
	}

	public boolean checkDisp(Rivista r,int id) throws SQLException
	{
		int disp;
		try {
			
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=usaDB;
				st.executeQuery(query);
		         st = conn.createStatement();

				
				rs=  st.executeQuery("SELECT disp FROM ispw.rivista where id = '"+id+"' ;");
				if(rs.next())
					{
					disp = rs.getInt(1);
					if (disp >= 1)
						return true;
					Log.logger.log(Level.INFO, "rivista trovata con id .{0}",r.getId());
					}
			
		} catch (SQLException e1) {
			e1.getCause();
		 
			
		}
		return false;
	}

	public ObservableList<Rivista> getRivistaSingolo() throws SQLException {
		
		conn= ConnToDb.generalConnection();
		ObservableList<Rivista> catalogo=FXCollections.observableArrayList();
		
		st=conn.createStatement();
		 
             rs=st.executeQuery(rivista);

            while(rs.next())
            {

        		try {
        			catalogo.add((Rivista) f.createRivista(riv,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toLocalDate(),rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11)));					
        		} catch (Exception e) {
        			e.getMessage();

				 
					
				}

            }
		
		Log.logger.log(Level.INFO,"{0}",catalogo);
		return catalogo;
		
	}

	public Boolean creaRivista(Rivista r) {
    	try 
		{
    		
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=usaDB;
				st.executeQuery(query);
			 	query= "INSERT INTO `ispw`.`rivista`"
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
			 			+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			 	prepQ = ConnToDb.conn.prepareStatement(query);	
				prepQ.setString(1,r.getTitolo()); 
				prepQ.setString(2,r.getTipologia());
				prepQ.setString(3,r.getAutore());
				prepQ.setString(4,r.getLingua());
				prepQ.setString(5,r.getEditore());
				prepQ.setString(6,r.getDescrizione());
				prepQ.setDate(7, java.sql.Date.valueOf(r.getDataPubb().toString()));  
				prepQ.setInt(8, r.getDisp());
				prepQ.setFloat(9, r.getPrezzo());
				prepQ.setInt(10,r.getCopieRim());


				
				prepQ.executeUpdate();
			 	Log.logger.log(Level.INFO,"Libro Inserito con successo");
			 	state= true; // true		 			 	
			
			
		}
		catch (SQLException e1) {
			e1.printStackTrace();
			}

		return state;
		
		
	}

	public void cancella(Rivista r) {

		try {
			
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=usaDB;
				st.executeQuery(query);
				
				prepQ=conn.prepareStatement("delete  FROM ispw.rivista where id = "+r.getId()+" ;");
				 row=prepQ.executeUpdate();
				
		} catch (SQLException e) {
			e.getMessage();

		 
			
		}
		
		Log.logger.log(Level.INFO,"rivista cancellata .{0}",row);

		
		
	}

	public ObservableList<Rivista> getRivistaSingoloById(Rivista r) throws SQLException {
		
		conn= ConnToDb.generalConnection();
		ObservableList<Rivista> catalogo=FXCollections.observableArrayList();
		st=conn.createStatement();
		rs=st.executeQuery(rivista);

            while(rs.next())
            {

        		try {
        			catalogo.add((Rivista) f.createRivista(riv,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toLocalDate(),rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11)));					
        		} catch (Exception e) {
        			e.getMessage();
				 
					
				}

            }
		
		Log.logger.log(Level.INFO,"{}",r.getTitolo());
		return catalogo;
		
	}

	public void aggiornaRivista(Rivista r) throws SQLException {

		
			conn = ConnToDb.generalConnection();
			st=conn.createStatement();
			query=usaDB;
			

			st.executeQuery(query);
			query="UPDATE `ispw`.`rivista`"
		 			+ "SET"
		 			+ "`titolo` = ?,"
		 			+ "`tipologia` =?,"
		 			+ "`autore` = ?,"
		 			+ "`lingua` = ?,"
		 			+ "`editore` = ?,"
		 			+ "`Descrizione` =?,"
		 			+ "`dataPubblicazione` =?,"
		 			+ "`disp` = ?,"
		 			+ "`prezzo` = ?,"
		 			+ "`copieRimanenti` =?"
		 			+ "WHERE `id` = "+r.getId()+";";
		 		
		 	prepQ=conn.prepareStatement(query);
			
			prepQ.setString(1,r.getTitolo());
			prepQ.setString(2,r.getTipologia());
			prepQ.setString(3,r.getAutore());
			prepQ.setString(4,r.getLingua());
			prepQ.setString(5,r.getEditore());
			prepQ.setString(6,r.getDescrizione());
			prepQ.setString(7,r.getDataPubb().toString());
			prepQ.setInt(8,r.getDisp());
			prepQ.setFloat(9,r.getPrezzo());
			prepQ.setInt(10,r.getCopieRim());
		

			int rowAffected = prepQ.executeUpdate();
			prepQ.close();
			
            Log.logger.log(Level.INFO,"row affected .{0}",rowAffected);

	 }	
	
	public void generaReport() throws SQLException, IOException
	{
				FileWriter w;
		        w=new FileWriter("ReportFinale\\riepilogoRiviste.txt");
		        BufferedWriter b;
		        b=new BufferedWriter (w);
		        
		        try (b){
				conn = ConnToDb.generalConnection();
				st=conn.createStatement();
				query=usaDB;
				st.executeQuery(query);
				
				st=conn.createStatement();
				rs=st.executeQuery("select titolo,editore,copieRimanenti,prezzo as totale  from rivista;");
				
				
		           
		            while(rs.next())
		            {
		        		
		        	

				
								rs.getString(1);
								rs.getString(2);
								rs.getInt(3);
								rs.getFloat(4);
								
										
				
		        		b.write("Titolo :"+rs.getString(1)+"\t"+"Editore :"+rs.getString(2)+"\t"+"Ricavo totale :" +rs.getInt(3)*rs.getFloat(4)+"\n");




		     			b.flush();


		        			
		        		
		            }
		           		        st.close();

				
	}catch (SQLException | IOException e) {
		e.getMessage();
		 
		
	}
	finally {
		if(conn!=null)
		{
			conn.close();
		}
		if(rs!=null)
		{
			rs.close();
		}
		
	}
			
	
	
	}

		
}

		
	

	



