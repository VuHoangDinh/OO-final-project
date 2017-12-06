package ATM;

public class Account {
	
	private double balance;
	/**
	 * Setup Account balance
	 */
	public Account() {
		this.balance = 500;
	}
	/**	
	 *  Get balance
	 */
	public double getBalance() {
		return this.balance;
	}
	/**	
	 *  Deposit money
	 */
	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}
		
	/**	
	 *  Withdraw money
	 */
	public void withdraw(double amount) {
		this.balance = this.balance - amount;

	}
	

}
