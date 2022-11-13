package synchronization;

import java.util.HashMap;

public class Accounts {
    private HashMap<String, BankAccount> accounts = new HashMap<>();

    public Accounts() {
        accounts.put("1234567890", new BankAccount(250, "1234567890", "John Doe"));
        accounts.put("1234567891", new BankAccount(250, "1234567891", "Jane Doe"));
        accounts.put("1234567892", new BankAccount(200, "1234567892", "John Smith"));
        accounts.put("1234567893", new BankAccount(200, "1234567893", "Jane Smith"));
        accounts.put("1234567894", new BankAccount(200, "1234567894", "Janet Doe"));
    }

    public void addAccount(BankAccount account) {
        this.accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount getAccount(String accountNumber) {
        return this.accounts.get(accountNumber);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, int amount) {
        BankAccount fromAccount = this.getAccount(fromAccountNumber);
        BankAccount toAccount = this.getAccount(toAccountNumber);

        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        } else if (fromAccount.getBalance() + fromAccount.getOverdraft() >= amount) {
            int overdraftAmount = amount - fromAccount.getBalance();
            fromAccount.withdraw(fromAccount.getBalance());
            fromAccount.withdraw(overdraftAmount);
            toAccount.deposit(amount);
        } else {
            System.out.println("Not enough money in " + Thread.currentThread().getName());
        }
    }
}
