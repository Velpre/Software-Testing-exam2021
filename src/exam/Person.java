package exam;

import java.util.ArrayList;

public class Person {
    private Food favoriteFood;
    private ArrayList<Food> allergies;
    private Diet diet;
    private float weight;

    //Constructor for VeganDiet
    public Person(Food favoriteFood, ArrayList<Food> allergies, Diet diet, float weight){

        if(diet instanceof VeganDiet && diet.isVegan() && !favoriteFood.isVegan()){
            throw new IllegalArgumentException("Vegan mismatch");
        }else if (diet instanceof VeganDiet && weight < ((VeganDiet) diet).getMinWeightKg()){
            throw new IllegalArgumentException("Weight mismatch");
        }if (diet instanceof LowCarbDiet && weight < ((LowCarbDiet) diet).getMinWeightKg()){
            throw new IllegalArgumentException("Weight mismatch");
        }

        this.favoriteFood = favoriteFood;
        this.allergies = allergies;
        this.diet = diet;
        this.weight = weight;
    }

    public Food getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(Food favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public ArrayList<Food> getAllergies() {
        return allergies;
    }

    public void setAllergies(ArrayList<Food> allergies) {
        this.allergies = allergies;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
