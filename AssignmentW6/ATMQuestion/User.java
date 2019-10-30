package AED.Assignment6.ATMQuestion;

class User  {
  
  private String name, address, phoneNumber, bankAccountNumber;
 private int age;
  
  
  String getName() {
    return name;
  }
  void setName(String name) {
    this.name = name;
  }
  String getAddress() {
    return address;
  }
  void setAddress(String address) {
    this.address = address;
  }
  String getBankAccountNumber() {
    return bankAccountNumber;
  }
  void setBankAccountNumber(String bankAccountNumber) {
    this.bankAccountNumber = bankAccountNumber;
  }
  String getPhoneNumber() {
    return phoneNumber;
  }
  void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
	
	 int getAge() {
		 return age; 
		 } 
	 void setAge(int year) {
	this.age = year; }
	 
  
  protected User(){};
  User(String name, String phone){
    this.name=name;
    this.phoneNumber=phone;
  }
  
  public String toString(){
    return name+", "+age+", "+phoneNumber+", "+bankAccountNumber+", "+address;
  //  return name+", "+phoneNumber+", "+bankAccountNumber+", "+address;

  }
}
