package oop.controler;

import oop.controler.enums.UserField;
import oop.model.User;
import oop.model.enums.Gender;
import oop.model.enums.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

// Interfejs -> szablon wymagań dla klasy go implementującej
public interface UserControllerTemplate {
    // pole statyczne finalne
    List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User("name1", "lastName1", "email1@server.com", "password1", "111-111-111", Gender.MAN),
                    new User("name2", "lastName2", "email2@server.com", "password2", "222-222-222", Gender.WOMAN),
                    new User("name3", "lastName3", "email3@server.com", "password3", "333-333-333", Gender.MAN)
            )
    );

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
