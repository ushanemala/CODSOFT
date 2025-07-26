import java.util.*;

class BankAccount {
    double currentBalance;

    BankAccount(double initialBalance) {
        currentBalance = initialBalance;
    }

    public void showBalance() {
        System.out.println("Current balance: ₹" + currentBalance);
    }

    public void addMoney(double depositAmount) {
        if (depositAmount > 0) {
            currentBalance += depositAmount;
            System.out.println("Successfully deposited amount: ₹" + depositAmount);
        } else {
            System.out.println("Invalid deposit amount!!");
        }
    }

    public void takeMoney(double withdrawAmount) {
        if (withdrawAmount > currentBalance) {
            System.out.println("Insufficient balance!!");
        } else if (withdrawAmount < 0) {
            System.out.println("Invalid withdraw amount!!");
        } else {
            currentBalance -= withdrawAmount;
            System.out.println("Successfully withdrew: ₹" + withdrawAmount);
        }
    }
}

public class ATMProgram {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        BankAccount myAccount = new BankAccount(10000);

        int userChoice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            userChoice = inputScanner.nextInt();

            switch (userChoice) {
                case 1:
                    myAccount.showBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount you want to deposit: ₹");
                    double moneyToDeposit = inputScanner.nextDouble();
                    myAccount.addMoney(moneyToDeposit);
                    break;
                case 3:
                    System.out.print("Enter the amount you want to withdraw: ₹");
                    double moneyToWithdraw = inputScanner.nextDouble();
                    myAccount.takeMoney(moneyToWithdraw);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (userChoice != 4);

        inputScanner.close();
    }
}