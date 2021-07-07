package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import logger.Log;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pagamento.Pagamento;
import users.singelton.User;

public class PagamentoDao {
	private  String qInsert ;
	private  PreparedStatement prepQ = null;
	private Connection connPag;
	

	public void inserisciPagamento(Pagamento p) throws SQLException {
		
		String m=p.getMetodo();
		int esito=p.getEsito();
		String nomeU=p.getNomeUtente();
		float amm=p.getAmmontare();
		String email=User.getInstance().getEmail();
		String tipologia=p.getTipo();
		int idProdotto=p.getId();
		
		try {
					connPag=ConnToDb.generalConnection();

		
		 qInsert="INSERT INTO pagamento (metodo,esito,nomeUtente,spesaTotale,eMail,tipoAcquisto,idProd) values (?,?,?,?,?,?,?)";
		prepQ = connPag.prepareStatement(qInsert);
		//prepQ.setInt(1,p.getEsito()); // numero pagine int
		prepQ.setString(1,m); // 
		prepQ.setInt(2,esito);
		prepQ.setString(3, nomeU);
		prepQ.setFloat(4,amm);
		prepQ.setString(5, email);
		prepQ.setString(6,tipologia);
		prepQ.setInt(7, idProdotto);
		prepQ.executeUpdate();
		
		connPag.close();
		}catch(SQLException s)
		{
			s.getStackTrace();
		}
		}
	public void daiPrivilegi() 
	{
		 prepQ=null;

		 try {
			  connPag = ConnToDb.generalConnection();
			  prepQ = connPag.prepareStatement(" SET SQL_SAFE_UPDATES=0");
			         prepQ.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	
	        	e.getMessage();

	         }	
		 finally{
			 try {
				connPag.close();
			} catch (SQLException e) {
			 e.getMessage();
				
			}
		 }
		
		 Log.logger.log(Level.INFO,"LibroDao. privilegi");

	}
	
public void aggiornaPagamentoCash(Pagamento p) throws SQLException {
		
		String m=p.getMetodo();
		int esito=p.getEsito();
		String nomeU=p.getNomeUtente();
		float amm=p.getAmmontare();
		String email=User.getInstance().getEmail();
		
		try {
					connPag=ConnToDb.generalConnection();

		
		 qInsert="update pagamento set metodo=?,esito=?,nomeUtente=?,spesaTotale=?,eMail=?  where 1+last_insert_id(id_op) order by id_op desc limit 1";
		prepQ = connPag.prepareStatement(qInsert);
		//prepQ.setInt(1,p.getEsito()); // numero pagine int
		prepQ.setString(1,m); // 
		prepQ.setInt(2,esito);
		prepQ.setString(3, nomeU);
		prepQ.setFloat(4,amm);
		prepQ.setString(5, email);
		prepQ.executeUpdate();
		
		connPag.close();
		}catch(SQLException s)
		{
			s.getStackTrace();
		}
		}

public void aggiornaPagamentoCC(Pagamento p) throws SQLException {
	
	String m=p.getMetodo();
	int esito=p.getEsito();
	String nomeU=p.getNomeUtente();
	float amm=p.getAmmontare();
	String email=User.getInstance().getEmail();
	
	try {
				connPag=ConnToDb.generalConnection();

	
	 qInsert="update pagamento set metodo=?,esito=?,nomeUtente=?,spesaTotale=?,eMail=?  where 1+last_insert_id(id_op) order by id_op desc limit 1";
	prepQ = connPag.prepareStatement(qInsert);
	//prepQ.setInt(1,p.getEsito()); // numero pagine int
	prepQ.setString(1,m); // 
	prepQ.setInt(2,esito);
	prepQ.setString(3, nomeU);
	prepQ.setFloat(4,amm);
	prepQ.setString(5, email);
	prepQ.executeUpdate();
	
	connPag.close();
	}catch(SQLException s)
	{
		s.getStackTrace();
	}
	}
public ObservableList<Pagamento> getPagamenti()  {
	
	 Statement stmt;
	 ResultSet rs;
    
		
		connPag= ConnToDb.generalConnection();

		ObservableList<Pagamento> catalogo=FXCollections.observableArrayList();
		 
		
		try {
			stmt=connPag.createStatement();
			rs = stmt.executeQuery("SELECT id_op,metodo,esito,nomeUtente,spesaTotale,tipoAcquisto,idProd from pagamento where eMail='"+User.getInstance().getEmail()+"'");
		
        while(rs.next())
        {

    		 
    			catalogo.add(new Pagamento (rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getInt(7)));
    		
        }
        stmt.close();
		} catch (SQLException e1) {
		 
			e1.printStackTrace();
		}
		finally {
        try {
			connPag.close();
		} catch (SQLException e) {
			e.getMessage();
		 
			
		}
		}
	
	
	Log.logger.log(Level.INFO,"{0}",catalogo);
	return catalogo;
		}

}





