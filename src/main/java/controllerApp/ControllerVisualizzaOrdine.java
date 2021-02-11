package controllerApp;

import java.sql.SQLException;

import database.*;
import factoryBook.Raccolta;
import javafx.collections.ObservableList;
import pagamento.Pagamento;


public class ControllerVisualizzaOrdine {
	
	private PagamentoDao pD;
	
	public ObservableList<Pagamento> getDati() throws SQLException {
		
		return pD.getPagamenti();
		}
	
	
	
	public ControllerVisualizzaOrdine()
	{
		pD=new PagamentoDao();
		
	}

}
