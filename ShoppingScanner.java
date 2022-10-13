import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingScanner {
    private Scanner scanner;

    public ShoppingScanner() {
        this.scanner = new Scanner(System.in);

    }

    public ShoppingScannerResults scanUserInput() {

        Map<String, Integer> available = new TreeMap<>();
        Map<String, Integer> ingredients = new TreeMap<>();

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
        return new ShoppingScannerResults(available, ingredients);

    }

}
