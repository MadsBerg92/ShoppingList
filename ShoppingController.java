import java.util.Map;

public class ShoppingController {

    private ShoppingScanner scanner;

    public ShoppingController() {
        this.scanner = new ShoppingScanner();
    }

    public void startShopping() {
        ShoppingScannerResults results = this.scanner.scanUserInput();
        ShoppingListCalculator calculator = new ShoppingListCalculator(results.getAvailable(),
                results.getIngredients());
        Map<String, Integer> calculatedShoppingList = calculator.calculateShoppingList();
        printShoppingList(calculatedShoppingList);
    }

    public void printShoppingList(Map<String, Integer> shoppingList) {
        System.out.println("Shopping List:");
        for (String ingredient : shoppingList.keySet()) {
            int amount = shoppingList.get(ingredient);
            System.out.println(amount + " g " + ingredient);
        }

    }

}