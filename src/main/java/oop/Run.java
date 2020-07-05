package oop;

import oop.controler.UserController;
import oop.controler.UserControllerTemplate;
import oop.model.User;
import oop.model.enums.Gender;

import java.util.Scanner;

public class Run {
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
        UserControllerTemplate.users.forEach(user -> System.out.println(user));
        UserController uc = new UserController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Co chcesz zrobic? \n1. Rejestracja \n2. Logowanie \nQ. Wyjście");
            String choice = scanner.nextLine().toUpperCase();
            if (choice.equals("1")) {
                System.out.println("Podaj imię:");
                String name = scanner.nextLine();
                System.out.println("Podaj nazwisko:");
                String lastName = scanner.nextLine();
                System.out.println("Podaj email:");
                String email = scanner.nextLine();
                System.out.println("Podaj hasło");
                String password = scanner.nextLine();
                System.out.println("Podaj płeć (M/K):");
                String gender = scanner.nextLine();
                System.out.println("Podaj telefon (000-000-000):");
                String phone = scanner.nextLine();

            } else if (choice.equals("2")) {

            } else if (choice.equals("q")) {

            } else {
                System.out.println("Błędny wybór");
            }
        }
    }
}