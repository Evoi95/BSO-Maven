package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import controller_app.ControllerModifGiornale;
import database.ConnToDb;
import factoryBook.Giornale;

class TestControllerModifGiornale {
	private Giornale g;
	private ControllerModifGiornale cMG=new ControllerModifGiornale();
	private boolean state=false;
	private static Connection conn;
	@Test
	void testGetGiornaliById() {
		g=new Giornale();
		g.setId(1);
		try {
			assertNotNull(cMG.getGiornaliById(g.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	@Test
	void testCheckData() throws SQLException {
		g=new Giornale();
		g.setTitolo("eee");
		g.setTipologia("Quotidiano");
		g.setEditore("la stampa");
		g.setLingua("Italiano");
		g.setDataPubb(LocalDate.of(2021, 5,7));
		g.setDisponibilita(1);
		g.setPrezzo((float)1.5);
		g.setCopieRimanenti(100);
		g.setId(8);
		cMG.checkData(g.getTitolo(),g.getTipologia(),g.getEditore(),g.getLingua(),g.getDataPubb(), g.getDisponibilita(),g.getPrezzo(),g.getCopieRimanenti(),g.getId());
		
	}
	
	
	@AfterAll
	public static void dopo() throws FileNotFoundException 
	{
		System.out.println("Entro nel after e lancio truncate");
		conn=ConnToDb.generalConnection();
		 ScriptRunner sr = new ScriptRunner(conn);
		 
		 //&& preso come terminatore-> eseguito;	
		 sr.setSendFullScript(true);
	      //Creating a reader object
	      Reader reader;
		
			reader = new BufferedReader(new FileReader("FileSql\\provaTruncateGiornali.sql"));
		
	      //Running the script
	      sr.runScript(reader);
	      
	      ScriptRunner sr1 = new ScriptRunner(conn);
			 
			 //&& preso come terminatore-> eseguito;	
			 sr1.setSendFullScript(true);
		      //Creating a reader object
		      Reader reader1 = new BufferedReader(new FileReader("FileSql\\stroredInsGiornali.sql"));
		      //Running the script
		      sr1.runScript(reader1);
		

	}
	

}
