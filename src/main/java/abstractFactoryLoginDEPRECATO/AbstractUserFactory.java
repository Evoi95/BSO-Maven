package abstractFactoryLoginDEPRECATO;

public abstract class AbstractUserFactory {

	abstract LoginInterface getRuolo (String R);
	
	abstract LoginInterface logout(User U);
}
