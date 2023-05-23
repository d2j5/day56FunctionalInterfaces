package Library;

import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        User user1 = new User("Kelan", 54321);
        User user2 = new User("John", 12345);
        User user3 = new User("Javier", 24681);
        Book book1 = new Book("Science Stuff with Bill", "Bill Nye", 2000, 1740, "Science");
        Book book2 = new Book("Moby-Dick", "Herman Melville", 1851, 720, "Fiction");
        Book book3 = new Book("The Origin of Species", "Charles Darwin", 1859, 502, "Non-Fiction");
        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180, "Fiction");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        System.out.println("Name: " + user1.getName() + ", Library card number: " + user1.getLibraryCardNumber());
        System.out.println("Name: " + user2.getName() + ", Library card number: " + user2.getLibraryCardNumber());
        System.out.println("Name: " + user3.getName() + ", Library card number: " + user3.getLibraryCardNumber());
        System.out.println();

        System.out.println("Books published in 2000:");
        List<Book> booksPublishedIn2000 = library.findBooksByPublicationYear(2000);
        booksPublishedIn2000.forEach(System.out::println);
        System.out.println();

        System.out.println("Books by F. Scott Fitzgerald:");
        List<Book> booksByAuthor1 = library.findBooksByAuthor("F. Scott Fitzgerald");
        booksByAuthor1.forEach(System.out::println);
        System.out.println();

        System.out.println("Book with the most pages:");
        Book bookWithMostPages = library.findBookWithMostPages();
        System.out.println(bookWithMostPages);
        System.out.println();

        System.out.println("Books with more than 250 pages:");
        List<Book> booksWithMoreThan250Pages = library.findBooksByPageCount(250);
        booksWithMoreThan250Pages.forEach(System.out::println);
        System.out.println();

        System.out.println("Book titles sorted alphabetically:");
        library.printAllBookTitlesSorted();
        System.out.println();

        System.out.println("Books in the 'Science' category:");
        List<Book> booksInEarlyChildhoodCategory = library.findBooksByCategory("Science");
        booksInEarlyChildhoodCategory.forEach(System.out::println);
        System.out.println();

        library.registerUser(user1);
        library.registerUser(user2);

        library.loanBook(book1, user1);
        library.loanBook(book2, user1);
        library.loanBook(book3, user2);

        System.out.println("User1's books on loan:");
        List<Book> user1BooksOnLoan = user1.getBooksOnLoan();
        user1BooksOnLoan.forEach(System.out::println);
        System.out.println();

        System.out.println("User2's books on loan:");
        List<Book> user2BooksOnLoan = user2.getBooksOnLoan();
        user2BooksOnLoan.forEach(System.out::println);
        System.out.println();

        library.returnBook(book1, user1);

        System.out.println("User1's books on loan after returning a book:");
        user1BooksOnLoan = user1.getBooksOnLoan();
        user1BooksOnLoan.forEach(System.out::println);
        System.out.println();

        double lateFee = library.calculateLateFees(user1);
        if (lateFee > 0) {
            System.out.println("User1 late fees: $" + lateFee);
        } else {
            System.out.println("User1: no late fees");
        }
    }
}
