package com.example.test;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controller_app.ControllerVisualizzaOrdine;
import javafx.collections.ObservableList;
import database.PagamentoDao;

import pagamento.Pagamento;

class TestControllerVisualizzaOrdine {
	private ControllerVisualizzaOrdine cVO=new ControllerVisualizzaOrdine();
	private ObservableList<Pagamento> elencoP;
	private Pagamento p;
	private PagamentoDao pD=new PagamentoDao();
	@Test
	void  testGetDati() throws SQLException {
		boolean state;
		p=new Pagamento(0, null, 0, null, 0, null, 0);
		pD.inserisciPagamento(p);
		elencoP=cVO.getDati();
		state=elencoP.isEmpty();
		assertEquals(false,state);
		
	}

}
