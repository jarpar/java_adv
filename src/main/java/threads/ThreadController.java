package threads;

import java.util.*;

public class ThreadController {
    Deque<Integer> numbers = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    // metoda implementująca wątek wypisujący wszystkie liczby
    public void printNumbers(Thread thread) {
        // utworzenie klasy anonimowej
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long timeStart = System.currentTimeMillis();
                while (!numbers.isEmpty()) {
                    try {
                        Thread.currentThread().sleep(new Random().nextInt(6) * 1000);     // uśpienie wąktu thread na 1s
                        synchronized (numbers) {
                            System.out.println("Wątek: " + Thread.currentThread().getName() +
                                    " - wartość: " + numbers.removeFirst() +
                                    " aktualna zawartość: " + numbers);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (NoSuchElementException e) {
                        break;
                    }
                }
                System.out.println("Całkowity czas [s]: " + ((System.currentTimeMillis() / 1000) - (timeStart / 1000)));
            }
        });
        thread.start();         // uruchomienie wątku -> "wykonanie metody run()"
    }

    public static void main(String[] args) {
        ThreadController tc = new ThreadController();
        long timeStart = System.currentTimeMillis();
        Thread th1 = null, th2 = null, th3 = null;
        System.out.println("Wątek: " + Thread.currentThread().getName());
        tc.printNumbers(th1);
        tc.printNumbers(th2);
        tc.printNumbers(th3);
        System.out.println("Wątek: " + Thread.currentThread().getName());
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();


    }
}