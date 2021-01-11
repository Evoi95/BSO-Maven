package abstractFactoryLoginDEPRECATO;

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

	// for logout function
	public LoginInterface getUserIstance(User U)
	{
		
		return null;
	}

	@Override
	public LoginInterface logout(User U) {
		U.setNull();
		if(U.getIdRuolo() == null && U.getEmail() == null)
		{ 
			return U;
		}
		return null;
	}
	
	public static LoginInterface setLogout(User U) {
		
		U.setNull();
		if(U.getIdRuolo() == null && U.getEmail() == null)
		{ 
			return U;
		}
		return null;
	}
}
