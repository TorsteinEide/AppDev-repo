package no.ntnu.Connectionjdbc;

/**
 * This class represents a book
 */
public class Book {
    //fields
    int BookID;
    String title;
    String publisher;
    String date;
    int isbn;
    int branchID;

    /**
     * Contstructor initializes an object of class Book
     * @param bookID
     * @param title
     * @param publisher
     * @param date
     * @param isbn
     * @param branchID
     */
    public Book(int bookID, String title, String publisher, String date, int isbn, int branchID)
    {
        this.BookID=bookID;
        this.title=title;
        this.publisher=publisher;
        this.date=date;
        this.isbn=isbn;
        this.branchID=branchID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }
}
