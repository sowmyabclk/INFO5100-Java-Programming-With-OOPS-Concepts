package AED.Assignment6.ATMQuestion;

public class ATMMainClass {

	public static void main(String[] args) {
		ATM atm=new ATM(10000, 1);
		 UserData user=new UserData("Bin",45, "2068180000" , "44006645", "NewBin");
		 atm.register(user);
		  
	}

}
