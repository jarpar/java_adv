package pizzaExercises;

import lambda_stream_optional.InMemoryData;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class PizzaController {
    // metoda zwracającą cenę pizzy na podstawie cen składowych wszystkich jej składników
    public int calculatePizzaPrice(Pizza pizza) {
        return pizza.getIngredients().stream()
                .mapToInt(p -> p.getPrice())
                .sum();
    }

    // metoda zwracająca tylko pizze ostre
    public List<Pizza> getAllSpicy() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
                .collect(Collectors.toList());
    }

    // metoda zwracająca obiekt Pizza dla najtańszej i ostrej pizzy
    public Pizza findCheapestSpicy() {
        Optional<Pizza> pizzaOpt = Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
                .sorted(Comparator.comparing(pizza -> calculatePizzaPrice(pizza)))      // sortowanie MIN-MAX
                .findFirst();                                                           // pobranie pierwszej wartości -> Optional
        if (pizzaOpt.isPresent()) {               // sprawdzenie czy optional zawiera wartość
            return pizzaOpt.get();              // wydobycie wartości z optionala
        }
        System.out.println("Brak danych do pobrania");
        return null;
    }

    // metoda wypisująca pizze wraz z cenami
    public void getAllPizzasWithPrices() {
        Arrays.stream(Pizza.values())
                .forEach(pizza -> System.out.println(pizza.getName() + " - " + calculatePizzaPrice(pizza) + " PLN"));
    }

    // metoda zwracająca najdroższą pizze wegetariańską
    Pizza findMostExpensiveVegetarian() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().noneMatch(ingredient -> ingredient.isMeat()))
                .sorted(Comparator.comparing(this::calculatePizzaPrice).reversed())
                .findFirst().get();
    }

    // metoda zwracająca ilość składników mięsnych danej pizzy
    public long countMeatIngredients(Pizza pizza) {
        return pizza.getIngredients().stream().filter(Ingredient::isMeat).count();
    }

    // metoda zwracająca pizze mięsna posotrowane malejąco po liczbie składników mięsnych
    public List<Pizza> iLikeMeat() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(Ingredient::isMeat))
                .sorted(Comparator.comparing(this::countMeatIngredients).reversed())
                .collect(Collectors.toList());
    }

    // metoda grupująca pizze po cenie
    public Map<Integer, List<Pizza>> groupByPrice() {
        return Arrays.stream(Pizza.values()).collect(Collectors.groupingBy(pizza -> calculatePizzaPrice(pizza)));
    }

    // metoda grupujące pizze po poziomach ostrości
    public Map<Boolean, List<Pizza>> groupBySpicy() {
        return Arrays.stream(Pizza.values()).collect(Collectors.groupingBy(
                pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
        );
    }

    // metoda grupująca pizze po liczbie składników()
    public Map<Integer, List<Pizza>> groupByIngredientsSize() {
        return Arrays.stream(Pizza.values()).collect(Collectors.groupingBy(pizza -> pizza.getIngredients().size()));
    }

    // pizza menu: nazwa (składniki) - cena zł
    public String formatedMenu() {
        Random random = new Random();
        int randomIndex = random.nextInt(Pizza.values().length);
        Pizza pizzaOfTheDay = Pizza.values()[randomIndex];

        return Arrays.stream(Pizza.values())
                .map(pizza -> String.format(
                        "%15s (%-90s) %5s %4s - %5.2f zł %1s",
                        pizza.getName(),
                        pizza.getIngredients().stream().map(Ingredient::getName).collect(Collectors.joining(", ")),
                        pizza.getIngredients().stream().anyMatch(Ingredient::isSpicy) ? "ostra" : "",
                        pizza.getIngredients().stream().noneMatch(Ingredient::isMeat) ? "wege" : "",
                        pizza.equals(pizzaOfTheDay) ? (double) calculatePizzaPrice(pizza) * 0.5 : (double) calculatePizzaPrice(pizza),
                        pizza.equals(pizzaOfTheDay) ? "*" : ""
                )).collect(Collectors.joining("\n"));
    }

    // pizza menu - sortowanie po nazwie
    public String formatedMenuOrderByName() {
        Random random = new Random();
        int randomIndex = random.nextInt(Pizza.values().length);
        Pizza pizzaOfTheDay = Pizza.values()[randomIndex];

        return Arrays.stream(Pizza.values())
                .sorted(Comparator.comparing(Pizza::getName))
                .map(pizza -> String.format(
                        "%15s (%-90s) %5s %4s - %5.2f zł %1s",
                        pizza.getName(),
                        pizza.getIngredients().stream().map(Ingredient::getName).collect(Collectors.joining(", ")),
                        pizza.getIngredients().stream().anyMatch(Ingredient::isSpicy) ? "ostra" : "",
                        pizza.getIngredients().stream().noneMatch(Ingredient::isMeat) ? "wege" : "",
                        pizza.equals(pizzaOfTheDay) ? (double) calculatePizzaPrice(pizza) * 0.5 : (double) calculatePizzaPrice(pizza),
                        pizza.equals(pizzaOfTheDay) ? "*" : ""
                ))
//                .sorted(Comparator.comparing(pizza -> pizza.trim()))
                .collect(Collectors.joining("\n"));
    }

    public double calculatePizzaPriceWithDiscount(Pizza pizza, Pizza pizzaOfTheDay) {
        return pizza.equals(pizzaOfTheDay) ? calculatePizzaPrice(pizza) * 0.5 : calculatePizzaPrice(pizza);
    }

    // pizza menu - sortowanie po nazwie
    public String formatedMenuOrderByPrice() {
        Random random = new Random();
        int randomIndex = random.nextInt(Pizza.values().length);
        Pizza pizzaOfTheDay = Pizza.values()[randomIndex];

        return Arrays.stream(Pizza.values())
                .sorted(Comparator.comparing(this::countMeatIngredients))
                .map(pizza -> String.format(
                        "%15s (%-90s) %5s %4s - %5.2f zł %1s",
                        pizza.getName(),
                        pizza.getIngredients().stream().map(Ingredient::getName).collect(Collectors.joining(", ")),
                        pizza.getIngredients().stream().anyMatch(Ingredient::isSpicy) ? "ostra" : "",
                        pizza.getIngredients().stream().noneMatch(Ingredient::isMeat) ? "wege" : "",
                        pizza.equals(pizzaOfTheDay) ? (double) calculatePizzaPrice(pizza) * 0.5 : (double) calculatePizzaPrice(pizza),
                        pizza.equals(pizzaOfTheDay) ? "*" : ""
                ))
                .collect(Collectors.joining("\n"));
    }

    // pizza menu - sortowanie po liczbie składników

    public int calculatedIngredientsSize(Pizza pizza) {
        return pizza.getIngredients().size();
    }

    public String formatedMenuOrderByIngredientsCount() {
        Random random = new Random();
        int randomIndex = random.nextInt(Pizza.values().length);
        Pizza pizzaOfTheDay = Pizza.values()[randomIndex];

        return Arrays.stream(Pizza.values())
                .sorted(Comparator.comparing(this::calculatedIngredientsSize).reversed())
                .map(pizza -> String.format(
                        "%15s (%-90s) %5s %4s - %5.2f zł %1s",
                        pizza.getName(),
                        pizza.getIngredients().stream().map(Ingredient::getName).collect(Collectors.joining(", ")),
                        pizza.getIngredients().stream().anyMatch(Ingredient::isSpicy) ? "ostra" : "",
                        pizza.getIngredients().stream().noneMatch(Ingredient::isMeat) ? "wege" : "",
                        pizza.equals(pizzaOfTheDay) ? (double) calculatePizzaPrice(pizza) * 0.5 : (double) calculatePizzaPrice(pizza),
                        pizza.equals(pizzaOfTheDay) ? "*" : ""
                ))
                .collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        System.out.println("CENA: " + pc.calculatePizzaPrice(Pizza.MARGHERITA));
        System.out.println("OSTRE");
        pc.getAllSpicy().forEach(System.out::println);
        System.out.println("PIZZE Z CENAMI");
        pc.getAllPizzasWithPrices();
        System.out.println("NAJTANSZA PIZZA OSTRA");
        System.out.println(pc.findCheapestSpicy());
        System.out.println("NAJDROŻSZA PIZZA WEGE");
        System.out.println(pc.findMostExpensiveVegetarian());
        System.out.println("PIZZE MIĘSNE POSORTOWANE PO LICZBIE SKŁADNIKÓW MIĘSNYCH");
        pc.iLikeMeat().forEach(pizza -> System.out.println(pizza + " " + pc.countMeatIngredients(pizza)));
        pc.groupByPrice().forEach((price, pizzas) -> System.out.println(price + " : " + pizzas));
        pc.groupBySpicy().forEach((spicy, pizzas) -> System.out.println(spicy + " : " + pizzas));
        pc.groupByIngredientsSize().forEach((ingredients, pizzas) -> System.out.println(ingredients + " : " + pizzas));
        System.out.println("MENU");
        System.out.println(pc.formatedMenu());
        System.out.println("MENU POSOTROWANE PO NAZWIE");
        System.out.println(pc.formatedMenuOrderByName());
        System.out.println("MENU POSOTROWANE PO CENIE");
        System.out.println(pc.formatedMenuOrderByPrice());
        System.out.println("MENU SORTOWANE PO LICZBIE SKŁADNIKÓW");
        System.out.println(pc.formatedMenuOrderByIngredientsCount());
        System.out.println("MENU GRUPUJĄCE PO LICZBIE SKŁADNIKÓW");
    }
}