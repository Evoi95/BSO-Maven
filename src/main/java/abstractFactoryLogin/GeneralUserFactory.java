package abstractFactoryLogin;

public class GeneralUserFactory extends AbstractUserFactory{

	@Override
	public LoginInterface getRuolo(String R) {
		// per il terzo caso d'uso
		// return a generic ures role
		if(R.equals("U"))
		{
			return new User();
		}
		
		return null;
	}
	
	public static LoginInterface getLogin(String R) {
		// per il terzo caso d'uso
		// return a generic ures role
		if(R.equals("U"))
		{
			return new User();
		}
		
		return null;
	}

}
