package application;

import java.io.IOException;
import java.sql.SQLException;

import database.ContrassegnoDao;
import pagamento.Fattura;

public class ControllerPagamentoCash {
	private ContrassegnoDao pD;
	private Fattura f;

	public void controlla(String nome, String cognome, String via, String com,float ammontare) throws IOException, SQLException {
		try {
			pD.daiPrivilegi();

			System.out.println("\n\n");
			f.setNome(nome);
			f.setCognome(cognome);
			f.setVia(via);
			f.setCom(com);
			f.setAmmontare(pD.prendiSpesa());
			pD.inserisciFattura(f);
		} catch (Exception e) {
			e.getCause();
		}

	}

	public ControllerPagamentoCash() throws Exception {
		pD = new ContrassegnoDao();
		f = new Fattura();
	}

}
