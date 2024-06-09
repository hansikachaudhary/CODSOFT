
import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient balance
        }
    }
}

// Class representing the ATM machine
public class ATMInterface {
    private BankAccount account;
    private Scanner scanner;

    public ATMInterface(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display ATM welcome message
    private void displayWelcomeMessage() {
        System.out.println("Welcome to the Unique ATM Experience!");
        System.out.println("======================================");
    }

    // Method to display ATM menu
    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Method to handle withdrawal
    private void withdraw() {
        System.out.print("Enter amount to withdraw: Rs.");
        double withdrawAmount = scanner.nextDouble();
        if (account.withdraw(withdrawAmount)) {
            System.out.println("Withdrawal successful. Please take your cash.");
        } else {
            System.out.println("Insufficient balance. Unable to process withdrawal.");
        }
    }

    // Method to handle deposit
    private void deposit() {
        System.out.print("Enter amount to deposit: Rs.");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
        System.out.println("Deposit successful. Thank you for banking with us!");
    }

    // Method to display balance
    private void checkBalance() {
        System.out.println("Your current balance: Rs." + account.getBalance());
    }

    // Method to display goodbye message
    private void displayGoodbyeMessage() {
        System.out.println("Thank you for using the ATM . Goodbye!");
    }

    // Method to handle user interaction with the ATM
    public void start() {
        displayWelcomeMessage();
        displayMenu();

        int choice;
        do {
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    displayGoodbyeMessage();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        // Create a bank account with initial balance
        BankAccount userAccount = new BankAccount(1500.0);

        // Create a UniqueATM object
        ATMInterface atm = new ATMInterface(userAccount);

        // Start ATM interaction
        atm.start();
    }
}
