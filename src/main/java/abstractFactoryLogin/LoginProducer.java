package abstractFactoryLogin;

public class LoginProducer {
	
	// PRENDO IL ROLO  E RICHIAMO LE FACTORY APPROPRIATE
	public static AbstractUserFactory getUserRole (String R)
	{
		// USO SEMPRE QUESTRA PER IL LOGIN INIZIALE O LA 
		//SPECIALIZZAZIONE IN UTENTE GENERICO  
		if (R.equals("U"))
		{
			return new  GeneralUserFactory();
		}
		// LO CHIAMO PER SPECIALIZZARE GLI UTENTI CON
		// PRIVELIGI SUPERIORI O PER FUNZIONI SPECIFICHE
		else if (R.equals("W") || R.equals("E") || R.equals("A"))
		{
			return new SpecialUserFactory();
		}
		return null;
	}

}
