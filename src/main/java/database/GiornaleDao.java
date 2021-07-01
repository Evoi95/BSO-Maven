package database;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;

import logger.Log;
import factoryBook.Factory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import factoryBook.Giornale;
import factoryBook.Raccolta;
import factoryBook.Rivista;

public class GiornaleDao {
	private Factory f;
	private String name;
	private static Statement stmt = null ;
	private static String query ;
	private static PreparedStatement prepQ = null; 
	private static Connection conn ;
	private static int q ; 
	private static ResultSet rs;
	private String categoria;
	
	
	
	
 	public void getDesc(factoryBook.Giornale g) 
	{	  
 		 String titolo;
 		 String tipologia;
 		 String lingua;
 		 String editore;
 		 Date data;
 		 int copieR;
 		 int disp;
 		 int rowAffected=0;
		 conn = ConnToDb.generalConnection();

		 try {
	             stmt = conn.createStatement();
	 
	            rs = stmt.executeQuery("select * from giornale where titolo ='"+g.getTitolo()+"'");
	            while ( rs.next() ) {
	                 titolo = rs.getString("titolo");
	                 tipologia=rs.getString("tipologia");
	                 lingua=rs.getString("lingua");	       
	                 editore=rs.getString("editore");
	                 data=rs.getDate("dataPubblicazione");	
	                 copieR=rs.getInt("copiRim");	
	                 disp=rs.getInt("disp");

	                float prezzo=rs.getFloat("prezzo");
	                
	    	        
	            }
	        } catch (Exception e) {
	        	
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
	
	public float getCosto(Giornale g) 
	{		  conn = ConnToDb.generalConnection();	
	float prezzo=(float) 0.0;


		try {
          stmt = conn.createStatement();
         

         rs = stmt.executeQuery("select * from giornale where titolo  ='"+g.getTitolo()+"'");
         while ( rs.next() ) {
              prezzo=rs.getFloat("prezzo");

         }
		}catch(SQLException e)
		{
			e.getCause();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.getMessage();
			 
				
			}
		}
		return prezzo;
		
	}
	
	public void aggiornaDisponibilita(Giornale g) 
	{
		Connection conn=null;
		PreparedStatement stmt=null;
		int d=g.getDisponibilita();
		

		 try {
			  conn = ConnToDb.generalConnection();
		      stmt = conn.prepareStatement("update giornale set copiRim=copiRim-'"+d+"' where titolo='"+g.getTitolo()+"'");
			  stmt.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	
	        	e.getMessage();

	         }	
		 finally {
			 try {
				conn.close();
			} catch (SQLException |NullPointerException e) {
				e.getMessage();

			 
				
			}
			 
		 }


		}

	public void daiPrivilegi() 
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
			
			 try {
				conn.close();
			} catch (SQLException | NullPointerException e) {
				e.getMessage();
			 
				
			}
			 
		 }


}
	
	public ObservableList<Raccolta> getGiornali()  {
		
		
		 conn= ConnToDb.generalConnection();

		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		 
		try {
			rs = conn.createStatement().executeQuery("SELECT * FROM ispw.giornale");
		
        while(rs.next())
        {
           

    		
				catalogo.add(f.createGiornale("giornale",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)));
    		

        }
		} catch (SQLException e1) {
		 
			e1.printStackTrace();
		}
		finally {
    	

        try {
			conn.close();
		} catch (SQLException e) {
		 
			e.getMessage();

		}
		}
	
	
	return catalogo;
		}
	
		
	public Giornale getGiornale(Giornale g,int id) 
	{

		conn= ConnToDb.generalConnection();
		try {
			rs = conn.createStatement().executeQuery("SELECT * FROM giornale where id = "+id+" ");
		if (rs.next())
        {
        	g = (Giornale) f.createGiornale("giornale", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate(), rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)) ;
        	 
        }
        else {

        }
		} catch (SQLException e) {
			e.getMessage();

		 
			
		}
		finally {
			try {
				conn.close();	

			} catch (SQLException e) {
				e.getMessage();

			 
				
			}		

		}
		return g;
        
	}
	
	public GiornaleDao()
	{
		f=new Factory();
	}
		
	public int retId(Giornale g) throws SQLException {
			int id = 0;
			String titolo=g.getTitolo();
			  conn = ConnToDb.generalConnection();
			 try {
	          stmt = conn.createStatement();

	         rs = stmt.executeQuery("select id from giornale where titolo ='"+titolo+"'");
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

	public String retTip(Giornale g)  {
		String titolo;
			
			 titolo=g.getTitolo();
			  conn = ConnToDb.generalConnection();
			 try {
	          stmt = conn.createStatement();
	        

	         rs = stmt.executeQuery("select tipologia from ispw.giornale where titolo ='"+titolo+"'");
	         while ( rs.next() ) {
	              categoria=rs.getString("tipologia");

	         }
			 }catch(SQLException e)
			 {
				 e.getCause();
			 }finally {
					try {
						conn.close();
					} catch (SQLException e) {
						e.getMessage();

					 
						
					}
				}
				
			return categoria;

			
		}
			
	public String getNome(Giornale g) 
	{
	
		conn= ConnToDb.generalConnection();
		try {
			rs = conn.createStatement().executeQuery("SELECT titolo FROM giornale where id = "+g.getId()+" ");
		if (rs.next())
        {
        	name = rs.getString(1);
        }
        else {
        	
            name=null;

        }	
		} catch (SQLException e) {
			e.getMessage();

		 
			
		}
        finally {
        	try {
				conn.close();
			} catch (SQLException e) {
				e.getMessage();

			 
				
			}
        }
		return name;
   }

	public int getDisp(Giornale g) 
	{
		int disp;
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				stmt=conn.createStatement();
		        Statement stmt = conn.createStatement();
				query="USE ispw";
				stmt.executeQuery(query);
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
			} catch (SQLException e) {
				e.getMessage();

			 
				
			}
		}
		return -1;
	}

	public int getQuantita(Giornale g) 
	{
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				stmt=conn.createStatement();
				query="USE ispw";
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
			} catch (SQLException e) {
				e.getMessage();

			 
				
			}
		}

		return q;
	}

	public boolean checkDisp(Giornale g,int id) 
	{
      
        boolean state=false;
		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				stmt=conn.createStatement();
				query="USE ispw";
				stmt.executeQuery(query);
		         stmt = conn.createStatement();

				rs=  stmt.executeQuery("SELECT disp FROM giornale where id = '"+id+"' ;");
				if(rs.next())
					{
					int disp = rs.getInt(1);
					if (disp >= 1)
						state= true;
					}
			}
		} catch (SQLException e) {
			e.getMessage();

		 
			
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.getMessage();

			 
				
			}
		}
		return state;
	}

	public ObservableList<Giornale> getLibriSingolo()  {
		
		Connection c= ConnToDb.generalConnection();
		ObservableList<Giornale> catalogo=FXCollections.observableArrayList();
		 
			try {
				rs = c.createStatement().executeQuery("SELECT * FROM giornale");
			
            while(rs.next())
            {

        		
        			catalogo.add((Giornale)f.createGiornale("giornale",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)));
					
					
				 
					
				

            }
			} catch (SQLException e1) {
			 
				e1.printStackTrace();
			}
			finally {
				try {
					c.close();
				} catch (SQLException e) {
					e.getMessage();

					
				}
			}

		
            return catalogo;
		
	

	}


	public boolean creaGiornale(Giornale g) throws SQLException {
		


			boolean state=false;
	    	try 
			{
	    		if (ConnToDb.connection())
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
				else {
			    	Log.logger.log(java.util.logging.Level.SEVERE,"errore inserimento utente");
			    	state= false ;
			    	}
			}
			catch (SQLException e1) {
				e1.printStackTrace();
				}
	    	finally {
	    		conn.close();
	    	}

	    					 	
			return state;
			
			
		}
		

	public void cancella(Giornale g) {

		try {
			if (ConnToDb.connection())
			{
				conn = ConnToDb.generalConnection();
				stmt=conn.createStatement();
		        
				query="USE ispw";
				stmt.executeQuery(query);
				
				 prepQ=conn.prepareStatement("delete  FROM ispw.giornale where id = "+g.getId()+" ;");
				prepQ.executeUpdate();
				}
		} catch (SQLException e) {
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

	public ObservableList<Giornale> getGiornaliSingoloById(Giornale g)  {
		conn= ConnToDb.generalConnection();
		ObservableList<Giornale> catalogo=FXCollections.observableArrayList();
		 
			try {
				rs = conn.createStatement().executeQuery("SELECT * FROM giornale where id="+g.getId()+"");
			
            while(rs.next())
            {

        		
        			catalogo.add((Giornale)f.createGiornale("giornale",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)));
					
        		

            }
			} catch (SQLException e1) {
			 
				e1.printStackTrace();
			}
			finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.getMessage();
				 
					
				}
			}

		
		
		return catalogo;
		
	}

	public ObservableList<Raccolta> getGiornaliByName(String s) throws SQLException {
		
		conn= ConnToDb.generalConnection();
		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		 
             rs=conn.createStatement().executeQuery("SELECT * FROM giornale where titolo = '"+s+"' OR editore = '"+s+"'");

            while(rs.next())
            {

        		try {
        			catalogo.add(f.createGiornale("giornale", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)));
					
        		} catch (Exception e) {
    				e.getMessage();

				 
					
				}

            }
		conn.close();
		return catalogo;
		

	}

	public void aggiornaGiornale(Giornale g)  {
		
		
		
		
		

		
	 	 

			 conn = ConnToDb.generalConnection();
			try {
				stmt=conn.createStatement();
			query="USE ispw";
			

			stmt.executeQuery(query);
		 	String query=" UPDATE `ispw`.`giornale`"
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


			int rowAffected = prepQ.executeUpdate();
			prepQ.close();
			
            
            
			} catch (SQLException e) {
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

	public static void generaReport() 
	{
			try {
				if (ConnToDb.connection())
				{
					conn = ConnToDb.generalConnection();
					stmt=conn.createStatement();
					query="USE ispw";
					stmt.executeQuery(query);
					
					
					rs=conn.createStatement().executeQuery("select titolo,editore,copiRim,prezzo as totale  from giornale;");
					
					 FileWriter w;
				        w=new FileWriter("ReportFinale\\riepilogoGiornali.txt");

				        BufferedWriter b;
				        b=new BufferedWriter (w);
				        while(rs.next())
				        {
				    	

					
									rs.getString(1);
									rs.getString(2);
									rs.getInt(3);
									rs.getFloat(4);
									
											
					
				    		b.write("Titolo :"+rs.getString(1)+"\t"+"Editore :"+rs.getString(2)+"\t"+"Ricavo totale :" +rs.getInt(3)*rs.getFloat(4)+"\n");




				 			b.flush();


				    			
				    		
				        }


				      b.close();
					}
			} catch (SQLException | IOException e) {
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

		
}


		
	




