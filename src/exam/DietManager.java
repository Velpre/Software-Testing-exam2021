package exam;

import java.util.ArrayList;

import static exam.Person.checkAllergies;

public class DietManager {
    // kode som validerer om personen er kompatibel med dietten.
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


        return true;
    }

    public HypercaloricDiet randomDiet(Person person, ArrayList<Food> food){
        return null;
    }


}
