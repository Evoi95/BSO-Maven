package controller_app;


import database.*;
import javafx.collections.ObservableList;
import pagamento.Pagamento;


public class ControllerVisualizzaOrdine {
	
	private PagamentoDao pD;
	
	public ObservableList<Pagamento> getDati()  {
		
		return pD.getPagamenti();
		}
	
	
	
	public ControllerVisualizzaOrdine()
	{
		pD=new PagamentoDao();
		
	}

}
