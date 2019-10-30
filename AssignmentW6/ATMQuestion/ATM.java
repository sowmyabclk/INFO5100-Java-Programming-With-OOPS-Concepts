package AED.Assignment6.ATMQuestion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

class ATM {

  private double availableAmountInMachine;
  private double transactionFee;

  
  private static final int RECENT_TRANS_NUM=10;
  private static final int MAX_TRY_TIMES=3;

 
  protected static Map<String, UserData> customers;
  
 
  protected static Map<String, String> accNumberToAccount;//map phone info. to account

  protected static Map<String, List<String>> transactions;
  

  private Scanner scanner;
  
  enum Transaction {
	  WithDrawal("WithDrawal"), Deposit("Deposit");
	  String name;

	  Transaction(String name) {
	    this.name = name;
	  }

	  public String toString() {
	    return String.format("%-10s", this.name);
	  }
	}
  
  
  double getAvailableAmountInMachine() {
    return availableAmountInMachine;
  }
  
  double getTransactionFee() {
    return transactionFee;
  }

  Map<String, String> getToAccount() {
    return accNumberToAccount;
  }

  void setPhoneToAccount(Map<String, String> phoneToAccount) {
    ATM.accNumberToAccount = phoneToAccount;
  }

  void setTransactionFee(double transactionFee) {
    this.transactionFee = transactionFee;
  }

  protected Map<String, UserData> getCustomers() {
    return customers;
  }

  protected void setCustomers(Map<String, UserData> customers) {
    ATM.customers = customers;
  }

  protected static Map<String, List<String>> getTransactions() {
    return transactions;
  }

  protected static void setTransactions(Map<String, List<String>> transactions) {
    ATM.transactions = transactions;
  }

  
  public ATM(double money, double fee){
    this(money, fee, true, true);
  }
  

  protected ATM(double money, double fee, boolean loadHistoricalRecords, boolean startConsole){
    scanner=new Scanner(System.in);
    availableAmountInMachine=money;
    transactionFee=fee;
      ATM.customers=new HashMap<>();
      ATM.accNumberToAccount=new HashMap<>();
      ATM.transactions=new HashMap<>();
      this.init();
  
    }
    
 

  private void init (){
    System.out.print("NEW USER | CURRENT USER (press 9: forgot password)");
    try {
      String item=scanner.nextLine();
      if(item.equals("NEW USER")){
        UserData user=this.register();
        this.run(user);
      }else if(item.equals("CURRENT USER")){
        this.login();
      }else if(item.equals("9")){
        this.promptPasswordReset();
      }else if(item.equals("*")){
        this.exit();
      }
      else{
        System.out.println("Please try again, and enter * to exit");
        this.init();
      }
    } catch (NoSuchElementException ne) {
      System.out.println("no line was found");
      ne.printStackTrace();
    } catch (IllegalStateException ie){
      System.out.println("this scanner is closed");
      ie.printStackTrace();
    }
  }
  

  UserData register() {
    UserData user = new UserData();

    System.out.print("Enter your bank account number and Press <Enter>:");

    String account = scanner.nextLine().trim();
    if (customers.containsKey(account)) {
      System.out.print("\nThis account seems already registerred.");
      System.out.print("\nPress 1 to continue to login, and 0 to try register again:");
      String item = scanner.nextLine();
      if (item.equals("1"))
        this.login();
      else
        this.register();
    } else {
      user.setBankAccountNumber(account);

      System.out.print("\nChoose a password and press <Enter>:");
      user.setPassword(scanner.nextLine());

    //  user=this.getCustomers().get(user.getBankAccountNumber());

      System.out.print("\n Enter your  phone number");
      String phone = "";
      while (phone != null && !phone.equals("0")) {
        phone = scanner.nextLine().trim();
        if (accNumberToAccount.containsKey(phone))
          System.out.println("Verify your phone number or try another one because it has been used.");
        else
          break;
      }
      user.setPhoneNumber(phone);

      this.register(user);

      System.out.print("\n Enter your name:");
      user.setName(scanner.nextLine().trim());

      System.out.print("\n Enter your age");
     user.setBirthYear(Integer.valueOf(scanner.nextLine()));

      System.out.println("\n Enter the address");
      String address = scanner.nextLine();
      if (address != null && !address.isEmpty()) {
        user.setAddress(address);
      } else {
        System.out.println("\nNo address information is recorded.");
      }
    }

    return user;
  }
  

