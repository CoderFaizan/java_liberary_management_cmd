public class Book {
    private static int nextId = 1;
    public int id;
    public String title;
    public String author;
    public Boolean available = true;
 
    public Book(String bookTitle, String bookAuthor) {
        this.id = nextId++;
        this.title = bookTitle;
        this.author = bookAuthor;
    }

}
