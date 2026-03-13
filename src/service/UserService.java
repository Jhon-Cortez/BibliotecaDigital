/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import entity.User;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Asus
 */
public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    // Método para agregar un nuevo usuario
    public void addUser(User user) {
        users.add(user);
        System.out.println("Add user: " + user.getName());
    }

    // elimina un usuario por su ID
    public void removeUser(Long userId) {
        users.removeIf(user -> user.getId().equals(userId));  // Elimina el usuario atraves del id
        System.out.println("Deleted user by ID: " + userId);

    }

    //lista todos los usuarios
    public List<User> listUsers() {
        return users;
    }

    // encuentra a un usuario por su ID
    public User findUserById(Long id) {
       // Busca y retorna el usuario atraves del id
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null; //por si no lo encuentra retorna null
    }
}

