/*
o Pizza findCheapestSpicy() - metoda zwracająca najtańszą ostrą pizzę.
o Pizza findMostExpensiveVegetarian() - metoda zwracająca najdroższą pizzę
wegetariańską.
o List iLikeMeat() - metoda zwracająca same pizzę mięsne, posortowane
malejąco po liczbie składników mięsnych.
o Map groupByPrice() - metoda grupujące pizzę po cenie.
o String formatedMenu() - metoda zwracająca string w postaci nazwa_pizzy:
składnik1, składnik2, składnik3 - cena, kolejne pizzę oddzielone znakiem
nowej linii.
 */

package pizzaExercises;

import java.util.*;
import java.util.stream.Collectors;

public class PizzaController {

    public int calculatePizzaPrice(Pizza pizza) {
        return pizza.getIngredients().stream()
                .mapToInt(p -> p.getPrice())
                .sum();
    }

    public List<Pizza> getAllSpicy() {
        return Arrays.stream(Pizza.values()).filter(pizza -> pizza.getIngredients().stream()
                .anyMatch(Ingredient::isSpicy)).collect(Collectors.toList());
    }

    public List<Pizza> getAllVegetarian() {
        return Arrays.stream(Pizza.values()).filter(pizza -> pizza.getIngredients().stream()
                .noneMatch(Ingredient::isMeat)).collect(Collectors.toList());
    }

    public Pizza findCheapestSpicy() {
        Optional<Pizza> pizzaOptional = Arrays.stream(Pizza.values()).filter(pizza -> pizza.getIngredients().stream().anyMatch(Ingredient::isSpicy))
                .sorted(Comparator.comparing(pizza -> calculatePizzaPrice(pizza)))
                .limit(1)
                .findFirst();
        if (pizzaOptional.isPresent()) {
            return pizzaOptional.get();
        }
        System.out.println("Brak danych do pobrania");
        return null;
    }

    public Pizza findMostExpensiveVegetarian() {
        Optional<Pizza> pizzaOptional = Arrays.stream(Pizza.values()).filter(pizza -> pizza.getIngredients().stream()
                .noneMatch(Ingredient::isMeat))
                .sorted(Comparator.comparing(this::calculatePizzaPrice).reversed())
                .findFirst();
        if (pizzaOptional.isPresent()) {
            return pizzaOptional.get();
        }
        System.out.println("Brak danych do pobrania");
        return null;
    }

    public void getAllPizzasWithPrices() {
        Arrays.stream(Pizza.values())
                .forEach(pizza -> System.out.println(pizza.getName() + " - " + calculatePizzaPrice(pizza) + " PLN"));
    }

    public long calculateMeatIngredients(Pizza pizza) {
        return pizza.getIngredients().stream()
                .filter(p -> p.isMeat())
                .count();
    }

    public List<Pizza> iLikeMeat() {
        return Arrays.stream(Pizza.values()).filter(pizza -> pizza.getIngredients().stream()
                .anyMatch(Ingredient::isMeat)).sorted(Comparator.comparing(this::calculateMeatIngredients).reversed()).collect(Collectors.toList());
    }

    public Map<Integer, List<Pizza>> groupByPrice() {
        return Arrays.stream(Pizza.values()).collect(Collectors.groupingBy(this::calculatePizzaPrice));
    }

    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
//        System.out.println(pc.calculatePizzaPrice(Pizza.MARGHERITA));
//        System.out.println(pc.getAllSpicy());
//        System.out.println(pc.findCheapestSpicy());
//        pc.getAllPizzasWithPrices();
//        System.out.println(pc.getAllVegetarian());
//        System.out.println(pc.findMostExpensiveVegetarian());
// System.out.println(pc.iLikeMeat());
        System.out.println(pc.groupByPrice());
    }
}
