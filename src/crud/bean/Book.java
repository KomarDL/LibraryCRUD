package crud.bean;

import java.util.Objects;

public class Book implements Comparable<Book>{
    @FieldInfo(name = "Author name", isRepresented = true)
    private String author;
    @FieldInfo(name = "Book title", isRepresented = true)
    private String title;
    @FieldInfo(name = "Page amount", isRepresented = true)
    private int pageAmount;
    @FieldInfo(name = "Type of cover(soft, hard, unknown", isRepresented = true)
    private BookCover cover;

    public enum BookCover {
        SOFT_COVER,
        HARD_COVER,
        UNKNOWN_COVER;
    }

    public Book() {
    }

    public Book(String author, String title, int pageAmount, BookCover cover) {
        this.author = author;
        this.title = title;
        this.pageAmount = pageAmount;
        this.cover = cover;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (pageAmount != book.pageAmount) return false;
        if (!Objects.equals(author, book.author)) return false;
        if (!Objects.equals(title, book.title)) return false;
        return cover == book.cover;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + pageAmount;
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return author + " " + title + " " + pageAmount + " " + cover;
    }
}
