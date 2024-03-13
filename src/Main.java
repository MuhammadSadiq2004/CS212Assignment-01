//Main class




import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialize the library and scanner
        Library library = LibraryFileHandler.loadDataFromFile(); // Load data from file
        Scanner sc = new Scanner(System.in);
        int choice;

        // Main menu loop
        do {
            try {
                // Display menu options
                System.out.println("Press 1 to add books");
                System.out.println("Press 2 to add users");
                System.out.println("Press 3 to borrow a book");
                System.out.println("Press 4 to return a book");
                System.out.println("Press 5 to search for a book by title");
                System.out.println("Press 6 to search for a book by author");
                System.out.println("Press 7 to display books");
                System.out.println("Press 8 to search book by user id");
                System.out.println("Press 9 to Exit");

                // Prompt user for input
                System.out.println("Enter Your Choice:");
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline
                boolean containsOnlyCharacters;

                // Process user choice
                switch (choice) {
                    case 1:
                        // Add book
                        library.addbook();
                        LibraryFileHandler.saveDataToFile(library);
                        break;
                    case 2:
                        // Add user
                        library.adduser();
                        LibraryFileHandler.saveDataToFile(library);
                        break;
                    case 3:
                        // Borrow a book

                        library.borrowed_book();
                        LibraryFileHandler.saveDataToFile(library);
                        break;
                    case 4:
                        // Return a book

                        library.return_book();
                        LibraryFileHandler.saveDataToFile(library);
                        break;
                    case 5:
                        // Search for a book by title
                        library = LibraryFileHandler.loadDataFromFile();// Load data from file before searching

                        String title;

                            System.out.print("Enter book title: ");
                            title = sc.nextLine();
                                library.searchBookByTitle(title);
                        break;
                    case 6:
                        // Search for a book by author
                        library = LibraryFileHandler.loadDataFromFile(); // Load data from file before searching
                        containsOnlyCharacters = false;
                        String author;
                        do {
                            System.out.print("Enter author name: ");
                            author = sc.nextLine();
                            containsOnlyCharacters = author.matches("[a-zA-Z]+");
                            if (containsOnlyCharacters) {
                                library.searchBookByAuthor(author);
                            } else {
                                System.out.println("Invalid Input");
                            }
                        } while (!containsOnlyCharacters);
                        break;
                    case 7:
                        // Display books
                        library = LibraryFileHandler.loadDataFromFile(); // Load data from file before displaying
                        library.displaybook();
                        break;
                    case 8:
                        // Search book by user id
                        library = LibraryFileHandler.loadDataFromFile(); // Load data from file before searching
                        int userId = 0;
                        boolean validInput = false;
                        while (!validInput) {
                            try {
                                System.out.print("Enter user ID: ");
                                userId = sc.nextInt();
                                sc.nextLine(); // Consume the newline character after reading the integer
                                validInput = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Input. Enter an integer.");
                                sc.nextLine(); // Consume the invalid input
                            }
                        }
                        library.bookbyuserid(userId);
                        break;
                    case 9:
                        // Exit the program
                        System.out.println("Saving data to file...");
                        LibraryFileHandler.saveDataToFile(library); // Save data to file before exiting
                        System.out.println("Thank you");
                        break;
                    default:
                        // Invalid input
                        System.out.println("Invalid Input");
                        break;
                }
            } catch (InputMismatchException e) {
                // Handle input mismatch exception
                System.out.println("Invalid Input. Please enter a valid number.");
                sc.nextLine(); // Consume the invalid input
                choice = -1; // Reset choice to force the loop to repeat
            }
        } while (choice != 9);

        // Close the scanner
        sc.close();
    }
}
