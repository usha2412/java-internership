import java.util.Scanner;


public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*********** Welcome to APNA Bank *********** ");

        System.out.print("\nEnter account number: ");
        String accNum = scanner.nextLine();
        System.out.print("\nEnter Account Holder Name: ");
        String accHodlerName = scanner.nextLine();

        AccountHolder account = new AccountHolder(accNum, accHodlerName);

        boolean running = true;
        while (running) {
            System.out.println("\n===== Bank Menu =====");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> System.out.println(account);
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(amt);
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();
                    account.withdraw(amt);
                }
                case 4 -> {
                    System.out.println("\n--- Transaction History ---");
                    account.getTransactionHistory().forEach(System.out::println);
                }
                case 5 -> {
                    running = false;
                    System.out.println("Thank you for banking with us!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();


    }
}
