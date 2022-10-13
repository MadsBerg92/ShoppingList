import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingList2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> available = new TreeMap<>();
        Map<String, Integer> ingredients = new TreeMap<>();
        Map<String, Integer> sL = new TreeMap<>();

        // Set<String> shoppingList = new TreeSet<>();

        int counter = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine(); // JUMPS TO NEXT LINE
            while (scanner.hasNextInt()) { // WILL PERFORM FUNCTION AS LONG AS THE INPUT HAS AN INTEGER
                int amount = scanner.nextInt();
                String unit = scanner.next();
                String ingre = scanner.next();
                if (unit.equals("kg")) {
                    amount = amount * 1000;
                }
                if (counter == 0) {
                    available.put(ingre, amount);
                }
                if (counter > 0) {

                    if (ingredients.containsKey(ingre)) {

                        int amountX = amount + ingredients.get(ingre);
                        ingredients.put(ingre, amountX);

                    } else {
                        ingredients.put(ingre, amount);
                    }

                }
            }
            counter++;
        }
        scanner.close();

        System.out.println("Shopping List:");

        for (String ingredientsInRecipe : ingredients.keySet()) { // ITERATES OVER ALL THE

            if (available.containsKey(ingredientsInRecipe)) {
                int amount = ingredients.get(ingredientsInRecipe) - available.get(ingredientsInRecipe);
                if (amount > 0) {
                    sL.put(ingredientsInRecipe, amount);
                    System.out.println(amount + " g " + ingredientsInRecipe);
                }

            }
            if (!available.containsKey(ingredientsInRecipe)) {
                int amount = ingredients.get(ingredientsInRecipe);
                sL.put(ingredientsInRecipe, amount);
                System.out.println(amount + " g " + ingredientsInRecipe);
            }

        }

    }

}