  public void register(UserData user) {
    if (customers.containsKey(user.getBankAccountNumber())){
    //    || accNumberToAccount.containsKey(user.getPhoneNumber())) {
      System.out.println("\nFailed. This bank account or phone number has been used. Please verify and try again!");
      this.register();
    } else {
    	//accNumberToAccount.put(user.getPhoneNumber(), user.getBankAccountNumber());
      customers.put(user.getBankAccountNumber(), user);
      System.out.printf("\nRegistered. Your login ID is %s, and password is %s \n", user.getBankAccountNumber(), user.getPassword());
    }
  }
  

  public void register(String name, int year, String phone, String bankAccount, String password){
    UserData user=new UserData(name, year, phone, bankAccount, password);

    this.register(user);
  }
  
  private void login(){
    this.login("","");
  }
  

	/*
	 * boolean promptPasswordReset() throws NumberFormatException { System.out.
	 * print("\nTo reset your password, please enter Name, Age and phone number:");
	 * String name=scanner.nextLine().trim(); int
	 * age=Integer.valueOf(scanner.nextLine().trim()); String
	 * phone=scanner.nextLine().trim(); if(this.validate(name, age, phone)){
	 * System.out.
	 * print("\nYou are a registered user. Please enter your new password:"); String
	 * password=scanner.nextLine(); return this.resetPassword(name, age, phone,
	 * password); }else{ System.out.
	 * print("\nYour phone number does not exist in our system. Try again!");
	 * this.init(); return false; } }
	 */
  boolean promptPasswordReset() throws NumberFormatException {
	    System.out.print("\nTo reset your password, please enter your name, age, and phone number:");
	    String name=scanner.nextLine().trim();
	    int yearOfBirth=Integer.valueOf(scanner.nextLine().trim());
	    String phone=scanner.nextLine().trim();
	    if(this.validate(name, yearOfBirth, phone)){
	      System.out.print("\nYou are a registered user. Please enter your new password:");
	      String password=scanner.nextLine();
	      return this.resetPassword(name, yearOfBirth, phone, password);
	    }else{
	      System.out.print("\nYour phone number does not exist in our system. Try again!");
	      this.init();
	      return false;
	    }
	  }

  boolean resetPassword(String name,int year, String phone, String newPassword){
    if(this.validate(name,year, phone)){
      return this.changePassword(customers.get(accNumberToAccount.get(phone)), newPassword);
    }else{
      return false;
    }
  }
  
  private void run(UserData user) {
    
    try {
      while (true) {
        this.displayMenu();
        String item = scanner.nextLine();
        if (item.equals("1"))
          this.getBalance(user);
        else if (item.equals("2")) {
          System.out.println("\nHow much would you like to withdrawal?");
          double withdrawal=Double.valueOf(scanner.nextLine());
          this.withDrawal(user, withdrawal);
        } else if (item.equals("3")) {
          System.out.println("\nHow much would you like to deposit?");
          double deposit=Double.valueOf(scanner.nextLine());
          this.deposit(user, deposit);
        } else if (item.equals("4"))
          this.recentTransactions(user);
        else if (item.equals("5")) {
          System.out.print("\nSet your new password:");
          this.changePassword(user, scanner.nextLine());
        } else if (item.equals("0")) {
          this.exit();
        } else {
          System.out.println(item + " is not valid, so please try again.");
        }
      }
    } catch (NumberFormatException nfe){
      System.out.println("The number you enterred is invalid. Please try again.");
      run(user);
    }
    catch (Exception e) {
      System.out.println("Unhandled EXCEPTION.");
      e.printStackTrace();
    } finally {
      scanner.close();
    }
  }
  
 
  private void exit(){
    System.out.println("Thank you for using ATM");
    scanner.close();
    System.exit(0);
    return;
  }
  

