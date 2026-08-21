package EXAMPLES.level5.BMS;

/* This is a Banking Management System with two custom exceptions.
1. Insufficient Balance and 2. Invalid Credential
 */

import java.util.Scanner;

public class Main {
    static boolean verifyCredentials(Customer customer, Scanner sc){
        System.out.print("Enter ID: ");
        int Id = sc.nextInt();

        System.out.print("Enter PIN: ");
        int Pin = sc.nextInt();

        try {
            customer.verifyUser(Id,Pin);
            return true;
        } catch (InvalidCredentialException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
//    System.out.println("Enter Id / Pin");
//    int enteredId = sc.nextInt();
//    int enteredPin = sc.nextInt();
    Customer customer = new Customer("Saroj Vineet", 1234,789,"52739408723", "Gandhinagar - Gujarat");

    SavingsAccount savingsAccount = new SavingsAccount("BOB", "Savings", 234791865, customer);

    savingsAccount.setBalance(12000);

    verifyCredentials(customer,sc);
    while (true) {
        System.out.println("\n The Details are :");
        System.out.println("1. Customer Details");
        System.out.println("2. Bank Details");
        System.out.println("3. Check Balance");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Exit");

        System.out.println("Enter Choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                customer.displayInfo();
                break;
            case 2:
                savingsAccount.displayInfo();
                break;
            case 3:
                if(verifyCredentials(customer,sc)) {
                    System.out.println(savingsAccount.getBalance());
                }
                break;
            case 4:
                if(verifyCredentials(customer,sc)){
                   savingsAccount.deposit(1500);
                }

                break;
            case 5:
                    if(verifyCredentials(customer,sc)){
                        try {
                            savingsAccount.withdraw(11000);
                            System.out.println(savingsAccount.getBalance());
                        }
                        catch (InsufficientBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid Choice");
        }
    }
}
}