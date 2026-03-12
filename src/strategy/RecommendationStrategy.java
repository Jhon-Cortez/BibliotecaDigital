/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package strategy;
import entity.Book;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface RecommendationStrategy {
// define el metodo para recomendar libros
    List<Book> recommend(List<Book> books);
}

