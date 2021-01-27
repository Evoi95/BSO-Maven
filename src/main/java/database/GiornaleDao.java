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
import factoryBook.Giornale;
import factoryBook.Libro;
import factoryBook.Raccolta;
import factoryBook.Rivista;

public class GiornaleDao {
	private Factory f;
	private String name;
	private static Statement st = null ;
	private static String query ;
	private static String qTrigger ;
	private static PreparedStatement prepQ = null; 
	private static Connection conn ;
	private static int q ; 
	
 	public void getDesc(factoryBook.Giornale g) throws SQLException
	{	           
		Connection conn = ConnToDb.generalConnection();

		 try {
	            //String url = "jdbc:msql://200.210.220.1:1114/Demo";
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("select * from giornale where titolo ='"+g.getTitolo()+"'");
	            while ( rs.next() ) {
	                String titolo = rs.getString("titolo");
	                String tipologia=rs.getString("tipologia");
	                String lingua=rs.getString("lingua");	       
	                String editore=rs.getString("editore");
	                Date data=rs.getDate("dataPubblicazione");	
	                int copieR=rs.getInt("copiRim");	
	                int disp=rs.getInt("disp");

	                float prezzo=rs.getFloat("prezzo");
	               // InputStream img=rs.getBinaryStream("img");
	                //int id=rs.getInt("id");



	                
	                Alert alert = new Alert(AlertType.INFORMATION);
	    	        alert.setTitle("  Riepilogo  ");
	    	        alert.setHeaderText("Ecco il riepigolo del libro");
	    	        alert.setContentText("  Titolo : "+titolo+"\n"+"tipologia : "+tipologia+"\n"+"lingua : "+lingua+"\n"+"editore : "+editore+ "\n"+
	    	        "data pubblicazione : "+data+"\n"+"numero copie rimanenti :"+copieR+"\n"+"disponibilita :"+disp+"\n"+"prezzo :"+prezzo
	    	        		+"\n"+"foto copertina : "+"\n");
	    	        alert.showAndWait();
	    	       
	    	        
	            }
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
		 finally {
			 conn.close();
		 }
	    }
	
	public float getCosto(Giornale g) throws SQLException
	{		 Connection conn = ConnToDb.generalConnection();	
	float prezzo=(float) 0.0;


		try {
         Statement stmt = conn.createStatement();
         ResultSet rs;

         rs = stmt.executeQuery("select * from giornale where titolo  ='"+g.getTitolo()+"'");
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
	
	public void aggiornaDisponibilita(Giornale g) throws SQLException
	{
		Connection conn=null;
		PreparedStatement stmt=null;
		int d=g.getDisponibilita();
		//)g.getCopieRimanenti();

		 try {
			  conn = ConnToDb.generalConnection();
		      stmt = conn.prepareStatement("update giornale set copiRim=copiRim-'"+d+"' where titolo='"+g.getTitolo()+"'");
			  stmt.executeUpdate();

	            
	         }catch(SQLException e)
	         {
	        	// esito=false;
	        	e.getMessage();

	         }	
		 finally {
			// stmt.close();
			 conn.close();
			 System.out.println("Ho chiuso tutto");
			 
		 }

		 System.out.println("LibroDao. questy");

		}

	public void daiPrivilegi() throws SQLException
	{
		Connection conn=null;
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
			// stmt.close();
			 conn.close();
			 System.out.println("Ho chiuso tutto");
			 
		 }

		 System.out.println("LibroDao. privilegi");

}
	
	public ObservableList<Raccolta> getGiornali() throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn= ConnToDb.generalConnection();

		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		 
		//ConnToDb.connection();
        ResultSet rs=conn.createStatement().executeQuery("SELECT * FROM ispw.giornale");

        while(rs.next())
        {
           // System.out.println("res :"+rs);

    		try {
				catalogo.add(f.createGiornale("giornale",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)));
				//rs=rs.next();
    		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
        conn.close();
	
	
	System.out.println(catalogo);
	return catalogo;
		}
	
	public ObservableList<Raccolta> getGiornaliByName(String S) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn= ConnToDb.generalConnection();

		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		 
		//ConnToDb.connection();
        ResultSet rs=conn.createStatement().executeQuery("SELECT * FROM ispw.giornale where titolo = '"+S+"' OR editore = '"+S+"'");

        while(rs.next())
        {
           // System.out.println("res :"+rs);

    		try {
				catalogo.add(f.createGiornale("giornale",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)));
				//rs=rs.next();
    		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
        conn.close();
	
	
	System.out.println(catalogo);
	return catalogo;
		}
	
	public Giornale getGiornale(Giornale G,int id) throws SQLException
	{

		Connection c= ConnToDb.generalConnection();
        ResultSet rs=c.createStatement().executeQuery("SELECT * FROM giornale where id = "+id+" ");
        if (rs.next())
        {
        	G = (Giornale) f.createGiornale("giornale", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toLocalDate(), rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getInt(9)) ;
        	//(Rivista) f.createRivista("rivista", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toLocalDate(),rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11)); 
        	return G;
        }
        else {
        	System.out.println("non ho torvato un cazzo e ritorno null");
            return G;

        }
	}
	
	public GiornaleDao()
	{
		f=new Factory();
	}
		
	public int retId(Giornale g) throws SQLException {
			int id = 0;
			String titolo=g.getTitolo();
			 Connection conn = ConnToDb.generalConnection();
			 try {
	         Statement stmt = conn.createStatement();
	         ResultSet rs;

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
			 //return id;
			return id;

			// TODO Auto-generated method stub
			
		}

	public String retTip(Giornale g) throws SQLException {
			// TODO Auto-generated method stub
			String titolo=g.getTitolo();
			String categoria=null;//=g.getTipologia();
			 Connection conn = ConnToDb.generalConnection();
			 try {
	         Statement stmt = conn.createStatement();
	         ResultSet rs;

	         rs = stmt.executeQuery("select tipologia from giornale where titolo ='"+titolo+"'");
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
			
	public String getNome(Giornale G) throws SQLException
	{
	
		Connection c= ConnToDb.generalConnection();
        ResultSet rs=c.createStatement().executeQuery("SELECT titolo FROM giornale where id = "+G.getId()+" ");
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

	public int getDisp(Giornale G) throws SQLException
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
						"SELECT `giornale`.`disp` FROM `ispw`.`giornale` where `id` = `"+G.getId()+"` ;");
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

	public int getQuantita(Giornale G) throws SQLException
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
				rs=  stmt.executeQuery(
						"SELECT `giornale`.`copiRim` FROM `ispw`.`giornale` where `id` = "+G.getId()+" ;");
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

	public boolean checkDisp(Giornale g,int id) throws SQLException
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
				
				rs=  stmt.executeQuery("SELECT disp FROM giornale where id = '"+id+"' ;");
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

}


