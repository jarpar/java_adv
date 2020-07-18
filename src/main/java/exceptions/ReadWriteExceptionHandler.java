package exceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadWriteExceptionHandler {

    private static String path = Paths.get("").toAbsolutePath().toString() + "data.txt";
    private static File file = new File(path);

    public static void appendDataToFile() {
        while (true) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                Scanner scanner = new Scanner(System.in);

                System.out.println("Wprowadź liczbę (Q - wyjście)");
                String data = scanner.nextLine();
                if (data.toUpperCase().equals("Q")) {
                    fileWriter.close();
                    break;
                }
                String s;
                double number = Double.valueOf(data);
                fileWriter.append(String.valueOf(number));

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InputMismatchException | NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Błąd typu danych");
            }
        }
    }

    public static void readDAtaFromFile() {

    }

    public static void main(String[] args) {
        appendDataToFile();
    }
}
