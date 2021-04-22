package exam;

public class Food {
    private String name;
    private float caloriesPer100g;
    private boolean isVegan;
    private FoodType type;


    public Food(String name, float caloriesPer100g, boolean isVegan, FoodType type) {
        this.name = name;
        this.caloriesPer100g = caloriesPer100g;
        this.isVegan = isVegan;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public float getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public FoodType getType() {
        return type;
    }
}
