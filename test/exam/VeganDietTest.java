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
}
