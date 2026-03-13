/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;
import entity.Book;
import java.util.List;

/**
 *
 * @author Asus
 */
public class EditorialRecommendation implements RecommendationStrategy{
    @Override
    public List<Book> recommend(List<Book> books) {
        // logica de recomendación por editorial
        return books;  
    }
}
