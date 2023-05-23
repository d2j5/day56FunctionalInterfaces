package Library;
import java.util.ArrayList;
import java.util.List;
public class User {
    private String name;
    private int libraryCardNumber;
    private List<Book> booksOnLoan;

    public User(String name, int libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.booksOnLoan = new ArrayList<>();
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(int libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public void setBooksOnLoan(List<Book> booksOnLoan) {
        this.booksOnLoan = booksOnLoan;
    }

    public List<Book> getBooksOnLoan() {
        return booksOnLoan;
    }

    // Add a book to the user's list of books on loan
    public void addBookOnLoan(Book book) {
        booksOnLoan.add(book);
    }

    // Remove a book from the user's list of books on loan
    public void removeBookOnLoan(Book book) {
        booksOnLoan.remove(book);
    }

}
