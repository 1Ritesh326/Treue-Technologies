package BookStore;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();
    private static User loggedInUser;

    // main method
    public static void main(String[] args) {
        showMainMenu();
    }

    // method borrowBook
    private static void borrowBooks() {
        System.out.print("Enter the book ID you want to borrow:");
        int id = scanner.nextInt();
        scanner.nextLine();
        library.borrowBook(id);
    }

    // method returnBook
    private static void returnBook() {
        System.out.print("Enter the book ID you want to return: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        library.returnBook(id);
    }

    // method rateAndReviewBook
    private static void rateAndReviewBook() {
        System.out.print("Enter the book ID you want to rate and review: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the rating (1 to 5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter your review: ");
        String review = scanner.nextLine();
        library.rateAndReviewBook(id, rating, review);
    }

    // method showMainMenu
    private static void showMainMenu() {
        System.out.println("Welcome to the BookStore!!");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            case 3:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showMainMenu();
        }
    }

    // method register
    private static void register() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        loggedInUser = new User(username, password);
        System.out.println("Registration successful!");
        showBookSection();
    }

    // method login
    private static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the username and password match with a registered user and not Null
        if (loggedInUser != null && loggedInUser.username.equals(username) && loggedInUser.password.equals(password)) {
            System.out.println("Login successful!");
            showBookSection();
        } else {
            System.out.println("Invalid username or password. Please try again...");
            showMainMenu();
        }
    }

    // method showBookSection
    private static void showBookSection() {
        System.out.println("\nBook Section");
        System.out.println("1. Add Books");
        System.out.println("2. Show All Books");
        System.out.println("3. Show Available Books");
        System.out.println("4. Borrow Books");
        System.out.println("5. Return Book");
        System.out.println("6. Rate and Review Book");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addBooks();
                break;
            case 2:
                showAllBooks();
                break;
            case 3:
                showAvailableBooks();
                break;
            case 4:
                borrowBooks();
                break;
            case 5:
                returnBook();
                break;
            case 6:
                rateAndReviewBook();
                break;
            case 7:
                System.out.println("Thank you for using the Library!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        showBookSection(); // Show the book section menu again
    }

    // method addBooks
    private static void addBooks() {
        System.out.print("Enter the book ID you want to add: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();
        library.addBook(id, title, author);
    }

    // method showAllBooks
    private static void showAllBooks() {
        System.out.println("\nAll Books:");
        List<Book> allBooks = library.getAllBooks();
        displayBooks(allBooks);
    }

    // method showAvailableBooks
    private static void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        List<Book> availableBooks = library.getAvailableBooks();
        displayBooks(availableBooks);
    }

    // method displayBooks
    private static void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.print("Id: " + book.id);
                System.out.print("\tTitle: " + book.title);
                System.out.print("\tAuthor: " + book.author);
                System.out.print("\tAvailable: " + (book.isAvailable ? "Yes" : "No"));
                System.out.println("\tAverage Rating: " + book.getAverageRating());
                System.out.println("Review: " + book.review);
                System.out.println();
            }
        }
    }
}