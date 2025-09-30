import java.util.ArrayList;
import java.util.List;


public class AccountHolder {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    public AccountHolder(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account crated " + accountNumber + " " + accountHolderName + " with balance: ");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionHistory.add(String.valueOf(amount));
        System.out.println("Deposited successfully: " + amount + "Balance amount: " + balance);

    }

    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        if (amount > balance)
            System.out.println("Insufficient Balance.");
        else {
            balance -= amount;
            transactionHistory.add("Withdraw " + amount + "Balance: " + balance);
            System.out.println("Withdrawn: " + amount + "Balance amount: " + balance);
        }

    }

        @Override
        public String toString(){
            return "AccountHolder [accountNumber=" + accountNumber + "accountHolderName=" + accountHolderName + "balance=" + balance + "transactionsHistory=" + transactionHistory + "]";
        }



}


