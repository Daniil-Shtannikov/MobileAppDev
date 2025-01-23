class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public void getBalance() {
        System.out.println("BankAccount: " + accountNumber + "Balance: " + balance );
    }
}
public class Bank{
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("1214crxq34x", 3000);
        bankAccount1.getBalance();
        bankAccount1.deposit(100);
        bankAccount1.getBalance();
    }
}