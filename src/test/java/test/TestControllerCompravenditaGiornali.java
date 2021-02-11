package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerCompravenditaGiornali;
import controllerApp.ControllerCompravenditaLibri;
import factoryBook.Raccolta;
import javafx.collections.ObservableList;
import usersSingelton.User;

class TestControllerCompravenditaGiornali {
	private ControllerCompravenditaGiornali cCG;
	private boolean state;
	private ObservableList<Raccolta>catalogo;
	private String tipo;
	private static User u=User.getInstance();



	@Test
	public void testGetGiornali() throws SQLException {
		cCG=new ControllerCompravenditaGiornali();
		String i="1";
		state=cCG.disponibilitaGiornale(i);
		assertEquals(true,state);
	
	}

	@Test
	public void testDisponibilitaGiornale() throws SQLException {
		cCG=new ControllerCompravenditaGiornali();
		catalogo=cCG.getGiornali();
		state=catalogo.isEmpty();
		assertEquals(false,state);
	
	}

	@Test
	public void testTipoUtente() {
		cCG=new ControllerCompravenditaGiornali();

		tipo=cCG.tipoUtente();
		
		if (tipo.equalsIgnoreCase("W") || tipo.equalsIgnoreCase("E") || tipo.equalsIgnoreCase("A")|| tipo.equalsIgnoreCase("U"))
			state=true;
		else
			state=false;
		assertEquals(true,state);

	}

}
