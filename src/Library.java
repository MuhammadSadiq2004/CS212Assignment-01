//Library Class

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {

    Scanner sc = new Scanner(System.in);
    ArrayList<Book> books; // List to store books in the library
    ArrayList<User> users; // List to store users in the library

    // Constructor to initialize the Library object
    public Library() {
        this.books = new ArrayList<>(); // Initializing the list of books
        this.users = new ArrayList<>(); // Initializing the list of users
    }

    // Method to add a new book to the library
    public void addbook() {
        // Input variables for book details
        String title;
        String genre;
        String author;

        // Prompt the user to enter book details and validate them
        System.out.print("Enter book title: ");
        title = sc.nextLine();



        System.out.print("Enter Genre: ");
        genre = sc.nextLine();
        while (!isValidInput(genre)) {
            System.out.println("Invalid input. Please enter a valid genre (only alphabets).");
            System.out.print("Enter Genre: ");
            genre = sc.nextLine();
        }

        System.out.print("Enter Author: ");
        author = sc.nextLine();
        while (!isValidInput(author)) {
            System.out.println("Invalid input. Please enter a valid author (only alphabets).");
            System.out.print("Enter Author: ");
            author = sc.nextLine();
        }

        // Create a new book object and add it to the books list
        Book book = new Book(title, genre, author);
        System.out.println("Book id is " + book.getId());
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Method to validate input (accepts only alphabets)
    private boolean isValidInput(String input) {
        return input.matches("[a-zA-Z ]+");
    }

    // Method to add a new user to the library
    public void adduser() {
        // Input variables for user details
        String name;
        String contactNo;

        // Prompt the user to enter user details and validate them
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        while (!isValidName(name)) {
            System.out.println("Invalid input. Please enter a valid name (only alphabets).");
            System.out.print("Enter Name: ");
            name = sc.nextLine();
        }

        System.out.print("Enter Contact Information: ");
        contactNo = sc.nextLine();
        while (!isValidContactNo(contactNo)) {
            System.out.println("Invalid input. Please enter a valid contact information (11 digits).");
            System.out.print("Enter Contact Information: ");
            contactNo = sc.nextLine();
        }

        // Create a new user object and add it to the users list
        User user = new User(name, contactNo);
        System.out.println("Your user id is " + user.getUserId());
        users.add(user);
        System.out.println("User added successfully!");
    }

    // Method to validate the name input (accepts only alphabets)
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    // Method to validate the contact number input (accepts exactly 11 digits)
    private boolean isValidContactNo(String contactNo) {
        return contactNo.matches("\\d{11}"); // Ensures the contact information consists of exactly 11 digits
    }

    // Method to handle borrowing a book
    public void borrowed_book() {
        boolean validinput = false;
        int user_id = 0;
        while (!validinput) {
            try {
                System.out.println("Enter user id: ");
                user_id = sc.nextInt();
                validinput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Enter an integer");
                sc.nextLine(); // Clear the input buffer
            }
        }
        User user = finduser(user_id);

        if (user == null) {
            System.out.println("User not found");
            return;
        }
        validinput = false;
        int book_id = 0;
        while (!validinput) {
            try {
                System.out.println("Enter book id: ");
                book_id = sc.nextInt();
                validinput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                sc.nextLine(); // Clear the input buffer
            }
        }
        Book book = findbook(book_id);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book already borrowed");
            return;
        }

        book.borrowBook();
        System.out.println("Book borrowed successfully");
        user.getBorrowedBooks().add(book_id);
    }

    // Method to handle returning a book
    public void return_book() {
        System.out.println("Enter user id: ");
        int user_id = 0;
        boolean validinput = false;
        while (!validinput) {
            try {
                user_id = sc.nextInt();
                validinput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input.");
                sc.nextLine(); // Clear the input buffer
            }
        }
        User user = finduser(user_id);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        validinput = false;
        int book_id = 0;
        while (!validinput) {
            try {
                System.out.println("Enter book id: ");
                book_id = sc.nextInt();
                validinput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                sc.nextLine(); // Clear the input buffer
            }
        }
        Book book = findbook(book_id);
        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("Book is already returned");
            return;
        }

        book.returnBook();
        user.getBorrowedBooks().remove(Integer.valueOf(book_id));
        System.out.println("Book returned successfully");
    }

    // Method to find a user by user id
    public User finduser(int user_id) {
        for (User user : users) {
            if (user.getUserId() == user_id) {
                return user;
            }
        }
        return null; // Return null if user not found
    }

    // Method to find a book by book id
    public Book findbook(int book_id) {
        for (Book book : books) {
            if (book.getId() == book_id) {
                return book;
            }
        }
        return null; // Return null if book not found
    }

    // Method to display details of all books in the library
    public void displaybook() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("ID: " + book.getId());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Available: " + book.isAvailable());
            System.out.println();
        }
    }

    // Method to search for a book by its title
    public void searchBookByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found successfully: ");
                book.bookdetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found");
        }
    }

    // Method to search for books by a specific author
    public void searchBookByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Book found successfully: ");
                book.bookdetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for author: " + author);
        }
    }

    // Method to display books borrowed by a user based on user id
    public void bookbyuserid(int user_id) {
        User user = finduser(user_id);
        if (user == null) {
            System.out.println("User not found");
        } else {
            System.out.println("Details are :");
            if (user.getBorrowedBooks().isEmpty()) {
                System.out.println("No books borrowed by this user.");
            } else {
                System.out.println("Borrowed books of user " + user_id + ":");
                for (Integer bookId : user.getBorrowedBooks()) {
                    Book book = findbook(bookId);
                    if (book != null) {
                        System.out.println("Book ID: " + book.getId() + ", Title: " + book.getTitle());
                    }
                }
            }
        }
    }
}
