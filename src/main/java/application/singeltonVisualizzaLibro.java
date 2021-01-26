package application;

// this is singelton battona 
public class singeltonVisualizzaLibro {
	
	 private int id;
	 private String type;
	 private static singeltonVisualizzaLibro instance = new singeltonVisualizzaLibro();
	 
	 private singeltonVisualizzaLibro()
	 {
		 
	 }
	 
	 public static singeltonVisualizzaLibro getIstance()
	 {
		 return instance;
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setTypeAsBook()
	{
		this.type = "libro";
	}
	public void setTypeAsMagazine()
	{
		this.type = "rivista";
	}
	public void setTypeAsDaily()
	{
		this.type = "giornale";
	}
	public String getType()
	{
		return type;
	}
	
}
