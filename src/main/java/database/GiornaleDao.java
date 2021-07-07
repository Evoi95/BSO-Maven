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
import factorybook.Giornale;
import factorybook.Raccolta;
import logger.Log;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GiornaleDao {
	private Factory f;
	private String name;
	private  Statement stmt = null ;
	private  Connection conn=null;
	private  ResultSet rs=null;
	

	private  String query ="USE ISPW;" ;
	private  PreparedStatement prepQ = null; 
	private  int q ; 
	private String categoria;
	private int disp=0;
	private int id=0;
	
	 private boolean state=false;
	 private String gior="giornale";
	 

	 
	
	
	
	
 	public void getDesc(factorybook.Giornale g) throws SQLException 
	{	  

 		


		 try 
		 {
					 conn = ConnToDb.generalConnection();
					 rs = stmt.executeQuery("select * from giornale where titolo ='"+g.getTitolo()+"'");
			 
	             stmt = conn.createStatement();
	 
	            while ( rs.next() ) {
	                 rs.getString("titolo");
	               rs.getString("tipologia");
	               rs.getString("lingua");	       
	                rs.getString("editore");
	               rs.getDate("dataPubblicazione");	
	                  rs.getInt("copiRim");	
	                 rs.getInt("disp");

	                 rs.getFloat("prezzo");
	                
	    	        
	            }
	        } catch (Exception e) {
	        	
	        	e.getMessage();
	        }
		 finally {
			 if(conn!=null)
			 {
			 
				conn.close();
			 }
			}
			 
		 
		 
		 }
	    
	
	public float getCosto(Giornale g)  
	{		
		float prezzo = 0;
		
		
		
		try
		{
			conn = ConnToDb.generalConnection();

				rs = stmt.executeQuery("select * from giornale where titolo  ='"+g.getTitolo()+"'");
	          stmt = conn.createStatement();
	         
	
	         while ( rs.next() ) {
	               prezzo=rs.getFloat("prezzo");
	
	         }
			}catch(SQLException e)
			{
				e.getCause();
			}
		finally {try {
			conn.close();
		} catch (SQLException |NullPointerException e) {
			e.printStackTrace();
		}}
		
		
	
		return prezzo;
		
	}
	
	public  void aggiornaDisponibilita(Giornale g) 
	{
		
		int d=g.getDisponibilita();
		

		 try {
			  conn = ConnToDb.generalConnection();
		      prepQ = conn.prepareStatement("update giornale set copiRim=copiRim-'"+d+"' where titolo='"+g.getTitolo()+"'");
			  prepQ.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	
	        	e.getMessage();

	         }	
		


		}

	public   void daiPrivilegi() 
	{
		
		
		 try {
			  conn = ConnToDb.generalConnection();
			  prepQ = conn.prepareStatement(" SET SQL_SAFE_UPDATES=0");
			         prepQ.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	e.getMessage();

	         }	
		 


}
	
	public  ObservableList<Raccolta> getGiornali() throws SQLException   {
		
		


		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		
		
		try {
			 conn= ConnToDb.generalConnection();
			
				stmt=conn.createStatement();
				rs=stmt.executeQuery("SELECT * FROM ispw.giornale");
		
		        while(rs.next())        
		           
		        {
		        	catalogo.add(f.createGiornale(gior,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)));
		        }
		    		
		        stmt.close();
		
		        
		
		
			
		}catch(SQLException e)
		{
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
	
	
	return catalogo;
		}
	
		
	public  Giornale getGiornale(Giornale g,int id) throws SQLException  
	{

		
		
		try  {
			conn=ConnToDb.generalConnection();
			
				stmt=conn.createStatement();
				rs=stmt.executeQuery("SELECT * FROM giornale where id = "+id+" ");
			
				if (rs.next())
		        {
		        	g = (Giornale) f.createGiornale(gior, rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate(), rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)) ;
		        	 
		        }
		        else {
		        	Log.logger.log(Level.SEVERE,"errore nel recupero gironale");
		
		        }
				stmt.close();
				
		
		
		}catch(SQLException e)
			{
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
		
		return g;
        
	}
	
	public GiornaleDao()
	{
		f=new Factory();
	}
		
	public  int retId(Giornale g)  {
			String titoloG=g.getTitolo();
			
			

			 try {
				conn = ConnToDb.generalConnection();
				stmt = conn.createStatement();
	          rs = stmt.executeQuery("select id from giornale where titolo ='"+titoloG+"'");

	         while ( rs.next() ) {
	              id=rs.getInt("id");

	         }
			 }catch(SQLException e) {
				 e.getMessage();
			 }
			 finally {try {
				conn.close();
			} catch (SQLException |NullPointerException  e) {
				e.printStackTrace();
			}}
			 
			return id;

			
			
		}

	public  String retTip(Giornale g)  {
		String titoloG;
			
			 titoloG=g.getTitolo();
			 

			 try  {
				  conn = ConnToDb.generalConnection();
				  stmt = conn.createStatement();
	          
	        	  rs=stmt.executeQuery("select tipologia from ispw.giornale where titolo ='"+titoloG+"'");

	         while ( rs.next() ) {
	              categoria=rs.getString("tipologia");

	         }
			 }catch(SQLException e)
			 {
				 e.getCause();
			 }
			 finally {
				 try {
					conn.close();
				} catch (SQLException  | NullPointerException e) {
					e.printStackTrace();
				}
			 }
				
			return categoria;

			
		}
			
	public  String getNome(Giornale g) throws SQLException  
	{
	
		
		
		try {		
			conn= ConnToDb.generalConnection();

			stmt=conn.createStatement();
			rs=stmt.executeQuery("SELECT titolo FROM giornale where id = "+g.getId()+" ");
			if (rs.next())
	        {
	        	name = rs.getString(1);
	        }
	        else {
	        	
	            name=null;
	
	        }	
			stmt.close();
		} catch (SQLException e) {
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
        
		return name;
   }

	public  int getDisp(Giornale g) 
	{
		
		
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				stmt=conn.createStatement();
				stmt.executeQuery(query);
		         stmt = conn.createStatement();

				rs=  stmt.executeQuery(
						"SELECT `giornale`.`disp` FROM `ispw`.`giornale` where `id` = `"+g.getId()+"` ;");
				disp = rs.getInt(1);
				if (disp >= 1)
					return disp;
				else if (disp == 0)
					return 0;
			}
		} catch (SQLException e) {
			e.getMessage();

		 
			
		}
		finally {
			try {
				conn.close();
			} catch (SQLException |NullPointerException e) {
				e.printStackTrace();
			}
		}
		
		return -1;
	}

	public  int getQuantita(Giornale g)  
	{
		
		
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				stmt=conn.createStatement();
				stmt.executeQuery(query);
		         stmt = conn.createStatement();

				rs=  stmt.executeQuery(
						"SELECT `giornale`.`copiRim` FROM `ispw`.`giornale` where `id` = "+g.getId()+" ;");
				if (rs.next()) {
					q = rs.getInt(1);
				}			
			}
		} catch (SQLException e) {
			e.getMessage();

		 
			
		}
		finally {
			
				try {
					conn.close();
				} catch (SQLException |NullPointerException e) {
					e.printStackTrace();
				}
			
		}
		

		return q;
	}

	public  boolean checkDisp(Giornale g,int id)  
	{
		
		
		try {
			
				conn = ConnToDb.generalConnection();
				stmt=conn.createStatement();
				stmt.executeQuery(query);
		         stmt = conn.createStatement();

				rs=  stmt.executeQuery("SELECT disp FROM giornale where id = '"+id+"' ;");
				if(rs.next())
					{
					 disp = rs.getInt(1);
					if (disp >= 1)
						state= true;
		            Log.logger.log(Level.INFO, "id .{0} ", g.getTitolo());
					}
			
		} catch (SQLException e) {
			e.getMessage();

		 
			
		}
		finally {
			try {
				conn.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}
		
		return state;
	}

	public  ObservableList<Giornale> getLibriSingolo() throws SQLException  {
		
		ObservableList<Giornale> catalogo=FXCollections.observableArrayList();
		
		
		 
			try {
				conn=ConnToDb.generalConnection();
				stmt= conn.createStatement();
				rs=stmt.executeQuery("SELECT * FROM giornale");
			
	            while(rs.next())
	            {
	
	        		
	        			catalogo.add((Giornale)f.createGiornale(gior,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)));
						
						
					 
						
					
	
	            }
	            stmt.close();
			} catch (SQLException e1) {
			 
				e1.printStackTrace();
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
			
			
	

		
            return catalogo;
		
	

	}


	public  boolean creaGiornale(Giornale g)  {
		

		
	    	try 
			{
	    		
					conn = ConnToDb.generalConnection();
					query= "INSERT INTO `ispw`.`giornale`"
				 			+ "(`titolo`,"
				 			+ "`tipologia`,"
				 			+ "`lingua`,"
				 			+ "`editore`,"
				 			+ "`dataPubblicazione`,"
				 			+ "`copiRim`,"
				 			+ "`disp`,"
				 			+ "`prezzo`)"
				 			+ "VALUES"
				 			+ "(?,?,?,?,?,?,?,?);"
				 			+ "";
					prepQ = ConnToDb.conn.prepareStatement(query);	
					prepQ.setString(1,g.getTitolo()); 
					prepQ.setString(2,g.getTipologia());
					prepQ.setString(3,g.getLingua());
					prepQ.setString(4,g.getEditore());
					prepQ.setDate(5, java.sql.Date.valueOf(g.getDataPubb().toString())); 
					prepQ.setInt(6,g.getCopieRimanenti());
					prepQ.setInt(7, g.getDisponibilita());
					prepQ.setFloat(8, g.getPrezzo());
					
					prepQ.executeUpdate();
					
				 	state= true; // true		 			 	
				}
			catch (SQLException e1) {
				e1.printStackTrace();
		    	Log.logger.log(java.util.logging.Level.SEVERE,"errore inserimento utente");

				}
	    	finally {try {
				conn.close();
			} catch (SQLException |NullPointerException  e) {
				e.printStackTrace();
			}}
	    	

	    					 	
			return state;
			
			
		}
		

	public  void cancella(Giornale g)  {
		

		try {
			
				conn = ConnToDb.generalConnection();
				stmt=conn.createStatement();
		        
				stmt.executeQuery(query);
				
				 prepQ=conn.prepareStatement("delete  FROM ispw.giornale where id = "+g.getId()+" ;");
				prepQ.executeUpdate();
				
		} catch (SQLException | NullPointerException  e) {
			e.getMessage();

		 
			
		}
		finally {try {
			conn.close();
		} catch (SQLException |NullPointerException e) {
			e.printStackTrace();
		}}
		
		
		
	}

	public ObservableList<Giornale> getGiornaliSingoloById(Giornale g) throws SQLException   {
		ObservableList<Giornale> catalogo=FXCollections.observableArrayList();
		
		
		 
			try {
				conn=ConnToDb.generalConnection();
				
				stmt= conn.createStatement();
				rs=stmt.executeQuery("SELECT * FROM giornale where id="+g.getId()+"");
			
            while(rs.next())
            {

        		
        			catalogo.add((Giornale)f.createGiornale(gior,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)));
					
        		

            }
			stmt.close();
			} catch (SQLException e1) {
						 
				e1.printStackTrace();
			}
			finally {
				if(conn!=null)
				{
				conn.close();}
				}if(rs!=null)
				{
					rs.close();
				}
			
			

		
		
		return catalogo;
		
	}

	public  ObservableList<Raccolta> getGiornaliByName(String s) throws SQLException {
		
		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		 
		 

         try
         {
        	 conn=ConnToDb.generalConnection();
        	 stmt=conn.createStatement();
        	 rs=stmt.executeQuery("SELECT * FROM giornale where titolo = '"+s+"' OR editore = '"+s+"'");
         
            while(rs.next())
            {

        		
        			catalogo.add(f.createGiornale(gior, rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)));
					
			}
            stmt.close();

            
         }catch(SQLException e)
         {
        	 e.getMessage();
         }
         finally {if(conn!=null)
			{
			conn.close();}
			}if(rs!=null)
			{
				rs.close();
			}
		
		return catalogo;
		

	}

	public  void aggiornaGiornale(Giornale g)  {
		

			try {			
				conn = ConnToDb.generalConnection();

				stmt=conn.createStatement();
			

			stmt.executeQuery(query);
		 	 query=" UPDATE `ispw`.`giornale`"
		 			+ "SET"
		 			+ "`titolo` =?,"
		 			+ "`tipologia` = ?,"
		 			+ "`lingua` = ?,"
		 			+ "`editore` = ?,"
		 			+ "`dataPubblicazione` = ?,"
		 			+ "`copiRim` = ?,"
		 			+ "`disp` = ?,"
		 			+ "`prezzo` = ?"
		 			+ "WHERE `id` = "+g.getId()+"";
			prepQ=conn.prepareStatement(query);
			
			prepQ.setString(1,g.getTitolo());
			prepQ.setString(2,g.getTipologia());
			prepQ.setString(3,g.getLingua());
			prepQ.setString(4, g.getEditore());
			prepQ.setString(5,g.getDataPubb().toString());
			prepQ.setInt(6,g.getCopieRimanenti());
			prepQ.setInt(7,g.getDisponibilita());
			prepQ.setFloat(8,g.getPrezzo());


			 prepQ.executeUpdate();
			prepQ.close();
			
            
            
			} catch (SQLException e) {
				e.getMessage();

			 
				
			}
			finally {try {
				conn.close();
			} catch (SQLException |NullPointerException e) {
				e.printStackTrace();
			}}
			

	 }	

	public   void generaReport() throws IOException, SQLException
	{
							 FileWriter w;
							 BufferedWriter b;
						     w=new FileWriter("ReportFinale\\riepilogoGiornali.txt");
					        b=new BufferedWriter (w);



		
			try (b){
				
					conn = ConnToDb.generalConnection();
					stmt=conn.createStatement();
					stmt.executeQuery(query);
					
					
					stmt=conn.createStatement();
					rs=stmt.executeQuery("select titolo,editore,copiRim,prezzo as totale  from giornale;");
					
				       

				        
				        while(rs.next())
				        {
				    	

					
									rs.getString(1);
									rs.getString(2);
									rs.getInt(3);
									rs.getFloat(4);
									
											
					
				    		b.write("Titolo :"+rs.getString(1)+"\t"+"Editore :"+rs.getString(2)+"\t"+"Ricavo totale :" +rs.getInt(3)*rs.getFloat(4)+"\n");




				 			b.flush();


				    			
				    		
				        
				        }
				        stmt.close();


				     
					
			} catch (SQLException | IOException e) {
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


		
	




