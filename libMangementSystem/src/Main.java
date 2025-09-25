import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        library.addBook(new Book(0123, "java", "Joshu Blouch", "Dhenpat Rai", false));
        library.addBook(new Book(0145, "python", "James S.", "Ram Kishan", false));
        library.addBook(new Book(125, "c++", "Bjarne Stroustrup", "James ", false));
        library.addUser(new User(23, "Seema"));
        library.addUser(new User(02, "Ram"));
        library.addUser(new User(01, "Raju"));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. LIst of Books.");
            System.out.println("2. List of Users.");
            System.out.println("3. Issue Books.");
            System.out.println("4. Return Books");
            System.out.println("5. Add Book");
            System.out.println("6. Add User");
            System.out.println("7. Exit...");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> library.listBooks();

                case 2 -> library.listUser();

                case 3 -> {
                    System.out.print("Enter user id: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter book id: ");
                    int bookId = scanner.nextInt();
                    library.issueBook(userId, bookId);
                }

                case 4 -> {
                    System.out.print("Enter user id: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter book id: ");
                    int bookId = scanner.nextInt();
                    library.returnBook(userId, bookId);
                }

                case 5 -> {
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    boolean isIssued = scanner.nextBoolean();
                    library.addBook(new Book(id, name, publisher, author,isIssued));
                    System.out.println("Book added.");
                }

                case 6 -> {
                    System.out.print("Enter User Id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Name: ");
                    String name = scanner.nextLine();
                    library.addUser(new User(id, name));
                    System.out.println("User added.");
                }

                case 7->{
                    if (false)
                        System.out.println("Thank you. Visit again. Exit...");

                }

                    default -> System.out.println("Invalid choice. Please try again.");


            }


        }
    }
}