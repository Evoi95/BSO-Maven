package controller_app;

import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;

import database.CartaCreditoDao;
import database.PagamentoDao;
import javafx.collections.ObservableList;
import pagamento.CartaCredito;
import pagamento.Pagamento;
import logger.Log;

public class ControllerPagamentoCC {
	private CartaCreditoDao cDao;
	private String appoggio = "";
	private CartaCredito cc;
	private PagamentoDao pD;
	
	private int cont=0;

	public boolean controllaPag(String d, String c,String civ) {
		int x;
		 Boolean state;

		 int anno;
		 int mese;
		 int giorno;

		appoggio = appoggio + d;
		  anno = Integer.parseInt((String) appoggio.subSequence(0, 4));
		  mese = Integer.parseInt((String) appoggio.subSequence(5, 7));
		  giorno = Integer.parseInt((String) appoggio.subSequence(8, 10));
		
		if (anno > 2020 && (mese >= 1 && mese <= 12) && (giorno >= 1 && giorno <= 31) && c.length() <= 20 && civ.length()==3 ) {
			
				String verifica[]=null;
				
					 verifica= c.split("-");
					
					for ( x=0; x<verifica.length; x++) {
							if(verifica[x].length()==4)
							{
								cont++;
							}
					}
					if (cont==4)
					{
						state=true;
					}
					else {
						state=false;
					}
				

		} else {
			state = false;

		}
		return state;

	}

	public ControllerPagamentoCC() throws SQLException {
		cDao = new CartaCreditoDao();
		cDao.daiPrivilegi();
		pD=new PagamentoDao();
		pD.daiPrivilegi();
	}

	public void aggiungiCartaDB(String n, String c, String cod, java.util.Date data, String civ, float prezzo)
			throws SQLException {
		try {
			cc = new CartaCredito(n, c, cod, (Date) data, civ, prezzo);
			
			Log.logger.log(Level.INFO,"\n\n CC: {0}",cc.getAmmontare());

			cc.setPrezzoTransazine(cDao.prendiSpesa());
			cDao.insCC(cc);
			Pagamento p;
			 p=new Pagamento(0,"cc",0,cc.getUserNome(),cc.getPrezzoTransazine(),null,0);
			pD.aggiornaPagamentoCC(p);
			
			
			


		} catch (SQLException e) {
			e.getCause();
		}

	}

	public ObservableList<CartaCredito> ritornaElencoCC(String nomeU) throws SQLException {
		
		return cDao.getCarteCredito(nomeU);
	}
	
	public CartaCredito tornaDalDb(String codiceCarta) throws SQLException
	{
		cc=new CartaCredito();
		cc.setNumeroCC(codiceCarta);
		return cDao.popolaDati(cc);
	}

}
