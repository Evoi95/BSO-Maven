package usersSingelton;

import java.time.LocalDate;
import java.util.ArrayList;

public class Editore {

	private String idRuolo,nome,cognome,email,password,descrizione;
	private LocalDate dataDiNascita;
	// array di codici isbn presi dai libri 
	
	public Editore(User u) {

		this.idRuolo = u.getInstance().getIdRuolo();
		this.nome = u.getInstance().getNome();
		this.cognome = u.getInstance().getCognome();
		this.email = u.getInstance().getEmail();
		this.password = u.getInstance().getPassword();
		this.descrizione = u.getInstance().getDescrizione();
		this.dataDiNascita =u.getInstance().getDataDiNascita();
	
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
	
}