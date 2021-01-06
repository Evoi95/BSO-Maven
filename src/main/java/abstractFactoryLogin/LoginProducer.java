package abstractFactoryLogin;

public class LoginProducer {
	
	public static AbstractUserFactory getUserRole (String R)
	{
		if (R.equals("U"))
		{
			return new  GeneralUserFactory();
		}
		else if (R.equals("W") || R.equals("E") || R.equals("A"))
		{
			return new SpecialUserFactory();
		}
		return null;
	}

}
