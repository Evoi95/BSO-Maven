package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerScegliNegozio;
import controller_app.SingeltonSystemState;
import javafx.collections.ObservableList;
import negozio.Negozio;

class TestControllerScegliNegozio {
	private ControllerScegliNegozio cSN=new ControllerScegliNegozio();
	private ObservableList<Negozio> listOfNegozi;
	private SingeltonSystemState vis = SingeltonSystemState.getIstance() ;


	@Test
	void testGetNegozi() throws SQLException {
		boolean state=false;
		listOfNegozi=cSN.getNegozi();
		//Log.logger.log(Level.INFO,"\n\n\n-----NEgozi "+listOfNegozi);
		if(listOfNegozi.isEmpty())
			state=false;
		else
			state=true;
		assertEquals(true,state);
	}

	@Test
	void testIsLogged() {
		vis.setIsLogged(true);
	}

}
