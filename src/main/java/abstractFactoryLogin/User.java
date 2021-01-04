package abstractFactoryLogin;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import factoryBook.Libro;

public class User implements LoginInterface{
	
	private String idRuolo,nome,cognome,email,password,descrizione;
	private Date dataDiNascita;
	// array di codici isbn presi dai libri 
	private ArrayList<String> listaPreferiti = new ArrayList<String>();
 	
	@Override
	public void login( String a) {
		// TODO Auto-generated method stub
		
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



	public ArrayList<String> getListaPreferiti() {
		return listaPreferiti;
	}



	public void setListaPreferiti(ArrayList<String> listaPreferiti) {
		this.listaPreferiti = listaPreferiti;
	}



	

}
