package controller_app;

import java.util.logging.Level;

import logger.Log;

public class ControllerRicercaPerTipo {

	private SingeltonSystemState vis=SingeltonSystemState.getIstance();
	private boolean state=false;
	
	public ControllerRicercaPerTipo() 
	{
		Log.logger.log(Level.INFO,"ControllerRicercaPErTipo");
	}
	
	public boolean setRicercaL()
	{
		
		if (vis.getType().equals("libro"))
			state=true;
		return state;
	}
	public boolean setRicercaG()
	{
		SingeltonSystemState.getIstance().setTypeAsDaily();
		if (SingeltonSystemState.getIstance().getType().equals("giornale"))
			state= true;
		return state;
	}
	public boolean setRicercaR()
	{
		SingeltonSystemState.getIstance().setTypeAsMagazine();
		if (SingeltonSystemState.getIstance().getType().equals("rivista"))
			state= true;
		return state;
	}
}
