import java.util.Map;

public class ShoppingScannerResults {
    private Map<String, Integer> available;
    private Map<String, Integer> ingredients;

    public ShoppingScannerResults(Map<String, Integer> available, Map<String, Integer> ingredients) {

        this.available = available;
        this.ingredients = ingredients;

    }

    public Map<String, Integer> getAvailable() {
        return available;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
