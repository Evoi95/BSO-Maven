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

import controller_app.ControllerModifBook;
import database.ConnToDb;
import factoryBook.Libro;

class TestControllerModifBook {
	private Libro l;
	private ControllerModifBook cMB=new ControllerModifBook();
	private static Connection conn;

	@Test
	void testGetLibriById() {
		l=new Libro();
		l.setId(5);
		try {
			assertNotNull(cMB.getLibriById(l.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testCheckData() throws NullPointerException, SQLException {
		
		l=new Libro();
		l.setTitolo("aaa");
		l.setNumPag(1500);
		l.setCodIsbn("000015260");
		l.setEditore("bbb");
		l.setEditore("mondadori");
		l.setLingua("Italiana");
		l.setCategoria("articolo cronaca");
		l.setDataPubb(LocalDate.of(1987, 5, 6));
		l.setRecensione("illuminante dal punto di vista filosofico");
		l.setNrCopie(150);
		l.setDesc(" occhio a non perdersi tra le righe");
		l.setDisponibilita(1);
		l.setPrezzo((float)15.36);
		l.setCopieRim(300);
		l.setId(19);
		cMB.checkData(l.getTitolo(),l.getNumPag(),l.getCodIsbn(),l.getEditore(), l.getAutore(),l.getLingua(), l.getCategoria(),l.getDataPubb(), l.getRecensione(),l.getDisponibilita(),l.getPrezzo(),l.getCopieRim(),l.getId());
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
		
			reader = new BufferedReader(new FileReader("FileSql\\provaTruncateLibro.sql"));
		
	      //Running the script
	      sr.runScript(reader);
	      
	      ScriptRunner sr1 = new ScriptRunner(conn);
			 
			 //&& preso come terminatore-> eseguito;	
			 sr1.setSendFullScript(true);
		      //Creating a reader object
		      Reader reader1 = new BufferedReader(new FileReader("FileSQl\\storedInsLibri.sql"));
		      //Running the script
		      sr1.runScript(reader1);
		

	}
	
	

}
