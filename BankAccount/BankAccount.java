/**	Zakery Clarke
*	CS251-002
*   9/26/2017
*	Lab 4 Exceptions
*/
public class BankAccount{
   private double balance=0;//bank account balance
   private int id;//bank account id
	/**
	 * Constructor for a bank account
	 * @param id the account id for a bank account
	 */
   public BankAccount(int id){
	    this.id=id;//sets bank account id
	    this.balance=0;//set balance to initially be 0
	}
	/**
	 * This method returns the account ID number
	 * @return int for the account id
	 */
	public int getAccountID(){
	    return id;
	}
	/**
	 * This mmethod returns the  current account balance
	 * @return a double for th current account balance
	 */
	public double getCurrentBalance(){
	    return this.balance;
	}
	/**
	 * Method for withdrawing money from an account. 
	 * Throws an exception if too much money is withdrawn
	 * @param amount the amount of money to withdraw
	 * @throws InsufficientFundsException the exception called when there isnt enough money
	 */
	public void withdraw(double amount)throws InsufficientFundsException{
	    if(this.balance-amount<0) {
	        double shortfall=Math.abs(amount-this.balance);
	        throw new InsufficientFundsException(shortfall);
	    }else { 
	        this.balance=this.balance-amount;    
	    }
	}
	/**
	 * Method for depositing money into an account
	 * @param amount the amount to be deposited
	 */
	public void deposit(double amount){
        this.balance=this.balance+amount;
    }
	
}