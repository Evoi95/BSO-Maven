package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import negozio.Negozio;

public class NegozioDao {
	
	private Negozio N; 
	private String nome;
	private String via; //primary key
	private Boolean isValid;
	private Boolean isOpen;
	private ObservableList<Negozio> listOfNegozi;
	
	public ObservableList<Negozio> getNegozi() throws SQLException
	{
		Connection c= ConnToDb.generalConnection();
	
		listOfNegozi=FXCollections.observableArrayList();
		 
        ResultSet rs=c.createStatement().executeQuery("SELECT * FROM negozio");
        
        while(rs.next())
        {
        	try 
        	{
        		N = new Negozio(rs.getString(1),rs.getString(2),rs.getBoolean(3),rs.getBoolean(4));
				listOfNegozi.add(N);
    		}
        	catch (Exception e) 
        	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return listOfNegozi;
	}
	
	public Integer setOpen(Negozio N, boolean i)
	{
		if (i == true)
		{
			N.setIsOpen(i);
			return 1;
		}
		else if (i == false)
		{
			N.setIsOpen(i);
			return 0;
		}
		return -1;
		
	}
	
	public Integer setRitiro(Negozio N, boolean i )
	{
		if (i == true)
		{
			N.setIsValid(i);
			return 1;
		}
		else if (i == false)
		{
			N.setIsValid(i);
			return 0;
		}
		return -1;
	}
	
	

}
