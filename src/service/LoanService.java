/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import Entity.Loan;
import Entity.User;
import Entity.Book;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class LoanService {
    private List<Loan> loans;

    public LoanService(List<Loan> loans) {
        this.loans = loans;
    }

    
    //registra un préstamo de libro
    public void borrowBook(User user, Book book) {
        Loan newLoan = new Loan(user, book);  //crea un nuevo préstamo
        loans.add(newLoan);  // lo añade a la lista
        System.out.println("el prestamo fue realizado al libro: " + book.getTitle());
    }

    //devuelve un libro
    public void returnBook(Book book) {
       for (Loan loan : loans) {  
        if (loan.getBook().equals(book) && !loan.isReturned()) {  
            loan.returnBook();  // marca el libro como devuelto  
            System.out.println("Libro devuelto: " + book.getTitle());  
            break;  
        }  
    }  
    }

    // lista todos los prestamos
    public List<Loan> listLoans() {
        return loans;// retorna la lista de prestamos
    }
}
