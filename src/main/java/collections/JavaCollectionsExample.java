package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaCollectionsExample {
    public void arrayOperations() {
        try {
            //utworzenie tablicy
            String[] names = new String[10];
            int[] numbers = {1, 2, 3, 4, 5};
            System.out.println("Tablica nazaw");
            Arrays.stream(names) //zamiana tablicy na stream
                    .forEach(s -> System.out.println(s)); // dla każdego elementu wykonaj predykat (CTRL + Soace)
//        for(String s : names){
//            System.out.println(s);
//        }
            System.out.println("modyfikacja wartości na indeksie");
            names[names.length - 1] = "Anna";
            Arrays.stream(names).forEach(n -> System.out.println(n));
            names[100] = "Jan"; //ArrayIndexOutOfBoundsException
            System.out.println("\nTablica liczb");
            Arrays.stream(numbers).forEach(n -> System.out.println(n));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listOperations() {
        //utworzenie pustej listy
        List<String> names = new ArrayList<>();
        //utworzenie listy zainicjowanej wartościami
        List<Double> params = new ArrayList<>(Arrays.asList(1.2, 1.44, 1.11, 4.));
    }

    public static void main(String[] args) {
        JavaCollectionsExample ex = new JavaCollectionsExample();
        //   ex.arrayOperations();

    }
}