package controller_app;

import java.sql.SQLException;

import database.ContrassegnoDao;
import database.PagamentoDao;
import pagamento.Fattura;
import pagamento.Pagamento;
public class ControllerPagamentoCash {
	private ContrassegnoDao pD;
	private Fattura f;
	private PagamentoDao pagD;

	public void controlla(String nome, String cognome, String via, String com) throws SQLException {
		try {
			pD.daiPrivilegi();
			pagD.daiPrivilegi();
			float spesa=pD.prendiSpesa();

			f.setNome(nome);
			f.setCognome(cognome);
			f.setVia(via);
			f.setCom(com);
			f.setAmmontare(spesa);
			pD.inserisciFattura(f);
			
			Pagamento p;
			p=new Pagamento(0, "cash", 0, f.getNome(), f.getAmmontare(), null, 0);
			pagD.aggiornaPagamentoCash(p);
			
			
			
			
		} catch (Exception e) {
			e.getCause();
		}

	}

	public ControllerPagamentoCash()  {
		pD = new ContrassegnoDao();
		f = new Fattura();
		pagD=new PagamentoDao();
		
	}

}
