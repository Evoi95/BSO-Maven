package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import controllerApp.ControllerRicercaPage;
import controllerApp.SingeltonSystemState;
import factoryBook.Raccolta;
import javafx.collections.ObservableList;

class TestRicerca {
	private static 		SingeltonSystemState vis=SingeltonSystemState.getIstance();
	boolean statoL = false,statoG = false,statoR = false,statoTotale=false;



	@Test
	void testCercaPerTipo() {
		ObservableList<Raccolta> elencoL = null;
		ObservableList<Raccolta> elencoG = null;
		ObservableList<Raccolta> elencoR = null;



		vis.setTypeAsBook();
		if(vis.getType().equals("libro"))
		{
		ControllerRicercaPage cRP=new ControllerRicercaPage();
		try {
			elencoL=cRP.cercaPerTipo("libro");
		} catch (SQLException e) {
		 
			e.printStackTrace();
		}
		statoL=elencoL.isEmpty();
		}
		
		
		vis.setTypeAsDaily();
		if(vis.getType().equals("giornale"))
		{
		ControllerRicercaPage cRP=new ControllerRicercaPage();
		try {
			elencoG=cRP.cercaPerTipo("giornale");
		} catch (SQLException e) {
		 
			e.printStackTrace();
		}
		statoG=elencoG.isEmpty();
		}
		
		
		vis.setTypeAsMagazine();		
		if(vis.getType().equals("rivista"))
		{
		ControllerRicercaPage cRP=new ControllerRicercaPage();
		try {
			elencoR=cRP.cercaPerTipo("rivista");
		} catch (SQLException e) {
		 
			e.printStackTrace();
		}
		statoR=elencoR.isEmpty();
		}
		
		System.out.println("StaoL + StatoR +StatoG"+ statoL+statoR+statoG);
		statoTotale=(statoL&&statoR&&statoG);
		
		
		assertEquals(true,statoTotale);
		//fail("Not yet implemented");
	}

	@Test
	void testReturnType() {
		//singeltonSystemState vis=singeltonSystemState.getIstance();

		ControllerRicercaPage cRP=new ControllerRicercaPage();
		String tipo=cRP.returnType();
		boolean stato=false;
		
		if(tipo.equals("libro") || tipo.equals("giornale")|| tipo.equals("rivista"))
			stato=true;
		else
			stato=false;
		assertNotEquals(false,stato);
		
		
		//fail("Not yet implemented");
	}

}
