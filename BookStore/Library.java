package BookStore;

import java.util.ArrayList;
import java.util.List;


class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
        // Pre-stored book data
        books.add(new Book(1, "C++", "Bill Gates"));
        books.add(new Book(2, "Java", "Satya Nandela"));
        books.add(new Book(3, "Python", "Sunder Pechai"));
        books.add(new Book(3, "MySql", "Elon Musk"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
    }


    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.id == id) {
                return book;
            }
        }
        return null; // Book not found
    }

    // method borrowBook
    public void borrowBook(int id) {
        Book book = getBookById(id);
        if (book == null) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }

        if (!book.isAvailable) {
            System.out.println("Book with ID " + id + " is not available for borrowing.");
            return;
        }

        // Book is available, mark it as borrowed
        book.isAvailable = false;
        System.out.println("Book with ID " + id + " has been borrowed.");
    }

    // method returnBook
    public void returnBook(int id) {
        Book book = getBookById(id);
        if (book == null) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }

        if (book.isAvailable) {
            System.out.println("Book with ID " + id + " is already available.");
            return;
        }

        // Book is returned, mark it as available
        book.isAvailable = true;
        System.out.println("Book with ID " + id + " has been returned.");
    }

    // method rateAndReviewBook
    public void rateAndReviewBook(int id, int rating, String review) {
        Book book = getBookById(id);
        if (book == null) {
            System.out.println("Book with ID " + id + " not found.");
            return;
        }

        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Rating should be on a scale of 1 to 5.");
            return;
        }

        // Update the book's rating and review
        book.totalRatingPoints += rating;
        book.numRatings++;
        book.review = review;

        System.out.println("Book with ID " + id + " has been rated and reviewed.");
    }

}
