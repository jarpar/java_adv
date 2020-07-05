package oop.controller;

import oop.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class InputOutputController {
    // globalna ścieżka bezpośednia do pliku
    private String usersFilePath = "/home/user/java_adv/src/main/resources/file/users.csv";

    public void saveUserToFile() {
        try {
            PrintWriter pw = new PrintWriter(new File(usersFilePath));
            for (User user : UserControllerTemplate.users
            ) {
                pw.println(String.format(
                        "%d;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s",
                        user.getUserId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword(),
                        user.getPhone(), user.getGender(), user.getRoles(), user.getRegistrationDateTime(), user.isStatus(),
                        user.isRemoved()
                ));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readUsersFromFile() {
        try {
            Scanner scanner = new Scanner(new File(usersFilePath));
            while (scanner.hasNextLine()) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
