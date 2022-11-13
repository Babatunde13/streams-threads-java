package synchronization;

public class BankAccount {
    private String accountNumber;
    private String name;
    private int balance = 0;
    private final int overdraft;

    public BankAccount(int overdraft, String accountNumber, String name) {
        if (overdraft < 0) {
            throw new IllegalArgumentException("Overdraft must be positive");
        }
        if (accountNumber == null) {
            throw new IllegalArgumentException("Account number must be non-null");
        }
        if (accountNumber.length() != 10) {
            throw new IllegalArgumentException("Account number must be 10 characters long");
        }
        if (!accountNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException("Account number must be numeric");
        }
        this.overdraft = overdraft;
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (this.overdraft + this.balance >= amount) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("Not enough money in account");
        }
    }

    public int getBalance() {
        return this.balance;
    }

    public int getOverdraft() {
        return this.overdraft;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Account Number: " + this.accountNumber + ", Name: " + this.name + ", Balance: " + this.balance + ", Overdraft: " + this.overdraft;
    }
}
 