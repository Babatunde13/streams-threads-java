package synchronization;

public class Atm {
    static void withdraw(BankAccount account, int amount) {
        Atm._withdraw(account, amount);
    }

    private static synchronized void _withdraw(BankAccount account, int amount) {
        // synchronized (account) {
            System.out.println("Welcome " + account.getName() + "!");
            System.out.println("Your balance before withdrawal is " + account.getBalance() + " and your overdraft is " + account.getOverdraft());

            int balance = account.getBalance();
            if (balance + account.getOverdraft() >= amount) {
                account.withdraw(amount);
                System.out.println("Withdrawn $" + amount + " from " + Thread.currentThread().getName());
            } else {
                System.out.println("Not enough money in " + Thread.currentThread().getName());
            }

            System.out.println("Current Balance: " + account.getBalance());
            System.out.println("Current Overdraft: " + account.getOverdraft());
            System.out.println();
        // }
    }
}
