package oop.controller;

import oop.controller.enums.UserField;
import oop.model.User;
import oop.model.enums.Gender;
import oop.model.enums.Role;

import java.time.LocalDateTime;
import java.util.*;

// Interfejs -> szablon wymagań dla klasy go implementującej
public interface UserControllerTemplate {
    // pole statyczne finalne

//    List<User> users = new ArrayList<>(
//            Arrays.asList(
//                    new User(1, "name1", "lastName1", "email1@server.com", "password1", "111-111-111", Gender.MAN,
//                            new HashSet<>(Arrays.asList(Role.ROLE_USER, Role.ROLE_ADMIN)),
//                            LocalDateTime.of(2010, 10, 15, 6, 30, 20), true, false),
//                    new User(2, "name2", "lastName2", "email2@server.com", "password2", "222-222-222", Gender.WOMAN,
//                            new HashSet<>(Arrays.asList(Role.ROLE_USER, Role.ROLE_ADMIN)),
//                            LocalDateTime.of(2013, 9, 13, 2, 40, 10), true, false),
//                    new User(3, "name3", "lastName3", "email3@server.com", "password3", "333-333-333", Gender.MAN,
//                            new HashSet<>(Arrays.asList(Role.ROLE_USER, Role.ROLE_ADMIN)),
//                            LocalDateTime.of(2017, 4, 11, 3, 20, 24), true, false)
//            )
//    );

    List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User(1, "Adam", "Kowalski", "ak@ak.pl", "ak", "123-123-123", Gender.MAN,
                            new HashSet<>(Arrays.asList(Role.ROLE_USER, Role.ROLE_ADMIN)),
                            LocalDateTime.of(2010, 10, 10, 10, 10, 10),
                            true,
                            false),
                    new User(2, "Jan", "Nowak", "jn@jn.pl", "jn", "333-123-123", Gender.MAN,
                            new HashSet<>(Arrays.asList(Role.ROLE_USER)),
                            LocalDateTime.of(2012, 11, 01, 11, 10, 10),
                            true,
                            false),
                    new User(3, "Anna", "Lis", "al@al.pl", "al", "444-231-823", Gender.WOMAN,
                            new HashSet<>(Arrays.asList(Role.ROLE_USER, Role.ROLE_VIEWER)),
                            LocalDateTime.of(2020, 1, 5, 13, 10, 10),
                            false,
                            false),
                    new User(5, "Hanna", "Lis", "hl@hl.pl", "hl", "114-231-823", Gender.WOMAN,
                            new HashSet<>(Arrays.asList(Role.ROLE_VIEWER)),
                            LocalDateTime.of(2020, 5, 5, 13, 10, 10),
                            false,
                            true)
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
    List<User> findAllUsersOrderByEmail(boolean asc);

}
