package factoryBook;

import boundary.laptop.MagazineCategory;

public class CategorieRivista {
	
	private MagazineCategory type;
	private Boolean isValid;
	
	public CategorieRivista(Boolean isValid)
	{
		this.isValid=isValid;
		this.isValid=false;
	}
	
	public CategorieRivista(String r) {
		this.type = MagazineCategory.valueOf(r); 
		this.isValid = true;
	}
	public boolean settimanale (MagazineCategory mC) 
	{
		return mC==MagazineCategory.SETTIMANALE;
	}	
	public boolean bisettimanale (MagazineCategory mC) 
	{
		return mC==MagazineCategory.BISETTIMANALE;
	}
	public boolean mensile (MagazineCategory mC) 
	{
		return mC==MagazineCategory.MENSILE;
	}
	public boolean bimestrale (MagazineCategory mC) 
	{
		return mC==MagazineCategory.BIMESTRALE;
	}
	public boolean trimestrale (MagazineCategory mC) 
	{
		return mC==MagazineCategory.TRIMESTRALE;
	}
	public boolean annuale (MagazineCategory mC) 
	{
		return mC==MagazineCategory.ANNUALE;
	}
	public boolean estivo (MagazineCategory mC) 
	{
		return mC==MagazineCategory.ESTIVO;
	}
	public boolean invernale (MagazineCategory mC) 
	{
		return mC==MagazineCategory.INVERNALE;
	}
	public boolean sportivo (MagazineCategory mC) 
	{
		return mC==MagazineCategory.SPORTIVO;
	}
	public boolean cinematografica (MagazineCategory mC) 
	{
		return mC==MagazineCategory.CINEMATOGRAFICA;
	}
	public boolean gossip (MagazineCategory mC) 
	{
		return mC==MagazineCategory.GOSSIP;
	}
	public boolean televisivo (MagazineCategory mC) 
	{
		return mC==MagazineCategory.TELEVISIVO;
	}
	public boolean militare (MagazineCategory mC) 
	{
		return mC==MagazineCategory.MILITARE;
	}
	public boolean informatica (MagazineCategory mC) 
	{
		return mC==MagazineCategory.INFORMATICA;
	}
	
	
		
		
		
	
}
	


