package abstractFactoryLogin;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import factoryBook.Libro;

public class User implements LoginInterface{
	

	private String idRuolo,nome,cognome,email,password,descrizione;
	private LocalDate dataDiNascita;
	// array di codici isbn presi dai libri 
	private ArrayList<String> listaPreferiti = new ArrayList<String>();
 	
	public User(String m, String p) {
		// temp user user for checking data
		this.email = m;
		this.password = p;
	}
	public User( String nome, String cognome, String email, String password,LocalDate dataDiNascita) {
		//user for registration
		this.nome = nome;		
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.dataDiNascita = dataDiNascita;
	}
	public User() 
	{
		// void user for reset pass 
		this.nome = null;
		this.cognome = null;
		this.email = null;
		this.password = null;
		this.dataDiNascita =  null;
	}
	
	public User(String idRuolo, String nome, String cognome, String email, String password, String descrizione,
			LocalDate dataDiNascita, ArrayList<String> listaPreferiti) {
		// user for third use case
		this.idRuolo = idRuolo;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.descrizione = descrizione;
		this.dataDiNascita = dataDiNascita;
		this.listaPreferiti = listaPreferiti;
	}
	@Override
	public void login( String a) {
		// TODO Auto-generated method stub
		a="Sono loggato come User generico";
		System.out.println(a);
		
	}
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



	public ArrayList<String> getListaPreferiti() {
		return listaPreferiti;
	}



	public void setListaPreferiti(ArrayList<String> listaPreferiti) {
		this.listaPreferiti = listaPreferiti;
	}



	

}
