package oop.controler;

import oop.controler.enums.UserField;
import oop.model.User;
import oop.model.enums.Role;

import java.util.List;
import java.util.Set;

// Interfejs -> szablon wymagań dla klasy go implementującej
public interface UserControllerTemplate {
    // metoda abstrakcyjna -> metoda nieposiadająca ciała - implementacji
    // [typ zwracanej wartości / void] [nazwa metody] ( argument-y / beez argumentów);
    //rejestracja
    void registerUser(User user);

    // logowanie
    boolean loginUser(String email, String password);

    // wyszukiwanie użytkownika
    User findUserById(int userId);

    // update password
    void updateUserPassword(int userId, String newPassword);

    // delete user
    void deleteUserById(int userId);

    // add / drop roles
    void updateRole(int userId, Set<Role> newRoles);

    // wypisanie wszstkich użytkowników
    List<User> findAllUsers();

    //  wypisanie użytkowników posortowanych po argumencie
    List<User> findAllUsersOrderByArg(UserField userField, boolean asc);

}
