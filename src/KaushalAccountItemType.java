//ItemType class
public class KaushalAccountItemType
{
	String name;
	int accountNumber;
	double balance;
	public KaushalAccountItemType(String name, int accountNumber, double balance) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	// if constructor without balance is use balance will default to zero
	public KaushalAccountItemType(String name, int accountNumber) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
		balance = 0;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	//no setter included for balance
	public double getBalance() {
		return balance;
	}

	// to deposit money
	public void depositMoney (double deposit){
		balance += deposit;
	}
	// to withdraw money
	public void withdrawMoney (double withdrawal){
		balance -= withdrawal;
	}
	//@Override
	public String toString() {
		return "\n Account [Customer Name =" + name + ", Account Number =" + accountNumber
				+ ", balance=" + balance + "] " ;
	}
	public int compareTo(KaushalAccountItemType info) {
		// TODO Auto-generated method stub
		if(this.accountNumber < info.accountNumber)
			return -1;
		else 
			if(this.accountNumber == info.accountNumber)
				return 0;
			else 
				return 1;
	}
 
}
