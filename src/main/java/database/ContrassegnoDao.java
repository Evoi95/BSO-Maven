package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import logger.Log;
import pagamento.Fattura;

public class ContrassegnoDao {
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	

	public void inserisciFattura(Fattura f) 
	{
		 
		
		String par1=f.getNome();
 		String par2=f.getCognome();
 		String par3=f.getVia();
 		String par4=f.getCom();
 		float par5=f.getAmmontare();
 		
 		Log.logger.log(Level.INFO,"parametri : {0}",par1 + par2 + par3 + par4 + par5);
       
		 try {

			 conn = ConnToDb.generalConnection();
         
             stmt = conn.prepareStatement("insert into fattura   values (?,?,?,?,?,?);");
             stmt.setString(1,par1);
             stmt.setString(2, par2);
             stmt.setString(3,par3);
             stmt.setString(4,par4 );
             stmt.setInt(5, 0);
             stmt.setFloat(6, par5);
             stmt.executeUpdate();
             

     		
             
            
         }catch(SQLException e)
         {
        	e.getMessage();

         }
		 		 
		 Log.logger.log(Level.INFO,"effettuo inserimento pagaentoDao");
         
         
        	 
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
			
			 Log.logger.log(Level.INFO,"Ho chiuso tutto");
			 
		 }

		 Log.logger.log(Level.INFO,"PagamentoDao. privilegi");

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
		finally
		{
			
				conn.close();
			
		}
		
		Log.logger.log(Level.INFO,"\n\n Spesa in Cdao .{0}",spesa);
		return spesa;
	}
	
	
	
	
	
	
}
         


