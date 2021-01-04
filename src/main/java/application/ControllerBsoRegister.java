package application;

public class ControllerBsoRegister {
	private Boolean state=false;

	public Boolean registra(String n, String c, String email, String pwd, String pwdC) {
		// TODO Auto-generated method stub
		if(pwd.length()>=8 && pwdC.length()>=8)
		{
			//todo daoUser.insert
			state=true;
		}
		else {
			state=false;
		}
		return state;
	}

}
