package andrewfroze.Collections.Kitchen.Ingredients;

import andrewfroze.Collections.Kitchen.ProductsClassification.ProductsTypes;

import java.util.Objects;

abstract public class IngredientForSalad {
    private ProductsTypes typeOfProduct;
    private double mass;
    private int calorie;
    private  double proteins;
    private  double fats;
    private  double carbohydrates;


    public IngredientForSalad(double mass) {
        this.mass = mass;
    }

    public IngredientForSalad(ProductsTypes typeOfProduct, double mass, int calorie, double proteins, double fats, double carbohydrates) {
        this.typeOfProduct = typeOfProduct;
        this.mass = mass;
        this.calorie = calorie;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public ProductsTypes getTypeOfProduct() {
        return typeOfProduct;
    }

    public double getMass() {
        return mass;
    }

    public int getCalorie() {
        return calorie;
    }

    public double getProteins() {
        return proteins;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    @Override
    public String toString() {
        return ("{, mass=" + mass + ", calorie=" + calorie + "}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientForSalad that = (IngredientForSalad) o;
        return Double.compare(that.mass, mass) == 0 &&
                Double.compare(that.calorie, calorie) == 0 &&
                Objects.equals(typeOfProduct, that.typeOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfProduct, mass, calorie);
    }
}
