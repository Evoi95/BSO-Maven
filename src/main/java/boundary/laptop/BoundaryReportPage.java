package boundary.laptop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;

import controller_app.ControllerReportGiornali;
import controller_app.ControllerReportLibri;
import controller_app.ControllerReportRiviste;
import controller_app.ControllerUserPage;
import logger.Log;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class BoundaryReportPage implements Initializable {
	
	@FXML
	private Pane pane;
	@FXML
	private Label header;
	@FXML
	private Button totaleB;
	@FXML
	private Button libroB;
	@FXML
	private Button raccoltaB;
	@FXML
	private Button giornaliB;
	@FXML
	private Button buttonI;
	@FXML
	private Button rivisteB;
	@FXML
	private TextArea ta;
	
	private ControllerReportLibri cRL;
	private ControllerReportGiornali cRG;
	private ControllerReportRiviste cRR;
	private ControllerUserPage cUP;
	protected String fileLibro = "ReportFinale\\riepilogoLibro.txt";
	protected String fileGiornale ="ReportFinale\\riepilogoGiornali.txt";	
	protected String fileRiviste = "ReportFinale\\riepilogoRiviste.txt";
	protected Scene scene;
	
	private BufferedReader reader;
	private BufferedReader readerR;
	private BufferedReader readerL;
	private BufferedReader readerG;
	private BufferedReader reader3;
	
	
	@FXML
	private void totale() throws SQLException, IOException
	{
		ta.clear();
		
			cRL.generaReportLibri();
			cRG.generaReportGiornali();
			cRR.generaReportRiviste();
			cUP.getUtenti();
		
			leggiLibri();
		

			leggiGiornale();
			
			riepilogoUtenti();
			
		
     

		

	}
	@FXML
	private void reportLibri() throws IOException 
	{
		ta.clear();

		  
		try {
			cRL.generaReportLibri();
		} catch (IOException | SQLException e) {
			e.getMessage();
		 
			
		}
		 reader = new BufferedReader(new FileReader(fileLibro));
        String line = reader.readLine();
        while(line!=null) {
            ta.appendText(line.concat("\n"));
            

            Log.logger.log(Level.INFO,line);
            line = reader.readLine();
        }
        reader.close();
    }
		

	
	@FXML
	private void raccolta() throws IOException, SQLException
	{
		ta.clear();
		cRL.generaReportLibri();
		cRG.generaReportGiornali();
		cRR.generaReportRiviste();
		
		leggiLibri();
		
		leggiGiornali();
		
		
        try {
		 reader = new BufferedReader(new FileReader("fileLibro"));
        String line2 = reader.readLine();
        while(line2!=null) {
            ta.appendText(line2.concat("\n"));
            

            Log.logger.log(Level.INFO,line2);
            line2 = reader.readLine();
        }}catch(IOException e)
        {
        	e.getMessage();
        }
        finally {
        reader.close();
        }

		
	}
	@FXML
	private void reportGiornali() throws IOException
	{
		ta.clear();

		cRG.generaReportGiornali(); 
		 reader = new BufferedReader(new FileReader(fileGiornale));
        String line = reader.readLine();
        while(line!=null) {
            ta.appendText(line.concat("\n"));
            

            Log.logger.log(Level.INFO,line);
            line = reader.readLine();
        }
        reader.close();

	}
	@FXML
	private void indietro() throws IOException
	{
		Stage stage;
		Parent root;
		stage = (Stage) buttonI.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
		stage.setTitle("Benvenuto nella schermata del riepilogo dei libri");
		scene = new Scene(root);
		stage.setScene(scene);

		stage.show();

	}
	@FXML
	private void reportRiviste() throws IOException
	{
		ta.clear();

		try {
			cRR.generaReportRiviste();
		
		} catch (IOException | SQLException eSQL) {
		 
			eSQL.printStackTrace();
		}

		leggiRiviste();

		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cRL=new ControllerReportLibri();
		cRG=new ControllerReportGiornali();
		cRR=new ControllerReportRiviste();
		cUP=new ControllerUserPage();
	}
	
	private void  leggiLibri() throws IOException
	{
		 String line;

		try {
			
			 readerL = new BufferedReader(new FileReader(fileLibro));		
				
	        while((line=readerL.readLine())!=null) {
	            ta.appendText(readerL.readLine().concat("\n"));
	            

	            Log.logger.log(Level.INFO,line);
	             line = readerL.readLine();
	        }
			}catch(IOException e)
			{
				e.getMessage();
			}
			finally {
	        readerL.close();
			}
	}
	private void leggiGiornale() {
		try {
			readerG = new BufferedReader(new FileReader(fileGiornale));
			String line1 = readerG.readLine();
			while(line1!=null) {
            ta.appendText(line1.concat("\n"));
            

            Log.logger.log(Level.INFO,line1);
            line1 = readerG.readLine();
        }
		} catch (IOException e) {
			e.getMessage();
		 
			
		 
		} 
		finally {
        
        try {
        	
			readerG.close();
		} catch (IOException e) {
			e.getMessage();
		 
			
		}
		}

	
	try {
		reader = new BufferedReader(new FileReader("fileGiornale"));
	} catch (FileNotFoundException e) {
		e.getMessage();
	 
		
	}
    String line2 = null;
	try {
		line2 = reader.readLine();
	while(line2!=null) {
        ta.appendText(line2.concat("\n"));
        

        Log.logger.log(Level.INFO,line2);
       
			line2 = reader.readLine();
		
	}
	}catch(IOException | NullPointerException e)
    {
    	e.getCause();
    }
    
    finally {
    try {
		reader.close();
	} catch (IOException e) {
		e.getMessage();
	 
		
	}
    }}
	
	private void riepilogoUtenti()
	{
		   
				try {
					reader3 = new BufferedReader(new FileReader("ReportFinale\\riepilogoUtenti.txt"));
				} catch (FileNotFoundException e) {
					e.getMessage();
					
				 
					
				}
		        String line3 = null;
				try {
					line3 = reader3.readLine();
				while(line3!=null) {
		            ta.appendText(line3.concat("\n"));
		            

		            Log.logger.log(Level.INFO,line3);
		            
						line3 = reader3.readLine();
					
				}}catch(IOException | NullPointerException e)
				{
					e.getMessage();
				}
			finally {
		        try {
					reader3.close();
				} catch (IOException e) {
					e.getMessage();
				 
					
				}
			}

	}
	private void leggiGiornali() throws IOException
	{
		try {
	        readerG = new BufferedReader(new FileReader(fileGiornale));
	        String line1 = readerG.readLine();
	        while(line1!=null) {
	            ta.appendText(line1.concat("\n"));
	            

	            Log.logger.log(Level.INFO,line1);
	            line1 = readerG.readLine();
	        }}catch(IOException e)
			{
	        	e.getMessage();
			}
			finally {
	        readerG.close();
			}

		
	}
	private void leggiRiviste() throws IOException
	{
		try {
			 readerR = new BufferedReader(new FileReader("fileRiviste"));
	        String line2 = readerR.readLine();
	        while(line2!=null) {
	            ta.appendText(line2.concat("\n"));
	            

	            Log.logger.log(Level.INFO,line2);
	            line2 = readerR.readLine();
	        }
			}catch(IOException e)
	        {
	        	e.getMessage();
	        }
			finally {
	        readerR.close();
			}

	}
	
}


