package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import application.ControllerCompravenditaLibri;
import factoryBook.Raccolta;
import javafx.collections.ObservableList;
import usersSingelton.User;

class TestControllerCompravenditaLibri {
	private ControllerCompravenditaLibri cCL;
	private boolean state;
	private ObservableList<Raccolta>catalogo;
	private String tipo;
	private static User u=User.getInstance();


	@Test
	public void testDisponibilitaLibro() throws SQLException {
		cCL=new ControllerCompravenditaLibri();
		String i="2";
		state=cCL.disponibilitaLibro(i);
		assertEquals(true,state);
	}

	@Test
	public void testGetLibri() throws SQLException {
		cCL=new ControllerCompravenditaLibri();
		catalogo=cCL.getLibri();
		state=catalogo.isEmpty();
		assertEquals(false,state);
	}

	@Test
	public void testRetTipoUser() {
		cCL=new ControllerCompravenditaLibri();
		//u.setIdRuolo("W");

		tipo=cCL.retTipoUser();
		
		if (tipo.equalsIgnoreCase("W") || tipo.equalsIgnoreCase("E") || tipo.equalsIgnoreCase("A")|| tipo.equalsIgnoreCase("U"))
			state=true;
		else
			state=false;
		assertEquals(true,state);
	}

}
