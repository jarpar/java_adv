package oop;

import oop.controller.InputOutputController;
import oop.controller.UserController;
import oop.model.User;
import oop.model.enums.Gender;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import static oop.controller.UserControllerTemplate.users;

public class Run extends InputOutputController {
    public static void main(String[] args) {
//        User u1 = new User("name1", "lastName1", "email1", "password1", "phone1", Gender.MAN);
//        User u2 = new User("name2", "lastName2", "email2", "password2", "phone2", Gender.WOMAN);
//        User u3 = new User("name3", "lastName3", "email3", "password3", "phone3", Gender.MAN);
//        System.out.println(u1);
//        System.out.println(u2);
//        System.out.println(u3);

        //drugi sposób:
//        for (User user : UserControllerTemplate.users
//        ) {
//            System.out.println(user);
//        }
        // trzeci sposób - stream wyrażenia lambda java 8 i wyżej

        //users.forEach(user -> System.out.println(user));
        UserController uc = new UserController();
        Scanner scanner = new Scanner(System.in);
        Run run = new Run();
        run.readUsersFromFile();

        while (true) {
            System.out.println("Co chcesz zrobic? \n1.Rejestracja \n2.Lista użytkowników \n3.Logowanie \n4.Zmień hasło \n5.Usuń użytkownika \n6.Sortuj po adresie e-mail \nQ.Wyjście");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("1")) {
                System.out.println("Podaj imię:");
                String name = scanner.nextLine();
                System.out.println("Podaj nazwisko:");
                String lastName = scanner.nextLine();
                System.out.println("Podaj email:");
                String email = scanner.nextLine();
                String emailPattern = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
                if (!Pattern.matches(emailPattern, email)) {
                    System.out.println("Błędny adres e-mail!");
                    continue;
                }
                System.out.println("Podaj hasło");
                String password = scanner.nextLine();
                System.out.println("Podaj płeć (M/K):");
                String genderPattern = "^[MK]{1}$";
                String genderInput = scanner.nextLine().toUpperCase();
                if (!Pattern.matches(genderPattern, genderInput)) {
                    System.out.println("Błędnie wprowadzona płeć!");
                    continue;
                }
                Gender gender = genderInput.equals("M") ? Gender.MAN : Gender.WOMAN;
                System.out.println("Podaj telefon (000-000-000):");
                String phone = scanner.nextLine();
                //walidacja na podstawie regex-ów
                String phonePattern = "^[0-9]{3}-[0-9]{3}-[0-9]{3}$";
                if (!Pattern.matches(phonePattern, phone)) {
                    System.out.println("Błędny numer telefonu!");
                    continue;
                }
                uc.registerUser(new User(name, lastName, email, password, phone, gender));
            } else if (choice.equals("2")) {
                uc.findAllUsers().forEach(user -> System.out.println(user));
            } else if (choice.equals("3")) {
                System.out.println("Podaj email:");
                String email = scanner.nextLine();
                System.out.println("Podaj hasło:");
                String password = scanner.nextLine();
                uc.loginUser(email, password);
            } else if (choice.equals("4")) {
                try {
                    System.out.println("Podaj id:");
                    int userId = Integer.valueOf(scanner.nextLine());
                    System.out.println("Podaj nowe hasło:");
                    String newPassword = scanner.nextLine();
                    uc.updateUserPassword(userId, newPassword);
                } catch (InputMismatchException e) {
                    System.out.println("Błędny id");
                    continue;
                }
            } else if (choice.equals("5")) {
                try {
                    System.out.println("Podaj id użytkownika do usunięcia:");
                    int userId = Integer.valueOf(scanner.nextLine());
                    uc.deleteUserById(userId);
                } catch (InputMismatchException e) {
                    System.out.println("Błędny id");
                    continue;
                }
            } else if (choice.equals("6")) {
                try {
                    System.out.println("Sortować rosnąco/ malejąco [ASC/DESC]");
                    String sortVal = scanner.nextLine().toUpperCase();
                    if (sortVal.equals("DESC")) {
                        uc.findAllUsersOrderByEmail(false).forEach(user -> System.out.println(user));
                    } else
                        uc.findAllUsersOrderByEmail(true).forEach(user -> System.out.println(user));
                } catch (InputMismatchException e) {
                    System.out.println("Błędny tryb sortowania!");
                    continue;
                }
            } else if (choice.equals("Q")) {
                run.saveUserToFile();
                return;
            } else {
                System.out.println("Błędny wybór");
            }
        }
    }
}