package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import application.ControllerScegliNegozio;
import application.singeltonSystemState;
import javafx.collections.ObservableList;
import negozio.Negozio;

class TestControllerScegliNegozio {
	private ControllerScegliNegozio cSN=new ControllerScegliNegozio();
	private ObservableList<Negozio> listOfNegozi;
	private singeltonSystemState vis = singeltonSystemState.getIstance() ;


	@Test
	public void testGetNegozi() throws SQLException {
		boolean state=false;
		listOfNegozi=cSN.getNegozi();
		System.out.println("\n\n\n-----NEgozi "+listOfNegozi);
		if(listOfNegozi.isEmpty())
			state=false;
		else
			state=true;
		assertEquals(true,state);
	}

	@Test
	public void testIsLogged() {
		vis.setIsLogged(true);
	}

}
