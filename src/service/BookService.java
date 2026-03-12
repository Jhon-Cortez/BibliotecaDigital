/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import Entity.Book;
import Observer.IObserver;
import Strategy.RecommendationStrategy;
import Iterator.IIterator;
import Iterator.BookIterator;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class BookService {
    private List<IObserver> observers;
    private List<Book> books;
    private RecommendationStrategy strategy;

    public BookService(List<IObserver> observers, List<Book> books, RecommendationStrategy strategy) {
        this.observers = observers;
        this.books = books;
        this.strategy = strategy;
    }
    // Métodos de la interfaz IObservable
    @Override
    public void attach(IObserver observer) {
        observers.add(observer);  // añade un observador
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);  // elimina un observador
    }

    @Override
    public void notifyObservers(String data) {
        for (IObserver observer : observers) {
            observer.update(data);  // notifica a cada observador con los datos
        }
    }
    
    // agregar un libro
    public void addBook() {
       books.add(book);
       notifyObservers("Nuevo libro agregado: " + book.getTitle());  // notifica a los observadores

    }

    //elimina un libro
    public void removeBook() {
       books.removeIf(book -> book.getId().equals(bookId));  // elimina el libro con el id
       notifyObservers("Libro removido: " + bookId);  // notifica a los observadores

    }

    //lista todos los libros
    public void listBook() {
        return list<book>; // devuelve la lista de los libros
    }

    //filtra libros por categoria
    public void filterBook() {
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                // filtra los libros por categoría y muestra el resultado
                System.out.println(book.getTitle());
            }
        }
    }

    //configura la estrategia de recomendacion de libros
    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    //recomienda libros segun la estrategia configurada
    public List<Book> recommendBook() {
        
        return strategy.recommend(books); // usa la estrategia para reomendar libros
    }

    //crea un iterador de libros
    public IIterator createIterator() {
        
        return null; // retorna el iterador para recorrer los libros
    }
}

