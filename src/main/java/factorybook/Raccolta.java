package factorybook;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

public interface Raccolta {
	
	//void compra(); //vedere acquista libro button
	void scarica() throws DocumentException, IOException;//stampo messsaggio libro scaricato 
	void leggi();//stampo messaggio libro in lettura

}
