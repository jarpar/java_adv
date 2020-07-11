package lambda_stream_optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleStreamApi {
    List<Double> numbers = new ArrayList<>(Arrays.asList(15.22, -2.333, 3., -4.55, 6.4444));

    // metoda wypisująca wszystkie liczby jedna pod drugą
    public void getAllNumbers() {
        numbers.stream().forEach(number -> System.out.println(number));
    }
    // metoda wypisująca wszystkie liczby oddzielone ";"

    public void getSeparatedNumbers(String separator) {
        System.out.println(numbers.stream().map(number -> String.valueOf(number)).collect(Collectors.joining(separator)));
    }

    // metoda wypiująca liczby zaokrąglone do OKREŚLONEJ  liczby miejsc po przecinku
    public void getShortNumers(int precision) {
        try {
            numbers.stream().forEach(number -> System.out.printf("%." + precision + "f\t", number));
        } catch (Exception e) {
            System.out.println("Błęcny zakres precyzji");
        }
    }

    public double getSumOfAllNo() {
        return numbers.stream().mapToDouble(value -> Double.valueOf(value)).sum();
    }

    public double getMin() {
        if (numbers.stream().mapToDouble(val -> Double.valueOf(val)).min().isPresent()) {
            return numbers.stream().mapToDouble(val -> Double.valueOf(val)).min().getAsDouble();
        } else {
            System.out.println("Błąd");
            return 0.0;
        }
    }


    public double getMax() {
        if (numbers.stream().mapToDouble(val -> Double.valueOf(val)).max().isPresent()) {
            return numbers.stream().mapToDouble(val -> Double.valueOf(val)).max().getAsDouble();
        } else {
            System.out.println("Błąd");
            return 0.0;
        }
    }

    public static void main(String[] args) {
        SimpleStreamApi ssa = new SimpleStreamApi();
        ssa.getAllNumbers();
        ssa.getSeparatedNumbers(";");
        ssa.getShortNumers(2);
        System.out.println(ssa.getSumOfAllNo());
        System.out.println(ssa.getMax());
        System.out.println(ssa.getMin());
    }
}
