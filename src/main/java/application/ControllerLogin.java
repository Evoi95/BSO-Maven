package application;

public class ControllerLogin {

	boolean controlla(String u, String p) {
		boolean esito = false;
		if (u.equals("admin") && p.equals("admin") ) {
				System.out.println("Accesso autorizzato ");
				esito = true;
			}
			else if (u.equals("user") && p.equals("user")){
				System.out.println("Accesso autorizzato ");
				esito = true;
			
			}
		 else if (u.equals("scrittore") && p.equals("scrittore")) {
			 System.out.println("Accesso autorizzato ");
				esito = true;
			
		} else {
			System.out.println("Errore nelle credenziali");
			esito=false;
		}
		return esito;
	}
}
