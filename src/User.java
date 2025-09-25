import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Book> issuedBooks =new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return issuedBooks;
    }

    public void returnBooks(Book book){
        issuedBooks.remove(book);

    }

    public void issueBooks(Book book){
        issuedBooks.add(book);

    }

    public String toString(){
        return "Id: " +id + "\nName:  "+name + "\nNo. of Books issued: " +issuedBooks.size()+"\n" +issuedBooks;
    }
}
