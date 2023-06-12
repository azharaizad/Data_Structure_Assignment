package extra.features;

/**
 *
 * @author Asus
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoodProduction {

    public static void main(String[] args) {
        Map<String, Double> foodPolitic = new HashMap<>();
        foodPolitic.put("S", 2.0);
        foodPolitic.put("A", 1.5);
        foodPolitic.put("B", 1.2);
        foodPolitic.put("C", 1.0);

        Map<String, Double> foodIntelligence = new HashMap<>();
        foodIntelligence.put("S", 1.8);
        foodIntelligence.put("A", 1.3);
        foodIntelligence.put("B", 1.0);
        foodIntelligence.put("C", 0.8);

        Scanner sc = new Scanner(System.in);

        double foodProduction = 0.0;

        for (int i = 0; i < 3; i++) {
            System.out.print("Select category " + (i + 1) + " (politic or intelligence): ");
            String category = sc.nextLine().toLowerCase();

            System.out.print("Select team " + (i + 1) + " (S, A, B, C): ");
            String team = sc.nextLine().toUpperCase();

            double categoryFoodProduction;

            if (category.equals("politic")) {
                categoryFoodProduction = 100*foodPolitic.getOrDefault(team, 1.0);
            } else if (category.equals("intelligence")) {
                categoryFoodProduction = 100*foodIntelligence.getOrDefault(team, 1.0);
            } else {
                System.out.println("Invalid category!");
                return;
            }

            foodProduction += categoryFoodProduction;
        }

        System.out.println("Food production: " + foodProduction);
    }
}




