package usersSingelton;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import factoryBook.Libro;

// Uso temp user per non compromettere lo stato dell'utente loggato 
public class TempUser {


	private String idRuolo,nome,cognome,email,password,descrizione;
	private LocalDate dataDiNascita;
	// array di codici isbn presi dai libri 
	private ArrayList<String> listaPreferiti = new ArrayList<String>();
	
	private static TempUser instance = new TempUser();
	
	private  TempUser()
	{
		// manco la mia anima e' così vuota
	}
 	
	// end of construtor
	// start of getters and setters
	
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

	// end of setters and getters
	
	// start method
	
	public static TempUser getInstance()
	{
		return instance;
	}

		
	public void setNull() {
		
		this.idRuolo = null; 
		this.nome = null;
		this.cognome = null;
		this.email = null;
		this.password = null;
		this.dataDiNascita =  null;
		
	}
}


	



	
	


	

