/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author rikyf
 */

import entity.Book;
import entity.User;
import java.util.List;
import service.BookService;
import service.UserService;
import service.LoanService;
import strategy.CategoryRecommendation;
import strategy.EditorialRecommendation;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    private BookService bookService;
    private UserService userService;
    private LoanService loanService;

    public Menu() {

        scanner = new Scanner(System.in);

        bookService = new BookService();
        userService = new UserService();
        loanService = new LoanService();

    }

    public void start() {

        int option;

        do {

            showMenu();

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1 -> addUser();

                case 2 -> addBook();

                case 3 -> listBooks();

                case 4 -> filterBooks();

                case 5 -> recommendByCategory();

                case 6 -> recommendByEditorial();

                case 7 -> borrowBook();

                case 8 -> returnBook();

                case 9 -> listLoans();

                case 0 -> System.out.println("Bye");

                default -> System.out.println("Invalid option");

            }

        } while (option != 0);

    }

    private void showMenu() {

        System.out.println("LIBRARY MENU");
        System.out.println("1. Add user");
        System.out.println("2. Add book");
        System.out.println("3. List books");
        System.out.println("4. Filter books");
        System.out.println("5. Recommend by category");
        System.out.println("6. Recommend by editorial");
        System.out.println("7. Borrow book");
        System.out.println("8. Return book");
        System.out.println("9. List loans");
        System.out.println("0. Exit");

        System.out.print("Option: ");

    }

    private void addUser() {

        System.out.println("Id:");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Name:");
        String name = scanner.nextLine();

        System.out.println("Email:");
        String email = scanner.nextLine();

        User user = new User(id, name, email);

        userService.addUser(user);
    }

    private void addBook() {

         System.out.println("Id:");
         long id = scanner.nextLong();
         scanner.nextLine();

         System.out.println("Title:");
         String title = scanner.nextLine();

         System.out.println("Editorial:");
         String editorial = scanner.nextLine();

         System.out.println("Category:");
         String category = scanner.nextLine();

         Book book = new Book(id, title, editorial, true, category);

         bookService.addBook(book);

    }

    private void listBooks() {

        for (Book book : bookService.listBook()) {
            System.out.println(
                book.getTitle() + " - " +
                book.getEditorial() + " - " +
                book.getCategory()
            );
        }

    }
    private void filterBooks() {

        bookService.filterBook();

    }

    private void recommendByCategory() {
        System.out.println("Category:");
        String category = scanner.nextLine();
        bookService.setStrategy(new CategoryRecommendation(category));
        bookService.recommendBook();
    }
    private void recommendByEditorial() {

        System.out.println("Editorial:");
        String editorial = scanner.nextLine();
        bookService.setStrategy(new EditorialRecommendation(editorial));
        bookService.recommendBook();
    }

    private void borrowBook() {

        System.out.println("User id:");
        long userId = scanner.nextLong();

        System.out.println("Book id:");
        long bookId = scanner.nextLong();
        scanner.nextLine();

        User user = userService.findUserById(userId);
        Book book = bookService.findBookById(bookId);

        loanService.borrowBook(user, book);
    }
    private void returnBook() {

        System.out.println("Loan id:");
        long loanId = scanner.nextLong();
        scanner.nextLine();

        loanService.returnBook(loanId);

    }
    private void listLoans() {

        loanService.listLoans();

    }

}