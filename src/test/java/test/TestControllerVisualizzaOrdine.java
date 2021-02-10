package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import application.ControllerVisualizzaOrdine;
import javafx.collections.ObservableList;
import pagamento.Pagamento;

class TestControllerVisualizzaOrdine {
	private ControllerVisualizzaOrdine cVO=new ControllerVisualizzaOrdine();
	private ObservableList<Pagamento> elencoP;

	@Test
	public void  testGetDati() throws SQLException {
		boolean state;
		elencoP=cVO.getDati();
		state=elencoP.isEmpty();
		assertNotEquals(false,state);
		
	}

}
