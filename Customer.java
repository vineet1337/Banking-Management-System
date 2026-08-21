package EXAMPLES.level5.BMS;

//Bank Management System
//Create InsufficientBalanceException and use it when a withdrawal violates the balance rule.

public class Customer {
    String customerName;
    int customerId;
    String phoneNo;
    String address;
    int pinNo;

    public Customer(String customerName, int customerId,int pinNo, String phoneNo, String address) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.pinNo = pinNo;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    void displayInfo(){
        System.out.println("----Customer Details----");
        System.out.println("Customer Name: " +customerName);
        System.out.println("Customer Id: " +customerId);
        System.out.println("Phone No: " +phoneNo);
        System.out.println("Address: " +address);
    }
    void verifyUser(int enteredId, int enteredPin) throws InvalidCredentialException{
        if(customerId != enteredId || pinNo != enteredPin){
            throw new InvalidCredentialException("Invalid ID / PIN");
        }
    }
}