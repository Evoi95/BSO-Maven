package users.singelton;


import java.time.LocalDate;
import java.util.logging.Level;

import logger.Log;

public class User {
	

	private String idRuolo;
	private String nome;
	private String cognome; 
	private String email;
	private String password;
	private String descrizione;
	private LocalDate dataDiNascita;
	private int idU;

	
	private static User instance =new User();
	
	private  User()
	{
		
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

	
	public static User getInstance()
	{
		return instance;
	}
	public User login( String a) {
		

		a="Sono loggato come User generico";
		Log.logger.log(Level.INFO,a);
		return null;
		
	}
		
	public void setNull() {
		
		this.idRuolo = null; 
		this.nome = null;
		this.cognome = null;
		this.email = null;
		this.password = null;
		this.dataDiNascita =  null;
		this.idU=0;
		
	}

	public int getIdU() {
		return idU;
	}

	public void setIdU(int idU) {
		this.idU = idU;
	}


	
}