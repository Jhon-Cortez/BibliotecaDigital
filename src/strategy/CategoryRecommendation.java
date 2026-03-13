/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;
import entity.Book;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Asus
 */


public class CategoryRecommendation implements RecommendationStrategy {

    private String category;

    public CategoryRecommendation(String category) {
        this.category = category;
    }

    @Override
    public List<Book> recommend(List<Book> books) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {

            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }

        }

        return result;
    }
}