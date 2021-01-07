package abstractFactoryLogin;

public class SpecialUserFactory extends AbstractUserFactory {

	@Override
	public LoginInterface getRuolo(String R) {
		// per il terzo caso d'uso
		// return a generic ures role
		if (R.equals("A"))
		{
			return new Admin();
		}
		else if (R.equals("E"))
		{
			return new Editore();
		}
		else if(R.equals("W"))
		{
			return new Scrittore();
		}
		return null;
	}
	
	
	public static LoginInterface getLogin(String R) {
		// per il Secondo caso d'uso
		// return a generic ures role
		if (R.equals("A"))
		{
			return new Admin();
		}
		else if (R.equals("E"))
		{
			return new Editore();
		}
		else if(R.equals("W"))
		{
			return new Scrittore();
		}
		return null;
	}

	
}
