package AED.Assignment6.ATMQuestion;



class UserData extends User {


  private double availableBalance;
  private String password;
  
  double getAvailableBalance() {
    return availableBalance;
  }
  void setAvailableBalance(double availableBalance) {
    this.availableBalance = availableBalance;
  }
  String getPassword() {
    return password;
  }
  void setPassword(String password) {
    this.password = password;
  }
  
  public UserData(){}
  
  UserData(String name, String phone){
    super(name,phone);
  }
  
	  UserData(String name, String phone, String card){
    super(name, phone);
    super.setBankAccountNumber(card);
    this.availableBalance=0.0;
  }
  
  UserData(String name, int age, String phone, String card, String password){

    this(name, phone, card);
    this.password=password;
  }
  
  public String toString(){
    return super.toString() +", "+password+", "+availableBalance;
  }
}
