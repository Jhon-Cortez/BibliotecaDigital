/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author rikyf
 */
import java.util.Date;
import java.util.List;

public class Loan {
    private static long counter = 1;
    private Long id;
    private Date loanDate;
    private Date returnDate;
    private boolean returned;
    private User user;
    private Book book;

    public Loan(User user, Book book) {
        this.id = counter++;
        this.user = user;
        this.book = book;
        this.loanDate = new Date(); 
        this.returned = false;
    }
    
    //Cada que se devuelve el libro guarda la hora y hace que el returned sea true
    public void returnBook() {
        this.returned = true;
        this.returnDate = new Date();
    }
    
    
    // Obtiene la fecha en el que se presto
    public Date getLoanDate() {
        return loanDate;
    }
    
    //Obtiene la fecha en que se devolvio
    public Date getReturnDate() {
        return returnDate;
    }

    //Nos dice si est adecuelto o no
    public boolean isReturned() {
        return returned;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public Long getId() {
        return id;
    }
}
