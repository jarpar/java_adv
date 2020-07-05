package oop.controler;

import oop.controler.enums.UserField;
import oop.model.User;
import oop.model.enums.Role;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

//Klasa kontrolera - odpowiedzialna za obsługę i implementację logiki biznesowej aplikacji
public class UserController implements UserControllerTemplate {
    @Override
    public void registerUser(User user) {
        //szyfrowanie hasła
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // operacja szyfrownia zwraca tablicę liczb naturalnych
            byte[] passwordHash = md.digest(user.getPassword().getBytes());
            // zapisanie tablicy liczb w typie String
            String passwordHashTxt = "";
            for (byte digit : passwordHash) {
                passwordHashTxt += digit;
            }
            users.add(user);
            System.out.println("Dodano nowego użytkownika: " + user.getEmail());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean loginUser(String email, String password) {
        return false;
    }


    @Override
    public User findUserById(int userId) {
        return null;
    }

    @Override
    public void updateUserPassword(int userId, String newPassword) {

    }

    @Override
    public void deleteUserById(int userId) {

    }

    @Override
    public void updateRole(int userId, Set<Role> newRoles) {

    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public List<User> findAllUsersOrderByArg(UserField userField, boolean asc) {
        return null;
    }
}
