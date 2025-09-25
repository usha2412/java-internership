import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<User> users = new ArrayList<> ();
    private List<Book> books = new ArrayList<>();

    public void addBook(Book b){
        books.add(b);
    }

    public void addUser(User u){
        users.add(u);
    }

    public Book findBook(int bookId){
//        for(Book b: books)
//            if(b.getId() == bookId)
//                return b;
        return books.stream().filter(b -> b.getId() == bookId).findFirst().orElse(null);



    }
    public User findUser(int userId){
//        for(User u:users)
//            if(u.getId() == userId)
//                return u;
        return users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
    }

    public boolean issueBook (int userId, int bookId){
        User user =findUser(userId);
        Book book = findBook(bookId);

        if(user == null || book == null){
            System.out.println("User or Book is not found.");
            return false;
        }

        if(book.isIssued()){
            System.out.println("Book is already issued.");
            return false;
        }
        book.setIssued(true);
            user.issueBooks(book);
            System.out.println("Book is successfully issued to: " + user.getName());
            return true;


    }
//    ********Return book********
    public boolean returnBook(int userId, int bookId){
        User user =findUser(userId);
        Book book =findBook(bookId);
        if(user ==null|| book==null)
            System.out.println("User or Book is not find.");
        if(!book.isIssued()) {
            System.out.println("Book is not issued.");
            return false;
        }

        if (user.getBooks().contains(book)) {
            user.returnBooks(book);
            book.setIssued(false);
            System.out.println("Book returned successfully by " + user.getName());
            return true;
        } else {
            System.out.println("This user did not issue this book.");
            return false;
        }


    }

    public void listBooks(){
        System.out.println("\nList of Books.");
        for(Book b:books)
            System.out.println(b);
    }

    public void listUser(){
        System.out.println("\nList of users.");
        for(User u:users)
            System.out.println(u);
    }

}
