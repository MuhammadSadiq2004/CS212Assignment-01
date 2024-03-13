//User Class

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    Scanner sc = new Scanner(System.in);

    private int userid; // Unique identifier for the user
    private static int nextid = 0000; // Static variable to generate unique IDs for users
    private String username; // Username of the user
    private String contactInfo; // Contact information of the user
    private List<Integer> borrowedBooks; // List of book IDs borrowed by the user

    // Constructor to initialize a new User object
    public User(String username, String contactInfo) {
        this.userid = ++nextid; // Incrementing nextid to generate a new unique ID
        this.username = username; // Assigning username
        this.contactInfo = contactInfo; // Assigning contact information
        this.borrowedBooks = new ArrayList<>(); // Initializing borrowedBooks list
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s", userid, username, contactInfo);
    }
    // Getter method to retrieve the ID of the user

    public int getUserId() {
        return userid;
    }

    // Getter method to retrieve the username of the user
    public String getUserName() {
        return username;
    }

    // Getter method to retrieve the contact information of the user
    public String getContactInfo() {
        return contactInfo;
    }

    // Getter method to retrieve the list of book IDs borrowed by the user
    public List<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method to display details of the user
    public void userdetails() {
        System.out.println("User details:");
        System.out.println("User name " + getUserName());
        System.out.println("User id :" + getUserId());
        System.out.println("User contact info " + getContactInfo());
    }

    // Setter method to update the ID of the user
    public void setUserId(int userId) {
        this.userid = userId;
    }
}
