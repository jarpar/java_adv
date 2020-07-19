package threadsClock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Napisz program wypisujący nq konsoli aktualny czas i odświeżający go co sekundęq
public class Clock implements Runnable {

    public void printTime() throws InterruptedException {
        while (true) {
            System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
            Thread.sleep(1000);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        clock.printTime();
        //Thread thread = new Thread(new Clock());
    }

    @Override
    public void run() {

    }
}
