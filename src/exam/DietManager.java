package exam;

import java.util.ArrayList;

import static exam.Person.checkAllergies;

public class DietManager {

    // Code that check if the person is compatible with diet
    public static boolean areCompatible(Person person, Diet diet){
        // checking for too many allergies in new diet
        if(person.getAllergies().size() > 0 && !checkAllergies(diet.getAllowedFood(), person.getAllergies())){
            return false;
        }
        // a none-vegan person cannot follow a vegan diet.
        if(!person.getFavoriteFood().isVegan() && diet.isVegan()){
            return false;
        }
        // a person with weight over minWeight for VeganDiet cannot follow a veganDiet.
        if(diet instanceof VeganDiet && ((VeganDiet) diet).getMinWeightKg() > person.getWeight()){
            return false;
        }
        if(diet instanceof LowCarbDiet && ((LowCarbDiet) diet).getMinWeightKg() > person.getWeight()){
            return false;
        }

        if(diet instanceof HypercaloricDiet && ((HypercaloricDiet) diet).getMaxWeightKg() < person.getWeight()){
            return false;
        }

        return true;
    }



    // Method for req 4B, returns random HyperCaloricDiet
    public static HypercaloricDiet randomDiet(Person person, ArrayList<Food> food){

        String purpose = "Random Hypercaloric Diet";

        ArrayList<Food> allowedFood = createAllowedFood(food, person.getAllergies() );

        return new HypercaloricDiet(randomDuration(),purpose,allowedFood,checkIfDietIsVegan(allowedFood),randomMaxWeight(person.getWeight()),randomCalorieValue());
    }

    //Helper method for randomDiet
    private static int randomDuration(){
         int randomDays = (int) Math.round(Math.random()*99) +1;
         return randomDays;
    }

    public static ArrayList createAllowedFood(ArrayList<Food> food, ArrayList<Food> allergies) {
        ArrayList<Food> allowedFood = new ArrayList<>();

        for (int i = 0; i < food.size()  ; i++) {
            boolean foundAllergy =false;
            for (int j = 0; j < allergies.size() ; j++) {
                if(food.get(i).getName().equalsIgnoreCase(allergies.get(j).getName() ) ) {
                    foundAllergy = true;
                    break;
                }
            }
            if(!foundAllergy){
                allowedFood.add(food.get(i));
            }
        }
            return allowedFood;
        }

    public static boolean checkIfDietIsVegan(ArrayList<Food> allowedFood){
        for (int i=0; i<allowedFood.size(); i++){
            if(!allowedFood.get(i).isVegan()){
                return false;
            }
        }
        return true;
    }

    public static float randomMaxWeight(float personWeight){
        int randomMaxWeight = (int) Math.round(Math.random()*19) +1;
        float newPersonWeight = personWeight + randomMaxWeight;
        return newPersonWeight;
    }

    public static float randomCalorieValue(){
        int startValueCalories = 2000;
        int randomCalories = (int) Math.round(Math.random()*1999) +1;
        float totalCalories = startValueCalories+randomCalories;
        return totalCalories;
    }

}
