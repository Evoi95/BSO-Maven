package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import logger.Log;
import pagamento.Fattura;

public class ContrassegnoDao {
	private  Connection conn;
	private  PreparedStatement stmt;
	
	

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
		  ResultSet rs=null;
		 Statement st=null;
		float spesa=0;
		try {
			 conn=ConnToDb.generalConnection();
			 st=conn.createStatement();
			 rs=st.executeQuery("select spesaTotale from pagamento  where 1+last_insert_id(id_op) order by id_op desc limit 1");
	          while (rs.next())
	          {
	        	  spesa=rs.getFloat("spesaTotale");
	          }
	          st.close();
		}catch(SQLException e)
		{
			e.getCause();
		}
		finally
		{
			if(st!=null)
			{
				st.close();
			}
			if(conn!=null)
			{
			
				conn.close();
			}
		}
		
		Log.logger.log(Level.INFO,"\n\n Spesa in Cdao .{0}",spesa);
		return spesa;
	}
	
	
	
	
	
	
}
         


