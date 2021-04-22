package exam;

import org.junit.Assert;
import org.junit.Test;

public class FoodTest {

    //Tester vi at konstruktøren funker
    @Test
    public void testConstructor(){
        Food egg = new Food("Egg", 100.0f,false, FoodType.PROTEIN);
        //DEtte sjekker at Getteren funker
        Assert.assertEquals("Egg", egg.getName());
        Assert.assertEquals(100.0f, egg.getCaloriesPer100g() ,0);
    }


}
