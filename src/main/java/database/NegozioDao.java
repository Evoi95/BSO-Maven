package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import negozio.Negozio;

public class NegozioDao {
	
	private Negozio shop; 
	
	private  Statement st = null ;
	private  ResultSet rs=null;
    private Connection  conn;
    
	public ObservableList<Negozio> getNegozi() throws SQLException
	{
		conn= ConnToDb.generalConnection();
		 ObservableList<Negozio> listOfNegozi;

	
		listOfNegozi=FXCollections.observableArrayList();
		st=conn.createStatement();
		 rs=st.executeQuery("SELECT "
        		+ "    `negozio`.`nome`,"
        		+ "    `negozio`.`via`,"
        		+ "    `negozio`.`isValid`,"
        		+ "    `negozio`.`isOpen`"
        		+ "FROM `ispw`.`negozio`");
        
        while(rs.next())
        {
        	try 
        	{
        		shop = new Negozio(rs.getString(1),rs.getString(2),rs.getBoolean(3),rs.getBoolean(4));
				listOfNegozi.add(shop);
    		}
        	catch (Exception e) 
        	{
			 e.printStackTrace();				
			}
        }
		return listOfNegozi;
	}
	
	public Integer setOpen(Negozio shop, boolean i)
	{
		// vanno messe  le query
		conn= ConnToDb.generalConnection();
		
		if (i)
		{
			shop.setIsOpen(i);
			return 1;
		}
		else 
		{
			shop.setIsOpen(i);
			return 0;
		}
		
	}
	
	public Integer setRitiro(Negozio shop, boolean i )
	{
		if (i)
		{
			shop.setIsValid(i);
			return 1;
		}
		else
		{
			shop.setIsValid(i);
			return 0;
		}
	}
	
	
	// controllo che il negozio sia aperto
	public boolean checkOpen(Negozio  shop)
	{
		conn= ConnToDb.generalConnection();
		
		return false;
	}
	
	//controllo se il negozio fa PickUP
	public boolean checkRitiro(Negozio shop)
	{
		return false;
	}

}
