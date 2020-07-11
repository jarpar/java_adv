package lambda_stream_optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleStreamApi {
    List<Double> numbers = new ArrayList<>(Arrays.asList(15.22, 2.333, 3., 4.55, 6.4444));

    // metoda wypisująca wszystkie liczby jedna pod drugą
    public void getAllNumbers() {
        numbers.stream().forEach(number -> System.out.println(number));
    }
    // metoda wypisująca wszystkie liczby oddzielone ";"

    public void getSeparatedNumbers(String separator) {
        System.out.println(numbers.stream().map(number -> String.valueOf(number)).collect(Collectors.joining(separator)));
    }
    // metoda wypiująca liczby zaokrąglone do 2 miejsc po przecinku

    public static void main(String[] args) {
        SimpleStreamApi ssa = new SimpleStreamApi();
        ssa.getAllNumbers();
        ssa.getSeparatedNumbers(";");
    }
}
