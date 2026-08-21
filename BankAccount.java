package EXAMPLES.level5.BMS;

public class BankAccount {
    String bankName;
    String accountType;
    int accountNo;
    private double balance;
    Customer customer;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(String bankName, String accountType, int accountNo,Customer customer) {
        this.bankName = bankName;
        this.accountType = accountType;
        this.accountNo = accountNo;
        this.customer = customer;
    }

    void displayInfo(){
        System.out.println("Bank Details:");
        System.out.println("Bank Name: " +bankName);
        System.out.println("Account Type: " +accountType);
        System.out.println("Account Number :" +accountNo);
    }

    void verifyUser(int Id, int Pin) throws InvalidCredentialException{
        customer.verifyUser(Id, Pin);
    }
}

class SavingsAccount extends BankAccount{

    public SavingsAccount(String bankName, String accountType, int accountNo,Customer customer) {
        super(bankName, accountType, accountNo,customer);
    }

    void deposit(double amount) {
//        verifyUser(Id,Pin);
        if(amount > 0){
            System.out.println("Processing...");
            setBalance(getBalance() + amount);
        }
        else{
            System.out.println("Invalid ID/PIN or amount.");
        }
    }
    void withdraw(double amount) throws InsufficientBalanceException{

//        verifyUser(Id, Pin);
        if ((getBalance() - amount) > 1000) {
            throw new InsufficientBalanceException("Insufficient Balance! Withdrawal Denied.");
        } else {
            System.out.println("Withdrawal Approved.");
            setBalance(getBalance() - amount);
        }
    }
    @Override
    void displayInfo(){
        super.displayInfo();
    }
}

