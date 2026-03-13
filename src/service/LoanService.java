/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import entity.Loan;
import entity.User;
import entity.Book;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class LoanService {
    private List<Loan> loans;

    public LoanService() {
        this.loans = new ArrayList<>();
    }


    
    //registra un préstamo de libro
    public void borrowBook(User user, Book book) {
        Loan newLoan = new Loan(user, book);  //crea un nuevo préstamo
        loans.add(newLoan);  // lo añade a la lista
        System.out.println("Book borrowed: " + book.getTitle());
        System.out.println("User: " + user.getName());
    }

    //devuelve un libro
    public void returnBook(Long loanId) {
        for (Loan loan : loans) {
            if (loan.getId().equals(loanId)) {
                loan.returnBook();
                loan.getBook().setStatus(true);
                loans.remove(loan);
                System.out.println("Book returned: " + loan.getBook().getTitle());
                System.out.println("User: " + loan.getUser().getName());
                System.out.println("Return date: " + loan.getReturnDate());
                return;
            }
        }
        System.out.println("Loan not found");
    }

    // lista todos los prestamos
    public void listLoans() {

        if (loans.isEmpty()) {
            System.out.println("No loans registered");
            return;
        }

        for (Loan loan : loans) {

            System.out.println(
                "Loan ID: " + loan.getId() +
                " | User: " + loan.getUser().getName() +
                " | Book: " + loan.getBook().getTitle()
            );
        }
    }
}
