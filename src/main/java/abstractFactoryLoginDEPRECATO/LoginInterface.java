package abstractFactoryLoginDEPRECATO;
 
// qui ho gia preso i dati 
public interface LoginInterface {
	
	// la string passata è il ruolo dell'utente
	User login(String a);
	
	User logout(User U);
	// set a instance return
	

}
