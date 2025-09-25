public class Book {
    private int id;
    private String name;
    private String publisher;
    private String author;
    private boolean isIssued;

    public Book(int id, String name, String publisher, String author, boolean isIssued) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }
    public void setIssued(boolean isIssued){
        this.isIssued =isIssued;
    }
    public String toString(){
        return "Book [id: " + id + ", name: " + name + ", publisher: " + publisher + ", author: " + author + ", isIssued: " + isIssued +"]";
    }


}
