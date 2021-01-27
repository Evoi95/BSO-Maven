package application;

import java.sql.SQLException;

import pagamento.Pagamento;
import database.GiornaleDao;
import database.LibroDao;
import database.PagamentoDao;
import database.RivistaDao;
import factoryBook.Giornale;
import factoryBook.Libro;
import factoryBook.Rivista;

public class ControllerAcquista {

	private LibroDao lD;
	private GiornaleDao gD;
	private RivistaDao rD;
	private PagamentoDao pagD;
	private Libro l;
	private Giornale g;
	private Rivista r;
	private Pagamento p;
	private static singeltonSystemState vis = singeltonSystemState.getIstance() ;
	private String name;
	private int disp;
	
	public float totale(String isbn, int disp) {
		float x = (float) 0.0;
		try {
			lD.daiPrivilegi();
			// se semo fermati qua 
			l.setId(vis.getIstance().getId());
			l.setDisponibilita(disp);
			x = lD.getCosto(l);

			System.out.println("ControllerAcquista");
			lD.aggiornaDisponibilita(l);
			lD.aggiornaCopieVendute(l,disp);
			
		
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	public float totaleG(String titolo, int disp) {
		float y = (float) 0.0;
		g.setTitolo(titolo);
		g.setDisponibilita(disp);
		try {
			gD.daiPrivilegi();
			y = gD.getCosto(g);
			gD.aggiornaDisponibilita(g);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return y;

	}

	public float totaleR(String titolo, int disp) {
		float z = (float) 0.0;
		r.setTitolo(titolo);
		r.setCopieRim(disp);
		try {
			rD.daiPrivilegi();
			z = rD.getCosto(r);
			rD.aggiornaDisponibilita(r);
			/*
			p=new Pagamento(0, null, 0, null, z, null, 0);
			p.setId(rD.retId(r));
			p.setTipo(rD.retTip(r));
			pagD.inserisciPagamento(p);
*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return z;

	}

	public ControllerAcquista() throws SQLException {
		lD = new LibroDao();
		gD = new GiornaleDao();
		rD = new RivistaDao();
		l = new Libro();
		g = new Giornale();
		r = new Rivista();
		pagD = new PagamentoDao();
		pagD.daiPrivilegi();
		//p = new Pagamento(0);

	}

	public int getIdL(String text) throws SQLException {
		l.setCodIsbn(text);
		return lD.retId( l);
		// TODO Auto-generated method stub
		
	}
	
	public String getTipL(String text) throws SQLException
	{
		l.setId(Integer.parseInt(text));
		return lD.retTip(l);
	}
	
	public int getIdG(String text) throws SQLException {
		g.setTitolo(text);//l.setCodIsbn(text);
		return gD.retId( g);
		// TODO Auto-generated method stub
		
	}
	
	public String getTipG(String text) throws SQLException
	{
		g.setTitolo(text);	
		return gD.retTip(g);
	}
	
	public int getIdR(String text) throws SQLException {
		r.setTitolo(text);//l.setCodIsbn(text);
		return rD.retId( r);
		// TODO Auto-generated method stub
		
	}
	
	public String getTipR(String text) throws SQLException
	{
		r.setTitolo(text);	
		return rD.retTip(r);
	}
	
	public void inserisciAmmontareL(Float f) throws SQLException
	{
		p=new Pagamento(0, null, 0, null,  f, null, 0);
		p.setId(lD.retId(l));
		p.setTipo(lD.retTip(l));
		pagD.inserisciPagamento(p);

	}
	
	public void inserisciAmmontareG(Float f) throws SQLException
	{
		p=new Pagamento(0, null, 0, null,  f, null, 0);
		p.setId(gD.retId(g));
		p.setTipo(gD.retTip(g));
		pagD.inserisciPagamento(p);

	}

	public void inserisciAmmontareR(Float f) throws SQLException
	{
		p=new Pagamento(0, null, 0, null,  f, null, 0);
		p.setId(rD.retId(r));
		p.setTipo(rD.retTip(r));
		pagD.inserisciPagamento(p);

	}
	
	public String getType()
	{
		
		String S = vis.getIstance().getType();
		System.out.println(S);
		return S;
	}

	public String getNomeById() throws SQLException
	{
		
		int id = vis.getIstance().getId();
		String type =vis.getIstance().getType();
		if(type.equals("libro"))
		{
			l.setId(id);
			name = lD.getNome(l);
		}
		else if(type.equals("giornale")) {
			g.setId(id);
			name = gD.getNome(g);
		}
		else if(type.equals("rivista"))
		{
			r.setId(id);
			name = rD.getNome(r);
			
		}
		return name ;
	}
	
	public int getDisp() throws SQLException
	{
		int id = vis.getIstance().getId();
		String type =vis.getIstance().getType();
		if(type.equals("libro"))
		{
		
			l.setId(id);
			disp = lD.getQuantita(l);
		}
		else if(type.equals("giornale")) {
			g.setId(id);
			disp = gD.getQuantita(g);
		}
		else if(type.equals("rivista"))
		{
			r.setId(id);
			disp = rD.getQuantita(r);
			
		}
		return disp ;
	}
	
	}
