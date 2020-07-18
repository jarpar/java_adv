package threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadController {

    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    public void printNumbers() {
        //utworzenie klasy anonimowej
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer number : numbers
                ) {
                    try {
                        Thread.currentThread().sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(number);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();//uruchomienie wątku, czyli wykonanie metody run
    }

    public static void main(String[] args) {
        ThreadController threadController = new ThreadController();
        System.out.println(Thread.currentThread().getName());
        threadController.printNumbers();
        System.out.println(Thread.currentThread().getName());
    }
}
