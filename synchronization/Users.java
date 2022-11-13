package synchronization;

import java.util.Scanner;

public class Users {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.next();
        int amount = 0;
        System.out.print("Enter amount to deposit: ");
        amount = scanner.nextInt();
        scanner.close();
    
        Accounts accounts = new Accounts();
        BankAccount account = accounts.getAccount(accountNumber);
        if (account == null) {
            System.out.println("No user with account number " + accountNumber);
            return;
        }

        account.deposit(amount);

        System.out.println("Before withdraw: " + account);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Atm.withdraw(account, 100);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Atm.withdraw(account, 200);
            }
        });

        t1.setName("John Doe -> 1");
        t2.setName("John Doe -> 2");

        t1.start();
        t2.start();
    }
}