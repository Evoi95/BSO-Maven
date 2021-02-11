package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerCompravenditaLibri;
import controllerApp.ControllerCompravenditaRiviste;
import factoryBook.Raccolta;
import javafx.collections.ObservableList;
import usersSingelton.User;

class TestControllercompravenditaRiviste {
	private ControllerCompravenditaRiviste cCR;
	private boolean state;
	private ObservableList<Raccolta>catalogo;
	private String tipo;
	private static User u=User.getInstance();


	@Test
	void testGetRiviste() throws SQLException {
		cCR=new ControllerCompravenditaRiviste();
		String i="2";
		state=cCR.disponibilitaRiviste(i);
		assertEquals(true,state);
	
	}

	@Test
	void testDisponibilitaRiviste() throws SQLException {
		cCR=new ControllerCompravenditaRiviste();
		catalogo=cCR.getRiviste();
		state=catalogo.isEmpty();
		assertEquals(false,state);
	
	}

	@Test
	void testTipoUtente() {
		cCR=new ControllerCompravenditaRiviste();
		//u.setIdRuolo("W");

		tipo=cCR.tipoUtente();
		
		if (tipo.equalsIgnoreCase("W") || tipo.equalsIgnoreCase("E") || tipo.equalsIgnoreCase("A")|| tipo.equalsIgnoreCase("U"))
			state=true;
		else
			state=false;
		assertEquals(true,state);

	}

}
