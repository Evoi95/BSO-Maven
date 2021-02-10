package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import application.ControllerCompravenditaLibri;
import application.ControllerCompravenditaRiviste;
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
	public void testGetRiviste() throws SQLException {
		cCR=new ControllerCompravenditaRiviste();
		String i="2";
		state=cCR.disponibilitaRiviste(i);
		assertEquals(true,state);
	
	}

	@Test
	public void testDisponibilitaRiviste() throws SQLException {
		cCR=new ControllerCompravenditaRiviste();
		catalogo=cCR.getRiviste();
		state=catalogo.isEmpty();
		assertEquals(false,state);
	
	}

	@Test
	public void testTipoUtente() {
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