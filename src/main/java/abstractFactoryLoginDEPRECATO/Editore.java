package abstractFactoryLoginDEPRECATO;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Editore implements LoginInterface {

	private String idRuolo,nome,cognome,email,password,descrizione;
	private LocalDate dataDiNascita;
	// array di codici isbn presi dai libri che l'editre ha publicato
	private ArrayList<String> listaPublicazioni = new ArrayList<String>();
	
	// array degli id degli scrittori associati alla casa editrice
	private ArrayList<Integer> listaScrittori = new ArrayList<Integer>();
	
	@Override
	public User login( String a) {
		// TODO Auto-generated method stub
		a="Sono loggato come Editore generico";
		System.out.println(a);
		return null;
		
	}
	@Override
	public User logout(User U) {
		return U;
		// TODO Auto-generated method stub
		
	}
	
	public Editore()
	{
		this.idRuolo = "E"; // use to abstrac factory 
		this.nome = null;
		this.cognome = null;
		this.email = null;
		this.password = null;
		this.dataDiNascita =  null;
	}
	public Editore(User u) {
		this.idRuolo = "E"; // use to abstrac factory 
		this.nome = u.getNome();
		this.cognome = u.getCognome();
		this.email = u.getEmail();
		this.password = u.getPassword();
		this.dataDiNascita =  u.getDataDiNascita();	}
	public String getIdRuolo() {
		return idRuolo;
	}



	public void setIdRuolo(String idRuolo) {
		this.idRuolo = idRuolo;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getDescrizione() {
		return descrizione;
	}



	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}



	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}



	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}


	public ArrayList<String> getListaPublicazioni() {
		return listaPublicazioni;
	}
	public void setListaPublicazioni(ArrayList<String> listaPublicazioni) {
		this.listaPublicazioni = listaPublicazioni;
	}
	public ArrayList<Integer> getListaScrittori() {
		return listaScrittori;
	}
	public void setListaScrittori(ArrayList<Integer> listaScrittori) {
		this.listaScrittori = listaScrittori;
	}

}