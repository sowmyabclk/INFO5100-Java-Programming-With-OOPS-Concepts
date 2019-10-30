package AED.Assignment6.ATMQuestion;

public class ATMMainClass {

	public static void main(String[] args) {
		ATM atm=new ATM(4000, 1);
		 UserData user=new UserData("Sowmya",45, "1234567" , "456789", "password");
		 atm.register(user);
		  
	}

}
