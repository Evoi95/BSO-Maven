package abstractFactoryLoginDEPRECATO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Admin implements LoginInterface {

	private String idRuolo,nome,cognome,email,password,descrizione;
	private LocalDate dataDiNascita;
		@Override
	public User login( String a) {
		// TODO Auto-generated method stub
		a="Sono loggato come Admin generico";
		System.out.println(a);
		return null;
	
	}
	
	public Admin()
	{
		this.idRuolo = "A"; // use to abstrac factory 
		this.nome = null;
		this.cognome = null;
		this.email = null;
		this.password = null;
		this.dataDiNascita =  null;
	}
	
	public Admin(User u) {
		this.idRuolo = "A"; // use to abstrac factory 
		this.nome = u.getNome();
		this.cognome = u.getCognome();
		this.email = u.getEmail();
		this.password = u.getPassword();
		this.dataDiNascita =  u.getDataDiNascita();
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
	@Override
	public User logout(User U) {
		return U;
		// TODO Auto-generated method stub
		
	}



}