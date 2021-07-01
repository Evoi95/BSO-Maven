package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import logger.Log;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import pagamento.CartaCredito;

public class CartaCreditoDao {
	private PreparedStatement stmt=null;
	private Connection conn;
	private ResultSet rs;
	private  String n;
	private  String cog;
	private String cod;

	
	
	public ObservableList<CartaCredito> getCarteCredito(String nome) throws SQLException 
	{
		String cod;
		/*
		 * uare funzione internet
		 */
		ObservableList<CartaCredito> catalogo=FXCollections.observableArrayList();
		 
            try {
				rs=ConnToDb.generalConnection().createStatement().executeQuery("select nomeP,cognomeP,codiceCarta from cartacredito where nomeP='"+nome+"'");
			
            while(rs.next())
            {
            	 n=rs.getString(1);
            	 cog=rs.getString(2);
            	 cod=rs.getString(3);
            	
            	

        		             

					catalogo.add(new CartaCredito(n,cog,cod, null, cod,0));
        		
        		
            }
            } catch (SQLException e1) {
			 
				e1.printStackTrace();
			}
            finally {
					
            	try{
            		rs.close();
            		conn.close();
            	}catch(SQLException e) {
            		e.getCause();
            	}
				
				}

            
		   return catalogo;

		
	}	
	
	public void daiPrivilegi() throws SQLException
	{

		 try {
			  conn = ConnToDb.generalConnection();
			  stmt = conn.prepareStatement(" SET SQL_SAFE_UPDATES=0");
			         stmt.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	e.getMessage();

	         }	
		 finally {
			 conn.close();
			 
		 }


	}
	public void insCC(CartaCredito cc) throws SQLException
	{
		
		String query;
		
		Log.logger.log(Level.INFO,"\t\tEntro in ins cc");
		String n=cc.getUserNome();
		 String c=cc.getUserCognome();
		 String num=cc.getNumeroCC();
		 Date d=cc.getScadenza();
		 String pin=cc.getCiv();
		 Float amm= cc.getPrezzoTransazine();		 
		 try {
			 conn=ConnToDb.generalConnection();
			 query="insert into cartacredito (nomeP,cognomeP,codiceCarta,scad,codicePin,ammontare)  values(?,?,?,?,?,?)";
			 stmt=conn.prepareStatement(query);
			

				stmt.setString(1,n);
				stmt.setString(2, c);
				stmt.setString(3, num);
				stmt.setDate(4,d);
				stmt.setString(5,pin);
				stmt.setFloat(6, amm);
			    stmt.executeUpdate();
			    
			   
			 
    	       
	            
	         }catch(SQLException e)
	         {
	        	e.getMessage();

	         }
		 finally {conn.close();}
		
		
		 Log.logger.log(Level.INFO,"LibroDao. questy");

		}
	
	public float prendiSpesa() throws SQLException 
	{
		float spesa=0;
		try {
			conn=ConnToDb.generalConnection();
	          rs=conn.createStatement().executeQuery("select spesaTotale from pagamento  where 1+last_insert_id(id_op) order by id_op desc limit 1");
	          while (rs.next())
	          {
	        	  spesa=rs.getFloat("spesaTotale");
	          }
	          
		}catch(SQLException e)
		{
			e.getCause();
		}
		finally {
			rs.close();
			conn.close();
		}
		
		Log.logger.log(Level.INFO,"\n\n Spesa in Cdao .{}:",spesa);
		return spesa;
	}
	  
	
	public CartaCredito  popolaDati(CartaCredito cc) throws SQLException
	{
		String codice=cc.getNumeroCC();
		 n = null;
		 cog = null;
		 cod = null;
		Date scad = null;
		conn= ConnToDb.generalConnection();
		try {
		    rs=conn.createStatement().executeQuery("select nomeP,cognomeP,codiceCarta,scad from cartacredito where codiceCarta='"+codice+"'");

            while(rs.next())
            {
            	n=rs.getString(1);
            	 cog=rs.getString(2);
            	 cod=rs.getString(3);
            	 scad=rs.getDate(4);
            	
            	

            }
            
            cc.setNomeUser(n);
            cc.setCognomeUser(cog);
            cc.setNumeroCC(cod);
            cc.setScadenza(scad);
		}catch(SQLException e)
		{
			e.getMessage();
		}
		finally {
			rs.close();
            conn.close();
		}
			return cc;

	
	}
}

           

		
	


		
	


