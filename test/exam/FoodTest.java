package exam;

import org.junit.Assert;
import org.junit.Test;

public class FoodTest {

    //Tester vi at konstruktøren funker
    @Test
    public void testConstructor(){
        Food egg = new Food("Egg", 100,false, FoodType.PROTEIN);
        //DEtte sjekker at Getteren funker
        Assert.assertEquals("Egg", egg.getName());
    }


}
