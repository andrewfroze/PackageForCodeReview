package andrewfroze.Collections.Kitchen;


import andrewfroze.Collections.Kitchen.Ingredients.Cereals;
import andrewfroze.Collections.Kitchen.Ingredients.Fruit;
import andrewfroze.Collections.Kitchen.Ingredients.IngredientForSalad;
import andrewfroze.Collections.Kitchen.Ingredients.Vegetable;
import andrewfroze.Collections.Kitchen.ProductsClassification.CerealTypes;
import andrewfroze.Collections.Kitchen.ProductsClassification.FruitTypes;
import andrewfroze.Collections.Kitchen.ProductsClassification.ProductsTypes;
import andrewfroze.Collections.Kitchen.ProductsClassification.VegetableTypes;

import java.util.*;

public class Kitchen {
    static List<IngredientForSalad> fillingRefrigerator = Arrays.asList(
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.TOMATO, 200, 19, 0.6,0.0, 4.2),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.BEET, 100, 48, 1.7,0.0, 10.8),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.CABBAGE, 550, 28, 1.8,0.0, 5.4),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.CARROT, 150, 33, 1.3,0.1, 7.0),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.CAULIFLOWER, 200,29, 2.5, 0.0,4.9),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.CUCUMBER, 300, 15, 0.8,0.0, 3.0),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.EGGPLANT, 400, 24, 0.6,0.1, 5.5),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.GARLIC, 200, 19, 0.6,0.0, 4.2),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.PUMPKIN, 500, 27, 0.6,0.3, 5.7),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.ONION, 100, 43, 1.7,0.0, 9.5),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.PEPPER, 100, 27, 1.3,0.0, 5.7),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.RADISH, 50, 20, 1.2,0.0, 4.1),
            new Fruit(ProductsTypes.FRUIT, FruitTypes.APPLE, 200, 46, 0.4,0.0, 11.3),
            new Fruit(ProductsTypes.FRUIT, FruitTypes.APRICOT, 100, 46, 0.9,0.0, 10.5),
            new Fruit(ProductsTypes.FRUIT, FruitTypes.AVOCADO, 150, 223, 1.9,23.5, 6.7),
            new Fruit(ProductsTypes.FRUIT, FruitTypes.BANANA, 350, 91, 1.5,0.0, 22.4),
            new Fruit(ProductsTypes.FRUIT, FruitTypes.KIWI, 150, 61, 1.0,0.0, 11.0),
            new Fruit(ProductsTypes.FRUIT, FruitTypes.PEACH, 250, 44, 0.9,0.0, 10.4),
            new Fruit(ProductsTypes.FRUIT, FruitTypes.PEAR, 300, 42, 0.4,0.0, 10.7),
            new Fruit(ProductsTypes.FRUIT, FruitTypes.PERSIMMON, 250, 62, 0.5,0.0, 15.9),
            new Fruit(ProductsTypes.FRUIT, FruitTypes.PINEAPPLE, 500, 48, 0.4,0.0, 11.8),
            new Fruit(ProductsTypes.FRUIT, FruitTypes.POMEGRANATE, 400, 52, 0.9,0.0, 11.8),
            new Cereals(ProductsTypes.CEREAL, CerealTypes.BUCKWHEAT, 200, 296, 10.8,3.2, 56.0),
            new Cereals(ProductsTypes.CEREAL, CerealTypes.CORN, 400, 328, 8.3,1.2, 71.0),
            new Cereals(ProductsTypes.CEREAL, CerealTypes.OAT, 300, 342, 12.3,6.1, 59.5),
            new Cereals(ProductsTypes.CEREAL, CerealTypes.RICE, 200, 303, 7.5,2.6, 62.3));

    static List<IngredientForSalad> saladRecipe = Arrays.asList(
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.CABBAGE, 500, 28, 1.8,0.0, 5.4),
            new Cereals(ProductsTypes.CEREAL, CerealTypes.CORN, 340, 328, 8.3,1.2, 71.0),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.CUCUMBER, 300, 15, 0.8,0.0, 3.0),
            new Vegetable(ProductsTypes.VEGETABLE, VegetableTypes.TOMATO, 200, 19, 0.6,0.0, 4.2));




    public static void main(String[] args) {
        Cooking refrigerator = new Cooking(fillingRefrigerator);
        Cooking salad = new Cooking(saladRecipe);
        System.out.println("Salad: " + salad.toString());
        double fullCalorie = 0.0;
        double fullMass = 0.0;
        for (int i = 0; i < saladRecipe.size(); i++) {
            fullCalorie = fullCalorie + saladRecipe.get(i).getCalorie()*saladRecipe.get(i).getMass()/100;
            fullMass = fullMass + saladRecipe.get(i).getMass();
        }
        System.out.println("Calorie on 100g: " + fullCalorie*100/fullMass + "\nFull calorie of salad: " + fullCalorie);
        System.out.println("All products for salad in refrigerator sorted by calorie: " + refrigerator.sortByCalorie().toString());

        Scanner scan = new Scanner(System.in);
        System.out.println("Set diapason of calories:");
        int minimalCalories = scan.nextInt();
        int maximalCalories = scan.nextInt();
        List<IngredientForSalad> ingredientsInCalorieDiapason = new ArrayList<>();
        for (int i = 0; i < saladRecipe.size(); i++) {
            if (saladRecipe.get(i).getCalorie() > minimalCalories && saladRecipe.get(i).getCalorie() < maximalCalories){
                ingredientsInCalorieDiapason.add(saladRecipe.get(i));
            }

        }
        System.out.println("Ingredients in salad in calorie diapason: " + ingredientsInCalorieDiapason.toString());
    }
}




