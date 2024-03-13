Details of Project:

This project is used to manage library data using concept of OOPs. In this library management system, user and book data store by making class and assign attributes to those classes. The file handling use to store data of books and user in txt file.

Instructions to set up this system:

1) The Intellij Idea  Community 2023 must be setup in your PC.
2) Create folder of java in your Local Disk except Local Disk C.
3) If no Local Disk is present except C. Then create folder on Desktop.
4) After creating folder, copy Assignment1Final folder in java folder.
5) Open Assignment1Final folder in IntellijIdea.
6) Open src folder present in Assignment folder.
7) You see 5 files (Book,User,LibraryFileHandler,Library).
8) Open Main File and then run.
9) Setup done successfully.

Key Features of Function Implemented:

1) addbook():

This method prompts the user to input details of a book (title, genre, author) and validates the inputs. It then creates a new Book object with the provided details and adds it to the library's collection.

2) isValidInput(String input): 

This is a helper method used to validate input strings. It checks whether the input contains only alphabetic characters.

3) adduser(): 

Similar to addbook(), this method prompts the user to input details of a new user (name, contact information) and validates the inputs. It creates a new User object and adds it to the list of library users.

4) borrowed_book(): 

This method handles the process of borrowing a book. It prompts the user to input their user ID and the book's ID, validates the inputs, and checks if the book is available for borrowing. If all conditions are met, it marks the book as borrowed and adds it to the user's borrowed books list.

5) return_book(): 

This method handles the process of returning a borrowed book. It prompts the user to input their user ID and the book's ID, validates the inputs, and checks if the book is already returned. If the book is borrowed by the user, it marks the book as returned and removes it from the user's borrowed books list.

6) finduser(int user_id):

This method searches for a user in the list of library users based on their user ID and returns the corresponding User object if found.

7) findbook(int book_id):

Similar to finduser(), this method searches for a book in the library's collection based on its book ID and returns the corresponding Book object if found.

8) displaybook():

This method displays details of all books in the library, including title, ID, author, genre, and availability status.

9) searchBookByTitle(String title): 

This method searches for a book in the library by its title. If found, it displays the book's details.

10) searchBookByAuthor(String author): 

Similar to searchBookByTitle(), this method searches for books by a specific author and displays their details if found.

11) bookbyuserid(int user_id): 

This method displays the books borrowed by a user based on their user ID. It retrieves the user's borrowed books list and displays the corresponding book details.

Conclusion:

These functions collectively provide basic functionalities for managing a library system, including adding books and users, borrowing and returning books, searching for books, and displaying book details
