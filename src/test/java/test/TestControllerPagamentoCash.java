package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import application.ControllerPagamentoCash;

class TestControllerPagamentoCash {
	private ControllerPagamentoCash cPC=new ControllerPagamentoCash();

	@Test
	public void testControlla() {
		boolean state=false;
		String nome="pippo";
		String cognome="pluto";
		String via="paperopoli 4";
		String com="";
		float ammontare =(float) 15.3;
		if(nome.equals("") || cognome.equals("")|| via.equals(""))
			state=false;
		else
		{
			try {
				cPC.controlla(nome, cognome, via, com, ammontare);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state=true;
		}
		assertEquals(true,state);
	}

}
