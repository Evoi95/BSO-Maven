package factoryBook;

enum MagazineCategory 
{	
	settimanale,Bisettimanale,mensile,
	bimestrale,trimestrale,annuale,
	estivo,invernale,sportivo,cinematografica,
	gossip,televisivo,militare,informatica
}

public class CategorieRivista {
	
	private MagazineCategory type;
	private Boolean isValid;
	
	public CategorieRivista()
	{
		isValid=false;
	}
	
	public CategorieRivista(String r) {
		type = MagazineCategory.valueOf(r); 
		isValid = true;
	}
	public String getCategoria() 
	{
		if (type.equals(MagazineCategory.Bisettimanale)) 
		{
			return "Bisettimanale";
		}
		if (type.equals(MagazineCategory.settimanale)) 
		{
			return "Bisettimanale";
		}
		if (type.equals(MagazineCategory.mensile)) 
		{
			return "mensile";
		}
		if (type.equals(MagazineCategory.bimestrale)) 
		{
			return "bimestrale";
		}
		if (type.equals(MagazineCategory.trimestrale)) 
		{
			return "trimestrale";
		}
		if (type.equals(MagazineCategory.annuale)) 
		{
			return "annuale";
		}
		if (type.equals(MagazineCategory.estivo)) 
		{
			return "estivo";
		}
		if (type.equals(MagazineCategory.invernale)) 
		{
			return "invernale";
		}
		if (type.equals(MagazineCategory.sportivo)) 
		{
			return "sportivo";
		}
		if (type.equals(MagazineCategory.cinematografica)) 
		{
			return "cinematografica";
		}
		if (type.equals(MagazineCategory.gossip)) 
		{
			return "gossip";
		}
		if (type.equals(MagazineCategory.televisivo)) 
		{
			return "televisivo";
		}
		if (type.equals(MagazineCategory.militare)) 
		{
			return "militare";
		}
		if (type.equals(MagazineCategory.informatica)) 
		{
			return "informatica";
		}
		
		return null;
	}

	
	}
	


