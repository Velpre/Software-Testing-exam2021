package exam;

import java.util.ArrayList;

public class Person {
    private Food favoriteFood;
    private ArrayList<Food> allergies = null;
    private Diet diet;
    private float weight;

    //Constructor for VeganDiet
    public Person(Food favoriteFood, ArrayList<Food> allergies, Diet diet, float weight){
        // req 2b
        if(allergies.size() > 0 && !checkAllergies(diet.getAllowedFood(),allergies)){
            throw new IllegalArgumentException("To many allergies");
        }
        // req 2a.
        if(diet instanceof VeganDiet && !favoriteFood.isVegan()){
            throw new IllegalArgumentException("Vegan mismatch");
        }
        // req 2c.
        else if (diet instanceof VeganDiet && weight < ((VeganDiet) diet).getMinWeightKg()){
            throw new IllegalArgumentException("Vegan Weight mismatch");
        }
        // req 2c.
        if (diet instanceof LowCarbDiet && weight < ((LowCarbDiet) diet).getMinWeightKg()){
            throw new IllegalArgumentException("LowCarbDiet Weight mismatch");
        }
        // req 2d.
        if (diet instanceof HypercaloricDiet && weight > ((HypercaloricDiet) diet).getMaxWeightKg()) {
            throw new IllegalArgumentException("You weigh too much");
        }
            this.favoriteFood = favoriteFood;
            this.allergies = allergies;
            this.diet = diet;
            this.weight = weight;
        }

       // help-method req 2b.
    public boolean checkAllergies(ArrayList<Food> allowed, ArrayList<Food> allergies) {
        double counter = 0;
        double size = allowed.size();
        double size2 = size / 2;
        for (int i = 0; i < allowed.size(); i++) {
            for (int j = 0; j < allergies.size(); j++) {
                if (allowed.get(i).getName().equalsIgnoreCase(allergies.get(j).getName())) {
                    counter++;
                }
            }

        }if(counter >= size2){
            return false;
        }
        return true;
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
