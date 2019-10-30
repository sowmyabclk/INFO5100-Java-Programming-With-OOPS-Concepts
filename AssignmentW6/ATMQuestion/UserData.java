package AED.Assignment6.ATMQuestion;

import java.io.Serializable;


class UserData extends User implements Serializable {


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
  
  protected UserData(){}
  
  UserData(String name, String phone){
    super(name,phone);
  }
  
 // UserData(String name, int birthYear, String phone, String card){
	  UserData(String name, String phone, String card){
    super(name, phone);
//    super.setBirthYear(birthYear);
    super.setBankAccountNumber(card);
    this.availableBalance=0.0;
  }
  
  UserData(String name, int birthYear, String phone, String card, String password){
	//  UserData(String name, String phone, String card, String password){

    this(name, phone, card);
    this.password=password;
  }
  
  public String toString(){
    return super.toString() +", "+password+", "+availableBalance;
  }
}