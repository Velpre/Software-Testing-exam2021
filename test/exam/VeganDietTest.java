package exam;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class VeganDietTest {

    //Testing to see if you can create a diet with a negative value for the field minWeight. Should throw exception
    @Test
    public void testConstructorWithNegativeWeight(){
        try {
            ArrayList<Food> allowedVeganFood = new ArrayList<>();
            allowedVeganFood.add(new Food("Peas", 50, true, FoodType.PROTEIN));
            VeganDiet diet1 = new VeganDiet(100, "eat vegan", allowedVeganFood, true, -80.5f);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("The diet must have a higher minWeight", e.getMessage());
        }
    }

    //Part of requirement 1C : Testing creating a vegan diet, with non-vegan foods.
    @Test
    public void testingVeganDietWithNonVeganFood(){
        try {
            ArrayList<Food> allowed = new ArrayList<>();
            allowed.add(new Food("Tomato", 100, true, FoodType.CARB));
            allowed.add(new Food("Potato", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Beans", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Peas", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Beef", 100, false, FoodType.PROTEIN));

            VeganDiet diet1 = new VeganDiet(100, "eat vegan food", allowed, true, 80.8f);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("Expected only non-vegan food", e.getMessage());
        }

    }



}
