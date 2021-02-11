package controllerApp;

public class ControllerRicercaPerTipo {

	private singeltonSystemState vis=singeltonSystemState.getIstance();
	
	public ControllerRicercaPerTipo() 
	{
		//singeltonSystemState vis=singeltonSystemState.getIstance();

	}
	
	public boolean setRicercaL()
	{
		
		if (vis.getType().equals("libro"))
			return true;
		else
			return false;
	}
	public boolean setRicercaG()
	{
		singeltonSystemState.getIstance().setTypeAsDaily();
		if (singeltonSystemState.getIstance().getType().equals("giornale"))
			return true;
		else
			return false;
	}
	public boolean setRicercaR()
	{
		singeltonSystemState.getIstance().setTypeAsMagazine();
		if (singeltonSystemState.getIstance().getType().equals("rivista"))
			return true;
		else
			return false;
	}
}
