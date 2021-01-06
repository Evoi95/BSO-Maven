package abstractFactoryLogin;

import java.sql.Date;
import java.util.ArrayList;

public class Admin implements LoginInterface {

	private String idRuolo,nome,cognome,email,password,descrizione;
	private Date dataDiNascita;
		@Override
	public void login( String a) {
		// TODO Auto-generated method stub
		a="Sono loggato come Admin generico";
		System.out.println(a);
	
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



	public Date getDataDiNascita() {
		return dataDiNascita;
	}



	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	@Override
	public void logout(User U) {
		// TODO Auto-generated method stub
		
	}



}
