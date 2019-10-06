package crud.bean;

public class Book implements Comparable<Book>{
    private Author author;
    private String title;
    private int pageAmount;
    private BookCover cover;

    public enum BookCover {
        SOFT_COVER,
        HARD_COVER,
        UNKNOWN_COVER;
    }

    public Book() {
    }

    public Book(Author author, String title, int pageAmount, BookCover cover) {
        this.author = author;
        this.title = title;
        this.pageAmount = pageAmount;
        this.cover = cover;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }

    public BookCover getCover() {
        return cover;
    }

    public void setCover(BookCover cover) {
        this.cover = cover;
    }

    @Override
    public int compareTo(Book book) {
        return title.compareToIgnoreCase(book.title);
    }
}
