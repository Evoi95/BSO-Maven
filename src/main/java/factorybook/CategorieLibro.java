package factorybook;

import boundary.laptop.BookCategory;

public class CategorieLibro {
	

	private BookCategory categoria;
	public BookCategory getCategoria() {
		return categoria;
	}

	public void setCategoria(BookCategory categoria) {
		this.categoria = categoria;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	private boolean isValid;
	public CategorieLibro(Boolean isValid) {
		this.isValid=isValid;
	}
	
	public CategorieLibro(String t) {
		this.categoria = BookCategory.valueOf(t);
		
	}


	public boolean adolescenti(BookCategory bC) 
	{
		return bC==BookCategory.ADOLESCENTI_RAGAZZI;
	}
	
	public boolean arte(BookCategory bC) 
	{
		return bC==BookCategory.ARTE;
	}
	public boolean cinema(BookCategory bC) 
	{
		return bC==BookCategory.CINEMA_FOTOGRAFIA;
	}
	public boolean biografie(BookCategory bC) 
	{
		return bC==BookCategory.BIOGRAFIE;
	}
	public boolean diari(BookCategory bC) 
	{
		return bC==BookCategory.DIARI_MEMORIE;
	}
	public boolean calendari(BookCategory bC) 
	{
		return bC==BookCategory.CALENDARI_AGENDE;
	}
	public boolean diritto(BookCategory bC) 
	{
		return bC==BookCategory.DIRITTO;
	}
	
	public boolean dizionari(BookCategory bC) 
		{
			return bC==BookCategory.DIZINARI_OPERE;
		}
	public boolean humor(BookCategory bC)
	{
		return bC==BookCategory.HUMOR;
	}
	public boolean economia(BookCategory bC)
	{
		return bC==BookCategory.ECONOMIA;
	}
	public boolean informatica(BookCategory bC)
	{
		return bC==BookCategory.INFORMATICA;
	}
	public boolean famiglia(BookCategory bC)
	{
		return bC==BookCategory.FAMIGLIA;
	}
	public boolean webDigital(BookCategory bC)
	{
		return bC==BookCategory.WEB_DIGITAL_MEDIA;
	}
	public boolean salute(BookCategory bC)
	{
		return bC==BookCategory.SALURE_BENESSERE;
	}
	public boolean letteratura(BookCategory bC)
	{
		return bC==BookCategory.LETTERATURA_NARRATIVA;
	}
	public boolean fantascienza(BookCategory bC)
	{
		return bC==BookCategory.FANTASCIENZA_FANTASY;
	}
	public boolean libriBambini(BookCategory bC)
	{
		return bC==BookCategory.LIBRI_BAMBINI;
	}
	public boolean fumetti(BookCategory bC)
	{
		return bC==BookCategory.FUMETTI_MANGA;
	}
	public boolean libriScolastici(BookCategory bC)
	{
		return bC==BookCategory.LIBRI_SCOLASTICI;
	}
	public boolean gialli(BookCategory bC)
	{
		return bC==BookCategory.GIALLI_THRILLER;
	}
	public boolean linguistica(BookCategory bC)
	{
		return bC==BookCategory.LINGUISTICA_SCRITTURA;
	}
	public boolean religione(BookCategory bC)
	{
		return bC==BookCategory.RELIGIONE;
	}
	public boolean politica(BookCategory bC)
	{
		return bC==BookCategory.POLITICA;
	}
	public boolean romanziRosa(BookCategory bC)
	{
		return bC==BookCategory.ROMANZI_ROSA;
	}
	public boolean libriUniversitari(BookCategory bC)
	{
		return bC==BookCategory.LIBRI_UNIVERSITARI;
	}
	public boolean scienze(BookCategory bC)
	{
		return bC==BookCategory.SCIENZE;
	}
	public boolean tecnologia(BookCategory bC)
	{
		return bC==BookCategory.TECNOLOGIA_MEDICINA;
	}
	public boolean sport(BookCategory bC)
	{
		return bC==BookCategory.SPORT;
	}
	public boolean storia(BookCategory bC)
	{
		return bC==BookCategory.STORIA;
	}
	public boolean viaggi(BookCategory bC)
	{
		return bC==BookCategory.VIAGGI;
	}
	public boolean tempoLibero(BookCategory bC)
	{
		return bC==BookCategory.TEMPO_LIBERO;
	}
	public boolean altro(BookCategory bC)
	{
		return bC==BookCategory.ALTRO;
	}
	public boolean computerGiochi(BookCategory bC)
	{
		return bC==BookCategory.COMPUTER_GIOCHI;
	}
	
}
