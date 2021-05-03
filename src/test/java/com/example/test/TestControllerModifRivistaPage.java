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

import controller_app.ControllerModifRivistaPage;
import database.ConnToDb;
import factoryBook.Rivista;

class TestControllerModifRivistaPage {
	private ControllerModifRivistaPage cMP=new ControllerModifRivistaPage();
	private Rivista r;
	private static Connection conn;

	@Test
	void testGetRivistaById() {
		r=new Rivista();
		r.setId(8);
		try {
			assertNotNull(cMP.getRivistaById(r.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testCheckData() {
		r=new Rivista();
		r.setTitolo("Rivista C");
		r.setTipologia("sportivo");
		r.setAutore("la gazzetta");
		r.setLingua("italiano");
		r.setEditore("la gazzetta");
		r.setDescrizione("cronaca della grionata sportiva");
		r.setDataPubb(LocalDate.of(2021,4,4));
		r.setDisp(0);
		r.setPrezzo((float) 0.90);
		r.setCopieRim(100);
		r.setId(5);
		try {
			cMP.checkData(r.getTitolo(),r.getTipologia(),r.getAutore(),r.getLingua(),r.getEditore(),r.getDescrizione(), r.getDataPubb(),r.getDisp(), r.getPrezzo(), r.getCopieRim(),r.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
			reader = new BufferedReader(new FileReader("FileSql\\provaTruncateRiviste.sql"));
		
	      //Running the script
	      sr.runScript(reader);
	      
	      ScriptRunner sr1 = new ScriptRunner(conn);
			 
			 //&& preso come terminatore-> eseguito;	
			 sr1.setSendFullScript(true);
		      //Creating a reader object
		      Reader reader1 = new BufferedReader(new FileReader("FileSql\\storedInsRiviste.sql"));
		      //Running the script
		      sr1.runScript(reader1);
		

	}
	

}
