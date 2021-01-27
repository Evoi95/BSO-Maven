package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factoryBook.Factory;
import factoryBook.Giornale;
import factoryBook.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import factoryBook.Raccolta;
import factoryBook.Rivista;

public class RivistaDao {
	private Factory f;
	private String name;
	private static Statement st = null ;
	private static String query ;
	private static String qTrigger ;
	private static PreparedStatement prepQ = null; 
	private static Connection conn ;
	private static int q;
	
	
	
	public void getDesc(Rivista r)
	{
		 try {
	            //String url = "jdbc:msql://200.210.220.1:1114/Demo";
	            Connection conn = ConnToDb.generalConnection();
	            Statement stmt = conn.createStatement();
	            ResultSet rs;
	 
	            rs = stmt.executeQuery("select * from rivista where titolo ='"+r.getTitolo()+"'");
	            while ( rs.next() ) {
	                String titolo = rs.getString("titolo");
	                String tipologia=rs.getString("tipologia");
	                String autore=rs.getString("autore");
	                String lingua=rs.getString("lingua");	   
	                String editore=rs.getString("editore");
	                String desc=rs.getString("Descrizione");

	                Date data=rs.getDate("dataPubblicazione");
	               
	                int disp=rs.getInt("disp");
	                float prezzo=rs.getFloat("prezzo");
	                int copieR=rs.getInt("copieRimanenti");
	               // InputStream img=rs.getBinaryStream("img");


	                
	                Alert alert = new Alert(AlertType.INFORMATION);
	    	        alert.setTitle("  Riepilogo  ");
	    	        alert.setHeaderText("Ecco il riepigolo del libro");
	    	        alert.setContentText("  Titolo : "+titolo+"\n"+"tipologia : "+tipologia+"\n"+"codice isbn :"+ "\n"+"autore :"+autore+"\n"+"lingua :"+lingua+"\n"+
	    	        "\n"+"editore : "+editore+"\n"+"descrizione :"+desc+"\n"+"data pubblicazione : "+data+"\n"+"disponibilita :"+ disp
	    	        		+"\n"+"prezzo :"+prezzo+"\n"+"copieRimanenti : "+copieR+"\n");
	    	        alert.showAndWait();
	    	        
	            }
	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
	    }
	
	public float getCosto(Rivista r) throws SQLException
	{
		float prezzo=(float) 0.0;
		 Connection conn = ConnToDb.generalConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs;

         rs = stmt.executeQuery("select * from rivista  where titolo='"+r.getTitolo()+"'");
         while ( rs.next() ) {
              prezzo=rs.getFloat("prezzo");

         }
		return prezzo;
		
	}
	
	public void aggiornaDisponibilita(Rivista r) throws SQLException
	{
		Connection conn=null;
		PreparedStatement stmt=null;
		int d=r.getCopieRim();

		 try {
			  conn = ConnToDb.generalConnection();
		      stmt = conn.prepareStatement("update rivista set copieRimanenti=copieRimanenti-'"+d+"' where titolo='"+r.getTitolo()+"'");
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
			 stmt.close();
			 conn.close();
			 System.out.println("Ho chiuso tutto");
			 
		 }

		 System.out.println("LibroDao. privilegi");

}
	
	public ObservableList<Raccolta> getRiviste() throws SQLException
	{
		Connection c= ConnToDb.generalConnection();

		
		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		 
			//ConnToDb.connection();
            ResultSet rs=c.createStatement().executeQuery("SELECT * FROM rivista");
           // int i=0;
            while(rs.next())
            {
               // System.out.println("res :"+rs);

        		try {
					catalogo.add(f.createRivista("rivista",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toLocalDate(), rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11)));
					
					//titolo,tipo,autore,lingua,editore,descrizione,dataPubb,disp,prezzo,copieRim,foto,id//rs=rs.next();
					//System.out.println("res: "+rs[i]);
        		} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		//System.out.println("rivista nome"+rs.getString(1));

            }
		//catalogo.add(new Libro("pippo","pluto","it","fantasy","8004163529","paperino","avventura",100,11,11,5252020,18,null,true));
	
			
		System.out.println(catalogo);
		return catalogo;
		
	}
	
	public ObservableList<Raccolta> getRivisteByName(String S) throws SQLException
	{
		Connection c= ConnToDb.generalConnection();

		
		ObservableList<Raccolta> catalogo=FXCollections.observableArrayList();
		 
			//ConnToDb.connection();
            ResultSet rs=c.createStatement().executeQuery("SELECT * FROM ispw.rivista where titolo = '"+S+"' OR autore = '"+S+"'");
           // int i=0;
            while(rs.next())
            {
               // System.out.println("res :"+rs);

        		try {
					catalogo.add(f.createRivista("rivista",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toLocalDate(), rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11)));
					
					//titolo,tipo,autore,lingua,editore,descrizione,dataPubb,disp,prezzo,copieRim,foto,id//rs=rs.next();
					//System.out.println("res: "+rs[i]);
        		} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		//System.out.println("rivista nome"+rs.getString(1));

            }
		//catalogo.add(new Libro("pippo","pluto","it","fantasy","8004163529","paperino","avventura",100,11,11,5252020,18,null,true));
	
			
		System.out.println(catalogo);
		return catalogo;
		
	}


	public Rivista getRivista(Rivista R,int id) throws SQLException
	{

		Connection c= ConnToDb.generalConnection();
        ResultSet rs=c.createStatement().executeQuery("SELECT * FROM rivista where id = "+id+" ");
        if (rs.next())
        {
        	R = (Rivista) f.createRivista("rivista", rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7).toLocalDate(),rs.getInt(8),rs.getFloat(9),rs.getInt(10),rs.getInt(11)); 
        	return R;
        }
        else {
        	System.out.println("non ho torvato un cazzo e ritorno null");
            return R;

        }
	}

	public RivistaDao()
	{
		f=new Factory();
	}
	
	public int retId(Rivista r) throws SQLException {
		int id = 0;
		String titolo=r.getTitolo();
		 Connection conn = ConnToDb.generalConnection();
		 try {
         Statement stmt = conn.createStatement();
         ResultSet rs;

         rs = stmt.executeQuery("select id from rivista where titolo ='"+titolo+"'");
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

	public String retTip(Rivista r) throws SQLException {
		// TODO Auto-generated method stub
		String categoria=null;
		 Connection conn = ConnToDb.generalConnection();
		 try {
         Statement stmt = conn.createStatement();
         ResultSet rs;

         rs = stmt.executeQuery("select tipologia from rivista where titolo ='"+r.getTitolo()+"'");
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
	
	public String getNome(Rivista R) throws SQLException
	{
	
		Connection c= ConnToDb.generalConnection();
        ResultSet rs=c.createStatement().executeQuery("SELECT titolo FROM rivista where id = "+R.getId()+" ");
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

	public int getDisp(Rivista R) throws SQLException
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
						"SELECT `rivista`.`disp` FROM `ispw`.`rivista` where `id` = `"+R.getId()+"` ;");
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
	
	public int getQuantita(Rivista R) throws SQLException
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
						"SELECT `rivista`.`copieRimanenti` FROM `ispw`.`rivista` where `id` = "+R.getId()+" ;");
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

	public boolean checkDisp(Rivista R,int id) throws SQLException
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
				
				rs=  stmt.executeQuery("SELECT disp FROM ispw.rivista where id = '"+id+"' ;");
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
