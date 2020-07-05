package oop;

import oop.model.User;
import oop.model.enums.Gender;

public class Run {
    public static void main(String[] args) {
        User u1 = new User("name1", "lastName1", "email1", "password1", "phone1", Gender.MAN);
        User u2 = new User("name2", "lastName2", "email2", "password2", "phone2", Gender.WOMAN);
        User u3 = new User("name3", "lastName3", "email3", "password3", "phone3", Gender.MAN);
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
    }

}