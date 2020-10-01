package andrewfroze.Collections.Kitchen.Ingredients;

import andrewfroze.Collections.Kitchen.ProductsClassification.FruitTypes;
import andrewfroze.Collections.Kitchen.ProductsClassification.ProductsTypes;

import java.util.Objects;

public class Fruit extends IngredientForSalad {

    private FruitTypes typeOfFruit;

    public Fruit(ProductsTypes typeOfProduct, FruitTypes typeOfFruit, double mass, int calorie, double proteins, double fats, double carbohydrates) {
        super(typeOfProduct, mass, calorie, proteins, fats, carbohydrates);
        this.typeOfFruit = typeOfFruit;
    }

    public FruitTypes getTypeOfFruit() {
        return typeOfFruit;
    }

    @Override
    public String toString() {
        return super.toString().replace("{", "{" + typeOfFruit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(typeOfFruit, fruit.typeOfFruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfFruit);
    }
}
