package bank;

import bank.exceptions.AmountException;

public class Account {

  private int id;
  private String type;
  private double balance;

  //Creating a constructor for our Account class
  public Account(int id, String type, double balance) {
    setId(id);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

public void deposit(double amount) throws AmountException{
if( amount < 1){
  throw new AmountException(" Amount can't be less that 1.00");
}
else{
double newBalance = balance + amount;
setBalance(newBalance);
DataSource.updateAccoutBalance(id, newBalance);
}
}
public void withdraw(double amount) throws AmountException{
if(amount < 0){
  throw new AmountException("Sorry you can't withdraw a negative amount");
}else if(amount < getBalance()){
  throw new AmountException("You do not have sufficient funds!");
}
else {
  double newBalance = balance - amount;
  setBalance(newBalance);
  DataSource.updateAccoutBalance(id, newBalance);
}
}
}
