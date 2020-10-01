package andrewfroze.Collections.Kitchen.Ingredients;

import andrewfroze.Collections.Kitchen.ProductsClassification.CerealTypes;
import andrewfroze.Collections.Kitchen.ProductsClassification.ProductsTypes;

import java.util.Objects;

public class Cereals extends IngredientForSalad{

    private CerealTypes typeOfCereals;

    public Cereals(ProductsTypes typeOfProduct, CerealTypes typeOfCereals, double mass, int calorie, double proteins, double fats, double carbohydrates) {
        super(typeOfProduct, mass, calorie, proteins, fats, carbohydrates);
        this.typeOfCereals = typeOfCereals;
    }

    public CerealTypes getTypeOfCereals() {
        return typeOfCereals;
    }

    @Override
    public String toString() {
        return super.toString().replace("{", "{" + typeOfCereals);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cereals cereals = (Cereals) o;
        return Objects.equals(typeOfCereals, cereals.typeOfCereals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfCereals);
    }
}

