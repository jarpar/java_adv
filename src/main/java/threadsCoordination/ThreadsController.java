package threadsCoordination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ZADANIE
// 1. Utwórz dwa wątki o nazwach producer 1 i producer 2
// 2. Producer 1 wypisuje ne ekran zawartość List<String>
// 3. Producer 2 wypisuje na ekran zawartość Array<Integer>
// --------------------------------------------------------
// 4. producer 2 może wypisywać na ekran dopiero gdy producer skończy działanie (wypisze wszystkie)
// 5. Po zakończeniu pracy obu wątków wątek główny niech wypisze "KONIEC"

public class ThreadsController {
    List<String> names = new ArrayList<>(Arrays.asList("Adam", "Jan", "Anna", "Ola", "Iga"));
    int[] numbers = {22, 12, 34, 54, 3, 2, 1, 1, 1, 1, 0, 0, 1};
    Thread thread1;// = new Thread();
    Thread thread2;//= new Thread();

    public void printNames() {
        thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (String n : names
                ) {
                    System.out.println(Thread.currentThread().getName() + ": " + n);
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "producer1");
        thread1.start();
    }

    public void printNumbers() {
        thread2 = new Thread(new Runnable() {


            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int n : numbers) {
                    System.out.println(Thread.currentThread().getName() + ": " + n);
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, "producer2");
        thread2.start();
    }

    public static void main(String[] args) {
        ThreadsController threadsController = new ThreadsController();
        threadsController.printNames();
        threadsController.printNumbers();
    }
}
