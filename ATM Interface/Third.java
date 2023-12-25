import java.util.Scanner;

class BankAccount
{
    private double balance;

    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }
    public double getBalance()
    {
        return balance;
    }

    public void deposite(double amount)
    {
        balance += amount;
    }

    public boolean withdrwa(double amount)
    {
        if (amount <= balance)
        {
            balance -= amount;
            return true; // Withdrwal successful
        }
        else 
        {
            return false; // Insufficient balance
        }
    }
}    
// ATM class representing the ATM machine
class ATM
{
  private BankAccount userAccount;

    public ATM(BankAccount account)
    {
        this.userAccount = account;
    }

    public void displayMenu()
    {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("0. Exit");
    }

    public void processOption(int option)
    {
        Scanner Scanner = new Scanner(System.in);

        switch (option) 
        {
            case 1: 
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = Scanner.nextDouble();
                
                if(userAccount.withdrwa(withdrawAmount))
                {
                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                }
                else 
                {
                    System.out.println("Insufficient balance. withdrawal failed.");
                }
                break;
        
            case 2:
                System.out.print("Enter deposite amount: ");
                double depositAmount = Scanner.nextDouble();
                userAccount.deposite(depositAmount);
                System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
                break;

            case 3:
                System.out.println("Current balance: " + userAccount.getBalance());
                break;

            case 0:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;

              default:
                 System.out.println("Invalid option. Please choose a vaild option.");      
            }
        }
    }
class Main 
{    
    public static void main(String[]args)
    {
        // create a bank amount with an initial balance of 1000
        BankAccount userAccount = new BankAccount(1000);

        // create an ATM instance
        ATM atmMachine = new ATM(userAccount);

        while (true) 
        {
            // Display menu and process user's choice
            atmMachine.displayMenu();

            Scanner Scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int userChoice = Scanner.nextInt();
            
            atmMachine.processOption(userChoice);
        }
    }
}    