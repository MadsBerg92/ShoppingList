import java.util.Map;
import java.util.TreeMap;

public class ShoppingListCalculator {
    private Map<String, Integer> available;
    private Map<String, Integer> ingredients;

    public ShoppingListCalculator(Map<String, Integer> available, Map<String, Integer> ingredients) {

        this.available = available;
        this.ingredients = ingredients;

    }

    public Map<String, Integer> calculateShoppingList() {
        Map<String, Integer> sL = new TreeMap<>();

        for (String ingredientsInRecipe : ingredients.keySet()) { // ITERATES OVER ALL THE

            if (available.containsKey(ingredientsInRecipe)) {
                int amount = ingredients.get(ingredientsInRecipe) - available.get(ingredientsInRecipe);
                if (amount > 0) {
                    sL.put(ingredientsInRecipe, amount);

                }

            }
            if (!available.containsKey(ingredientsInRecipe)) {
                int amount = ingredients.get(ingredientsInRecipe);
                sL.put(ingredientsInRecipe, amount);

            }

        }
        return sL;
    }

}
