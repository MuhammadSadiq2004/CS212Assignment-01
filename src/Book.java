//Book Class


public class Book {
    private int bookid; // Unique identifier for the book
    private String title; // Title of the book
    private String genre; // Genre of the book
    private String author; // Author of the book
    private boolean available; // Availability status of the book
    private static int nextid = 0000; // Static variable to generate unique IDs for books

    // Constructor to initialize a new Book object
    public Book(String title, String genre, String author) {
        this.bookid = ++nextid; // Incrementing nextid to generate a new unique ID
        this.title = title; // Assigning title
        this.genre = genre; // Assigning genre
        this.author = author; // Assigning author
        this.available = true; // By default, a new book is available
    }
    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s,%b", bookid, title, author, genre, available);
    }

    // Getter method to retrieve the ID of the book
    public int getId() {
        return bookid;
    }

    // Getter method to retrieve the title of the book
    public String getTitle() {
        return title;
    }

    // Getter method to retrieve the genre of the book
    public String getGenre() {
        return genre;
    }

    // Getter method to retrieve the author of the book
    public String getAuthor() {
        return author;
    }

    // Getter method to retrieve the availability status of the book
    public boolean isAvailable() {
        return available;
    }

    // Method to mark the book as borrowed
    public void borrowBook() {
        available = false;
    }

    // Method to mark the book as returned
    public void returnBook() {
        available = true;
    }

    // Method to display details of the book
    public void bookdetails() {
        System.out.println("Book details:");
        System.out.println("Book id :" + getId());
        System.out.println("Book author :" + getAuthor());
        System.out.println("Book title :" + getTitle());
        System.out.println("Book genre :" + getGenre());
    }

    // Setter method to update the availability status of the book
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
