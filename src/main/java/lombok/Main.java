package lombok;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        User userNoArgs = new User();
        User userAllArgs = new User(1, "test@test.pl", "test", LocalDateTime.now(), true);
        System.out.println(userNoArgs);
        System.out.println(userAllArgs);
        userNoArgs.setPassword("nowe hasło");
        System.out.println(userNoArgs.getPassword());
        userAllArgs.setStatus(false);
        System.out.println(userAllArgs.isStatus());
        userAllArgs.setRegistrationDateTime(LocalDateTime.of(2020, 1, 10, 6, 15, 20));
        System.out.println(userAllArgs.getRegistrationDateTime());
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy'r.' '('HH:mm')' ");
        System.out.println(dateFormat.format(userAllArgs.getRegistrationDateTime()));

        Task task1 = new Task();
        Task task2 = new Task("nauka Javy", "programowanie obiektowe", false, userAllArgs);
        System.out.println(task1);
        System.out.println(task2);

    }
}