  private void login(String bankAccountNumber){
    
     if(bankAccountNumber!=null && !bankAccountNumber.isEmpty()){
      System.out.println("Your password is wrong. Retry!");
      login(bankAccountNumber);
    }else{
      System.out.print("\nEnter your bank account Number and press <Enter> and password<Enter> to login: ");
      String bankacc=scanner.nextLine().trim(), password=scanner.nextLine();
      
      int type=this.authenticate(bankacc, password);
      if(type==1) {
        String account=accNumberToAccount.get(bankAccountNumber);
        this.run(this.getCustomers().get(account));
      }
      else if(type==0){
        this.login(bankAccountNumber);
      }else{
        System.out.println("Your account doesn't even exist.");
        this.login("");
      }
    }
  }
  

  protected boolean login(String acc, String password){
    if(this.authenticate(acc, password)==1) return true;
    else return false;
  }
  

  private int authenticate(String acc, String password){
    UserData user=customers.get(acc);
    if(user==null) return -1;
    else if(user.getPassword().equals(password)) return 1;
    else return 0;
  }
  

  private boolean validate(String name, int age, String phone) {
    UserData user = customers.get(accNumberToAccount.get(phone));
   if (user != null && user.getName().equals(name) && user.getBirthYear() == age
 //   if (user != null && user.getName().equals(name) 
        && user.getPhoneNumber().equals(phone))
      return true;
    else
      return false;
  }
  

  double getBalance(UserData user){
    double balance=user.getAvailableBalance();
    System.out.println("Your current balance is: "+ balance);
    return balance;
  }
  
  
  public boolean withDrawal(UserData user, double money){
    if(user.getAvailableBalance()<money) {
      System.out.println("Not enough money.");
      return false;
    }
    else{
      double balance=user.getAvailableBalance()-money-this.transactionFee;
      user.setAvailableBalance(balance);
      this.availableAmountInMachine-=money;
      this.logTransaction(user, Transaction.WithDrawal, money);
      return true;
    }
  }
  
 
  private void logTransaction(UserData user, Transaction trans, double money){
    String log=trans+" - "+String.format("%8.2f", money)+" (fee:"+this.transactionFee+")";
    if(!transactions.containsKey(user.getBankAccountNumber())){
      transactions.put(user.getBankAccountNumber(), new ArrayList<>());
    }
    transactions.get(user.getBankAccountNumber()).add(log);
    System.out.println(log);
  }
  
 
  protected void deposit(UserData user, double money){
    double balance=user.getAvailableBalance()+money-this.transactionFee;
    user.setAvailableBalance(balance);
    this.availableAmountInMachine+=money;
    this.logTransaction(user, Transaction.Deposit, money);
  }
  

  void recentTransactions(UserData user){
    List<String> list=transactions.get(user.getBankAccountNumber());
    if(list!=null) {
      System.out.println("\nThe recent "+ATM.RECENT_TRANS_NUM+" transactions are:");
      int end=list.size()-1;
      for(int i=end;i>=Math.max(end-10, 0);i--){
        System.out.println(list.get(i));
      }
      System.out.println("**End of rencent transactions**\n");
    }else{
      System.out.println("No transactoins.");
    }
  }
  
 
  private boolean changePassword(UserData user, String newPassword){
    if(customers.containsKey(user.getBankAccountNumber())){
      user.setPassword(newPassword);
      System.out.println("Your password has been changed to "+newPassword);
      return true;
    }else {
      System.out.println("No such user. Please check your login status.");
      return false;
    }
  }
  

  private void displayMenu() {
    StringBuilder menu=new StringBuilder("\nMENU\n");
    menu.append("Press a number to start a transaction:\n");
    menu.append("1.Check Balance\n");
    menu.append("2.WithDrawal\n");
    menu.append("3.Deposit\n");
    menu.append("4.Recent Transactions\n");
    menu.append("5.Change Password\n");
    menu.append("0.Exit");
    System.out.println(menu);
  }

}
