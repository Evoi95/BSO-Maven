package controller_app;



import database.GiornaleDao;

public class ControllerReportGiornali {
	private GiornaleDao gd;
	
	public void generaReportGiornali () 
	{
		gd.generaReport();
		
	}
	
	
	public ControllerReportGiornali()
	{
		gd=new GiornaleDao();
	}

}
