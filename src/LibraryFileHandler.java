//Library File Handler Class


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LibraryFileHandler {
    public static final String BOOKS_FILE = "books.txt";
    public static final String USERS_FILE = "users.txt";


    public static void saveDataToFile(Library library) {
        try {
            // Save books data to a text file
            BufferedWriter booksWriter = new BufferedWriter(new FileWriter(BOOKS_FILE));
            for (Book book : library.books) {
                booksWriter.write(book.toString());
                booksWriter.newLine();
            }
            booksWriter.close();


            // Save users data to a text file
            BufferedWriter usersWriter = new BufferedWriter(new FileWriter(USERS_FILE));
            for (User user : library.users) {
                usersWriter.write(user.toString());
                usersWriter.newLine();
            }
            usersWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Library loadDataFromFile() {
        Library library = new Library();


        try {
            // Load books data from the text file
            BufferedReader booksReader = new BufferedReader(new FileReader(BOOKS_FILE));
            String line;
            while ((line = booksReader.readLine()) != null) {
                String[] bookData = line.split(",");
                if (bookData.length != 5) {
                    // Incorrect data format, handle appropriately
                    System.out.println("Invalid data format in books file.");
                    continue;
                }
                int bookID = Integer.parseInt(bookData[0]);
                String title = bookData[1];
                String author = bookData[2];
                String genre = bookData[3];
                boolean availability = Boolean.parseBoolean(bookData[4]);


                Book newBook = new Book(title, genre, author);
                newBook.setAvailable(availability);
                library.books.add(newBook);
            }
            booksReader.close();


            // Load users data from the text file
            BufferedReader usersReader = new BufferedReader(new FileReader(USERS_FILE));
            while ((line = usersReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length != 3) {
                    // Incorrect data format, handle appropriately
                    System.out.println("Invalid data format in users file.");
                    continue;
                }
                int userId = Integer.parseInt(userData[0]);
                String name = userData[1];
                String contact = userData[2];


                User newUser = new User(name, contact);
                newUser.setUserId(userId);
                library.users.add(newUser);
            }
            usersReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


        return library;
    }
}
