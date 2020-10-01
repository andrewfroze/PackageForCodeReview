package andrewfroze.Collections.Kitchen.Ingredients;

import andrewfroze.Collections.Kitchen.ProductsClassification.ProductsTypes;
import andrewfroze.Collections.Kitchen.ProductsClassification.VegetableTypes;

import java.util.Objects;

public class Vegetable extends IngredientForSalad {

    private  VegetableTypes typeOfVegetable;


    public Vegetable(ProductsTypes typeOfProduct, VegetableTypes typeOfVegetable, double mass, int calorie, double proteins, double fats, double carbohydrates) {
        super(typeOfProduct, mass, calorie, proteins, fats, carbohydrates);
        this.typeOfVegetable = typeOfVegetable;
    }

    public VegetableTypes getTypeOfVegetable() {
        return typeOfVegetable;
    }

    @Override
    public String toString() {
        return super.toString().replace("{","{" + typeOfVegetable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vegetable vegetable = (Vegetable) o;
        return Objects.equals(typeOfVegetable, vegetable.typeOfVegetable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfVegetable);
    }
}
