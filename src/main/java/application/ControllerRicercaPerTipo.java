package application;

public class ControllerRicercaPerTipo {

	private singeltonSystemState vis = singeltonSystemState.getIstance() ;
 
	public ControllerRicercaPerTipo() 
	{
		
	}
	
	public boolean setRicercaL()
	{
		vis.getIstance().setTypeAsBook();
		if (vis.getIstance().getType().equals("libro"))
			return true;
		else
			return false;
	}
	public boolean setRicercaG()
	{
		vis.getIstance().setTypeAsDaily();
		if (vis.getIstance().getType().equals("giornale"))
			return true;
		else
			return false;
	}
	public boolean setRicercaR()
	{
		vis.getIstance().setTypeAsMagazine();
		if (vis.getIstance().getType().equals("rivista"))
			return true;
		else
			return false;
	}
}
