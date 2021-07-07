package factorybook;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import logger.Log;


public class Giornale implements Raccolta {
	
	
	private String  titolo;
	private String tipologia;
	private String lingua;
	private String editore;
	private LocalDate dataPubb;
	private int copieRimanenti;
	private int disponibilita;
	private float prezzo;
	private int id;
	private String url="C:\\libriScaricati";

	

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public LocalDate getDataPubb() {
		return dataPubb;
	}

	public void setDataPubb(LocalDate dataPubb) {
		this.dataPubb = dataPubb;
	}

	public int getCopieRimanenti() {
		return copieRimanenti;
	}

	public void setCopieRimanenti(int copieRimanenti) {
		this.copieRimanenti = copieRimanenti;
	}

	public int getDisponibilita() {
		return this.disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}




	@Override
	public void scarica() throws IOException {
		Desktop desktop=null;
		 File dirToOpen=null;
		 File file;


		   file = new File(url);
	      boolean bool = file.mkdir();
	      if(bool){
	         Log.logger.log(Level.INFO,"Directory created successfully");
	      }else{
	         Log.logger.log(Level.INFO,"Sorry could not create specified directory");
	      }
	      
	      
	      
		  desktop = Desktop.getDesktop();
	        try {
	            dirToOpen = new File(url);
	            
					desktop.open(dirToOpen);
				
	        } catch (IllegalArgumentException iae) {
	            Log.logger.log(Level.INFO,"File Not Found");
	        }
	        	        	
		
		
	}

	@Override
	public void leggi() {
		 Document document=null;


	    //definiamo il nome del nostro file di prova
	    // Creiamo un Document
	     document = new Document();
	    // otteniamo una istanza di PdfWriter passando il document ed uno stream file
	    try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\libriScaricati\\prova2.pdf"));
			} catch (FileNotFoundException|DocumentException e) {
				e.getMessage();

			 
				
			} 
	        document.open();
	        // aggiungiamo un paragrafo
	        try {
				document.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sed nisi non mi vulputate vestibulum. In hac habitasse platea dictumst. Aenean pellentesque est eget tortor blandit pulvinar. Donec in finibus ante. Phasellus molestie pretium magna, non cursus tortor. Ut malesuada consequat lectus, et laoreet dui eleifend vel. In sit amet luctus quam. Sed laoreet tellus at imperdiet pulvinar. Vestibulum ut erat et nunc aliquet interdum.\r\n"
						+ "\n"
						+ "In commodo nisl velit, a egestas nunc consectetur vitae. Sed vulputate eros eget massa blandit ornare. Donec semper bibendum lacus, at pharetra enim pharetra sed. Mauris tempus tellus nec nulla molestie, faucibus semper nibh consequat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec iaculis purus nisi, vel volutpat sapien vulputate a. Aenean blandit non nibh in finibus. Integer ac tempus dui, laoreet gravida ex. Integer vitae orci vel nulla commodo cursus quis et nisi. Nulla sit amet nibh sed justo dapibus vulputate ut et nisi. Mauris efficitur commodo iaculis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus blandit urna eros, sed cursus mauris blandit ut. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n"
						+ "\n"
						+ "Vestibulum eros tellus, rhoncus vel fringilla nec, vehicula in velit. Nam malesuada eget tellus ut viverra. Aenean iaculis gravida urna, eu convallis leo dapibus vel. Nullam et suscipit diam. Sed tincidunt ipsum sed placerat consequat. Vestibulum lacinia lacinia commodo. Vestibulum lacus erat, pellentesque sed rhoncus id, tincidunt eget ante. Phasellus vulputate urna sit amet dolor rhoncus bibendum eu feugiat nisl. Proin ipsum libero, consectetur sit amet sagittis nec, feugiat nec quam. In dictum massa quis ligula semper, eget dignissim turpis blandit.\r\n"
						+ "\n"
						+ "Sed congue laoreet diam vel iaculis. Maecenas tempor convallis dolor nec laoreet. Quisque vitae dui vitae erat tempor volutpat aliquam ac ipsum. Nulla nulla erat, iaculis eu vulputate in, fermentum sed est. Ut ac enim ac felis molestie fringilla at a lectus. Donec porttitor a elit eget tempus. Morbi molestie libero lorem, et fringilla mi pharetra scelerisque. Fusce ut nunc sit amet odio dapibus tristique. Phasellus ultrices, nisl sit amet faucibus ultrices, odio nisl dictum enim, at sollicitudin arcu metus a risus. Duis suscipit, mi sed mollis euismod, erat justo pellentesque orci, vitae finibus nunc est vitae felis. Ut venenatis commodo eros sed fermentum. Fusce feugiat pellentesque justo. Ut finibus, lacus quis ornare consectetur, sapien urna placerat mauris, non ultricies justo nunc sed ante. Phasellus sodales dui a ex gravida, a tempor mi eleifend.\r\n"
						+ "\n"
						+ "Aenean pharetra tortor semper, laoreet dui sed, porta lacus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque interdum purus cursus venenatis mollis. Donec venenatis bibendum ullamcorper. Phasellus porttitor, mauris eget placerat imperdiet, tellus purus aliquet mauris, eget laoreet quam nibh eget nisi. Nam volutpat urna vitae eros porttitor efficitur. Etiam mi velit, vulputate sed lacinia rutrum, viverra sed nulla. Sed sem mi, tempus ut lacus faucibus, congue dignissim dolor. Praesent sed quam feugiat, condimentum eros non, luctus dui."));
			} catch (DocumentException e) {
				e.getMessage();
			 
				
			}
	        // chiudiamo il documento
	        document.close();
		
		
	}

	public Giornale(String titolo, String tipologia, String lingua, String editore, LocalDate dataPubb2, int copieRimanenti,
			int disponibilita, float prezzo, int id ) {
		this.titolo = titolo;
		this.tipologia = tipologia;
		this.lingua = lingua;
		this.editore = editore;
		this.dataPubb = dataPubb2;
		this.copieRimanenti = copieRimanenti;
		this.disponibilita = disponibilita;
		this.prezzo = prezzo;
		this.id = id;
	}
	
	public Giornale()
	{
		super();
		this.titolo=null;
		this.tipologia=null;
		this.lingua=null;
		this.editore=null;
		this.dataPubb=null;
		this.copieRimanenti=0;
		this.disponibilita=0;
		this.prezzo=0;
		this.id = -1;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
