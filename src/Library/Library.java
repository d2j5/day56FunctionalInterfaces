package Library;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Register a new user with the library
    public void registerUser(User user) {
        users.add(user);
    }
    public void addBook(Book book) {
        books.add(book);
    }

    // Loan out a book to a user
    public void loanBook(Book book, User user) {
        if (!book.isOnLoan()) {
            book.setOnLoan(true);
            user.addBookOnLoan(book);
        } else {
            System.out.println("Sorry, the book is already on loan.");
        }
    }

    // Return a book from a user
    public void returnBook(Book book, User user) {
        if (user.getBooksOnLoan().contains(book)) {
            book.setOnLoan(false);
            user.removeBookOnLoan(book);
        } else {
            System.out.println("The book is not on loan to this user.");
        }
    }
    //Find book by publication year
    public List<Book> findBooksByPublicationYear(int year) {
        Predicate<Book> filterByPublicationYear = book -> book.getPublicationYear() == year;
        return filterBooks(filterByPublicationYear);
    }

    // Calculate late fees for a user's overdue books
    public double calculateLateFees(User user) {
        double lateFeePerDay = 2.0; // Assuming a fixed late fee per day
        double totalLateFees = 0.0;
        LocalDate currentDate = LocalDate.now();

        for (Book book : user.getBooksOnLoan()) {
            LocalDate dueDate = book.getLoanDueDate();
            if (dueDate != null && currentDate.isAfter(dueDate)) {
                long daysLate = currentDate.toEpochDay() - dueDate.toEpochDay();
                totalLateFees += lateFeePerDay * daysLate;
            }
        }

        return totalLateFees;
    }

    // Find all books that match a given condition
    private List<Book> findBooks(Predicate<Book> condition) {
        return books.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
    //Book with the most pages
    public Book findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null);
    }

    // Find all books by a specific author using Predicate
    public List<Book> findBooksByAuthor(String author) {
        Predicate<Book> condition = book -> book.getAuthor().equals(author);
        return findBooks(condition);
    }

    // Find all books with more than n pages using Predicate
    public List<Book> findBooksByPageCount(int pageCount) {
        Predicate<Book> condition = book -> book.getPages() > pageCount;
        return findBooks(condition);
    }

    // Find all books in a specific category using Predicate
    public List<Book> findBooksByCategory(String category) {
        Predicate<Book> condition = book -> book.getCategory().equals(category);
        return findBooks(condition);
    }
    //All book titles sorted
    public void printAllBookTitlesSorted() {
        books.stream()
                .map(Book::getTitle)
                .sorted()
                .forEach(System.out::println);
    }
    // Find all books that match a given condition
    private List<Book> filterBooks(Predicate<Book> condition) {
        return books.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
}
