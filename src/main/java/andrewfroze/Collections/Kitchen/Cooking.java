package andrewfroze.Collections.Kitchen;

import andrewfroze.Collections.Kitchen.Ingredients.Cereals;
import andrewfroze.Collections.Kitchen.Ingredients.Fruit;
import andrewfroze.Collections.Kitchen.Ingredients.IngredientForSalad;
import andrewfroze.Collections.Kitchen.Ingredients.Vegetable;

import java.util.*;

public class Cooking {
    private List<? extends IngredientForSalad> ingredients;

    public Cooking(List<? extends IngredientForSalad> ingredients) {
        this.ingredients = ingredients;
    }



    public List<Vegetable> getVegetable() {
        List<Vegetable> vegetables = new ArrayList<>();
        for (IngredientForSalad ingredient : ingredients) {
            if (ingredient instanceof Vegetable) {
                vegetables.add((Vegetable) ingredient);
            }
        }
        return vegetables;
    }

    public List<Fruit> getFruit() {
        List<Fruit> fruits = new ArrayList<>();
        for (IngredientForSalad ingredient : ingredients) {
            if (ingredient instanceof Fruit) {
                fruits.add((Fruit) ingredient);
            }
        }
        return fruits;
    }

    public List<Cereals> getCereals() {
        List<Cereals> cereals = new ArrayList<>();
        for (IngredientForSalad ingredient : ingredients) {
            if (ingredient instanceof Cereals) {
                cereals.add((Cereals) ingredient);
            }
        }
        return cereals;
    }

    public Cooking sortByCalorie() {
        Collections.sort(ingredients, new Comparator<IngredientForSalad>() {
            public int compare(IngredientForSalad o1, IngredientForSalad o2) {
                return o1.getCalorie() - o2.getCalorie();
            }
        });
        return this;
    }

    public Cooking sortByProteins() {
        Collections.sort(ingredients, new Comparator<IngredientForSalad>() {
            public int compare(IngredientForSalad o1, IngredientForSalad o2) {
                return (int) ((o1.getProteins() - o2.getProteins())*10);
            }
        });
        return this;
    }

    public Cooking sortByFats() {
        Collections.sort(ingredients, new Comparator<IngredientForSalad>() {
            public int compare(IngredientForSalad o1, IngredientForSalad o2) {
                return (int) ((o1.getFats() - o2.getFats())*10);
            }
        });
        return this;
    }

    public Cooking sortByCarbohydrates() {
        Collections.sort(ingredients, new Comparator<IngredientForSalad>() {
            public int compare(IngredientForSalad o1, IngredientForSalad o2) {
                return (int) ((o1.getCarbohydrates() - o2.getCarbohydrates())*10);
            }
        });
        return this;
    }

    public List<? extends IngredientForSalad> getIngredients() {
        return ingredients;
    }

    private void print(Collection<? extends IngredientForSalad> collection) {
        Iterator<? extends IngredientForSalad> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return "Ingredients=" + ingredients +
                '}';
    }
}
