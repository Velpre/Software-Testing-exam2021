package exam;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class LowCarbDietTest {
    //Testing to see if you can create a diet with a negative value for the field minWeight. Should throw exception
    @Test
    public void testConstructorWithNegativeWeight(){
        try {
            ArrayList<Food> allowedVeganFood = new ArrayList<>();
            allowedVeganFood.add(new Food("Peas", 50, true, FoodType.PROTEIN));
            LowCarbDiet diet1 = new LowCarbDiet(100, "eat lowcarb", allowedVeganFood, true, -80.5f);
        } catch (IllegalArgumentException e){
            Assert.assertEquals("The diet must have a higher minWeight", e.getMessage());
        }
    }

    /*****************testing req 1 e : The maximum carb-type foods that can be included in a LowCarbDiet is two.***********/
    @Test
    public void testWithMoreCarbTypeThanAllowed(){

        try {
            ArrayList<Food> allowLowCarbFood = new ArrayList<>();
            allowLowCarbFood.add( new Food("Beans",30,true,FoodType.CARB));
            allowLowCarbFood.add( new Food("Peanuts",60,true,FoodType.CARB));
            allowLowCarbFood.add( new Food("Bread",20,true,FoodType.CARB));
            allowLowCarbFood.add( new Food("Beaf",20,false,FoodType.PROTEIN));

            LowCarbDiet diet2 = new LowCarbDiet(50,"reduce the ingestion of carbs",allowLowCarbFood,false,80.0f);

        }catch (IllegalArgumentException e){
            Assert.assertEquals("This lowcarb-diet contains to many carb-type food",e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    // Testing with 2 carb types
    @Test
    public void testWithAllowedCarbTypes(){


            ArrayList<Food> allowLowCarbFood = new ArrayList<>();
            allowLowCarbFood.add( new Food("Peanuts",60,true,FoodType.CARB));
            allowLowCarbFood.add( new Food("Bread",20,true,FoodType.CARB));
            allowLowCarbFood.add( new Food("Beaf",20,false,FoodType.PROTEIN));
            allowLowCarbFood.add( new Food("Pork",30,false,FoodType.PROTEIN));
            allowLowCarbFood.add( new Food("Pork",30,false,FoodType.PROTEIN));
            LowCarbDiet diet2 = new LowCarbDiet(50,"reduce the ingestion of carbs",allowLowCarbFood,false,80.0f);

            Assert.assertEquals(50,diet2.getDaysDuration());
    }
    // Testing with none carb types
    @Test
    public void testWithNoneCarbType(){

        ArrayList<Food> allowLowCarbFood = new ArrayList<>();
        allowLowCarbFood.add( new Food("Beaf",20,false,FoodType.PROTEIN));
        allowLowCarbFood.add( new Food("Pork",30,false,FoodType.PROTEIN));
        allowLowCarbFood.add( new Food("Pork",30,false,FoodType.PROTEIN));
        allowLowCarbFood.add( new Food("Rib",30,false,FoodType.FAT));
        LowCarbDiet diet3 = new LowCarbDiet(60,"reduce the ingestion of carbs",allowLowCarbFood,false,80.0f);

        Assert.assertEquals(60,diet3.getDaysDuration());
    }


}
